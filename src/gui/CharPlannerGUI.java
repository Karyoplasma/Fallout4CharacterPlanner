package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import components.PerkPanel;
import components.SpecialPanel;
import components.StatPanel;
import core.BuildFileIO;
import core.BuildState;
import core.CharacterCalc;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class CharPlannerGUI {

	private JFrame frmFalloutCharacter;
	private CharacterCalc character;
	private SpecialPanel specialPanel;
	private StatPanel statPanel;
	private PerkPanel perkPanel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSave;
	private JMenuItem mntmLoad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharPlannerGUI window = new CharPlannerGUI();
					window.frmFalloutCharacter.setVisible(true);
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
		frmFalloutCharacter = new JFrame();
		frmFalloutCharacter.setTitle("Fallout 4 Character Planner");
		frmFalloutCharacter.setBounds(10, 10, 1100, 1000);
		frmFalloutCharacter.setMinimumSize(new Dimension(1100, 1000));
		frmFalloutCharacter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFalloutCharacter.getContentPane().setLayout(new MigLayout("", "[][][grow,fill]", "[][grow,fill]"));

		menuBar = new JMenuBar();
		frmFalloutCharacter.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmSave = new JMenuItem("Save Build");
		mntmSave.addActionListener(e -> {
			this.saveBuild();
		});
		mnFile.add(mntmSave);
		mntmLoad = new JMenuItem("Load Build");
		mntmLoad.addActionListener(e -> {
			this.loadBuild();
		});
		mnFile.add(mntmLoad);

		this.character = new CharacterCalc();
		this.statPanel = new StatPanel(this.character);
		this.specialPanel = new SpecialPanel(this.character);
		this.perkPanel = new PerkPanel(this.character);
		this.character.addSpecialChangeListener(specialPanel);
		this.character.addSpecialChangeListener(perkPanel);
		this.character.addStatChangeListener(statPanel);
		this.character.addPerkRemovalListener(perkPanel);
		frmFalloutCharacter.getContentPane().add(this.specialPanel, "cell 0 0 1 1");
		frmFalloutCharacter.getContentPane().add(this.statPanel, "cell 1 0 1 1");
		frmFalloutCharacter.getContentPane().add(this.perkPanel, "cell 0 1 3 1,grow");

	}

	public BuildState saveState() {
		BuildState state = new BuildState();
		this.character.saveState(state);
		this.perkPanel.saveState(state);
		this.specialPanel.saveState(state);
		this.statPanel.saveState(state);
		return state;
	}

	public void loadState(BuildState state) {
		this.character.loadState(state);
		this.perkPanel.loadState(state);
		this.specialPanel.loadState(state);
		this.statPanel.loadState(state);
	}

	public void saveBuild() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("fo4build files", "fo4build"));
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		if (chooser.showSaveDialog(frmFalloutCharacter) == JFileChooser.APPROVE_OPTION) {
			try {
				File selectedFile = chooser.getSelectedFile();
				if (!selectedFile.getName().toLowerCase().endsWith(".fo4build")) {
					selectedFile = new File(selectedFile.getAbsolutePath() + ".fo4build");
				}
				BuildState state = this.saveState();
				BuildFileIO.exportBuildFile(state, selectedFile);
				;
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(frmFalloutCharacter, "Error saving build:\n" + ex.getMessage());
			}
		}
	}

	public void loadBuild() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("fo4build files", "fo4build"));
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		if (chooser.showOpenDialog(frmFalloutCharacter) == JFileChooser.APPROVE_OPTION) {
			try {
				BuildState state = BuildFileIO.importBuildFile(chooser.getSelectedFile());
				this.loadState(state);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(frmFalloutCharacter, "Error loading build:\n" + ex.getMessage());
			} catch (NullPointerException ex) {
				this.showCriticalError(ex);
			}
		}
	}

	private void showCriticalError(NullPointerException ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();
		JOptionPane.showMessageDialog(frmFalloutCharacter,
				"This should not happen.\n" + "Please take a screenshot of this window and report it on GitHub:\n\n"
						+ ex.getMessage() + "\n\n" + stackTrace,
				"Critical Error", JOptionPane.ERROR_MESSAGE);
	}

}
