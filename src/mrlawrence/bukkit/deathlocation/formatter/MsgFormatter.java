package mrlawrence.bukkit.deathlocation.formatter;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MsgFormatter {
	private MsgReplacer replacer = new MsgReplacer();

	public String buildAutoMsg(Player player, FileConfiguration config) {
		return buildString(player, config.getString("auto-message"),
				config.getString("auto-color"));
	}

	public String buildCmdMsg(Player player, FileConfiguration config) {
		return buildString(player, config.getString("cmd-message"),
				config.getString("cmd-color"));
	}

	private String buildString(Player player, String message, String color) {
		Map<String, String> replacements = new HashMap<String, String>();

		Location location = player.getLocation();
		String world = location.getWorld().getName();
		String x = Integer.toString(location.getBlockX());
		String y = Integer.toString(location.getBlockY());
		String z = Integer.toString(location.getBlockZ());
		String playerName = player.getName();

		replacements.put("$w", world);
		replacements.put("$x", x);
		replacements.put("$y", y);
		replacements.put("$z", z);
		replacements.put("$n", playerName);

		String formatted = replacer.replace(message, replacements);
		formatted = addColor(formatted, color);
		return formatted;
	}

	private String addColor(String configString, String chatColor) {
		ChatColor color = ChatColor.WHITE;
		color = ChatColor.valueOf(chatColor);
		return color + configString;
	}
}
