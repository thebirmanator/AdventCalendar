package games.indigo.adventcalendar;

import games.indigo.adventcalendar.api.rewards.Reward;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import games.indigo.adventcalendar.listeners.InventoryClickListener;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "HOLIDAY" + ChatColor.DARK_GRAY + " ⎜ " + ChatColor.GRAY;
	
	private AdventCalendarCommand adventcmd = new AdventCalendarCommand();
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		Reward.createPrizes();
		getCommand(adventcmd.adventcalendar).setExecutor(adventcmd);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Advent calendar enabled!");
	}
	
	public void onDisable() {
		saveConfig();
	}
}
