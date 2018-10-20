package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.AlexFW.MonitoringFW.MonitoringFW;
import enums.InventorySort;
import manager.InventoryManagerMonitoring;

public class Monitoring_CMD implements CommandExecutor {

	private final MonitoringFW plugin;

	public Monitoring_CMD(final MonitoringFW plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

		if (sender instanceof Player) {

			if (sender.hasPermission("MonitoringFW.monitor")) {

				if (args.length == 1) {

					if (args[0].equals("#reload") || args[0].equals("#reload")) {

						plugin.onEnable();
						return true;

					}

					else if (Bukkit.getPlayer(args[0]) != null
							&& Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {

						// ---------------------------------------------------------------------------------------------------

						MonitoringFW.monitoredPlayer.put((Player) sender, Bukkit.getPlayer(args[0]));
						new InventoryManagerMonitoring(InventorySort.MONITORING, (Player) sender).openInv((Player) sender);
						MonitoringFW.inMonitoringInv.put((Player) sender, true);
						return true;

						// -------------------------------------------------------------------------------------------------

					}

					else {

						sender.sendMessage(MonitoringFW.PREFIX + MonitoringFW.PLAYER_NOT_AVAILABLE);
						return true;
					}

				} else {

					sender.sendMessage(MonitoringFW.PREFIX + " /monitor <Player>");
					return true;

				}

			}

			else {

				sender.sendMessage(MonitoringFW.PREFIX + MonitoringFW.NO_PERM);
				return true;
			}

		}

		else {

			sender.sendMessage(MonitoringFW.PREFIX + MonitoringFW.NOT_A_PLAYER);
			return true;

		}

	}

}
