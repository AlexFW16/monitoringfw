package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import at.AlexFW.MonitoringFW.MonitoringFW;

public class Join_LSTMonitoring implements Listener {

	public Join_LSTMonitoring() {

	}

	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {

		MonitoringFW.inMonitoringInv.put(e.getPlayer(), false);

		MonitoringFW.monitoredPlayer.put(e.getPlayer(), null);

		MonitoringFW.inTargetInvForEnchanting.put(e.getPlayer(), false);

	}

}
