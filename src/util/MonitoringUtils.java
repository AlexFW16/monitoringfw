package util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import at.AlexFW.MonitoringFW.MonitoringFW;
import enums.InventorySort;
import manager.InventoryManagerMonitoring;

public class MonitoringUtils {

	private static MonitoringFW plugin;

	public MonitoringUtils(final MonitoringFW plugin) {

		MonitoringUtils.plugin = plugin;

	}

	public static void switchMonitoringInv(final String itemName, final Player klicker, final Player target) {

		if (itemName == null)
			return;

		switch (itemName) {

		case " ":

			break;

		case "§3Zurück":

			if (klicker.getOpenInventory().getTitle().equals("§6Extras"))
				extraOptions(klicker, target, "§3Zurück");

			else
				openMonitoringInv(klicker);
			break;

		case "§6Spieler kicken":
			kick(target, klicker);
			break;

		case "§6Teleportieren":
			openTeleportInv(klicker);
			break;

		case "§6Inventar":

			openInventoryInv(klicker);

			break;

		case "§6Endertruhe":
			openEcInv(klicker);
			break;

		case "§6Informationen":
			infos(klicker, target);

			break;

		case "§6Einfrieren":
			openFreezInv(klicker);

			break;

		case "§6Spieler töten!":
			kill(target, klicker);

			break;

		case "§6Spielmodus ändern!":
			openGMInv(klicker);
			break;

		case "§6Hungerleiste ändern!":
			openFoodLevelInv(klicker);

			break;

		case "§aLevel ändern!":
			openLvlInv(klicker);
			break;

		case "§6Leben ändern!":
			openHealthInv(klicker);
			break;

		case "§6Heilen":
			heal(klicker, target);
			break;

		// ============================================

		case "§20":
			freeze(klicker, target, 0);
			break;

		case "§d5":
			freeze(klicker, target, 5);
			break;

		case "§d10":
			freeze(klicker, target, 10);
			break;

		case "§530":
			freeze(klicker, target, 30);
			break;

		case "§560":
			freeze(klicker, target, 60);
			break;

		case "§5120":
			freeze(klicker, target, 120);
			break;

		case "§4300":
			freeze(klicker, target, 300);
			break;

		case "§4600":
			freeze(klicker, target, 600);
			break;

		// ============================================

		case "§6Dich zum Spieler teleportieren!":
			teleport(klicker, target, "toT");
			break;

		case "§6Spieler zu dir teleportieren!":
			teleport(klicker, target, "toK");

			break;
		// ============================================

		case "§cLeer":
			setFoodLevel(target, klicker, "null");
			break;

		case "§6Hälfte":
			setFoodLevel(target, klicker, "half");
			break;

		case "§2Voll":
			setFoodLevel(target, klicker, "full");

			break;
		// ============================================

		case "§6Survival":
			setGM(target, klicker, GameMode.SURVIVAL);
			break;

		case "§cCreative":
			setGM(target, klicker, GameMode.CREATIVE);

			break;

		case "§bAdventure":
			setGM(target, klicker, GameMode.ADVENTURE);

			break;

		case "§5Spectator":
			setGM(target, klicker, GameMode.SPECTATOR);

			break;

		// ============================================

		case "§aRemove 1 Level":
			setLvl(target, klicker, -1);
			break;

		case "§aRemove 5 Level":
			setLvl(target, klicker, -5);

			break;

		case "§aRemove 10 Level":
			setLvl(target, klicker, -10);

			break;

		case "§aRemove all Level":
			setLvl(target, klicker, 0);

			break;

		case "§aAdd 1 Level":
			setLvl(target, klicker, +1);

			break;

		case "§aAdd 5 Level":
			setLvl(target, klicker, +5);

			break;

		case "§aAdd 10 Level":
			setLvl(target, klicker, +10);

			break;

		// ============================================

		case "§c1 Herz":
			setHealth(klicker, target, 1);

			break;

		case "§c5 Herzen":
			setHealth(klicker, target, 5);
			break;

		case "§c10 Herzen":
			setHealth(klicker, target, 10);

			break;

		case "§c100 Herzen":
			setHealth(klicker, target, 100);

			break;

		// ============================================

		case "§6Inventar öffnen":
			inventoryOptions(klicker, target, "open");
			break;

		case "§6Inventar tauschen":
			inventoryOptions(klicker, target, "swap");

			break;

		case "§6Extra":
			inventoryOptions(klicker, target, "extra");
			break;

		case "§cInventar löschen":
			inventoryOptions(klicker, target, "clear");

			break;

		case "§6Inventar kopieren":
			inventoryOptions(klicker, target, "copy");

			break;

		// ============================================

		case "§dEnderkiste§c löschen":
			ecOptions(klicker, target, "clear");

			break;

		case "§dEnderkiste §6kopieren":
			ecOptions(klicker, target, "copy");

			break;

		case "§dEnderkiste§6 öffnen":
			ecOptions(klicker, target, "open");

			break;

		case "§dEnderkiste§6 tauschen":
			ecOptions(klicker, target, "swap");

			break;
		// ============================================

		case "§6Anwenden":

			extraOptions(klicker, target, "apply");

			break;

		case "§cOff-Hand löschen":

			extraOptions(klicker, target, "off-handL");

			break;

		case "§cHelm löschen":

			extraOptions(klicker, target, "helmL");

			break;

		case "§cBrustplatte löschen":

			extraOptions(klicker, target, "chestL");

			break;

		case "§cHose löschen":

			extraOptions(klicker, target, "leggingsL");

			break;

		case "§cSchuhe löschen":

			extraOptions(klicker, target, "bootsL");

			break;
		// ============================================

		case "§9Verzaubern":
			openEnchInv(klicker);
			break;

		case "§dWasseraffinität":
			enchantingOptions(klicker, "aquaAffinity", target);

			break;

		case "§dVerderben der Gliederfüßer":
			enchantingOptions(klicker, "baneOfA", target);
			break;

		case "§dExplosionsschutz":
			enchantingOptions(klicker, "blastP", target);
			break;

		case "§dFluch der Bindung":
			enchantingOptions(klicker, "curseOfB", target);
			break;

		case "§dFluch des Verschwindens":
			enchantingOptions(klicker, "curseOfV", target);
			break;

		case "§dWasserläufer":
			enchantingOptions(klicker, "depthStrider", target);
			break;

		case "§dEffizienz":
			enchantingOptions(klicker, "efficiency", target);
			break;

		case "§dFederfall":
			enchantingOptions(klicker, "featherFalling", target);
			break;

		case "§dVerbrennung":
			enchantingOptions(klicker, "fireAspect", target);
			break;

		case "§dFeuerschutz":
			enchantingOptions(klicker, "fireP", target);
			break;

		case "§dFlamme":
			enchantingOptions(klicker, "flame", target);
			break;

		case "§dGlück":
			enchantingOptions(klicker, "fortune", target);
			break;

		case "§dEisläufer":
			enchantingOptions(klicker, "frostWalker", target);
			break;

		case "§dUnendlichkeit":
			enchantingOptions(klicker, "infinity", target);
			break;

		case "§dRückstoß":
			enchantingOptions(klicker, "knockback", target);
			break;

		case "§dPlünderung":
			enchantingOptions(klicker, "looting", target);
			break;

		case "§dGlück des Meeres":
			enchantingOptions(klicker, "luckOfSea", target);
			break;

		case "§dKöder":
			enchantingOptions(klicker, "lure", target);
			break;

		case "§dReparatur":
			enchantingOptions(klicker, "mending", target);
			break;

		case "§dStärke":
			enchantingOptions(klicker, "power", target);
			break;

		case "§dSchusssicher":
			enchantingOptions(klicker, "projectileP", target);
			break;

		case "§dSchutz":
			enchantingOptions(klicker, "protection", target);
			break;

		case "§dSchlag":
			enchantingOptions(klicker, "punch", target);
			break;

		case "§dAtmung":
			enchantingOptions(klicker, "respiration", target);
			break;

		case "§dSchärfe":
			enchantingOptions(klicker, "sharpness", target);
			break;

		case "§dBehutsamkeit":
			enchantingOptions(klicker, "silk_touch", target);
			break;

		case "§dBann":
			enchantingOptions(klicker, "smite", target);
			break;

		case "§dSchwungkraft":
			enchantingOptions(klicker, "sweepingEdge", target);
			break;

		case "§dDornen":
			enchantingOptions(klicker, "thorns", target);
			break;

		case "§dHaltbarkeit":
			enchantingOptions(klicker, "unbreaking", target);
			break;
		// ============================================

		case "§6Level 1":
			switchLvlOptions(klicker, 1);
			break;

		case "§6Level 2":
			switchLvlOptions(klicker, 2);
			break;

		case "§6Level 3":
			switchLvlOptions(klicker, 3);
			break;

		case "§6Level 4":
			switchLvlOptions(klicker, 4);
			break;

		case "§6Level 5":
			switchLvlOptions(klicker, 5);
			break;
		default:

			break;

		}

	}

