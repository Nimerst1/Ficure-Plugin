package ts.ralexme.ficure.functions.clear;

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

import static sun.audio.AudioPlayer.player;

public class ClearCMD implements CommandExecutor {

    //-----------------------------------------------------------------
    private final Map<UUID, Long> cooldowns = new HashMap<>();  //cooldown Getting UUID, and long value
    private static final long cl_t = 30000; //30 sec The cooldown
    //-----------------------------------------------------------------
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments
        Player player = (Player) commandSender;

        //-----------------------------------------------------------------
        if(!(isCooldownExpired(player, cl_t))){
            commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " Please wait ~30 seconds before using this command again!"));
            return true;                    //SETTING COOLDOWN / MESSAGE
        }
        setCooldown(player);
        //-----------------------------------------------------------------

        if(strings[0].equalsIgnoreCase("chat")){
            for(int i = 0; i < 100; i++) {
                commandSender.sendMessage("          ");
            }
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" ->" + ChatColor.GREEN + "You're chat successfully cleaned!");
            return true;
        }
        return false;
    }
    //-----------------------------------------------------------------
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
        //-----------------------------------------------------------------
    }
}