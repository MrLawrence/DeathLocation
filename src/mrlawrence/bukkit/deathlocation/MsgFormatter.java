package mrlawrence.bukkit.deathlocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MsgFormatter {
	private final JavaPlugin plugin;

	public MsgFormatter(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public String buildDeathMessage(Player player) {
		Object[] formatArgs = this.getArgs(player);
		String configMessage = plugin.getConfig().getString("message");
		String format = this.formatString(configMessage);
		format = addColor(format);
		return String.format(format, formatArgs);
	}

	private String addColor(String configString) {
		ChatColor color = ChatColor.WHITE;
		String configColor = plugin.getConfig().getString("color");
		try {
			color = ChatColor.valueOf(configColor);
		} catch (IllegalArgumentException e) {
			plugin.getLogger().warning(
					"Illegal 'color' value in config.yml: " + configColor);
		}
		return color + configString;
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
		Map<String, String> placeholders = new HashMap<String, String>();
		placeholders.put("$w", "%1$s");
		placeholders.put("$x", "%2$s");
		placeholders.put("$y", "%3$s");
		placeholders.put("$z", "%4$s");
		placeholders.put("$n", "%5$s");

		String formatted = configString;
		for (Entry<String, String> entry : placeholders.entrySet()) {
			formatted = formatted.replace(entry.getKey(), entry.getValue());
		}

		return formatted;
	}
}
