package ts.ralexme.ficure.functions.B1_Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

public class broadcastCMD implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player

        Player player = (Player) commandSender;
        String pName = player.getName();

        if(!commandSender.hasPermission("ficure.broadcast")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------
    if(command.getName().equalsIgnoreCase("broadcast")){
        if(strings.length < 1){
            commandSender.sendMessage(ChatColor.RED + "Please include a message!");
            return false;
        }
        else if(strings.length == 1) {
            String message = String.join(" ", strings);
            message = ChatColor.translateAlternateColorCodes('&', message);
            Bukkit.broadcastMessage(ChatColor.GOLD + "[Broadcast] " + ChatColor.GRAY + pName + " Says: " + message);
        }
    }
        return true;
    }
}
