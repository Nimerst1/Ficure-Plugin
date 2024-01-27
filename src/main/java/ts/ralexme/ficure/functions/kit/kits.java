package ts.ralexme.ficure.functions.kit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class kits implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        if (!(commandSender instanceof Player)) return true; //Check for player
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments

        //itemstack's start
        ItemStack beef = new ItemStack(Material.COOKED_BEEF, 16);
        ItemStack sword_s = new ItemStack(Material.STONE_SWORD);
        ItemStack axe_s = new ItemStack(Material.STONE_AXE);
        ItemStack pickaxe_s = new ItemStack(Material.STONE_PICKAXE);
        ItemStack boots_l = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack leggings_l = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack chestplate_l = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack helmet_l = new ItemStack(Material.LEATHER_HELMET);

        //itemstack's medium
        ItemStack sword_m = new ItemStack(Material.IRON_SWORD);
        ItemStack axe_m = new ItemStack(Material.IRON_AXE);
        ItemStack pickaxe_m = new ItemStack(Material.IRON_PICKAXE);
        ItemStack boots_i = new ItemStack(Material.IRON_BOOTS);
        ItemStack leggings_i = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack chestplate_i = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack helmet_i = new ItemStack(Material.IRON_HELMET);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack arrow = new ItemStack(Material.ARROW, 32);

        //itemstack's maximum
        ItemStack sword_max = new ItemStack(Material.NETHERITE_SWORD);
        ItemStack axe_max = new ItemStack(Material.NETHERITE_AXE);
        ItemStack pickaxe_max = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemStack boots_max = new ItemStack(Material.NETHERITE_BOOTS);
        ItemStack leggings_max = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemStack chestplate_max = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack helmet_max = new ItemStack(Material.NETHERITE_HELMET);
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 8);
        ItemStack arrow_max = new ItemStack(Material.SPECTRAL_ARROW, 32);


        if (strings[0].equalsIgnoreCase("start")) {
            player.getInventory().addItem(sword_s, axe_s, pickaxe_s); //instruments
            player.getInventory().addItem(beef); //food
            //armor
            player.getEquipment().setBoots(boots_l);
            player.getEquipment().setLeggings(leggings_l);
            player.getEquipment().setChestplate(chestplate_l);
            player.getEquipment().setHelmet(helmet_l);

            commandSender.sendMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.DARK_GREEN +
                    " kit Start" + ChatColor.GRAY + "!");

            return true;
        } else if (strings[0].equalsIgnoreCase("medium")) {
            player.getInventory().addItem(sword_m, axe_m, pickaxe_m); //instruments
            player.getInventory().addItem(beef); //food
            player.getInventory().addItem(bow, arrow); //weapons
            //armor
            player.getEquipment().setBoots(boots_i);
            player.getEquipment().setLeggings(leggings_i);
            player.getEquipment().setChestplate(chestplate_i);
            player.getEquipment().setHelmet(helmet_i);

            commandSender.sendMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.DARK_GREEN +
                    " kit Medium" + ChatColor.GRAY + "!");

            return true;
        } else if(strings[0].equalsIgnoreCase("maximum")){
            player.getInventory().addItem(sword_max, axe_max, pickaxe_max); //instruments
            player.getInventory().addItem(gapple, beef); //food
            player.getInventory().addItem(bow, arrow, arrow_max); //weapons
            //armor
            player.getEquipment().setBoots(boots_max);
            player.getEquipment().setLeggings(leggings_max);
            player.getEquipment().setChestplate(chestplate_max);
            player.getEquipment().setHelmet(helmet_max);

            commandSender.sendMessage(ChatColor.YELLOW + "[server_prefix]" + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.DARK_GREEN +
                    " kit Maximum" + ChatColor.GRAY + "!");

            return true;
        }


        return false;
    }
}
