package manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import at.AlexFW.MonitoringFW.MonitoringFW;
import enums.InventorySort;

public class InventoryManagerMonitoring {

	private final InventorySort type;
	private Inventory inv;
	private final Player klicker;

	public InventoryManagerMonitoring(final InventorySort type, final Player klicker) {

		this.type = type;
		this.klicker = klicker;

		switch (this.type) {

		case MONITORING:

			inv = Bukkit.createInventory(null, 5 * 9, MonitoringFW.monitoredPlayer.get(klicker).getDisplayName());
			createMonitoringInv();

			break;

		case TELEPORT:

			createTeleportInv();

			break;

		case FREEZE:

			createFreezeInv();

			break;

		case GAMEMODE:

			createGMInv();

			break;

		case FOOD:

			createFoodInv();

			break;

		case LEVEL:

			createLvlInv();

			break;

		case HEALTH:

			createHealthInv();

			break;

		case INVENTORY:

			createInventoryInv();

			break;

		case ENDERCHEST:

			createECInv();

			break;

		case INVENTORY_EXTRA:

			createInventoryExtraInv();

			break;

		case ENCHANTMENTS:

			createEnchantmentsInv();

			break;

		case ENCHANTING_LVL1:
			createEnchantingLvlInv1();

			break;

		case ENCHANTING_LVL2:
			createEnchantingLvlInv2();

			break;

		case ENCHANTING_LVL3:
			createEnchantingLvlInv3();

			break;

		case ENCHANTING_LVL4:
			createEnchantingLvlInv4();

			break;

		case ENCHANTING_LVL5:
			createEnchantingLvlInv5();

			break;

		case ENCHANTING_ITEM_CHOOSE:

			createEnchantingItemChooseInv();

			break;

		case ENCHANTING_ITEM_CHOOSE_EXTRA:

			createEnchantingItemChooseExtraInv();

			break;

		case ENCHANTING_ITEM_CHOOSE_EC:

			createEnchantingItemChooseECInv();

			break;

		case ENCHANTING_INV_CHOOSE:

			createEnchantingInvChoose();

			break;

		default:

			break;

		// MONITORING, TELEPORT, FREEZE, GAMEMODE, FOOD, LEVEL, HEALTH

		}

	}

	public Inventory build() {

		return this.inv;

	}

	public void openInv(final Player player) {

		player.openInventory(inv);

	}

