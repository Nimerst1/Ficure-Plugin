package ts.ralexme.ficure;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.functions.ChatFunctions.chat;
import ts.ralexme.ficure.functions.calculate.CalculateCMD;
import ts.ralexme.ficure.functions.calculate.CalculateTC;
import ts.ralexme.ficure.functions.clear.ClearCMD;
import ts.ralexme.ficure.functions.clear.ClearTC;
import ts.ralexme.ficure.functions.cookies.feedCMD;
import ts.ralexme.ficure.functions.cookies.healCMD;
import ts.ralexme.ficure.functions.cookies.setfoodCMD;
import ts.ralexme.ficure.functions.cookies.sethealthCMD;
import ts.ralexme.ficure.functions.events.events;
import ts.ralexme.ficure.functions.kit.kits;
import ts.ralexme.ficure.functions.kit.kitsTC;
import ts.ralexme.ficure.functions.me.MeCMD;
import ts.ralexme.ficure.functions.me.MeTC;
import ts.ralexme.ficure.functions.spawnmob.spawnbossTC;
import ts.ralexme.ficure.functions.spawnmob.spawnboss;

import java.io.File;
import java.util.Objects;


public final class Ficure extends JavaPlugin implements Listener {
    public static final String ANSI_RED = "\u001B[31m";

    private static Ficure instance; //instance for config and others
    FileConfiguration config; //for config
    File cfile;  //for config


    @Override
    public void onEnable() {
        //----------------------------------------------------------------
        //ENABLING
        for(int count = 0; count < 100; count += 10) {
            System.out.println(ANSI_RED + "Ficure Ready for " + count + "%");
        }
        System.out.println(ANSI_RED + "Ficure by RalexME - Successfully enabled");
        //----------------------------------------------------------------
        //FUNCTIONS
        instance = this; //instance for config and others
        saveDefaultConfig(); //config.yml
        config = getConfig(); //config
        cfile = new File(getDataFolder(), "config.yml");



        Objects.requireNonNull(getCommand("clear")).setExecutor(new ClearCMD());
        Objects.requireNonNull(getCommand("clear")).setTabCompleter(new ClearTC());

        Objects.requireNonNull(getCommand("calculate")).setExecutor(new CalculateCMD());
        Objects.requireNonNull(getCommand("calculate")).setTabCompleter(new CalculateTC());

        Objects.requireNonNull(getCommand("me")).setExecutor(new MeCMD());
        Objects.requireNonNull(getCommand("me")).setTabCompleter(new MeTC());

        Objects.requireNonNull(getCommand("spawnboss")).setExecutor(new spawnboss());
        Objects.requireNonNull(getCommand("spawnboss")).setTabCompleter(new spawnbossTC());

        Objects.requireNonNull(getCommand("heal")).setExecutor(new healCMD());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feedCMD());

        Objects.requireNonNull(getCommand("setfood")).setExecutor(new setfoodCMD(this)); //with THIS we gave permission to have access to the server
        Objects.requireNonNull(getCommand("sethealth")).setExecutor(new sethealthCMD(this));

        Objects.requireNonNull(getCommand("kit")).setExecutor(new kits());
        Objects.requireNonNull(getCommand("kit")).setTabCompleter(new kitsTC());

        Objects.requireNonNull(getCommand("test")).setExecutor(new chat()); //no one need only me
        Objects.requireNonNull(getCommand("test2")).setExecutor(new chat()); //no one need only me meeen


        Objects.requireNonNull(getCommand("reloadFicure")).setExecutor(this);


        //listener registration
        getServer().getPluginManager().registerEvents(new events(), this);  //this -= is FICURE.JAVA
    }

    public static Ficure getInstance() {
        return instance;
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("reloadFicure")){
            config = YamlConfiguration.loadConfiguration(cfile);
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" -> " + ChatColor.GREEN + "Ficure config - reloaded successfully");
        }
        return true;
    }

    @Override
    public void onDisable() {
        System.out.println(ANSI_RED + "Ficure by RalexME - Successfully disabled");
    }
}
