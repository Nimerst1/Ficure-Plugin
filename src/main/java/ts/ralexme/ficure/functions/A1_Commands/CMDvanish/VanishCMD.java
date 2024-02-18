package ts.ralexme.ficure.functions.A1_Commands.CMDvanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

import java.util.ArrayList;


public class VanishCMD implements CommandExecutor {

    public static ArrayList<Player> vanished = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        Player player = (Player) commandSender;
        if(!commandSender.hasPermission("vanish.vanish")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------

        if(command.getName().equalsIgnoreCase("vanish")){
            if(vanished.contains(player)){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.showPlayer(player);
                }
                vanished.remove(player);
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + Ficure.getInstance().getConfig().getString("vanishdisabled")));
            } else {
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.hidePlayer(player);
                }
                vanished.add(player);
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + Ficure.getInstance().getConfig().getString("vanishenabled")));
            }
            return true;
        }
        return false;
    }
}
