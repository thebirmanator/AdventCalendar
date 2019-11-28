package games.indigo.adventcalendar;

import games.indigo.adventcalendar.api.Calendar;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdventCalendarCommand implements CommandExecutor {

	public String adventcalendar = "adventcalendar";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("darks.holiday.adventcalendar")) {
				Calendar calendar = Calendar.getCalendar(player);
				calendar.openCalendar();
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Sorry, you do not have permission to run this command.");
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Sorry, you cannot run this command.");
			return true;
		}
	}

}
