package components;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import core.CharacterCalc;
import core.Stat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EnumMap;

public class SpecialPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8417546657549869651L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	private final EnumMap<Stat, JLabel> valueLabels = new EnumMap<Stat, JLabel>(Stat.class);
    private final JLabel remainingPointsLabel = new JLabel();
    private final JCheckBox specialBook = new JCheckBox("S.P.E.C.I.A.L. Book");
    private final CharacterCalc calc;
    private final ActionListener updateListener;

    public SpecialPanel(CharacterCalc calc, ActionListener updateListener) {
        this.calc = calc;
        this.updateListener = updateListener;
        initUI();
        refresh();
    }

    private void initUI() {
        setLayout(new MigLayout("insets 10, wrap 4", "[][grow 0][grow 0][grow 0]", "[]10[]"));
        TitledBorder border = javax.swing.BorderFactory.createTitledBorder("S.P.E.C.I.A.L.");
        border.setTitleFont(BOLD);
        setBorder(border);
        
        for (Stat stat : Stat.values()) {
        	JLabel statLabel = new JLabel(stat.getStat());
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
                calc.unskillAttribute(stat);
                refresh();
                updateListener.actionPerformed(e);
            });
            plus.addActionListener(e -> {
                calc.skillAttribute(stat);
                refresh();
                updateListener.actionPerformed(e);
            });

            valueLabels.put(stat, valueLabel);

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
        	calc.setSPECIALBook(this.specialBook.isSelected());
        	refresh();
        	updateListener.actionPerformed(e);
        });
        add(specialBook);
    }

    public void refresh() {
        for (Stat stat : Stat.values()) {
            valueLabels.get(stat).setText(String.valueOf(calc.getAttributeLevel(stat)));
        }
        remainingPointsLabel.setText(String.valueOf(calc.getRemaining()));
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		refresh();		
	}
 }