	public static void switchTargetInvForEnch(final Player klicker, final ItemStack item) {

		switch (MonitoringFW.currentEnchantment.get(klicker).getEnch()) {

		case "aquaAffinity":

			item.addUnsafeEnchantment(Enchantment.WATER_WORKER,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());
			klicker.sendMessage("adfs");
			break;

		case "baneOfA":
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "blastP":
			item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "curseOfB":
			item.addUnsafeEnchantment(Enchantment.BINDING_CURSE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "curseOfV":
			item.addUnsafeEnchantment(Enchantment.VANISHING_CURSE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "depthStrider":
			item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "efficiency":
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "featherFalling":
			item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "fireAspect":
			item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "fireP":
			item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "flame":
			item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "fortune":
			item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "frostWalker":
			item.addUnsafeEnchantment(Enchantment.FROST_WALKER,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "infinity":
			item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "knockback":
			item.addUnsafeEnchantment(Enchantment.KNOCKBACK, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "looting":
			item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "luckOfSea":
			item.addUnsafeEnchantment(Enchantment.LUCK, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "lure":
			item.addUnsafeEnchantment(Enchantment.LURE, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "mending":
			item.addUnsafeEnchantment(Enchantment.MENDING, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "power":
			item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "projectileP":
			item.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "protection":
			item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "punch":
			item.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "respiration":
			item.addUnsafeEnchantment(Enchantment.OXYGEN, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "sharpness":
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "silk_touch":
			item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "smite":
			item.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "sweepingEdge":
			item.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE,
					MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "thorns":
			item.addUnsafeEnchantment(Enchantment.THORNS, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		case "unbreaking":
			item.addUnsafeEnchantment(Enchantment.DURABILITY, MonitoringFW.currentEnchantment.get(klicker).getLevel());

			break;

		default:

			klicker.sendMessage(
					"§cAn Error has occured while trying to enchat the current Item[SwitchTargetInvForEnch -> switch(default)]");
			break;

		}

		new InventoryManagerMonitoring(InventorySort.MONITORING, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

//=================================================================================================================================================================================================
//=================================================================================================================================================================================================
//=================================================================================================================================================================================================

	// =========================================================================================================

	private static void openMonitoringInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.MONITORING, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openTeleportInv(final Player klicker) {
		new InventoryManagerMonitoring(InventorySort.TELEPORT, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openInventoryInv(final Player klicker) {
		new InventoryManagerMonitoring(InventorySort.INVENTORY, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openFreezInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.FREEZE, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openGMInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.GAMEMODE, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openFoodLevelInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.FOOD, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openLvlInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.LEVEL, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openHealthInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.HEALTH, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openEcInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.ENDERCHEST, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openInventoryExtraInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.INVENTORY_EXTRA, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);
	}

	private static void openEnchInv(final Player klicker) {

		new InventoryManagerMonitoring(InventorySort.ENCHANTMENTS, klicker).openInv(klicker);
		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	private static void openEnchLvlInv(final Player klicker, final int number) {

		switch (number) {

		case 1:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_LVL1, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);
			break;

		case 2:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_LVL2, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case 3:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_LVL3, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case 4:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_LVL4, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case 5:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_LVL5, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		default:
			klicker.sendMessage("§cAn Error has occured!");

			break;

		}

		MonitoringFW.inMonitoringInv.put(klicker, true);

	}

	// =========================================================================================================

	private static void heal(final Player klicker, final Player target) {

		klicker.setHealth(klicker.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
		klicker.sendMessage(MonitoringFW.PREFIX + "§3" + target.getDisplayName() + " §6 wurde §2§lgeheilt!");
		target.sendMessage(MonitoringFW.PREFIX + "§6Du wurdest geheilt!");

	}

	private static void kick(final Player target, final Player klicker) {

		if (!target.hasPermission("Wl.admin")) {
			target.kickPlayer(MonitoringFW.KICK);
			klicker.sendMessage(MonitoringFW.PREFIX + "§3" + target.getDisplayName() + " §6wurde gekickt!");
		}

		else {
			klicker.sendMessage(MonitoringFW.PREFIX + "§2" + target.getDisplayName() + "§c kann nicht gekickt werden!");
		}
	}

	private static void infos(final Player klicker, final Player target) {

		klicker.sendMessage(MonitoringFW.PREFIX);
		klicker.sendMessage("                               ");
		klicker.sendMessage("§6UUID: §2" + target.getUniqueId().toString());
		klicker.sendMessage("§6Ping: §2" + ((CraftPlayer) target).getHandle().ping);
		klicker.sendMessage("§6OP:" + target.isOp());
		klicker.sendMessage("------------------------");
		klicker.sendMessage("§6Gamemode:§2 " + target.getGameMode());
		klicker.sendMessage("§6Leben: §2" + target.getHealth());
		klicker.sendMessage("§6Level:§2 " + target.getLevel());
		klicker.sendMessage("§6Location: §2: " + "Welt: " + target.getLocation().getWorld().getName() + " §6|§2 X:"
				+ Math.round(target.getLocation().getX()) + " §6| §2Y: " + Math.round(target.getLocation().getY())
				+ " §6| §2Z: " + Math.round(target.getLocation().getZ()));

	}

	private static void kill(final Player target, final Player klicker) {

		klicker.sendMessage(MonitoringFW.PREFIX + "§3" + target.getDisplayName() + " §6 wurde getötet");
		target.sendMessage(MonitoringFW.KILL);
		target.setHealth(0);

	}

	private static void freeze(final Player klicker, final Player target, final int time) {

		if (time == 0) {
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Der Spieler §2" + target.getDisplayName()
					+ " §6ist nun nicht mehr eingefroren!");
			target.sendMessage(MonitoringFW.PREFIX + "§6Du bist nun nicht mehr eingefroren!");

		} else {

			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Der Spieler §2" + target.getDisplayName() + " §6wurde eingefroren!");
			target.sendMessage(MonitoringFW.PREFIX + "§6Du wurdest eingefroren!");
		}
		MonitoringFW.freezeTime.put(target, time * 4);

		final Location loc1 = target.getLocation();

		final int ID[] = new int[1];

		ID[0] = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

			if (!target.getLocation().equals(loc1)) {
				target.teleport(loc1);
				// target.playEffect(EntityEffect.SQUID_ROTATE);
				target.playSound(loc1, Sound.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
			}

			if (MonitoringFW.freezeTime.get(target) == 0) {

				Bukkit.getScheduler().cancelTask(ID[0]);

			} else {
				MonitoringFW.freezeTime.put(target, MonitoringFW.freezeTime.get(target) - 1);
			}

		}, 20, (long) (20 * 0.25));

	}

	private static void teleport(final Player klicker, final Player target, final String loc) {

		if (loc.equals("toK")) {

			target.teleport(klicker);
			klicker.sendMessage(MonitoringFW.PREFIX + "§3" + target.getName() + " §6wurde zu dir teleportiert");

		} else {

			klicker.teleport(target);
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Du wurdest zu " + "§3" + target.getName() + " §6teleportiert");

		}

	}

	// =========================================================================================================

	private static void setFoodLevel(final Player target, final Player klicker, final String amount) {

		if (amount.equals("full")) {

			target.setFoodLevel(20);
			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Hungerleiste wurde aufgefüllt");
			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Die Hungerleiste von §3" + target.getName() + " §6wurde aufgefüllt");
			new InventoryManagerMonitoring(InventorySort.FOOD, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

		}

		else if (amount.equals("half")) {

			target.setFoodLevel(10);
			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Hungerleiste wurde halbiert");
			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Die Hungerleiste von §3" + target.getName() + " §6wurde halbiert");
			new InventoryManagerMonitoring(InventorySort.FOOD, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

		} else {
			target.setFoodLevel(0);
			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Hungerleiste wurde geleert");
			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Die Hungerleiste von §3" + target.getName() + " §6wurde geleert");
			new InventoryManagerMonitoring(InventorySort.FOOD, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

		}

	}

	private static void setGM(final Player target, final Player klicker, final GameMode gm) {

		switch (gm) {

		case SURVIVAL:

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Der Spielmodus von §3" + target.getDisplayName()
					+ " §6wurde auf §2§lÜberleben§r§6 geändert");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Spielmodus wurde auf §2§lÜberleben§r§6 geändert");
			target.setGameMode(GameMode.SURVIVAL);
			new InventoryManagerMonitoring(InventorySort.GAMEMODE, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case CREATIVE:

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Der Spielmodus von §3" + target.getDisplayName()
					+ " §6wurde auf §2§lKreativ§r§6 geändert");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Spielmodus wurde auf §2§lKreativ§r§6 geändert");
			target.setGameMode(GameMode.CREATIVE);
			new InventoryManagerMonitoring(InventorySort.GAMEMODE, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case SPECTATOR:

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Der Spielmodus von §3" + target.getDisplayName()
					+ " §6wurde auf §2§lZuschauer§r§6 geändert");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Spielmodus wurde auf §2§lZuschauer§r§6 geändert");
			target.setGameMode(GameMode.SPECTATOR);
			new InventoryManagerMonitoring(InventorySort.GAMEMODE, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		case ADVENTURE:

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Der Spielmodus von §3" + target.getDisplayName()
					+ " §6wurde auf §2§lAbenteuer§r§6 geändert");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Spielmodus wurde auf §2§lAbenteuer§r§6 geändert");
			target.setGameMode(GameMode.ADVENTURE);
			new InventoryManagerMonitoring(InventorySort.GAMEMODE, klicker).openInv(klicker);
			MonitoringFW.inMonitoringInv.put(klicker, true);

			break;

		}

	}

	private static void setLvl(final Player target, final Player klicker, final int amount) {

		switch (amount) {

		case 0:

			target.setLevel(0);
			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Level wurden auf §2§l0§r§6 gesetzt");
			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l0§r§6 gesetzt");

			break;

		case -1:

			target.setLevel(target.getLevel() - 1);
			target.sendMessage("§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		case -5:

			target.setLevel(target.getLevel() - 5);
			target.sendMessage("§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		case -10:

			target.setLevel(target.getLevel() - 10);
			target.sendMessage(
					MonitoringFW.PREFIX + "§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		case +1:

			target.setLevel(target.getLevel() + 1);
			target.sendMessage(
					MonitoringFW.PREFIX + "§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		case +5:

			target.setLevel(target.getLevel() + 5);
			target.sendMessage(
					MonitoringFW.PREFIX + "§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		case +10:

			target.setLevel(target.getLevel() + 10);
			target.sendMessage(
					MonitoringFW.PREFIX + "§6Deine Level wurden auf §2§l" + target.getLevel() + "§r§6 gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Level von §3" + target.getName() + "§6 wurden auf §2§l"
					+ target.getLevel() + "§r§6 gesetzt");

			break;

		}

	}

	private static void setHealth(final Player klicker, final Player target, final int amount) {

		// 1 5 10 100

		switch (amount) {

		case 1:

			target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2L);
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());

			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Herzen wurden auf§2§l " + amount + " §r§6gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Herzen von §3" + target.getName() + " §6wurden auf §2§l"
					+ amount + " §r§6gesetzt");

			break;

		case 5:

			target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(10L);
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());

			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Herzen wurden auf§2§l " + amount + " §r§6gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Herzen von §3" + target.getName() + " §6wurden auf §2§l"
					+ amount + " §r§6gesetzt");

			break;

		case 10:
			target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20L);
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());

			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Herzen wurden auf§2§l " + amount + " §r§6gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Herzen von §3" + target.getName() + " §6wurden auf §2§l"
					+ amount + " §r§6gesetzt");

			break;

		case 100:
			target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(200L);
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());

			target.sendMessage(MonitoringFW.PREFIX + "§6Deine Herzen wurden auf§2§l " + amount + " §r§6gesetzt");
			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die Herzen von §3" + target.getName() + " §6wurden auf §2§l"
					+ amount + " §r§6gesetzt");

			break;

		}

	}

	// =========================================================================================================

	private static void inventoryOptions(final Player klicker, final Player target, final String type) {

		switch (type) {

		case "open":

			klicker.openInventory(target.getInventory());

			break;

		case "swap":

			ItemStack[] kCon = klicker.getInventory().getContents();
			ItemStack[] tCon = target.getInventory().getContents();
			ItemStack[] helpCon;

			helpCon = kCon;

			kCon = tCon;

			tCon = helpCon;

			klicker.getInventory().setContents(kCon);
			target.getInventory().setContents(tCon);

			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Dein Inventar wurde mit dem von §3" + target.getName() + "§6 getauscht");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Inventar wurde verändert");

			break;

		case "extra":

			openInventoryExtraInv(klicker);

			break;

		case "clear":

			final ItemStack[] clearC = {};
			target.getInventory().setContents(clearC);

			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Das Inventar von§3 " + target.getName() + " §6wurde §c§lgelöscht§r");
			target.sendMessage(MonitoringFW.PREFIX + "§6Dein Inventar wurde §c§lgelöscht§r");

			break;

		case "copy":

			final ItemStack[] tarCon = target.getInventory().getContents();

			klicker.getInventory().setContents(tarCon);

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Das Inventar von §3" + target.getName()
					+ " §6wurde in dein Inventar§6 kopiert");

			break;

		}

	}

	private static void ecOptions(final Player klicker, final Player target, final String type) {

		switch (type) {

		case "open":

			klicker.openInventory(target.getEnderChest());

			break;

		case "copy":

			final ItemStack[] tarCon = target.getEnderChest().getContents();

			klicker.getInventory().setContents(tarCon);

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Die §dEnderkiste§6 von §3" + target.getName()
					+ " §6wurde in dein Inventar kopiert");

			break;

		case "clear":

			final ItemStack[] clear = {};

			target.getEnderChest().setContents(clear);

			klicker.sendMessage(
					MonitoringFW.PREFIX + "§6Die §dEnderkiste§6 von§3 " + target.getName() + " §6wurde §c§lgelöscht§r");

			break;

		case "swap":

			ItemStack[] kCon = klicker.getEnderChest().getContents();
			ItemStack[] tCon = target.getEnderChest().getContents();
			ItemStack[] helpCon;

			helpCon = kCon;

			kCon = tCon;

			tCon = helpCon;

			klicker.getEnderChest().setContents(kCon);
			target.getEnderChest().setContents(tCon);

			klicker.sendMessage(MonitoringFW.PREFIX + "§6Deine §dEnderkiste§6 wurde mit der §dEnderkiste§6 von §3"
					+ target.getName() + "§6 getauscht");

			break;

		}

	}

	private static void extraOptions(final Player klicker, final Player target, final String type) {

		// 3, 12, 21, 30, 39

		switch (type) {

		case " ":

			break;

		case "apply":

			if (!klicker.getOpenInventory().getItem(3).getType().equals(Material.AIR))
				target.getEquipment().setItemInOffHand(klicker.getOpenInventory().getItem(3));
			if (!klicker.getOpenInventory().getItem(12).getType().equals(Material.AIR))
				target.getEquipment().setHelmet(klicker.getOpenInventory().getItem(12));
			if (!klicker.getOpenInventory().getItem(21).getType().equals(Material.AIR))
				target.getEquipment().setChestplate(klicker.getOpenInventory().getItem(21));
			if (!klicker.getOpenInventory().getItem(30).getType().equals(Material.AIR))
				target.getEquipment().setLeggings(klicker.getOpenInventory().getItem(30));
			if (!klicker.getOpenInventory().getItem(39).getType().equals(Material.AIR))
				target.getEquipment().setBoots(klicker.getOpenInventory().getItem(39));

			openInventoryExtraInv(klicker);

			break;

		case "§3Zurück":

			if (!klicker.getOpenInventory().getItem(3).getType().equals(Material.AIR)) {
				klicker.getInventory().addItem(klicker.getOpenInventory().getItem(3));
			}

			if (!klicker.getOpenInventory().getItem(12).getType().equals(Material.AIR)) {
				klicker.getInventory().addItem(klicker.getOpenInventory().getItem(12));

			}

			if (!klicker.getOpenInventory().getItem(21).getType().equals(Material.AIR)) {
				klicker.getInventory().addItem(klicker.getOpenInventory().getItem(21));

			}

			if (!klicker.getOpenInventory().getItem(30).getType().equals(Material.AIR)) {
				klicker.getInventory().addItem(klicker.getOpenInventory().getItem(30));

			}

			if (!klicker.getOpenInventory().getItem(39).getType().equals(Material.AIR)) {
				klicker.getInventory().addItem(klicker.getOpenInventory().getItem(39));

			}

			openMonitoringInv(klicker);
			break;

		case "off-handL":

			target.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
			openInventoryExtraInv(klicker);

			break;

		case "helmL":
			target.getEquipment().setHelmet(new ItemStack(Material.AIR));
			openInventoryExtraInv(klicker);

			break;

		case "chestL":
			target.getEquipment().setChestplate(new ItemStack(Material.AIR));
			openInventoryExtraInv(klicker);

			break;

		case "leggingsL":
			target.getEquipment().setLeggings(new ItemStack(Material.AIR));
			openInventoryExtraInv(klicker);

			break;

		case "bootsL":
			target.getEquipment().setBoots(new ItemStack(Material.AIR));
			openInventoryExtraInv(klicker);

			break;

		default:
			break;

		}

	}

	private static void enchantingOptions(final Player klicker, final String enchantment, final Player target) {

		switch (enchantment) {

		case "aquaAffinity":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("aquaAffinity", 0));
			klicker.sendMessage(MonitoringFW.currentEnchantment.get(klicker).getEnch());
			break;

		case "baneOfA":
			openEnchLvlInv(klicker, 5);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("baneOfA", 0));

			break;

		case "blastP":
			openEnchLvlInv(klicker, 4);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("blastP", 0));

			break;

		case "curseOfB":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("curseOfB", 0));

			break;

		case "curseOfV":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("curseOfV", 0));

			break;

		case "depthStrider":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("depthStrider", 0));

			break;

		case "efficiency":
			openEnchLvlInv(klicker, 5);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("efficiency", 0));

			break;

		case "featherFalling":
			openEnchLvlInv(klicker, 4);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("featherFalling", 0));

