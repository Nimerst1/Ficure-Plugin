package ts.ralexme.ficure.functions.event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ts.ralexme.ficure.Ficure;

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
        player.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" -> " +  ChatColor.BOLD + ChatColor.DARK_RED + " You successfully connected to the " + Ficure.getInstance().getConfig().getString("server_prefix"));
    }

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e){ //Chat colors event
        //get the FunctionsCHAT message
        String original = e.getMessage();
        //format the FunctionsCHAT message with &colorCodes
        String formatted = ChatColor.translateAlternateColorCodes('&', original);
        //set the message to the formatted message
        e.setMessage(formatted);
    }
}