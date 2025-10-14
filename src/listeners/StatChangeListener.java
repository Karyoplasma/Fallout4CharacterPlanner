package listeners;

import core.Stat;

public interface StatChangeListener {

	void onStatChanged(Stat... stats);
}
