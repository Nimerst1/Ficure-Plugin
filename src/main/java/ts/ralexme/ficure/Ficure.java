package ts.ralexme.ficure;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.functions.A1_Commands.CMDsetfood.setfoodTC;
import ts.ralexme.ficure.functions.A1_Commands.CMDsethealth.sethealthTC;
import ts.ralexme.ficure.functions.B1_Commands.broadcastCMD;
import ts.ralexme.ficure.functions.Z0_TestFUNCTIONs.FunctionsCHAT;
import ts.ralexme.ficure.functions.A1_Commands.CMDcalculate.CalculateCMD;
import ts.ralexme.ficure.functions.A1_Commands.CMDcalculate.CalculateTC;
import ts.ralexme.ficure.functions.A1_Commands.CMDclear.ClearCMD;
import ts.ralexme.ficure.functions.A1_Commands.CMDclear.ClearTC;
import ts.ralexme.ficure.functions.B1_Commands.feedCMD;
import ts.ralexme.ficure.functions.B1_Commands.healCMD;
import ts.ralexme.ficure.functions.A1_Commands.CMDsetfood.setfoodCMD;
import ts.ralexme.ficure.functions.A1_Commands.CMDsethealth.sethealthCMD;
import ts.ralexme.ficure.functions.event.events;
import ts.ralexme.ficure.functions.A1_Commands.CMDkit.kits;
import ts.ralexme.ficure.functions.A1_Commands.CMDkit.kitsTC;
import ts.ralexme.ficure.functions.A1_Commands.CMDme.MeCMD;
import ts.ralexme.ficure.functions.A1_Commands.CMDme.MeTC;
import ts.ralexme.ficure.functions.A1_Commands.CMDspawnboss.spawnbossTC;
import ts.ralexme.ficure.functions.A1_Commands.CMDspawnboss.spawnboss;

import java.io.File;
import java.util.Objects;


public final class Ficure extends JavaPlugin implements Listener {
    public static final String ANSI_RED = "\u001B[31m";
    private static Ficure instance; //instance for config and others
    FileConfiguration config; //for config
    File cfile;  //for config


    @Override
    public void onEnable() {
        //-------------------------- ENABLING --------------------------
        for(int count = 0; count < 100; count += 10) {
            getServer().getLogger().info(ANSI_RED + "Ficure Ready for " + count + "%");
        }
        getServer().getLogger().info(ANSI_RED + "Ficure by RalexME - Successfully enabled");
        //------------------------- /ENABLING -----------------------------


        //-------------------------- NOW FOR CONFIG --------------------------
        instance = this; //instance for config and others
        saveDefaultConfig(); //config.yml
        config = getConfig(); //config
        cfile = new File(getDataFolder(), "config.yml"); //getting config.yml
        //-------------------------- /NOW FOR CONFIG --------------------------



        //--------------------------- FUNCTIONS --------------------------------
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

        Objects.requireNonNull(getCommand("setfood")).setExecutor(new setfoodCMD(this)); //with THIS we gave access to the server
        Objects.requireNonNull(getCommand("setfood")).setTabCompleter(new setfoodTC());

        Objects.requireNonNull(getCommand("sethealth")).setExecutor(new sethealthCMD(this)); //with THIS we gave access to the server
        Objects.requireNonNull(getCommand("sethealth")).setTabCompleter(new sethealthTC());

        Objects.requireNonNull(getCommand("kit")).setExecutor(new kits());
        Objects.requireNonNull(getCommand("kit")).setTabCompleter(new kitsTC());

        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new broadcastCMD());

        Objects.requireNonNull(getCommand("reloadFicure")).setExecutor(this);


        //listener/event registration
        getServer().getPluginManager().registerEvents(new events(), this);  //this -= is FICURE.JAVA
        //------------------------ /FUNCTIONS ----------------------------------------

        //------------------------ TEST FUNCTIONS ------------------------------------
        Objects.requireNonNull(getCommand("test")).setExecutor(new FunctionsCHAT()); //no one need only me
        Objects.requireNonNull(getCommand("test2")).setExecutor(new FunctionsCHAT()); //no one need only me men
        //------------------------ /TEST FUNCTIONS -------------------------------------
    }

    public static Ficure getInstance() {
        return instance;
    } //FOR CONFIG READ! not needed*

    //------------------------- CONFIG RELOAD --------------------------------
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("reloadFicure")){
            config = YamlConfiguration.loadConfiguration(cfile);
            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" -> " + ChatColor.GREEN + "Ficure config - reloaded successfully");
        }
        return true;
    }
    //------------------------- /CONFIG RELOAD --------------------------------


    //------------------------- DISABLING -------------------------------------
    @Override
    public void onDisable() {

        getServer().getLogger().info(ANSI_RED + "Ficure by RalexME - Successfully disabled");
    }
    //------------------------- /DISABLING ------------------------------------
}
