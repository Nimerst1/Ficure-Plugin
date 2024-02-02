package ts.ralexme.ficure.functions.Z0_TestFUNCTIONs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class FunctionsCHAT implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        //ONLY FOR LEARNING


        if(command.getName().equalsIgnoreCase("test")) {
            String text = "&lHello, &aWorld!";
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
        }
        if(command.getName().equalsIgnoreCase("test2")){
            //the message
            String message = "&a&lGreen and Bold";
            // Translating code
            String coloredMessage = ChatColor.translateAlternateColorCodes ('&', message);
            commandSender.sendMessage (coloredMessage); // send message for player
        }
        return true;
    }
}
