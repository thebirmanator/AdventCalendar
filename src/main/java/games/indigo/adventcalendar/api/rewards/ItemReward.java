package games.indigo.adventcalendar.api.rewards;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ItemReward extends Reward {

    private ItemStack item;

    public ItemReward(ItemStack item) {
        this.item = item;
    }

    @Override
    public void givePlayer(Player player) {
        HashMap<Integer, ItemStack> failed = player.getInventory().addItem(item);
        if (!failed.isEmpty()) {
            for (ItemStack fail : failed.values()) {
                player.getWorld().dropItem(player.getLocation(), fail);
            }
        }
    }
}
