package ts.ralexme.ficure.functions.clear;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.bukkit.ChatColor;
import ts.ralexme.ficure.Ficure;

public class ClearCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments

        if(strings[0].equalsIgnoreCase("chat")){
            for(int i = 0; i < 100; i++) {
                commandSender.sendMessage("          ");
            }
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" ->" + ChatColor.GREEN + "You're chat successfully cleaned!");
            return true;
        }
        return false;
    }
}
