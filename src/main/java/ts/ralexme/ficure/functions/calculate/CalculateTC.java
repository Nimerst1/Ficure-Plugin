package ts.ralexme.ficure.functions.calculate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateTC implements TabCompleter {
    List<String> arguments = new ArrayList<String>();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1) {
            return Arrays.asList("1", "500", "1000");
        }
        else if(strings.length == 2){
               return Arrays.asList("+", "-", "*", "/");
            }
        else if (strings.length == 3){
            return Arrays.asList("1", "500", "1000");
        }
        {

        }
        return new ArrayList<>();
    }
}
