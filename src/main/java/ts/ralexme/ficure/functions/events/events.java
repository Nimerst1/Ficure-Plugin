package ts.ralexme.ficure.functions.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class events implements Listener {

    ItemStack helmet_netherite = new ItemStack(Material.NETHERITE_HELMET);
    @EventHandler
    public void ondeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Wither) {
            event.getDrops().clear();
            ItemStack netherite_scrap = new ItemStack(Material.NETHERITE_SCRAP, 5);
            ItemMeta ns_meta = netherite_scrap.getItemMeta();
            ns_meta.setDisplayName("Netherite scrap from Wither Boss");
            netherite_scrap.setItemMeta(ns_meta);
            event.getDrops().add(netherite_scrap);
        }
    }

    @EventHandler
    public void onspawn(EntitySpawnEvent event) {
        if(event.getEntity() instanceof Zombie){
            Zombie zombie = (Zombie) event.getEntity();
            zombie.setCustomName("Street Walker");
            zombie.setCustomNameVisible(true);
            zombie.getEquipment().setHelmet(helmet_netherite);
        }
    }
    @EventHandler
    public void handleJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer(); //Player info

        player.sendMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" -> " + player + ChatColor.BOLD + ChatColor.DARK_RED + " Connected to the [server_prefix]");
    }
}
