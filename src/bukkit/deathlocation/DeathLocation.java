package bukkit.deathlocation;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocation extends JavaPlugin {
	private final DeathListener deathListener = new DeathListener(this);
	
	@Override
	public void onEnable() {
	    this.saveDefaultConfig();
	    
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(deathListener, this);
	}

	@Override
	public void onDisable() {
	}
}