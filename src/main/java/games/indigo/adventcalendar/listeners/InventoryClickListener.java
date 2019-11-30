package games.indigo.adventcalendar.listeners;

import games.indigo.adventcalendar.api.Calendar;
import games.indigo.adventcalendar.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(Calendar.isCalendar(event.getView())) {
			event.setCancelled(true);
			if(event.getCurrentItem() != null) {
				HumanEntity clicked = event.getWhoClicked();
				ItemStack currentItem = event.getCurrentItem();
				int slot = event.getSlot();
				if(currentItem != null) {
					if(currentItem.isSimilar(Calendar.getItem("available", slot + 1))) {
						if(clicked instanceof Player) {
							Calendar.getCalendar((Player) clicked).collect(slot + 1);
							clicked.sendMessage(Main.prefix + "Received gift for " + ChatColor.GREEN + "Day " + (slot + 1));
						}
					} else if(currentItem.isSimilar(Calendar.getItem("collected", slot + 1))) {
						clicked.sendMessage(Main.prefix + "You have already collected this item!");
					} else if(currentItem.isSimilar(Calendar.getItem("locked", slot + 1))){
						clicked.sendMessage(Main.prefix + "This item is still locked.");
					}
				}
			}
		}
	}
}
