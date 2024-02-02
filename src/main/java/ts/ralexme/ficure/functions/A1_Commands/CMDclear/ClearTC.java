package ts.ralexme.ficure.functions.A1_Commands.CMDclear;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList; // CLASS FOR ARRAYLIST - ALI!
import java.util.Arrays;
import java.util.List;

public class ClearTC implements TabCompleter {

    List<String> arguments = new ArrayList<String>();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1) {
            return Arrays.asList("FunctionsCHAT", "inventory");
        }
        return new ArrayList<>();
    }
}
