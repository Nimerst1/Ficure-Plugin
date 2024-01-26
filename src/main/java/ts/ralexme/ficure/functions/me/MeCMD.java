package ts.ralexme.ficure.functions.me;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import org.bukkit.*;

public class MeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        String pName = player.getName();

        if (strings[0].equalsIgnoreCase("Hello")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" -> " + ChatColor.GRAY + pName + " Сказал: Привет Земляки!");
            return true;
        } else if (strings[0].equalsIgnoreCase("GoodBye")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" -> " + ChatColor.GRAY + pName +" Сказал: Пока Земляки!");
            return true;
        } else if (strings[0].equalsIgnoreCase("WhatsUp")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" -> " + ChatColor.GRAY + pName + " Сказал: ВатСап земляки!");
            return true;
        }

        return false;
    }
}
