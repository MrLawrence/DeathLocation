package mrlawrence.bukkit.deathlocation;

import mrlawrence.bukkit.deathlocation.formatter.MsgFormatter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathLocCommand implements CommandExecutor {
	private final MsgFormatter formatter = new MsgFormatter();
	private DeathLocation plugin;

	public DeathLocCommand(DeathLocation plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				return false;
			}
			Player player = (Player) sender;
			if (plugin.wasDead(player)) {

				String message = formatter.buildCmdMsg(player,
						plugin.getConfig());
				player.sendMessage(message);
				return true;
			} else {
				player.sendMessage("Your last death wasn't registered");
			}
		}

		return false;
	}
}
