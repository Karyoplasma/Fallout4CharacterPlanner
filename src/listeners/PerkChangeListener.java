package listeners;

import core.Perk;

public interface PerkChangeListener {
    
	void perkChanged(Perk perk, int oldValue, int newValue, boolean wasRemoved);
}