	private void createMonitoringInv() {

		final Inventory mInv = Bukkit.createInventory(null, 5 * 9,
				MonitoringFW.monitoredPlayer.get(klicker).getDisplayName());

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack borderItem = new ItemManagerMonitoring(Material.LEAVES_2).setDisplayName(" ").build();

		final ItemStack kick = new ItemManagerMonitoring(Material.TNT).setDisplayName("§6Spieler kicken")
				.setLore("§cKickt den Spieler!").build();

		final ItemStack teleport = new ItemManagerMonitoring(Material.ENDER_PEARL).setDisplayName("§6Teleportieren")
				.setLore("§2Teleportiert dich zu diesem ", "§2Spieler oder umgekehrt!").build();

		final ItemStack inventory = new ItemManagerMonitoring(Material.CHEST).setDisplayName("§6Inventar")
				.setLore("§2Öffnet das Inventar!").build();

		final ItemStack enderChest = new ItemManagerMonitoring(Material.ENDER_CHEST).setDisplayName("§6Endertruhe")
				.setLore("§2Öffnet die Enderkiste!").build();

		final ItemStack infos = new ItemManagerMonitoring(Material.BOOK).setDisplayName("§6Informationen")
				.setLore("§2Zeigt Informationen über", "§2diesen Spieler an!").build();

		final ItemStack freeze = new ItemManagerMonitoring(Material.PACKED_ICE).setDisplayName("§6Einfrieren")
				.setLore("§9Friert den Spieler ein!").build();

		final ItemStack kill = new ItemManagerMonitoring(Material.DIAMOND_SWORD).setDisplayName("§6Spieler töten!")
				.setLore("§cTötet den Spieler!").build();

		final ItemStack setGM = new ItemManagerMonitoring(Material.NETHER_STAR).setDisplayName("§6Spielmodus ändern!")
				.setLore("§2Ändert den Spielmodus", "§2des Spielers").build();

		final ItemStack foodLevel = new ItemManagerMonitoring(Material.BREAD).setDisplayName("§6Hungerleiste ändern!")
				.setLore("§2Ändert die Hungerleiste", "§2des Spielers").build();

		final ItemStack setLvl = new ItemManagerMonitoring(Material.EXP_BOTTLE).setDisplayName("§aLevel ändern!")
				.setLore("§2Ändert das Level", "§2des Spielers").build();

		final ItemStack setHealth = new ItemManagerMonitoring(Material.POTION).setDisplayName("§6Leben ändern!")
				.setLore("§2Ändert die Leben", "§2des Spielers").build();

		final ItemStack heal = new ItemManagerMonitoring(Material.CAKE).setDisplayName("§6Heilen").setLore("§2Heilt den Spieler")
				.build();

		final ItemStack enchanting = new ItemManagerMonitoring(Material.ENCHANTMENT_TABLE).setDisplayName("§9Verzaubern")
				.setLore("§2Verzaubere ein item", "§2des Spielers").build();

//-------------------------------------------------------------------------------------------------------------------------------------------------------

		// 0 1 2 3 4 5 6 7 8
		final ItemStack[] contents = { borderItem, borderItem, borderItem, borderItem, borderItem, borderItem,
				borderItem, borderItem, borderItem,
				// 9 10 11 12 13 14 15 16 17
				borderItem, teleport, defaultItem, setGM, defaultItem, infos, defaultItem, freeze, borderItem,
				// 18 19 20 21 22 23 24 25 26
				borderItem, inventory, defaultItem, setLvl, enchanting, kill, defaultItem, setHealth, borderItem,
				// 27 28 29 30 31 32 33 34 35
				borderItem, enderChest, defaultItem, foodLevel, defaultItem, kick, defaultItem, heal, borderItem,
				// 36 37 38 39 40 41 42 43 44
				borderItem, borderItem, borderItem, borderItem, borderItem, borderItem, borderItem, borderItem,
				borderItem,

		};

		// 0 1 2 3 4 5 6 7 8
		// 9 10 11 12 13 14 15 16 17
		// 18 19 20 21 22 23 24 25 26 <-- Inventory
		// 27 28 29 30 31 32 33 34 35

//--------------------------------------------------------------------------------------------------------------------------------------------------------------

		mInv.setContents(contents);
		this.inv = mInv;

	}

	private void createFreezeInv() {

		final Inventory invF = Bukkit.createInventory(null, 9, "§9FREEZE");

		final ItemStack it1 = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack it2 = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§20").setLore("§9Freeze stoppen!")
				.build();

		final ItemStack it3 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§d5").setLore("§95 Sekunden!").build();

		final ItemStack it4 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§d10").setLore("§910 Sekunden!").build();

		final ItemStack it5 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§530").setLore("§930 Sekunden!").build();

		final ItemStack it6 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§560").setLore("§91 Minute! ").build();

		final ItemStack it7 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§5120").setLore("§92 Minuten!").build();

		final ItemStack it8 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§4300").setLore("§95 Minuten!").build();

		final ItemStack it9 = new ItemManagerMonitoring(Material.WATCH).setDisplayName("§4600").setLore("§910 Minuten!").build();

		final ItemStack[] contents = { it1, it2, it3, it4, it5, it6, it7, it8, it9 };

		invF.setContents(contents);

		this.inv = invF;

	}

	private void createTeleportInv() {

		final Inventory invT = Bukkit.createInventory(null, 9, "§6Teleport");

		final ItemStack teleportTo = new ItemManagerMonitoring(Material.EYE_OF_ENDER)
				.setDisplayName("§6Dich zum Spieler teleportieren!")
				.setLore("§5Teleportiert dich", "§5zu§2 " + MonitoringFW.monitoredPlayer.get(klicker).getDisplayName())
				.build();

		final ItemStack teleportHere = new ItemManagerMonitoring(Material.ENDER_PEARL)
				.setDisplayName("§6Spieler zu dir teleportieren!")
				.setLore("§5Teleportiert §2" + MonitoringFW.monitoredPlayer.get(klicker).getDisplayName(), "§5zu dir!")
				.build();

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		invT.setItem(0, defaultItem);
		invT.setItem(1, back);
		invT.setItem(2, defaultItem);
		invT.setItem(3, teleportTo);
		invT.setItem(4, defaultItem);
		invT.setItem(5, teleportHere);
		invT.setItem(6, defaultItem);
		invT.setItem(7, defaultItem);
		invT.setItem(8, defaultItem);

		this.inv = invT;

	}

