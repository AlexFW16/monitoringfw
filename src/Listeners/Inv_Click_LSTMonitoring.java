package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import at.AlexFW.MonitoringFW.MonitoringFW;
import util.MonitoringUtils;

public class Inv_Click_LSTMonitoring implements Listener {

	public Inv_Click_LSTMonitoring() {

		super();
	}

	@EventHandler
	public void onInvClick(final InventoryClickEvent e) {

		if (e.getWhoClicked() instanceof Player) {

			final Player klicker = (Player) e.getWhoClicked();

			if (MonitoringFW.inMonitoringInv.get(klicker) == null)
				MonitoringFW.initPlayers();

			if (MonitoringFW.inMonitoringInv.get(klicker)) {

				if (klicker.hasPermission("Monitoring.monitor")) {

					if (e.getCurrentItem() == null)
						return;
					if (e.getCurrentItem().getItemMeta() == null)
						return;

					if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(e.getClickedInventory().getTitle()))) {

						e.setCancelled(true);

						MonitoringUtils.switchMonitoringInv(e.getCurrentItem().getItemMeta().getDisplayName(), klicker,
								Bukkit.getPlayer(e.getClickedInventory().getTitle()));
						MonitoringFW.monitoredPlayer.put(klicker, Bukkit.getPlayer(e.getClickedInventory().getTitle()));

					}

					else if (

					e.getClickedInventory().getTitle().equals("§9FREEZE")
							|| e.getClickedInventory().getTitle().equals("§6Teleport")
							|| e.getClickedInventory().getTitle().equals("§6Hungerleiste")

							|| e.getClickedInventory().getTitle().equals("§6Spielmodus")
							|| e.getClickedInventory().getTitle().equals("§2Level")

							|| e.getClickedInventory().getTitle().equals("§cLeben")
							|| e.getClickedInventory().getTitle().equals("§6Inventar")

							|| e.getClickedInventory().getTitle().equals("§dEnderkiste")
							|| e.getClickedInventory().getTitle().equals("§9Verzauberungen")

							|| e.getClickedInventory().getTitle().equals("§6Level auswählen")

					) {
						e.setCancelled(true);

						MonitoringUtils.switchMonitoringInv(e.getCurrentItem().getItemMeta().getDisplayName(), klicker,
								MonitoringFW.monitoredPlayer.get(klicker));

					}

					else if (e.getClickedInventory().getTitle().equals("§6Extras")) {

						if (e.getSlot() == 3 || e.getSlot() == 12 || e.getSlot() == 21 || e.getSlot() == 30
								|| e.getSlot() == 39) {

							e.setCancelled(false);

						} else {
							e.setCancelled(true);

							MonitoringUtils.switchMonitoringInv(e.getCurrentItem().getItemMeta().getDisplayName(),
									klicker, MonitoringFW.monitoredPlayer.get(klicker));

						}

						// klicker.sendMessage(MonitoringFW.PREFIX + MonitoringFW.PLAYER_NOT_AVAILABLE);

					}

				}

				else {
					klicker.sendMessage(MonitoringFW.PREFIX + MonitoringFW.NO_PERM);
				}

			}

			else if (MonitoringFW.inTargetInvForEnchanting.get(klicker)) {
				e.setCancelled(true);
				MonitoringUtils.switchTargetInvForEnch(klicker, e.getCurrentItem());

			}

			else {
				e.setCancelled(false);
			}

		}

		else {
			e.getWhoClicked().sendMessage(MonitoringFW.PREFIX + MonitoringFW.NOT_A_PLAYER);
		}

	}

}
