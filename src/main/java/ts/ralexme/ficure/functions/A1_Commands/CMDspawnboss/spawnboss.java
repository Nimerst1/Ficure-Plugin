package ts.ralexme.ficure.functions.A1_Commands.CMDspawnboss;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class spawnboss implements CommandExecutor, Listener {

    private final Map<UUID, Long> cooldowns = new HashMap<>();  //cooldown Getting UUID, and long value
    private static final long cl_t = 300000; //300 sec The cooldown


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player

        Player player = (Player) commandSender;
        String pName = player.getName();
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments

        if(!commandSender.hasPermission("ficure.spawnboss")){
            commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
            return true;
        }

        if(!(isCooldownExpired(player, cl_t))){
            commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                    " -> " + ChatColor.GRAY + " Please wait ~5 min before using this command again!"));
            return true;                    //SETTING COOLDOWN / MESSAGE
        }
        setCooldown(player);
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------


        ItemStack helmet_max = new ItemStack(Material.NETHERITE_HELMET);

        if(strings[0].equalsIgnoreCase("enderman")) {
            //functions
            Enderman enderman = (Enderman) player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMAN);
            enderman.setMaxHealth(300);
            enderman.setHealth(300);
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 10));
            //text
            enderman.setCustomName(ChatColor.RED + "ENDERMAN BOSS" + " SUMMONED BY: " + pName);
            Bukkit.broadcastMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY + " -> "
                    + ChatColor.GRAY + pName + " Summoned: EnderMan" + ChatColor.DARK_RED
                    + " BOSS" + ChatColor.GRAY + "!"));
            //sound
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.7F, 0.7F);
            return true;
        }
        else if(strings[0].equalsIgnoreCase("creeper")){
            //functions
            Creeper creeper = (Creeper) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
            creeper.setMaxHealth(300);
            creeper.setHealth(300);
            creeper.setPowered(true);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 10));
            //text
            creeper.setCustomName(ChatColor.RED + "CREEPER BOSS" + " SUMMONED BY: " + pName);
            Bukkit.broadcastMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY + " -> "
                    + ChatColor.GRAY + pName + " Summoned: Creeper" + ChatColor.DARK_RED
                    + " BOSS" + ChatColor.GRAY + "!"));
            //sound
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.7F, 0.7F);
            return true;
        }
        else if (strings[0].equalsIgnoreCase("wither")) {
            //functions
            Wither wither = (Wither) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITHER);
            wither.setHealth(300);
            wither.setMaxHealth(300);
            wither.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 60, 3));
            //text
            wither.setCustomName(ChatColor.RED + "WITHER BOSS" + " SUMMONED BY: " + pName);
            Bukkit.broadcastMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY + " -> "
                    + ChatColor.GRAY + pName + " Summoned: Wither" + ChatColor.DARK_RED
                    + " BOSS" + ChatColor.GRAY + "!"));
            //sound
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.7F, 0.7F);
            //drop
            return true;
        }
        else if(strings[0].equalsIgnoreCase("skeleton")) {
            //functions
            Skeleton skeleton = (Skeleton) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON);
            skeleton.setMaxHealth(300);
            skeleton.setHealth(300);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 10));
            skeleton.getEquipment().setHelmet(helmet_max);

            //text
            skeleton.setCustomName(ChatColor.RED + "SKELETON BOSS" + " SUMMONED BY: " + pName);
            Bukkit.broadcastMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY + " -> "
                    + ChatColor.GRAY + pName + " Summoned: Skeleton" + ChatColor.DARK_RED
                    + " BOSS" + ChatColor.GRAY + "!"));
            //sound
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.7F, 0.7F);
            return true;
        }

        return false;
    }

    //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
    private boolean isCooldownExpired(Player player, long cooldown) {
        final Long startTime = cooldowns.get(player.getUniqueId());
        if(startTime == null){
            return true;
        }
        final long elapsedTime = System.currentTimeMillis() - startTime;       //Cooldown 2
        return elapsedTime >=  cooldown;
    }
    private void setCooldown(Player player) {
        final Long currentTimeMillis = System.currentTimeMillis();
        cooldowns.merge(player.getUniqueId(), currentTimeMillis, (oldValue, newValue) -> newValue);
    }
    //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------
}
