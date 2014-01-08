package bukkit.deathlocation;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MsgFormatter {
	private FileConfiguration config;

	public MsgFormatter(FileConfiguration config) {
		this.config = config;
	}

	public String buildDeathMessage(Player player) {
		Object[] formatArgs = this.getArgs(player);
		String format = this.formatString(config.getString("message"));

		return String.format(format, formatArgs);
	}

	private Object[] getArgs(Player player) {
		Location location = player.getLocation();
		String world = location.getWorld().getName();
		String x = Integer.toString(location.getBlockX());
		String y = Integer.toString(location.getBlockY());
		String z = Integer.toString(location.getBlockZ());
		String playerName = player.getName();

		Object[] args = { world, x, y, z, playerName };
		return args;
	}

	private String formatString(String configString) {
		String formatted;
		formatted = configString.replace("$w", "%1$s");
		formatted = formatted.replace("$x", "%2$s");
		formatted = formatted.replace("$y", "%3$s");
		formatted = formatted.replace("$z", "%4$s");
		formatted = formatted.replace("$n", "%4$s");
		return formatted;
	}
}
