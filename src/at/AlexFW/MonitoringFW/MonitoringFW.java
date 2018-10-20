package at.AlexFW.MonitoringFW;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.MonitoringRl_CMD;
import Commands.Monitoring_CMD;
import Listeners.InvClose_LSTMonitoring;
import Listeners.Inv_Click_LSTMonitoring;
import Listeners.Join_LSTMonitoring;
import Listeners.Leave_LSTMonitoring;
import util.Enchantment_WrapperMonitoring;
import util.MonitoringUtils;

public class MonitoringFW extends JavaPlugin {

	public static String PREFIX;
	public static String KICK;
	public static String KILL;
	public static String NO_PERM;
	public static String NOT_A_PLAYER;
	public static String PLAYER_NOT_AVAILABLE;
	public static String FOOD_LEVEL_CHANGE_MESSAGE;
	public static String FREEZE_MESSAGE;
	public static String LEVEL_CHANGE_MESSAGE;

	// ------------------------------------------------------------------------------

	public static HashMap<Player, Boolean> inMonitoringInv = new HashMap<>();
	// public static HashMap<Player, Boolean> freezed = new HashMap<>();

	public static HashMap<Player, Integer> freezeTime = new HashMap<>();

	public static HashMap<Player, Player> monitoredPlayer = new HashMap<>();

	public static HashMap<Player, Enchantment_WrapperMonitoring> currentEnchantment = new HashMap<>();

	public static HashMap<Player, Boolean> inTargetInvForEnchanting = new HashMap<>();

	// Deprecation MHF_Arrow in INV-MNG
	// Items des Spielers enchanten (auch Rüssi)
	// kein freeze bei disconnect -> ändern
	// Zurück bei extraInvOptions unbedingt auf lambda ändern!
	// mit Wl.admin perm kann man nicht gekickt werden
	// wenn monitored person die gleiche wie ausführender, keine doppelte message!
	@Override
	public void onEnable() {

		super.onDisable();

		initConfig();
		initCommandsAndListeners();
		initVars();

		initPlayers();

		new MonitoringUtils(this);

	}

	@Override
	public void onDisable() {

		super.onDisable();
	}

	private void initConfig() {

		if (!new File(this.getDataFolder(), "config.yml").exists()) {
			getConfig().options().copyDefaults();
			// getConfig().set("Prefix", "MonitoringFW");
			getConfig().set("KickMessage", "default kickmessage");
			getConfig().set("KillMessage", "default killmessage");
			getConfig().set("No_Perm", "no Permission");
			getConfig().set("Not_A_Player", "Not a Player");
			getConfig().set("Player_Not_Available", "Player is not available");

			saveConfig();
		}

	}

	private void initCommandsAndListeners() {

		this.getCommand("monitor").setExecutor(new Monitoring_CMD(this));
		this.getCommand("monitorrl").setExecutor(new MonitoringRl_CMD());

		// ---------------------------------------------------------------------------

		this.getServer().getPluginManager().registerEvents(new Join_LSTMonitoring(), this);
		this.getServer().getPluginManager().registerEvents(new Leave_LSTMonitoring(), this);
		this.getServer().getPluginManager().registerEvents(new Inv_Click_LSTMonitoring(), this);
		this.getServer().getPluginManager().registerEvents(new InvClose_LSTMonitoring(), this);

	}

	public MonitoringFW getInstance() {

		return new MonitoringFW();

	}

	private void initVars() {

		// MonitoringFW.PREFIX = ChatColor.translateAlternateColorCodes('&',
		// getConfig().getString("Prefix")) + " ";
		MonitoringFW.PREFIX = "§b۞ §6Wunderland§b ۞ ";
		MonitoringFW.KICK = ChatColor.translateAlternateColorCodes('&', getConfig().getString("KickMessage"));
		MonitoringFW.KILL = ChatColor.translateAlternateColorCodes('&', getConfig().getString("KillMessage"));
		MonitoringFW.NO_PERM = ChatColor.translateAlternateColorCodes('&', getConfig().getString("No_Perm"));
		MonitoringFW.NOT_A_PLAYER = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Not_A_Player"));
		MonitoringFW.PLAYER_NOT_AVAILABLE = ChatColor.translateAlternateColorCodes('&',
				getConfig().getString("Player_Not_Available"));

	}

	public static void initPlayers() {

		Bukkit.getOnlinePlayers().forEach(p -> {

			MonitoringFW.monitoredPlayer.put(p, null);
			MonitoringFW.currentEnchantment.put(p, null);
			MonitoringFW.inMonitoringInv.put(p, false);
			MonitoringFW.inTargetInvForEnchanting.put(p, false);

		});

	}

}
