package ts.ralexme.ficure.functions.A1_Commands.CMDkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ts.ralexme.ficure.Ficure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class kits implements CommandExecutor {


    private final Map<UUID, Long> cooldowns = new HashMap<>();  //cooldown Getting UUID, and long value
    private static final long cl_t = 3600000; //1 hour The cooldown

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Hey! You must be a player to use this command!");
            return false;
        } //Check for player
        Player player = (Player) commandSender;
        if(strings.length != 1) return false; //if strings nor equal 1(2) arguments
        //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------

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
            if(!commandSender.hasPermission("ficure.kitstart")){
                commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
                return true;
            }

            player.getInventory().addItem(sword_s, axe_s, pickaxe_s); //instruments
            player.getInventory().addItem(beef); //food
            //armor
            player.getEquipment().setBoots(boots_l);
            player.getEquipment().setLeggings(leggings_l);
            player.getEquipment().setChestplate(chestplate_l);
            player.getEquipment().setHelmet(helmet_l);

            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.BOLD +
                    " kit Start" + ChatColor.GRAY + "!");
            if(!(isCooldownExpired(player, cl_t))){
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + " Please wait ~1 hour before using this command again!"));
                return true;                    //SETTING COOLDOWN for start
            }
            setCooldown(player);
            return true;

        } else if (strings[0].equalsIgnoreCase("medium")) {
            if(!commandSender.hasPermission("ficure.kitmedium")){
                commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
                return true;
            }

            player.getInventory().addItem(sword_m, axe_m, pickaxe_m); //instruments
            player.getInventory().addItem(beef); //food
            player.getInventory().addItem(bow, arrow); //weapons
            //armor
            player.getEquipment().setBoots(boots_i);
            player.getEquipment().setLeggings(leggings_i);
            player.getEquipment().setChestplate(chestplate_i);
            player.getEquipment().setHelmet(helmet_i);

            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.BOLD +
                    " kit Medium" + ChatColor.GRAY + "!");
            if(!(isCooldownExpired(player, cl_t))){
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + " Please wait ~1 hour before using this command again!"));
                return true;                    //SETTING COOLDOWN for start 2
            }
            setCooldown(player);
            return true;
        }

        else if(strings[0].equalsIgnoreCase("maximum")){
            if(!commandSender.hasPermission("ficure.kitmaximum")){
                commandSender.sendMessage(ChatColor.RED + "You must have permission to use /" + command.getName());
                return true;
            }

            player.getInventory().addItem(sword_max, axe_max, pickaxe_max); //instruments
            player.getInventory().addItem(gapple, beef); //food
            player.getInventory().addItem(bow, arrow, arrow_max); //weapons
            //armor
            player.getEquipment().setBoots(boots_max);
            player.getEquipment().setLeggings(leggings_max);
            player.getEquipment().setChestplate(chestplate_max);
            player.getEquipment().setHelmet(helmet_max);

            commandSender.sendMessage(ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +" ->"
                    + ChatColor.GRAY + "You're successfully claimed" + ChatColor.BOLD +
                    " kit Maximum" + ChatColor.GRAY + "!");
            if(!(isCooldownExpired(player, cl_t))){
                commandSender.sendMessage((ChatColor.YELLOW + Ficure.getInstance().getConfig().getString("server_prefix") + ChatColor.DARK_GRAY +
                        " -> " + ChatColor.GRAY + " Please wait ~1 hour before using this command again!"));
                return true;                    //SETTING COOLDOWN for start 3
            }
            setCooldown(player);
            return true;
        }


        return false;
    }

    //------------------------SOME IMPORTS/CHECKS/FEATURES----------------------------
    private boolean isCooldownExpired(Player player, long cooldown) {
        final Long startTime = cooldowns.get(player.getUniqueId());
        if (startTime == null) {
            return true;
        }
        final long elapsedTime = System.currentTimeMillis() - startTime;       //Cooldown 2
        return elapsedTime >= cooldown;
    }

    private void setCooldown(Player player) {
        final Long currentTimeMillis = System.currentTimeMillis();
        cooldowns.merge(player.getUniqueId(), currentTimeMillis, (oldValue, newValue) -> newValue);
    }
    //------------------------/SOME IMPORTS/CHECKS/FEATURES----------------------------
}
