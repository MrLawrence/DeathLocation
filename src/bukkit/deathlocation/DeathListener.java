package bukkit.deathlocation;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathListener implements Listener {
	private final JavaPlugin plugin;

	public DeathListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void death(PlayerDeathEvent event) {
		Player player = event.getEntity();

		Object[] formatArgs = getArgs(player.getLocation());

		String configString = plugin.getConfig().getString("message");
		String format = formatString(configString);

		String message = String.format(format, formatArgs);
		player.sendMessage(message);
	}

	private Object[] getArgs(Location location) {
		String world = location.getWorld().getName();
		String x = Integer.toString(location.getBlockX());
		String y = Integer.toString(location.getBlockY());
		String z = Integer.toString(location.getBlockZ());

		Object[] args = { world, x, y, z };
		return args;
	}

	private String formatString(String configString) {
		String formatted;
		formatted = configString.replace("$w", "%1$s");
		formatted = formatted.replace("$x", "%2$s");
		formatted = formatted.replace("$y", "%3$s");
		formatted = formatted.replace("$z", "%4$s");
		return formatted;
	}
}
