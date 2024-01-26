package ts.ralexme.ficure.functions.me;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MeTC implements TabCompleter {
    List<String> arguments = new ArrayList<String>();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings[0].isEmpty()) {
            arguments.add("hello");
        }

        //NOT WORKING AT ALL

        return null;
    }
}
