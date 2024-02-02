package ts.ralexme.ficure.functions.A1_Commands.CMDsethealth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class sethealthCMD implements CommandExecutor {

    private final JavaPlugin plugin;

    public sethealthCMD(JavaPlugin plugin) {
        this.plugin = plugin; //reserve from Ficure - head plugin file
    }


    private final Map<UUID, Long> cooldowns = new HashMap<>();  //cooldown Getting UUID, and long value
    private static final long cl_t = 30000; //30 sec The cooldown

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        Player player = (Player) commandSender;
        if(strings.length != 2) return false; //if there more than 2 argument
        if(!commandSender.hasPermission("ficure.sethealth")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }

        if(!(isCooldownExpired(player, cl_t))){
            commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " Please wait ~30 seconds before using this command again!"));
            return true;                    //SETTING COOLDOWN / MESSAGE
        }
        setCooldown(player);
        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------

        String pName = strings[0];
        String healthlevel = strings[1];

        try {
            int healthLevelValue = Integer.parseInt(healthlevel); //Parse String healthlevel to int value!
            Player stringsPlayer = plugin.getServer().getPlayer(pName);
            if(stringsPlayer == null){
                commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix")  + ChatColor.RED +
                        "Hey this player is offline :(");
                return true;
            }
            stringsPlayer.setHealth(healthLevelValue);
            stringsPlayer.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " You're health level was customized!"));
        }
        catch (NumberFormatException e){
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.RED +
                    "Hey value of 'HealthLevel' can be only in numbers 1-20!");
            return false;
        }
        return true;
    }

    //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
    private boolean isCooldownExpired(Player player, long cooldown) {
        final Long startTime = cooldowns.get(player.getUniqueId());
        if(startTime == null){
            return true;
        }
        final long elapsedTime = System.currentTimeMillis() - startTime;       //Cooldown 2
        return elapsedTime >=  cooldown;
    }
    private void setCooldown(Player player) {
        final Long currentTimeMillis = System.currentTimeMillis();
        cooldowns.merge(player.getUniqueId(), currentTimeMillis, (oldValue, newValue) -> newValue);
    }
    //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------
}
