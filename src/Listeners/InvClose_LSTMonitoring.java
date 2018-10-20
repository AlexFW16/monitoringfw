package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import at.AlexFW.MonitoringFW.MonitoringFW;

public class InvClose_LSTMonitoring implements Listener {

	public InvClose_LSTMonitoring() {

	}

	@EventHandler
	public void onClose(final InventoryCloseEvent e) {

		MonitoringFW.inMonitoringInv.put((Player) e.getPlayer(), false);
		MonitoringFW.inTargetInvForEnchanting.put((Player) e.getPlayer(), false);
	}

}
