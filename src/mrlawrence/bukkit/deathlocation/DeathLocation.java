package mrlawrence.bukkit.deathlocation;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocation extends JavaPlugin {
	private DeathListener deathListener;
	private DeathRegistry registry = new DeathRegistry();

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		deathListener = new DeathListener(this);

		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(deathListener, this);

		getCommand("mydeathloc").setExecutor(new DeathLocCommand(this));
	}

	public void addDeathLocation(Player player, Location location) {
		registry.put(player, location);
	}

	public Location getDeathLocation(Player player) {
		return registry.get(player);
	}

	public Boolean wasDead(Player player) {
		return registry.wasDead(player);
	}
}