	private void createFoodInv() {

		final Inventory foodInv = Bukkit.createInventory(null, 9, "§6Hungerleiste");

		final ItemStack it1 = new ItemManagerMonitoring(Material.ROTTEN_FLESH).setDisplayName("§cLeer")
				.setLore("§9Leert die Hungerleiste", "§9komplett").build();

		final ItemStack it2 = new ItemManagerMonitoring(Material.APPLE).setDisplayName("§6Hälfte")
				.setLore("§9Setzt die Hungerleiste", "§9auf die Hälfte").build();

		final ItemStack it3 = new ItemManagerMonitoring(Material.COOKED_BEEF).setDisplayName("§2Voll")
				.setLore("§9Füllt die Hungerleiste", "§9komplett auf").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		// =====================================================================================================

		if (MonitoringFW.monitoredPlayer.get(klicker).getFoodLevel() >= 18) {
			it3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

		} else if (MonitoringFW.monitoredPlayer.get(klicker).getFoodLevel() >= 10) {
			it2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

		}

		else {
			it1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

		}

		foodInv.setItem(0, back);
		foodInv.setItem(1, defaultItem);
		foodInv.setItem(2, defaultItem);
		foodInv.setItem(3, it1);
		foodInv.setItem(4, defaultItem);
		foodInv.setItem(5, it2);
		foodInv.setItem(6, defaultItem);
		foodInv.setItem(7, it3);
		foodInv.setItem(8, defaultItem);

		this.inv = foodInv;

	}

	private void createGMInv() {

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack gm0 = new ItemManagerMonitoring(Material.PORK).setDisplayName("§6Survival")
				.setLore("§2Setzt den Spieler", "§2in den Überlebens-Modus").build();

		final ItemStack gm1 = new ItemManagerMonitoring(Material.GOLDEN_APPLE).setDisplayName("§cCreative")
				.setLore("§2Setzt den Spieler", "§2in den Kreativ-Modus").build();

		final ItemStack gm2 = new ItemManagerMonitoring(Material.WOOD_SWORD).setDisplayName("§bAdventure")
				.setLore("§2Setzt den Spieler", "§2in den Abenteuer-Modus").build();

		final ItemStack gm3 = new ItemManagerMonitoring(Material.COMPASS).setDisplayName("§5Spectator")
				.setLore("§2Setzt den Spieler", "§2in den Zuschauer-Modus").build();

		switch (MonitoringFW.monitoredPlayer.get(klicker).getGameMode()) {

		case SURVIVAL:

			gm0.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
			break;

		case CREATIVE:
			gm1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		case ADVENTURE:
			gm2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		case SPECTATOR:
			gm3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		default:
			break;

		}

		final Inventory gmInv = Bukkit.createInventory(null, 9, "§6Spielmodus");

		gmInv.setItem(0, back);
		gmInv.setItem(1, defaultItem);
		gmInv.setItem(2, gm0);
		gmInv.setItem(3, defaultItem);
		gmInv.setItem(4, gm1);
		gmInv.setItem(5, defaultItem);
		gmInv.setItem(6, gm2);
		gmInv.setItem(7, defaultItem);
		gmInv.setItem(8, gm3);

		this.inv = gmInv;

	}

