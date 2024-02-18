package ts.ralexme.ficure.functions.A1_Commands.CMDsetvanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;


public class SetvanishCMD implements CommandExecutor, Listener {

    private final JavaPlugin plugin;

    public SetvanishCMD(JavaPlugin plugin) {
        this.plugin = plugin; //to reserve ficure - head file plugin
    }

    public static ArrayList<Player> setvanish = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        String pName = strings[0];
        Player stringsPlayer = plugin.getServer().getPlayer(pName);
        if(!commandSender.hasPermission("vanish.setvanish")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------

        if (command.getName().equalsIgnoreCase("setvanish")) {
            if (stringsPlayer == null) {
                commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.RED +
                        "Hey this player is offline :(");
                return true;
            }
            if(setvanish.contains(stringsPlayer)) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(stringsPlayer);
                }
                getServer().dispatchCommand(getServer().getConsoleSender(), "effect clear " + pName);
                setvanish.remove(stringsPlayer);
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + Ficure.getInstance().getConfig().getString("setvanishdisabled")) + pName);
            } else {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(stringsPlayer);
                    getServer().dispatchCommand(getServer().getConsoleSender(), "effect give " + pName + " minecraft:invisibility 100000 1");
                }
                setvanish.add(stringsPlayer);
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + Ficure.getInstance().getConfig().getString("setvanishenabled")) + pName);
            }
        }
        return true;
    }
}
