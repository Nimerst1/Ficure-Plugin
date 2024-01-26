package ts.ralexme.ficure.functions.clear;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList; // CLASS FOR ARRAYLIST - ALI!
import java.util.List;
import java.util.Locale;

public class ClearTC implements TabCompleter {

    List<String> arguments = new ArrayList<String>();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (arguments.isEmpty()) {
            arguments.add("chat");
        }

        //NOT WORKING AT ALL

        return null;
    }
}
