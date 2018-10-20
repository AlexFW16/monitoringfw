package manager;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManagerMonitoring {

	private final ItemStack itemStack;
	private final ItemMeta itemMeta;

	public ItemManagerMonitoring(final Material material) {

		this.itemStack = new ItemStack(material);
		this.itemMeta = itemStack.getItemMeta();

	}

	public ItemManagerMonitoring setDisplayName(final String name) {

		itemMeta.setDisplayName(name);
		return this;
	}

	public ItemManagerMonitoring(final Material material, final int amount) {

		this.itemStack = new ItemStack(material, amount);
		this.itemMeta = itemStack.getItemMeta();

	}

	public ItemManagerMonitoring setAmount(final int amount) {
		itemStack.setAmount(amount);
		return this;
	}

	public ItemManagerMonitoring setLore(final String... strings) {

		itemMeta.setLore(Arrays.asList(strings));
		;

		return this;

	}

	public ItemStack build() {
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

}
