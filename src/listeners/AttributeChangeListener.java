package listeners;

import core.Attribute;

public interface AttributeChangeListener {
	
	void attributeChanged(Attribute Attribute, int oldValue, int newValue, boolean wasBoost);
}
