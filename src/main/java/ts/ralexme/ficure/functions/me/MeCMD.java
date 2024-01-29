package ts.ralexme.ficure.functions.me;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import org.bukkit.*;
import ts.ralexme.ficure.Ficure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static sun.security.krb5.SCDynamicStoreConfig.getConfig;

public class MeCMD implements CommandExecutor {

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
        Player player = (Player) commandSender;
        String pName = player.getName();
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments
        //-----------------------------------------------------------------
        if(!(isCooldownExpired(player, cl_t))){
            commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " Please wait ~30 seconds before using this command again!"));
            return true;                    //SETTING COOLDOWN / MESSAGE
        }
        setCooldown(player);
        //-----------------------------------------------------------------


        if (strings[0].equalsIgnoreCase("Hello")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + pName + " Said: Hello fellow countryman!!");
            return true;
        } else if (strings[0].equalsIgnoreCase("GoodBye")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" -> " + ChatColor.GRAY + pName +" Said: Goodbye fellow countryman!!");
            return true;
        } else if (strings[0].equalsIgnoreCase("WhatsUp")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" -> " + ChatColor.GRAY + pName + " Said: WhatsUp fellow countryman!!");
            return true;
        }

        return false;
    }
    //-----------------------------------------------------------------
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
        //-----------------------------------------------------------------
    }
}
