package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import at.AlexFW.MonitoringFW.MonitoringFW;

public class MonitoringRl_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

		if (sender.hasPermission("Wl.admin")) {

			reloadPlugin();
			sender.sendMessage(MonitoringFW.PREFIX + "§2 MonitoringFW wurde reloaded");

			return true;
		} else {
			sender.sendMessage(MonitoringFW.PREFIX + MonitoringFW.NO_PERM);
			return true;
		}

	}

	public static void reloadPlugin() {

		Bukkit.getOnlinePlayers().forEach(p -> {

			MonitoringFW.inMonitoringInv.put(p, false);
			MonitoringFW.monitoredPlayer.put(p, null);
			MonitoringFW.inTargetInvForEnchanting.put(p, false);

		});

	}

}
