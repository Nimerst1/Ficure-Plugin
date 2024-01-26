package ts.ralexme.ficure.functions.calculate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CalculateTC implements TabCompleter {
    List<String> arguments = new ArrayList<String>();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (arguments.isEmpty()) {
            arguments.add("1 + 2");
        }

        //NOT WORKING AT ALL

        return null;
    }
}