			break;

		case "fireAspect":
			openEnchLvlInv(klicker, 2);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("fireAspect", 0));

			break;

		case "fireP":
			openEnchLvlInv(klicker, 4);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("fireP", 0));

			break;

		case "flame":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("flame", 0));

			break;

		case "fortune":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("fortune", 0));

			break;

		case "frostWalker":
			openEnchLvlInv(klicker, 2);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("frostWalker", 0));

			break;

		case "infinity":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("infinity", 0));

			break;

		case "knockback":
			openEnchLvlInv(klicker, 2);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("knockback", 0));

			break;

		case "looting":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("looting", 0));

			break;

		case "luckOfSea":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("luckOfSea", 0));

			break;

		case "lure":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("lure", 0));

			break;

		case "mending":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("mending", 0));

			break;

		case "power":
			openEnchLvlInv(klicker, 5);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("power", 0));

			break;

		case "projectileP":
			openEnchLvlInv(klicker, 4);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("projectileP", 0));

			break;

		case "protection":
			openEnchLvlInv(klicker, 4);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("protection", 0));

			break;

		case "punch":
			openEnchLvlInv(klicker, 2);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("punch", 0));

			break;

		case "respiration":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("respiration", 0));

			break;

		case "sharpness":
			openEnchLvlInv(klicker, 5);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("sharpness", 0));

			break;

		case "c":
			openEnchLvlInv(klicker, 1);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("sharpness", 0));

			break;

		case "smite":
			openEnchLvlInv(klicker, 5);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("smite", 0));

			break;

		case "sweepingEdge":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("sweepingEdge", 0));

			break;

		case "thorns":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("thorns", 0));

			break;

		case "unbreaking":
			openEnchLvlInv(klicker, 3);
			MonitoringFW.currentEnchantment.put(klicker, new Enchantment_WrapperMonitoring("unbreaking", 0));

			break;

		}

	}

	private static void switchLvlOptions(final Player klicker, final int level) {

		switch (level) {

		case 1:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_ITEM_CHOOSE, klicker).openInv(klicker);
			MonitoringFW.currentEnchantment.put(klicker, MonitoringFW.currentEnchantment.get(klicker).setLevel(1));
			MonitoringFW.inMonitoringInv.put(klicker, false);
			MonitoringFW.inTargetInvForEnchanting.put(klicker, true);
			break;

		case 2:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_ITEM_CHOOSE, klicker).openInv(klicker);
			MonitoringFW.currentEnchantment.put(klicker, MonitoringFW.currentEnchantment.get(klicker).setLevel(2));
			MonitoringFW.inMonitoringInv.put(klicker, false);
			MonitoringFW.inTargetInvForEnchanting.put(klicker, true);

			break;

		case 3:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_ITEM_CHOOSE, klicker).openInv(klicker);
			MonitoringFW.currentEnchantment.put(klicker, MonitoringFW.currentEnchantment.get(klicker).setLevel(3));
			MonitoringFW.inMonitoringInv.put(klicker, false);
			MonitoringFW.inTargetInvForEnchanting.put(klicker, true);

			break;

		case 4:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_ITEM_CHOOSE, klicker).openInv(klicker);
			MonitoringFW.currentEnchantment.put(klicker, MonitoringFW.currentEnchantment.get(klicker).setLevel(4));
			MonitoringFW.inMonitoringInv.put(klicker, false);
			MonitoringFW.inTargetInvForEnchanting.put(klicker, true);

			break;

		case 5:
			new InventoryManagerMonitoring(InventorySort.ENCHANTING_ITEM_CHOOSE, klicker).openInv(klicker);
			MonitoringFW.currentEnchantment.put(klicker, MonitoringFW.currentEnchantment.get(klicker).setLevel(5));
			MonitoringFW.inMonitoringInv.put(klicker, false);
			MonitoringFW.inTargetInvForEnchanting.put(klicker, true);

			break;

		default:

			klicker.sendMessage("An Error has occured while: switchLvLOptions");
			break;

		}

	}

}
