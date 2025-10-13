package core;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import listeners.AttributeChangeListener;
import listeners.PerkChangeListener;

public class Character {
	private PerkChangeListener perkListener;
	private AttributeChangeListener specialListener;
	private Attribute[] special = new Attribute[7];
	private final Map<Perk, Integer> perks = new EnumMap<>(Perk.class);

	@Deprecated
	public Character() {
		this.special[0] = new Attribute(Stat.Strength, 1);
		this.special[1] = new Attribute(Stat.Perception, 1);
		this.special[2] = new Attribute(Stat.Endurance, 1);
		this.special[3] = new Attribute(Stat.Charisma, 1);
		this.special[4] = new Attribute(Stat.Intelligence, 1);
		this.special[5] = new Attribute(Stat.Agility, 1);
		this.special[6] = new Attribute(Stat.Luck, 1);
	}

	public Character(PerkChangeListener perkListener, AttributeChangeListener specialListener) {
		this.special[0] = new Attribute(Stat.Strength, 1);
		this.special[1] = new Attribute(Stat.Perception, 1);
		this.special[2] = new Attribute(Stat.Endurance, 1);
		this.special[3] = new Attribute(Stat.Charisma, 1);
		this.special[4] = new Attribute(Stat.Intelligence, 1);
		this.special[5] = new Attribute(Stat.Agility, 1);
		this.special[6] = new Attribute(Stat.Luck, 1);
		this.perkListener = perkListener;
		this.specialListener = specialListener;

	}
	
	public void removeStalePerks() {
		for (Perk perk : perks.keySet()) {
			if (this.special[perk.getStatType()].getAttributeLevel() < perk.getStatReq()) {
				this.removePerk(perk);
			}
		}
	}
	
	private void removePerk(Perk perk) {
		int currentLevel = perks.getOrDefault(perk, 0);
		perks.remove(perk);
		perkListener.perkChanged(perk, currentLevel, 0, true);
	}
	
	public void skillPerk(Perk perk) {
		if (perk.getStatReq() > this.special[perk.getStatType()].getAttributeLevel()) {
			return;
		}
		int currentValue = perks.getOrDefault(perk, 0);
		if (currentValue >= perk.getRanks()) {
			return;
		}
		perks.put(perk, currentValue + 1);
		perkListener.perkChanged(perk, currentValue, currentValue + 1, false);
	}

	public void unskillPerk(Perk perk) {
		int currentValue = perks.getOrDefault(perk, 0);
		if (currentValue > 0) {
			if (currentValue > 1) {
				perks.put(perk, currentValue - 1);
				perkListener.perkChanged(perk, currentValue, currentValue - 1, false);
			} else {
				perks.remove(perk);
				perkListener.perkChanged(perk, currentValue, 0, false);
			}

		}
	}

	public void skillAttribute(Stat attribute) {
		Attribute toChange = this.special[attribute.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		if (toChange.skillAttribute()) {
			specialListener.attributeChanged(toChange, oldValue, oldValue + 1, false);
		}
	}

	public void unskillAttribute(Stat attribute) {
		Attribute toChange = this.special[attribute.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		if (toChange.unskillAttribute()) {
			specialListener.attributeChanged(toChange, oldValue, oldValue - 1, false);
		}
	}

	public void boostAttribute(Stat attribute, int boost) {
		Attribute toChange = this.special[attribute.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		toChange.boostAttribute(boost);
		specialListener.attributeChanged(toChange, oldValue, oldValue + boost, true);
	}

	public int getPerkLevel(Perk perk) {
		return this.perks.getOrDefault(perk, 0);
	}

	public int getAttributeLevel(Stat attribute) {
		return this.special[attribute.ordinal()].getAttributeLevel();
	}

	public int getMaximumPerkLevelRequirement() {
		int maximum = 0;
		int current = -1;
		for (Map.Entry<Perk, Integer> entry : perks.entrySet()) {
			current = entry.getKey().getLevelReq(entry.getValue());
			if (current > maximum) {
				maximum = current;
			}
		}
		return current;
	}
	
	public boolean perkAvailable(Perk perk) {
		return this.special[perk.getStatType()].getAttributeLevel() >= perk.getStatReq();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SPECIAL: ").append(Arrays.toString(this.special));
		builder.append(System.getProperty("line.separator"));
		builder.append("Perks:").append(System.getProperty("line.separator"));
		for (Map.Entry<Perk, Integer> entry : perks.entrySet()) {
			builder.append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
		}
		return builder.toString();
	}

	
}
