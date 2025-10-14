package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import core.BuildState;
import core.CharacterCalc;
import core.Perk;
import core.SPECIAL;
import listeners.PerkRemovalListener;
import listeners.SpecialChangeListener;
import net.miginfocom.swing.MigLayout;

public class PerkPanel extends JPanel implements SpecialChangeListener, PerkRemovalListener {

	private static final long serialVersionUID = -1182378778622771289L;
	private static final Font PLAIN = new Font("Tahoma", Font.PLAIN, 14);
	private static final SPECIAL[] statValues = SPECIAL.values();
	private final CharacterCalc calc;
	private final EnumMap<SPECIAL, JCheckBox> bobbleheads = new EnumMap<SPECIAL, JCheckBox>(SPECIAL.class);
	private final Map<Perk, JTextPane> perkPanes = new EnumMap<>(Perk.class);
	private Map<SPECIAL, List<Perk>> groups;
	private boolean isLoading = false;

	public PerkPanel(CharacterCalc calc) {
		this.calc = calc;
		String colSpec = "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill]";
		setLayout(new MigLayout("insets 6, gap 0, wrap 7", colSpec, "[]0[]"));
		initBobbleheads();
		initPerksGrid();
		for (SPECIAL s : statValues) {
			this.colorPanels(s, 1);
		}
		refresh();
	}

	private void initBobbleheads() {
		for (SPECIAL stat : statValues) {
			JCheckBox box = new JCheckBox(stat.getStat() + " Bobblehead");
			box.addActionListener(e -> {
				if (isLoading) {
					return;
				}
				calc.setBobblehead(stat, box.isSelected());
			});
			this.bobbleheads.put(stat, box);
			add(box);
		}
	}

	private void initPerksGrid() {
		this.groups = new EnumMap<SPECIAL, List<Perk>>(SPECIAL.class);
		for (SPECIAL s : statValues) {
			this.groups.put(s, new ArrayList<Perk>());
		}

		for (Perk p : Perk.values()) {
			this.groups.get(statValues[p.getStatType()]).add(p);
		}

		int maxRows = 10;

		for (Perk perk : Perk.values()) {
			JTextPane pane = new JTextPane();
			pane.setEditable(false);
			pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pane.setFont(PLAIN);
			pane.setFocusable(false);
			pane.setPreferredSize(new Dimension(140, 80));
			pane.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						calc.skillPerk(perk);
					} else if (SwingUtilities.isRightMouseButton(e)) {
						calc.unskillPerk(perk);
					}
					refreshSinglePane(perk);
				}
			});
			perkPanes.put(perk, pane);
		}
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < statValues.length; col++) {
				SPECIAL stat = statValues[col];
				List<Perk> list = groups.get(stat);
				if (row < list.size()) {
					Perk perk = list.get(row);
					JTextPane pane = perkPanes.get(perk);
					add(pane);
				}
			}
		}
	}

	private void refreshSinglePane(Perk perk) {
		JTextPane pane = perkPanes.get(perk);
		int level = calc.getPerkLevel(perk);
		int max = perk.getRanks();
		formatPerkPane(pane, perk.getName(), level, max);
		pane.setToolTipText("<html>" + perk.getDescription(level) + "</html>");
	}

	public void refresh() {
		for (Map.Entry<Perk, JTextPane> e : perkPanes.entrySet()) {
			Perk perk = e.getKey();
			this.refreshSinglePane(perk);
		}
		revalidate();
		repaint();
	}

	public void colorPanels(SPECIAL special, int newValue) {
		List<Perk> perkList = groups.get(special);
		for (int i = 0; i < perkList.size(); i++) {
			JTextPane pane = perkPanes.get(perkList.get(i));
			if (i < newValue) {
				pane.setBackground(Color.CYAN);
			} else {
				pane.setBackground(Color.WHITE);
			}
		}
	}

	private void formatPerkPane(JTextPane pane, String name, int current, int max) {
		String text = name + "\n\n(" + current + " / " + max + ")";
		pane.setText(text);

		StyledDocument doc = pane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		pane.setMargin(new Insets(20, 0, 0, 0));
	}

	public void saveState(BuildState state) {
		state.bobbleheads = new EnumMap<SPECIAL, Boolean>(SPECIAL.class);
		for (SPECIAL stat : SPECIAL.values()) {
			state.bobbleheads.put(stat, bobbleheads.get(stat).isSelected());
		}
	}

	public void loadState(BuildState state) {
		this.isLoading = true;
		try {
			for (SPECIAL stat : SPECIAL.values()) {
				bobbleheads.get(stat).setSelected(state.bobbleheads.get(stat));
				colorPanels(stat, state.specialLevels[stat.ordinal()].getAttributeLevel());
			}
		} finally {
			this.isLoading = false;
		}
		refresh();
	}

	@Override
	public void onSpecialChanged(SPECIAL special, int newValue) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(() -> onSpecialChanged(special, newValue));
			return;
		}
		this.colorPanels(special, newValue);
		revalidate();
		repaint();
	}

	@Override
	public void onPerkRemoved(Perk perk) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(() -> onPerkRemoved(perk));
			return;
		}

		this.formatPerkPane(perkPanes.get(perk), perk.getName(), 0, perk.getRanks());
	}
}
