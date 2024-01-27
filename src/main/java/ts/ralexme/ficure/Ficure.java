package ts.ralexme.ficure;

import org.bukkit.plugin.java.JavaPlugin;
import ts.ralexme.ficure.functions.calculate.CalculateCMD;
import ts.ralexme.ficure.functions.calculate.CalculateTC;
import ts.ralexme.ficure.functions.clear.ClearCMD;
import ts.ralexme.ficure.functions.clear.ClearTC;
import ts.ralexme.ficure.functions.kit.kits;
import ts.ralexme.ficure.functions.me.MeCMD;
import ts.ralexme.ficure.functions.me.MeTC;
import ts.ralexme.ficure.functions.spawnmob.spawnboss;

import java.util.Objects;


public final class Ficure extends JavaPlugin {
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void onEnable() {
        //ENABLING
        for(int count = 0; count < 100; count += 10) {
            System.out.println(ANSI_RED + "Ficure Ready for " + count + "%");
        }
        System.out.println(ANSI_RED + "Ficure by RalexME - Successfully enabled");

        //FUNCTIONS
        saveDefaultConfig(); //config.yml
        Objects.requireNonNull(getCommand("clear")).setExecutor(new ClearCMD());
        Objects.requireNonNull(getCommand("clear")).setTabCompleter(new ClearTC());

        Objects.requireNonNull(getCommand("calculate")).setExecutor(new CalculateCMD());
        Objects.requireNonNull(getCommand("calculate")).setTabCompleter(new CalculateTC());

        Objects.requireNonNull(getCommand("me")).setExecutor(new MeCMD());
        Objects.requireNonNull(getCommand("me")).setTabCompleter(new MeTC());

        Objects.requireNonNull(getCommand("spawnboss")).setExecutor(new spawnboss());

        Objects.requireNonNull(getCommand("kit")).setExecutor(new kits());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
