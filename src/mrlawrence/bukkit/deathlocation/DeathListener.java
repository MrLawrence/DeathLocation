package mrlawrence.bukkit.deathlocation;

import mrlawrence.bukkit.deathlocation.formatter.MsgFormatter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	private final MsgFormatter formatter = new MsgFormatter();;
	private DeathLocation plugin;

	public DeathListener(DeathLocation plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void death(PlayerDeathEvent event) {
		Player player = event.getEntity();
		plugin.addDeathLocation(player, player.getLocation());

		if (player.hasPermission("deathlocation.automsg")) {
			String message = formatter.buildAutoMsg(player,
					plugin.getConfig());
			player.sendMessage(message);
		}
	}
}
