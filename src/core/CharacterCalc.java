package core;

import listeners.AttributeChangeListener;
import listeners.PerkChangeListener;

public class CharacterCalc implements PerkChangeListener, AttributeChangeListener {

	private int remaining, pointsUsed;
	private Character character;

	public CharacterCalc() {
		this.remaining = 21;
		this.pointsUsed = 0;
		this.character = new Character(this, this);
	}

	@Override
	public void attributeChanged(Attribute attribute, int oldValue, int newValue, boolean wasBoost) {
		this.character.removeStalePerks();
		if (!wasBoost) {
			if (oldValue < newValue) {
				this.remaining--;
				if (remaining < 0) {
					this.pointsUsed++;
				}
			} else {
				this.remaining++;
				if (remaining <= 0) {
					this.pointsUsed--;
				}
			}
		}
		System.out.printf("%s - old: %d, new: %d, remaining: %d, pointsUsed: %d\n", attribute.getStat(), oldValue,
				newValue, remaining, pointsUsed);
	}

	@Override
	public void perkChanged(Perk perk, int oldValue, int newValue, boolean wasRemoved) {
		if (wasRemoved) {
			pointsUsed -= oldValue;
		} else {
			if (oldValue > newValue) {
				pointsUsed--;
			} else {
				pointsUsed++;
			}
		}
		switch (perk) {
		case Vans:
			if (newValue == 2) {
				this.character.boostAttribute(Stat.Perception, 2);
			} else {
				if (oldValue == 2)
					this.character.boostAttribute(Stat.Perception, -2);
			}
			break;
		default:
			break;
		}
		System.out.println(character);
	}

	public void setSPECIALBook(boolean hasBook) {
		if (hasBook) {
			remaining++;
			if (remaining <= 0) {
				pointsUsed--;
			}
		} else {
			remaining--;
			if (remaining < 0) {
				pointsUsed++;
			}
		}
	}

	public void setBobblehead(Stat attribute, boolean active) {
		if (active) {
			this.character.boostAttribute(attribute, 1);
		} else {
			this.character.boostAttribute(attribute, -1);
		}
	}

	public double getHitPoints() {
		int perkModifier = this.character.getPerkLevel(Perk.Lifegiver) * 20;
		int level = Math.max(this.character.getMaximumPerkLevelRequirement(), this.pointsUsed + 1);
		double hitPoints = Math.floor(80 + perkModifier + (this.character.getAttributeLevel(Stat.Endurance) * 5)
				+ (level - 1) * ((this.character.getAttributeLevel(Stat.Endurance) / 2) + 2.5));
		return hitPoints;
	}

	public int getCarryWeight(boolean survival) {
		int carryWeight;
		int perkModifier = Math.min(this.character.getPerkLevel(Perk.StrongBack), 2) * 25;
		perkModifier += Math.min(this.character.getPerkLevel(Perk.LoneWanderer), 2) * 50;
		if (survival) {
			carryWeight = 75 + perkModifier + (10 * (this.character.getAttributeLevel(Stat.Strength)));
		} else {
			carryWeight = 200 + perkModifier + (10 * (this.character.getAttributeLevel(Stat.Strength)));
		}
		return carryWeight;
	}

	public int getActionPoints() {
		int perkModifier = 0;
		if (this.character.getPerkLevel(Perk.LoneWanderer) == 4) {
			perkModifier += 25;
		}
		return 60 + perkModifier + this.character.getAttributeLevel(Stat.Agility) * 10;
	}

	public int getRemaining() {
		return Math.max(this.remaining, 0);
	}

	public int getLevelNeeded() {
		int ret = Math.max(this.character.getMaximumPerkLevelRequirement(), this.pointsUsed + 1);
		System.out.println("getLevelNeeded(): " + ret);
		return ret;
	}
	
	public int getAttributeLevel(Stat stat) {
		return this.character.getAttributeLevel(stat);
	}
	
	public void skillAttribute(Stat stat) {
		this.character.skillAttribute(stat);	
	}
	
	public void unskillAttribute(Stat stat) {
		this.character.unskillAttribute(stat);	
	}
	
	public void skillPerk(Perk perk) {
		this.character.skillPerk(perk);
	}
	
	public void unskillPerk(Perk perk) {
		this.character.unskillPerk(perk);
	}
	
	public int getPerkLevel(Perk perk) {
		return character.getPerkLevel(perk);
	}
	
	public boolean canLevelPerk(Perk perk) {
		return character.perkAvailable(perk);
	}
//	public static void main(String[] args) {
//		CharacterCalc calc = new CharacterCalc();
//		System.out.println(calc.getCarryWeight(true));
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.skillAttribute(Stat.Strength);
//		calc.character.unskillAttribute(Stat.Strength);
//		calc.character.skillPerk(Perk.Vans);
//		calc.character.skillPerk(Perk.Vans);
//		calc.character.unskillAttribute(Stat.Perception);
//		calc.character.skillPerk(Perk.Rifleman);
//		calc.character.skillPerk(Perk.Rifleman);
//		calc.character.skillPerk(Perk.Rifleman);
//		calc.character.unskillPerk(Perk.Vans);
//		System.out.println(calc.character);
//	}
}
