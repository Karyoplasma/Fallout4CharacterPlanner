package components;

import java.awt.Font;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import core.CharacterCalc;
import core.Stat;
import listeners.StatChangeListener;
import net.miginfocom.swing.MigLayout;

public class StatPanel extends JPanel implements StatChangeListener {

	private static final long serialVersionUID = -7509581031372886703L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	private final CharacterCalc calc;
	private final JCheckBox survivalBox = new JCheckBox("Survival");
	private final EnumMap<Stat, JLabel> valueLabels = new EnumMap<Stat, JLabel>(Stat.class);

	public StatPanel(CharacterCalc calc) {
		this.calc = calc;
		initUI();
	}

	private void refresh() {
		boolean survival = this.survivalBox.isSelected();
		for (Stat stat : Stat.values()) {
			valueLabels.get(stat).setText(String.valueOf(calc.getStat(stat, survival)));
		}
	}

	private void initUI() {
		setLayout(new MigLayout("insets 10, wrap 2", "[grow][min:60:60]", "[]10[]10[]10[]10[]"));
		TitledBorder border = BorderFactory.createTitledBorder("Character Stats");
		border.setTitleFont(BOLD);
		setBorder(border);
		this.survivalBox.setFont(BOLD);
		this.survivalBox.addActionListener(e -> {
			onStatChanged(Stat.CARRYWEIGHT);
		});
		add(survivalBox, "span 2, right");
		for (Stat stat : Stat.values()) {
			JLabel temp = new JLabel(stat.toString());
			JLabel statLabel = new JLabel();
			if (stat == Stat.LEVEL) {
				statLabel.setFont(BOLD);
				temp.setFont(BOLD);
			} else {
				statLabel.setFont(PLAIN);
				temp.setFont(PLAIN);
			}
			this.valueLabels.put(stat, statLabel);
			add(temp, "sg frontlabel");
			add(statLabel, "sg backlabel");
		}
		refresh();
	}

	@Override
	public void onStatChanged(Stat... stats) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(() -> onStatChanged(stats));
			return;
		}
		boolean survival = this.survivalBox.isSelected();
		for (Stat stat : stats) {
			JLabel label = valueLabels.get(stat);
			label.setText(String.valueOf(calc.getStat(stat, survival)));
		}
	}

}
