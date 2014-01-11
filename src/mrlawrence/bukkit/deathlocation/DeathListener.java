package mrlawrence.bukkit.deathlocation;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	private final MsgFormatter formatter;

	public DeathListener(MsgFormatter formatter) {
		this.formatter = formatter;
	}

	@EventHandler
	public void death(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player.hasPermission("deathlocation.automsg")) {
			String message = formatter.buildDeathMessage(player);
			player.sendMessage(message);
		}
	}
}
