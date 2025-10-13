package components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import core.CharacterCalc;
import net.miginfocom.swing.MigLayout;

public class StatPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -7509581031372886703L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	private final CharacterCalc calc;
	private final JLabel carryWeightLabel, hpLabel, levelRequiredLabel;
	private final JCheckBox survivalBox = new JCheckBox("Survival");

	public StatPanel(CharacterCalc calc) {
		this.calc = calc;
		this.carryWeightLabel = new JLabel();
		this.hpLabel = new JLabel();
		this.levelRequiredLabel = new JLabel();
		initUI();
	}

	private void refresh() {
		this.carryWeightLabel.setText(String.valueOf(calc.getCarryWeight(survivalBox.isSelected())));
		this.hpLabel.setText(String.valueOf((int) calc.getHitPoints()));
		this.levelRequiredLabel.setText(String.valueOf(calc.getLevelNeeded()));
	}

	private void initUI() {
		setLayout(new MigLayout("insets 10, wrap 2", "[grow][min:60:60]", "[]10[]10[]10[]"));
		TitledBorder border = javax.swing.BorderFactory.createTitledBorder("Character Stats");
		border.setTitleFont(BOLD);
		setBorder(border);
		this.carryWeightLabel.setFont(PLAIN);
		this.hpLabel.setFont(PLAIN);
		this.levelRequiredLabel.setFont(BOLD);
		this.survivalBox.setFont(BOLD);
		this.survivalBox.addActionListener(e -> {
			carryWeightLabel.setText(String.valueOf(calc.getCarryWeight(survivalBox.isSelected())));
		});
		add(survivalBox, "span 2, right");
		JLabel temp = new JLabel("Hit Points:");
		temp.setFont(PLAIN);
		add(temp, "sg frontlabel");
		add(this.hpLabel, "sg backlabel");
		temp = new JLabel("Carry Weight:");
		temp.setFont(PLAIN);
		add(temp);
		add(this.carryWeightLabel, "sg backlabel");
		temp = new JLabel("Level:");
		temp.setFont(PLAIN);
		add(temp);
		add(this.levelRequiredLabel, "sg backlabel");
		refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.refresh();
	}
}
