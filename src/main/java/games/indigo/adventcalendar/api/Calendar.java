package games.indigo.adventcalendar.api;

import games.indigo.adventcalendar.Main;
import games.indigo.adventcalendar.api.rewards.Reward;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private Player player;
    private Inventory inv;
    private Main main;
    private static String name = ChatColor.GREEN + "Advent Calendar";

    private Calendar(Player player) {
        this.player = player;
        main = Main.getPlugin(Main.class);
        if (player.getOpenInventory().getTitle().equals(name)) {
            inv = player.getOpenInventory().getTopInventory();
        } else {
            inv = Bukkit.createInventory(null, 27, name);
            int day = LocalDate.now().getDayOfMonth();
            for (int i = 1; i < 26; i++) {
                if (i <= day) {
                    if (hasCollected(i)) {
                        inv.setItem(i - 1, getItem("collected", i));
                    } else {
                        inv.setItem(i - 1, getItem("available", i));
                    }
                } else {
                    inv.setItem(i - 1, getItem("locked", i));
                }
            }
        }
    }

    public static Reward getReward(int day) {
        return Reward.getRewards().get(day - 1);
    }

    public boolean hasCollected(int day) {
        List<Integer> collected = main.getConfig().getIntegerList(player.getUniqueId().toString());
        return collected.contains(day);
    }

    public void collect(int day) {
        getReward(day).givePlayer(player);
        inv.setItem(day - 1, Calendar.getItem("collected", day));
        List<Integer> collected = main.getConfig().getIntegerList(player.getUniqueId().toString());
        collected.add(day);
        main.getConfig().set(player.getUniqueId().toString(), collected);
    }

    public void openCalendar() {
        player.openInventory(inv);
    }

    public static boolean isCalendar(InventoryView view) {
        return view != null && view.getTitle().equals(name);
    }

    public static ItemStack getItem(String type, int day) {
        ItemStack item = new ItemStack(Material.AIR);
        switch (type) {
            case "available":
                Material amaterial = Material.DRIED_KELP_BLOCK;
                String aname = ChatColor.GREEN + "" + ChatColor.BOLD + "Open Me!";
                List<String> alore = new ArrayList<String>();
                alore.add(ChatColor.RED + "Day " + day);
                alore.add("");
                alore.add(ChatColor.WHITE + "Click to collect");
                item = createItem(amaterial, 1, aname, alore);
                break;
            case "collected":
                Material cmaterial = Material.SCUTE;
                String cname = ChatColor.GREEN + "" + ChatColor.BOLD + "Already Opened";
                List<String> clore = new ArrayList<String>();
                clore.add(ChatColor.RED + "Day " + day);
                clore.add("");
                clore.add(ChatColor.GRAY + "You have already collected this day's gift");
                item = createItem(cmaterial, 1, cname, clore);
                break;
            case "locked":
                Material lmaterial = Material.DARK_OAK_DOOR;
                String lname = ChatColor.GREEN + "" + ChatColor.BOLD + "Locked";
                List<String> llore = new ArrayList<String>();
                llore.add(ChatColor.RED + "Day " + day);
                llore.add("");
                llore.add(ChatColor.GRAY + "You must wait until the right day to open this");
                item = createItem(lmaterial, 1, lname, llore);
                break;
            default:
                break;
        }
        return item;
    }

    public static ItemStack createItem(Material material, int amount, String name, List<String> lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static String getInvName() {
        return name;
    }

    public static Calendar getCalendar(Player player) {
        return new Calendar(player);
    }
}