	private void createLvlInv() {

		final Inventory invL = Bukkit.createInventory(null, 9, "§2Level");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		// =====================================================================================================

		final ItemStack r1 = new ItemManagerMonitoring(Material.GLASS_BOTTLE, 1).setDisplayName("§aRemove 1 Level")
				.setLore("§2Nimmt dem Spieler", "§2ein Level weg").build();

		final ItemStack r5 = new ItemManagerMonitoring(Material.GLASS_BOTTLE, 5).setDisplayName("§aRemove 5 Level")
				.setLore("§2Nimmt dem Spieler", "§25 Level weg").build();

		final ItemStack r10 = new ItemManagerMonitoring(Material.GLASS_BOTTLE, 10).setDisplayName("§aRemove 10 Level")
				.setLore("§2Nimmt dem Spieler", "§210 Level weg").build();

		final ItemStack rAll = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§aRemove all Level").setAmount(1)
				.setLore("§2Nimmt dem Spieler", "§2alle §cLevel§2 weg").build();

		// =======================================================================================================

		final ItemStack a1 = new ItemManagerMonitoring(Material.EXP_BOTTLE, 1).setDisplayName("§aAdd 1 Level")
				.setLore("§2Gibt dem Spieler", "§2ein Level").build();

		final ItemStack a5 = new ItemManagerMonitoring(Material.EXP_BOTTLE, 5).setDisplayName("§aAdd 5 Level")
				.setLore("§2Gibt dem Spieler", "§25 Level").build();

		final ItemStack a10 = new ItemManagerMonitoring(Material.EXP_BOTTLE, 10).setDisplayName("§aAdd 10 Level")
				.setLore("§2Gibt dem Spieler", "§210 Level").build();

		final ItemStack[] contents = { back, defaultItem, rAll, r10, r5, r1, a1, a5, a10 };
		invL.setContents(contents);

		this.inv = invL;

	}

	private void createHealthInv() {

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack h1 = new ItemManagerMonitoring(Material.REDSTONE).setDisplayName("§c1 Herz")
				.setLore("§2Setzt die Leben", "des Spielers auf 1 Herz").build();

		final ItemStack h5 = new ItemManagerMonitoring(Material.REDSTONE, 5).setDisplayName("§c5 Herzen")
				.setLore("§2Setzt die Leben", "des Spielers auf 5 Herzen").build();

		final ItemStack h10 = new ItemManagerMonitoring(Material.REDSTONE, 10).setDisplayName("§c10 Herzen")
				.setLore("§2Setzt die Leben", "des Spielers auf  10 Herzen").build();

		final ItemStack h100 = new ItemManagerMonitoring(Material.REDSTONE, 100).setDisplayName("§c100 Herzen")
				.setLore("§2Setzt die Leben", "des Spielers auf 100 Herzen").build();

		@SuppressWarnings("deprecation")
		final int maxH = (int) MonitoringFW.monitoredPlayer.get(klicker).getMaxHealth();

		switch (Math.round(maxH)) {

		case 2:
			h1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;
		case 10:
			h5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		case 20:
			h10.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		case 200:
			h100.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);

			break;

		default:
			break;

		}

		final ItemStack[] contents = { back, defaultItem, h1, defaultItem, h5, defaultItem, h10,

				defaultItem, h100 };

		final Inventory hInv = Bukkit.createInventory(null, 9, "§cLeben");

		hInv.setContents(contents);

