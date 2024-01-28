package ts.ralexme.ficure.functions.cookies;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

public class setfoodCMD implements CommandExecutor {

    private final JavaPlugin plugin;

    public setfoodCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        if(strings.length != 2) return false; //if there more than 2 argument

        String pName = strings[0];
        String foodlevel = strings[1];

        try {
            int foodLevelValue = Integer.parseInt(foodlevel); //Parse String foodlevel to int value!
            Player stringsPlayer = plugin.getServer().getPlayer(pName);
            if(stringsPlayer == null){
                commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.RED +
                        "Hey this player is offline :(");
                return true;
            }
            stringsPlayer.setFoodLevel(foodLevelValue);
            stringsPlayer.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " You're food level was customized!"));
        }
        catch (NumberFormatException e){
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.RED +
                    "Hey value of 'FoodLevel' can be only in numbers 1-20!");
            return false;
        }
        return true;
    }
}
