package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import at.AlexFW.MonitoringFW.MonitoringFW;

public class Leave_LSTMonitoring implements Listener {

	@EventHandler
	public void onQuit(final PlayerQuitEvent e) {

		/*
		 * Mit besserem Lambda lösen(consumer, ...)
		 * 
		 * 
		 * if(Optional.ofNullable(MonitoringFW.monitoredPlayer.get(e.getPlayer())).
		 * isPresent()) {
		 * 
		 * MonitoringFW.monitoredPlayer.forEach((player, player2) ->{
		 * 
		 * if(e.getPlayer().equals(MonitoringFW.monitoredPlayer.get(player))) {
		 * 
		 * player.closeInventory(); player.sendMessage(MonitoringFW.PREFIX +
		 * "§6Der Spieler hat den Server verlassen!");
		 * 
		 * }
		 * 
		 * 
		 * });
		 * 
		 * }
		 * 
		 * 
		 * 
		 */

		if (MonitoringFW.monitoredPlayer.containsValue(e.getPlayer())) {

			for (final Player p : MonitoringFW.monitoredPlayer.keySet()) {

				if (e.getPlayer().equals(MonitoringFW.monitoredPlayer.get(p)) && MonitoringFW.inMonitoringInv.get(p)) {

					p.closeInventory();
					p.sendMessage(MonitoringFW.PREFIX + "§6Der Spieler hat den Server verlassen!");
					MonitoringFW.monitoredPlayer.put(p, null);

				}

			}

		}

	}

	@EventHandler
	public void onKick(final PlayerKickEvent e) {

		if (MonitoringFW.monitoredPlayer.containsValue(e.getPlayer())) {

			for (final Player p : MonitoringFW.monitoredPlayer.keySet()) {

				if (e.getPlayer().equals(MonitoringFW.monitoredPlayer.get(p))) {

					p.closeInventory();
					MonitoringFW.monitoredPlayer.put(p, null);

				}

			}

		}

	}

}