		this.inv = hInv;

	}

	private void createInventoryInv() {

		final Inventory iInv = Bukkit.createInventory(null, 9, "§6Inventar");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack openInv = new ItemManagerMonitoring(Material.CHEST).setDisplayName("§6Inventar öffnen")
				.setLore("§2Öffnet das §9Inventar", "§2des Spielers").build();

		final ItemStack switchInv = new ItemManagerMonitoring(Material.SHEARS).setDisplayName("§6Inventar tauschen")
				.setLore("§2Tauscht dein §9Inventar", "§2mit dem des Spielers").build();

		final ItemStack armorAndOff = new ItemManagerMonitoring(Material.ARMOR_STAND).setDisplayName("§6Extra")
				.setLore("§2Zeigt die §9Rüstung", "§2und §9Off-Hand§2 des Spielers").build();

		final ItemStack clear = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cInventar löschen")
				.setLore("§2Löscht das §9Inventar", "§2des Spielers").build();

		final ItemStack copy = new ItemManagerMonitoring(Material.FEATHER).setDisplayName("§6Inventar kopieren")
				.setLore("§2Kopiert das §9Inventar", "§2des Spielers in dein §9Inventar").build();

		final ItemStack[] contents = { back, defaultItem, defaultItem, openInv, armorAndOff, defaultItem, switchInv,
				copy, clear

		};

		iInv.setContents(contents);

		this.inv = iInv;

	}

	private void createECInv() {

		final Inventory ecInv = Bukkit.createInventory(null, 9, "§dEnderkiste");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack clear = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§dEnderkiste§c löschen")
				.setLore("§2Löscht alle Items in der ", "§dEnderkiste§2 des Spielers").build();

		final ItemStack copy = new ItemManagerMonitoring(Material.FEATHER).setDisplayName("§dEnderkiste §6kopieren")
				.setLore("§2Kopiert die §dEnderkiste", "§2des Spielers in dein Inventar").build();

		final ItemStack openInv = new ItemManagerMonitoring(Material.ENDER_CHEST).setDisplayName("§dEnderkiste§6 öffnen")
				.setLore("§2Öffnet die §dEnderkiste", "§2des Spielers").build();

		final ItemStack switchInv = new ItemManagerMonitoring(Material.SHEARS).setDisplayName("§dEnderkiste§6 tauschen")
				.setLore("§2Tauscht deine §dEnderkiste", "§2mit der §dEnderkiste §2Spielers").build();

		final ItemStack[] contents = { back, defaultItem, openInv, defaultItem, copy, defaultItem, switchInv,
				defaultItem, clear, };

		ecInv.setContents(contents);

		this.inv = ecInv;

	}

	@SuppressWarnings("deprecation")
	private void createInventoryExtraInv() {

		final Player target = MonitoringFW.monitoredPlayer.get(klicker);

		final Inventory extraInv = Bukkit.createInventory(null, 9 * 5, "§6Extras");

		final ItemStack air = new ItemStack(Material.AIR);

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack apply = new ItemManagerMonitoring(Material.DOUBLE_PLANT).setDisplayName("§6Anwenden")
				.setLore("§2Stattet den Spieler mit den", "§9ausgewählten Items§2 aus").build();

		final ItemStack offHandL = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cOff-Hand löschen")
				.setLore("§2Löscht das Item in", "§2der Off-Hand des Spielers").build();

		final ItemStack helmL = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cHelm löschen")
				.setLore("§2Löscht den Helm", "§2des Spielers").build();

		final ItemStack brustL = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cBrustplatte löschen")
				.setLore("§2Löscht die Brustplatte", "§2des Spielers").build();

		final ItemStack hoseL = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cHose löschen")
				.setLore("§2Löscht die Hose", "§2des Spielers").build();

		final ItemStack schuhL = new ItemManagerMonitoring(Material.BARRIER).setDisplayName("§cSchuhe löschen")
				.setLore("§2Löscht die Schuhe", "§2des Spielers").build();

		final ItemStack offHand = target.getEquipment().getItemInOffHand();
		final ItemStack head = target.getEquipment().getHelmet();
		final ItemStack body = target.getEquipment().getChestplate();
		final ItemStack leggings = target.getEquipment().getLeggings();
		final ItemStack shoes = target.getEquipment().getBoots();

		final ItemStack arrow1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		final SkullMeta aMeta1 = (SkullMeta) arrow1.getItemMeta();
		aMeta1.setDisplayName("§6Off-Hand");
		// aMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("a68f0b64-8d14-4000-a95f-4b9ba14f8df9")));
		aMeta1.setOwner("MHF_ArrowRight");
		arrow1.setItemMeta(aMeta1);

		final ItemStack arrow2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		final SkullMeta aMeta2 = (SkullMeta) arrow2.getItemMeta();
		aMeta2.setDisplayName("§6Helm");
		aMeta2.setOwner("MHF_ArrowRight");
		arrow2.setItemMeta(aMeta2);

		final ItemStack arrow3 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		final SkullMeta aMeta3 = (SkullMeta) arrow2.getItemMeta();
		aMeta3.setDisplayName("§6Brustplatte");
		aMeta3.setOwner("MHF_ArrowRight");
		arrow3.setItemMeta(aMeta3);

		final ItemStack arrow4 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		final SkullMeta aMeta4 = (SkullMeta) arrow2.getItemMeta();
		aMeta4.setDisplayName("§6Hose");
		aMeta4.setOwner("MHF_ArrowRight");
		arrow4.setItemMeta(aMeta4);

		final ItemStack arrow5 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		final SkullMeta aMeta5 = (SkullMeta) arrow2.getItemMeta();
		aMeta5.setDisplayName("§6Schuhe");
		aMeta5.setOwner("MHF_ArrowRight");
		arrow5.setItemMeta(aMeta5);
		final ItemStack[] contents = {

				offHandL, offHand, arrow1, air, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, helmL,
				head, arrow2, air, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, brustL, body,
				arrow3, air, defaultItem, defaultItem, apply, defaultItem, back, hoseL, leggings, arrow4, air,
				defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, schuhL, shoes, arrow5, air,
				defaultItem, defaultItem, defaultItem, defaultItem, defaultItem,

		};

		extraInv.setContents(contents);
		this.inv = extraInv;

		/*
		 * 
		 * | 1 O MHF_ArrowRight OPEN 5 6 7 8 9
		 * 
		 * | 1 H MHF_ArrowRight OPEN 5 6 7 8 9
		 * 
		 * | 1 B MHF_ArrowRight OPEN 5 Apply 7 8 9
		 * 
		 * | 1 T MHF_ArrowRight OPEN 5 6 7 8 9
		 * 
		 * | 1 S MHF_ArrowRight OPEN 5 Back 7 8 9
		 * 
		 */

	}

	private void createEnchantmentsInv() {

		final Inventory enchantmentsInv = Bukkit.createInventory(null, 9 * 5, "§9Verzauberungen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack aquaAffinity = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dWasseraffinität")
				.build();

		final ItemStack baneOfA = new ItemManagerMonitoring(Material.ENCHANTED_BOOK)
				.setDisplayName("§dVerderben der Gliederfüßer").build();

		final ItemStack blastP = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dExplosionsschutz").build();

		// final ItemStack channeling = new
		// ItemManager(Material.ENCHANTED_BOOK).setDisplayName("§dWasseraffinität")
		// .build();

		final ItemStack curseOfB = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dFluch der Bindung")
				.build();

		final ItemStack curseOfV = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dFluch des Verschwindens")
				.build();

		final ItemStack depthStrider = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dWasserläufer")
				.build();

		final ItemStack efficiency = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dEffizienz").build();

		final ItemStack featherFalling = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dFederfall").build();

		final ItemStack fireAspect = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dVerbrennung").build();

		final ItemStack fireP = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dFeuerschutz").build();

		final ItemStack flame = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dFlamme").build();

		final ItemStack fortune = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dGlück").build();

		final ItemStack frostWalker = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dEisläufer").build();

		// final ItemStack impaling = new
		// ItemManager(Material.ENCHANTED_BOOK).setDisplayName("§dWasseraffinität")
		// .build();

		final ItemStack infinity = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dUnendlichkeit").build();

		final ItemStack knockback = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dRückstoß").build();

		final ItemStack looting = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dPlünderung").build();

		// final ItemStack loyalty = new
		// ItemManager(Material.ENCHANTED_BOOK).setDisplayName("§dWasseraffinität").build();

		final ItemStack luckOfSea = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dGlück des Meeres")
				.build();

		final ItemStack lure = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dKöder").build();

		final ItemStack mending = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dReparatur").build();

		final ItemStack power = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dStärke").build();

		final ItemStack projectileP = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dSchusssicher").build();

		final ItemStack protection = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dSchutz").build();

		final ItemStack punch = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dSchlag").build();

		final ItemStack respiration = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dAtmung").build();

		// final ItemStack riptide = new
		// ItemManager(Material.ENCHANTED_BOOK).setDisplayName("§dWasseraffinität").build();

		final ItemStack sharpness = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dSchärfe").build();

		final ItemStack silk_touch = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dBehutsamkeit").build();

		final ItemStack smite = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dBann").build();

		final ItemStack sweepingEdge = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dSchwungkraft")
				.build();

		final ItemStack thorns = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dDornen").build();

		final ItemStack unbreaking = new ItemManagerMonitoring(Material.ENCHANTED_BOOK).setDisplayName("§dHaltbarkeit").build();

		final ItemStack[] contents = {

				back, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem,
				defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, defaultItem, aquaAffinity,
				baneOfA, blastP, curseOfB, curseOfV, depthStrider, efficiency, featherFalling, fireAspect, fireP, flame,
				fortune, frostWalker, infinity, knockback, looting, luckOfSea, lure, mending, power, projectileP,
				protection, punch, respiration, sharpness, silk_touch, smite, sweepingEdge, thorns, unbreaking,

		};

		enchantmentsInv.setContents(contents);
		this.inv = enchantmentsInv;

	}

	private void createEnchantingLvlInv1() {

		final Inventory l1Inv = Bukkit.createInventory(null, 9, "§6Level auswählen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack lvl1 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 1").build();

		final ItemStack[] contents = {

				defaultItem, defaultItem, back, defaultItem, defaultItem, lvl1, defaultItem, defaultItem

		};

		l1Inv.setContents(contents);
		this.inv = l1Inv;

	}

	private void createEnchantingLvlInv2() {

		final Inventory l2Inv = Bukkit.createInventory(null, 9, "§6Level auswählen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack lvl1 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 1").build();
		final ItemStack lvl2 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 2").setAmount(2).build();

		final ItemStack[] contents = {

				back, defaultItem, defaultItem, lvl1, defaultItem, lvl2, defaultItem, defaultItem

		};

		l2Inv.setContents(contents);
		this.inv = l2Inv;

	}

	private void createEnchantingLvlInv3() {

		final Inventory l3Inv = Bukkit.createInventory(null, 9, "§6Level auswählen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack lvl1 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 1").build();
		final ItemStack lvl2 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 2").setAmount(2).build();
		final ItemStack lvl3 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 3").setAmount(3).build();

		final ItemStack[] contents = {

				back, defaultItem, lvl1, defaultItem, lvl2, defaultItem, lvl3, defaultItem

		};

		l3Inv.setContents(contents);
		this.inv = l3Inv;

	}

	private void createEnchantingLvlInv4() {

		final Inventory l4Inv = Bukkit.createInventory(null, 9, "§6Level auswählen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack lvl1 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 1").build();
		final ItemStack lvl2 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 2").setAmount(2).build();
		final ItemStack lvl3 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 3").setAmount(3).build();
		final ItemStack lvl4 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 4").setAmount(4).build();

		final ItemStack[] contents = {

				back, defaultItem, defaultItem, lvl1, lvl2, lvl3, lvl4, defaultItem

		};

		l4Inv.setContents(contents);
		this.inv = l4Inv;

	}

	private void createEnchantingLvlInv5() {

		final Inventory l5Inv = Bukkit.createInventory(null, 9, "§6Level auswählen");

		final ItemStack defaultItem = new ItemManagerMonitoring(Material.STAINED_GLASS_PANE).setDisplayName(" ").build();

		final ItemStack back = new ItemManagerMonitoring(Material.SNOW_BALL).setDisplayName("§3Zurück").build();

		final ItemStack lvl1 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 1").build();
		final ItemStack lvl2 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 2").setAmount(2).build();
		final ItemStack lvl3 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 3").setAmount(3).build();
		final ItemStack lvl4 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 4").setAmount(4).build();
		final ItemStack lvl5 = new ItemManagerMonitoring(Material.GOLD_NUGGET).setDisplayName("§6Level 5").setAmount(5).build();

		final ItemStack[] contents = {

				back, defaultItem, lvl1, lvl2, lvl3, lvl4, lvl5, defaultItem

		};

		l5Inv.setContents(contents);
		this.inv = l5Inv;

	}

	private void createEnchantingItemChooseInv() {

		this.inv = MonitoringFW.monitoredPlayer.get(klicker).getInventory();

	}

	private void createEnchantingItemChooseExtraInv() {

	}

	private void createEnchantingItemChooseECInv() {

		this.inv = MonitoringFW.monitoredPlayer.get(klicker).getEnderChest();

	}

	private void createEnchantingInvChoose() {

	}

}
