package util;

public class Enchantment_WrapperMonitoring {

	private int level;
	private String ench;

	public Enchantment_WrapperMonitoring(final String ench, final int level) {
		this.ench = ench;
		this.level = level;
	};

	public int getLevel() {

		return this.level;

	}

	public String getEnch() {
		return this.ench;
	}

	public Enchantment_WrapperMonitoring setLevel(final int level) {
		this.level = level;
		return this;

	}

	public Enchantment_WrapperMonitoring setEnch(final String ench) {

		this.ench = ench;
		return this;
	}
}
