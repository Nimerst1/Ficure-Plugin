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

import static sun.security.krb5.SCDynamicStoreConfig.getConfig;

public class MeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        Player player = (Player) commandSender;
        String pName = player.getName();
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments


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
}
