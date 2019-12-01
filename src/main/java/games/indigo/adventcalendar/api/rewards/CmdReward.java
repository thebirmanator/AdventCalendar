package games.indigo.adventcalendar.api.rewards;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CmdReward extends Reward {

    private String cmd;

    public CmdReward (String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void givePlayer (Player player) {
        String copy = cmd.replaceAll("%player%", player.getName());
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), copy);
    }
}
