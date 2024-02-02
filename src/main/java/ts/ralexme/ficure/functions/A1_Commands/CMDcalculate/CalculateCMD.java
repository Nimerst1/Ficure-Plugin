package ts.ralexme.ficure.functions.A1_Commands.CMDcalculate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.bukkit.ChatColor;
import ts.ralexme.ficure.Ficure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CalculateCMD implements CommandExecutor {

    //-----------------------------------------------------------------
    private final Map<UUID, Long> cooldowns = new HashMap<>();  //cooldown Getting UUID, and long value
    private static final long cl_t = 30000; //30 sec The cooldown

    //-----------------------------------------------------------------

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        Player player = (Player) commandSender;
        if(!commandSender.hasPermission("ficure.calculate")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }

        if(!(isCooldownExpired(player, cl_t))){
            commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " Please wait ~30 seconds before using this command again!"));
            return true;                    //SETTING COOLDOWN / MESSAGE
        }
        setCooldown(player);
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------

        int a, b;

        if(strings.length != 3) return false; //if strings nor equal 3(4) arguments

        try{
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[2]);
        }

        catch(NumberFormatException error){
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.RED + " Heeeey you'r command is sick...");
            return false;
        }

        if (strings[1].equals("+")){
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.GREEN + " Result: " + (a+b));
            return true;
        } else if (strings[1].equals("-")) {
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.GREEN + " Result: " + (a-b));
            return true;
        }
        else if(strings[1].equals("*")) {
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.GREEN + " Result: " + (a*b));
            return true;
        }
        else if (strings[1].equals("/")){
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.GREEN + " Result: " + (a/b));
            return true;
        }
        return false;
    }

    //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
    private boolean isCooldownExpired(Player player, long cooldown) {
        final Long startTime = cooldowns.get(player.getUniqueId());
        if (startTime == null) {
            return true;
        }
        final long elapsedTime = System.currentTimeMillis() - startTime;       //Cooldown 2
        return elapsedTime >= cooldown;
    }

    private void setCooldown(Player player) {
        final Long currentTimeMillis = System.currentTimeMillis();
        cooldowns.merge(player.getUniqueId(), currentTimeMillis, (oldValue, newValue) -> newValue);
    }
    //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------
}
