package ts.ralexme.ficure.functions.A1_Commands.CMDsethealth;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class sethealthTC implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
            ArrayList<String> onlinePlayerName = new ArrayList<>();
            for(Player onlinePlayer : onlinePlayers){
                String name = onlinePlayer.getName();
                onlinePlayerName.add(name);
            }
            return onlinePlayerName;
        }
        if(strings.length == 2) {
            return Arrays.asList("1", "5", "10", "15", "30", "40");
        }
        return new ArrayList<>();
    }
}
