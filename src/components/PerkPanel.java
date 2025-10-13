package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import core.CharacterCalc;
import core.Perk;
import core.Stat;
import net.miginfocom.swing.MigLayout;

public class PerkPanel extends JPanel {

    private static final long serialVersionUID = 1L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final Stat[] statValues = Stat.values();
    private final CharacterCalc calc;
    private final Map<Perk, JTextPane> perkPanes = new EnumMap<>(Perk.class);
    private ActionListener statListener, specialListener;

    public PerkPanel(CharacterCalc calc, SpecialPanel specialPanel, StatPanel statPanel) {
        this.calc = calc;
        String colSpec = "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill]";
        setLayout(new MigLayout("insets 6, gap 0, wrap 7", colSpec, "[]0[]"));
        initBobbleheads();
        initPerksGrid();
        this.specialListener = specialPanel;
        this.statListener = statPanel;
        refresh();
    }

    private void initBobbleheads() {
        for (Stat stat : statValues) {
            JCheckBox box = new JCheckBox(stat.getStat() + " Bobblehead");
            box.addActionListener(e -> {
                calc.setBobblehead(stat, box.isSelected());
                statListener.actionPerformed(e);
                specialListener.actionPerformed(e);
                refresh();
            });
            add(box);
        }
    }

    private void initPerksGrid() {
    	Map<Stat, List<Perk>> groups = new EnumMap<Stat, List<Perk>>(Stat.class);
        for (Stat s : statValues) {
        	groups.put(s, new ArrayList<Perk>());
        }
        
        for (Perk p : Perk.values()) {
            groups.get(statValues[p.getStatType()]).add(p);
        }
        
        int maxRows = 10;
        
        for (Perk perk : Perk.values()) {
            JTextPane pane = new JTextPane();
            pane.setEditable(false);
            pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pane.setBackground(Color.WHITE);
            pane.setFont(PLAIN);
            pane.setPreferredSize(new Dimension(140, 80));
            pane.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        calc.skillPerk(perk);
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        calc.unskillPerk(perk);
                    }
                    switch (perk) {
                    case Vans:
                        specialListener.actionPerformed(null);
					default:
						statListener.actionPerformed(null);
						break;
                    }
                    refresh();
                }
            });
            perkPanes.put(perk, pane);
        }
        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < statValues.length; col++) {
                Stat stat = statValues[col];
                List<Perk> list = groups.get(stat);
                if (row < list.size()) {
                    Perk perk = list.get(row);
                    JTextPane pane = perkPanes.get(perk);
                    add(pane);
                }
            }
        }
    }

    public void refresh() {
    	System.out.println("refreshing perk panel");
    	 for (Map.Entry<Perk, JTextPane> e : perkPanes.entrySet()) {
             Perk perk = e.getKey();
             JTextPane pane = e.getValue();
             int level = calc.getPerkLevel(perk);
             String name = perk.getName();
             int max = perk.getRanks();
             pane.setText(name + " (" + level + "/" + max + ")");
             pane.setToolTipText("<html>" + perk.getDescription(level) + "</html>");
             if (calc.canLevelPerk(perk)) {
            	 pane.setBackground(Color.CYAN);
             }
         }
         revalidate();
         repaint();
    }
}

