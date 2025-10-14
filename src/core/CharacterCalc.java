package core;

import java.util.ArrayList;
import java.util.List;
import listeners.AttributeChangeListener;
import listeners.PerkChangeListener;
import listeners.PerkRemovalListener;
import listeners.SpecialChangeListener;
import listeners.StatChangeListener;

public class CharacterCalc implements PerkChangeListener, AttributeChangeListener {

	private int remaining, pointsUsed;
	private Character character;
	private final List<StatChangeListener> statChangeListeners;
	private final List<SpecialChangeListener> specialChangeListeners;
	private final List<PerkRemovalListener> perkRemovalListeners;
	
	public CharacterCalc() {
		this.statChangeListeners = new ArrayList<StatChangeListener>();
		this.specialChangeListeners = new ArrayList<SpecialChangeListener>();
		this.perkRemovalListeners = new ArrayList<PerkRemovalListener>();
		this.remaining = 21;
		this.pointsUsed = 0;
		this.character = new Character(this, this);
		
	}
	
	public void addPerkRemovalListener(PerkRemovalListener perkRemovalListener) {
		this.perkRemovalListeners.add(perkRemovalListener);
	}

	public void removeStatChangeListener(PerkRemovalListener perkRemovalListener) {
		this.perkRemovalListeners.remove(perkRemovalListener);
	}
	
	public void addStatChangeListener(StatChangeListener statChangeListener) {
		this.statChangeListeners.add(statChangeListener);
	}

	public void removeStatChangeListener(StatChangeListener statChangeListener) {
		this.statChangeListeners.remove(statChangeListener);
	}

	public void addSpecialChangeListener(SpecialChangeListener specialChangeListener) {
		this.specialChangeListeners.add(specialChangeListener);
	}

	public void removeSpecialChangeListener(SpecialChangeListener specialChangeListener) {
		this.specialChangeListeners.remove(specialChangeListener);
	}
	
	private void notifyPerkRemovalListeners(Perk perk) {
		for (PerkRemovalListener listener : this.perkRemovalListeners) {
			listener.onPerkRemoved(perk);
		}
	}
	
	private void notifyStatChangeListeners(Stat... stats) {
		for (StatChangeListener listener : this.statChangeListeners) {
			for (Stat stat : stats) {
				listener.onStatChanged(stat);
			}
		}
	}

	private void notifySpecialChangeListeners(SPECIAL special, int newValue) {
		for (SpecialChangeListener listener : this.specialChangeListeners) {
			listener.onSpecialChanged(special, newValue);
		}
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
		SPECIAL special = attribute.getStat();
		this.notifySpecialChangeListeners(special, newValue);
		switch (special) {
		case Agility:
			this.notifyStatChangeListeners(Stat.ACTIONPOINTS, Stat.HITPOINTS, Stat.LEVEL);
			break;
		case Endurance:
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.LEVEL);
			break;
		case Strength:
			this.notifyStatChangeListeners(Stat.CARRYWEIGHT, Stat.HITPOINTS, Stat.LEVEL);
			break;
		default:
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.LEVEL);
			break;
		}
	}

	@Override
	public void perkChanged(Perk perk, int oldValue, int newValue, boolean wasRemoved) {
		if (wasRemoved) {
			pointsUsed -= oldValue;
			this.notifyPerkRemovalListeners(perk);
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
				this.character.boostAttribute(SPECIAL.Perception, 2);
			} else {
				if (oldValue == 2)
					this.character.boostAttribute(SPECIAL.Perception, -2);
			}
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.LEVEL);
			break;
		case StrongBack:
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.CARRYWEIGHT, Stat.LEVEL);
			break;
		case LoneWanderer:
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.ACTIONPOINTS, Stat.CARRYWEIGHT, Stat.LEVEL);
			break;
		default:
			this.notifyStatChangeListeners(Stat.HITPOINTS, Stat.LEVEL);
			break;
		}

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
		this.notifyStatChangeListeners(Stat.LEVEL, Stat.HITPOINTS);
	}

	public void setBobblehead(SPECIAL attribute, boolean active) {
		if (active) {
			this.character.boostAttribute(attribute, 1);
		} else {
			this.character.boostAttribute(attribute, -1);
		}
	}

	public double getHitPoints() {
		int perkModifier = this.character.getPerkLevel(Perk.Lifegiver) * 20;
		int level = Math.max(this.character.getMaximumPerkLevelRequirement(), this.pointsUsed + 1);
		double hitPoints = Math.floor(80 + perkModifier + (this.character.getAttributeLevel(SPECIAL.Endurance) * 5)
				+ (level - 1) * ((this.character.getAttributeLevel(SPECIAL.Endurance) / 2) + 2.5));
		return hitPoints;
	}

	public int getCarryWeight(boolean survival) {
		int carryWeight;
		int perkModifier = Math.min(this.character.getPerkLevel(Perk.StrongBack), 2) * 25;
		perkModifier += Math.min(this.character.getPerkLevel(Perk.LoneWanderer), 2) * 50;
		if (survival) {
			carryWeight = 75 + perkModifier + (10 * (this.character.getAttributeLevel(SPECIAL.Strength)));
		} else {
			carryWeight = 200 + perkModifier + (10 * (this.character.getAttributeLevel(SPECIAL.Strength)));
		}
		return carryWeight;
	}

	public int getActionPoints() {
		int perkModifier = 0;
		if (this.character.getPerkLevel(Perk.LoneWanderer) == 4) {
			perkModifier += 25;
		}
		return 60 + perkModifier + this.character.getAttributeLevel(SPECIAL.Agility) * 10;
	}

	public int getRemaining() {
		return Math.max(this.remaining, 0);
	}

	public int getLevelNeeded() {
		return Math.max(this.character.getMaximumPerkLevelRequirement(), this.pointsUsed + 1);
	}

	public int getAttributeLevel(SPECIAL stat) {
		return this.character.getAttributeLevel(stat);
	}

	public void skillAttribute(SPECIAL stat) {
		this.character.skillAttribute(stat);
	}

	public void unskillAttribute(SPECIAL stat) {
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
	
	public void saveState(BuildState state) {
		this.character.saveState(state);
		state.pointsUsed = this.pointsUsed;
		state.remaining = this.remaining;
	}
	
	public void loadState(BuildState state) {
		this.character.loadState(state);
		this.pointsUsed = state.pointsUsed;
		this.remaining = state.remaining;
	}
	
	public int getStat(Stat stat, boolean survival) {
		switch (stat) {
		case CARRYWEIGHT:
			return this.getCarryWeight(survival);
		case ACTIONPOINTS:
			return this.getActionPoints();
		case LEVEL:
			return this.getLevelNeeded();
		default:
			return (int) this.getHitPoints();
		}
	}
}
