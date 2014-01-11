package mrlawrence.bukkit.deathlocation;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocation extends JavaPlugin {

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		MsgFormatter formatter = new MsgFormatter(this);
		DeathListener deathListener = new DeathListener(formatter);
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(deathListener, this);
	}
}