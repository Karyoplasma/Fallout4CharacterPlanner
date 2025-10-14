package components;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import core.BuildState;
import core.CharacterCalc;
import core.SPECIAL;
import listeners.SpecialChangeListener;
import java.awt.*;
import java.util.EnumMap;

public class SpecialPanel extends JPanel implements SpecialChangeListener {

	private static final long serialVersionUID = 8417546657549869651L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	private final EnumMap<SPECIAL, JLabel> valueLabels = new EnumMap<SPECIAL, JLabel>(SPECIAL.class);
	private final JLabel remainingPointsLabel = new JLabel();
	private final JCheckBox specialBook = new JCheckBox("S.P.E.C.I.A.L. Book");
	private final CharacterCalc calc;
	private boolean isLoading;

	public SpecialPanel(CharacterCalc calc) {
		this.calc = calc;
		initUI();
		refresh();
	}

	private void initUI() {
		setLayout(new MigLayout("insets 10, wrap 4", "[][grow 0][grow 0][grow 0]", "[]10[]"));
		TitledBorder border = BorderFactory.createTitledBorder("S.P.E.C.I.A.L.");
		border.setTitleFont(BOLD);
		setBorder(border);

		for (SPECIAL special : SPECIAL.values()) {
			JLabel statLabel = new JLabel(special.getFlavorName());
			statLabel.setFont(PLAIN);
			add(statLabel);

			JButton minus = new JButton("<");
			minus.setFont(PLAIN);
			JButton plus = new JButton(">");
			plus.setFont(PLAIN);
			JLabel valueLabel = new JLabel("", SwingConstants.CENTER);
			valueLabel.setFont(PLAIN);

			minus.setMargin(new Insets(0, 5, 0, 5));
			plus.setMargin(new Insets(0, 5, 0, 5));
			valueLabel.setPreferredSize(new Dimension(30, 20));

			minus.addActionListener(e -> {
				calc.unskillAttribute(special);
				refreshRemainingPointsLabel();
			});
			plus.addActionListener(e -> {
				calc.skillAttribute(special);
				refreshRemainingPointsLabel();
			});

			valueLabels.put(special, valueLabel);

			add(minus, "growx");
			add(valueLabel, "growx");
			add(plus, "growx, wrap");
		}
		JLabel remainingLabel = new JLabel("Points Remaining:");
		remainingLabel.setFont(PLAIN);
		add(remainingLabel);
		remainingPointsLabel.setFont(PLAIN);
		add(remainingPointsLabel, "span 3, left");
		specialBook.setFont(BOLD);
		specialBook.addActionListener(e -> {
			if (this.isLoading) {
				return;
			}
			calc.setSPECIALBook(this.specialBook.isSelected());
			refreshRemainingPointsLabel();
		});
		add(specialBook);
	}

	private void refreshRemainingPointsLabel() {
		remainingPointsLabel.setText(String.valueOf(calc.getRemaining()));
	}

	public void refresh() {
		for (SPECIAL special : SPECIAL.values()) {
			valueLabels.get(special).setText(String.valueOf(calc.getAttributeLevel(special)));
		}
		remainingPointsLabel.setText(String.valueOf(calc.getRemaining()));
	}

	public void saveState(BuildState state) {
		state.specialBook = this.specialBook.isSelected();
	}

	public void loadState(BuildState state) {
		this.isLoading = true;
		try {
			this.specialBook.setSelected(state.specialBook);
		} finally {
			this.isLoading = false;
		}
		refresh();
	}

	@Override
	public void onSpecialChanged(SPECIAL stat, int newValue) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(() -> onSpecialChanged(stat, newValue));
			return;
		}
		valueLabels.get(stat).setText(String.valueOf(newValue));
	}
}
