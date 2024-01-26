package ts.ralexme.ficure.functions.spawnmob;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class spawnboss implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        String pName = player.getName();

        if(strings[0].equalsIgnoreCase("enderman")) {
            //functions
            Enderman enderman = (Enderman) player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMAN);
            enderman.setMaxHealth(300);
            enderman.setHealth(300);
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 10));
            //text
            enderman.setCustomName(ChatColor.RED + "ENDERMAN BOSS" + " SUMMONED BY: " + pName);
            Bukkit.broadcastMessage((ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + pName + " Summoned: EnderMan" + ChatColor.DARK_RED + " BOSS" + ChatColor.GRAY + "!"));
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
            Bukkit.broadcastMessage((ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + pName + " Summoned: Creeper" + ChatColor.DARK_RED + " BOSS" + ChatColor.GRAY + "!"));
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
            Bukkit.broadcastMessage((ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + pName + " Summoned: Wither" + ChatColor.DARK_RED + " BOSS" + ChatColor.GRAY + "!"));
            //sound
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.7F, 0.7F);
            return true;
        }

        return false;
    }
}
