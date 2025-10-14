package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import components.PerkPanel;
import components.SpecialPanel;
import components.StatPanel;
import core.CharacterCalc;
import net.miginfocom.swing.MigLayout;

public class CharPlannerGUI {

	private JFrame frame;
	private CharacterCalc character;
	private SpecialPanel specialPanel;
	private StatPanel statPanel;
	private PerkPanel perkPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharPlannerGUI window = new CharPlannerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CharPlannerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1100, 1000);
		frame.setMinimumSize(new Dimension(1100, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][grow,fill]", "[][grow,fill]"));

		this.character = new CharacterCalc();
		this.statPanel = new StatPanel(this.character);
		this.specialPanel = new SpecialPanel(this.character);
		this.perkPanel = new PerkPanel(this.character);
		this.character.addSpecialChangeListener(specialPanel);
		this.character.addSpecialChangeListener(perkPanel);
		this.character.addStatChangeListener(statPanel);
		this.character.addPerkRemovalListener(perkPanel);
		frame.getContentPane().add(this.specialPanel, "cell 0 0 1 1");
		frame.getContentPane().add(this.statPanel, "cell 1 0 1 1");
		frame.getContentPane().add(this.perkPanel, "cell 0 1 3 1,grow");
	}
}
