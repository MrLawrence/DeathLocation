package bukkit.deathlocation;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	
	@EventHandler
	 public void death(PlayerDeathEvent event) {
	      Player deathPlayer = event.getEntity();
	      Location deathLocation = deathPlayer.getLocation();
	      World world = deathLocation.getWorld();
	      String worldName = world.getName();
	      int x = deathLocation.getBlockX();
	      int y = deathLocation.getBlockY();
	      int z = deathLocation.getBlockZ();
	      String locationString = x + "|" + y + "|" + z;
	      deathPlayer.sendMessage("You died on "+ worldName + " at " + locationString);
	    }
}
