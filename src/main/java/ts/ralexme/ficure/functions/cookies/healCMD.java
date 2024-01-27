package ts.ralexme.ficure.functions.cookies;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class healCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        if(command.getName().equalsIgnoreCase("healCMD")){
            double maxhealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxhealth);
            commandSender.sendMessage((ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " You were healed!"));
        return true;
        }


        return false;
    }
}
