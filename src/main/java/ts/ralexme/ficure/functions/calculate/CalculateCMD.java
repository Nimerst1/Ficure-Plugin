package ts.ralexme.ficure.functions.calculate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.bukkit.ChatColor;
import ts.ralexme.ficure.Ficure;

public class CalculateCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player

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
}
