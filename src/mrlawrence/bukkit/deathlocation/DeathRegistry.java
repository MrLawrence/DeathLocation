package mrlawrence.bukkit.deathlocation;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class DeathRegistry {
	private final Map<Player, Location> deathLocations = new HashMap<Player, Location>();

	public void put(Player player, Location location) {
		deathLocations.put(player, location);
	}

	public Location get(Player player) {
		return deathLocations.get(player);
	}

	public Boolean wasDead(Player player) {
		return deathLocations.containsKey(player);
	}
}
