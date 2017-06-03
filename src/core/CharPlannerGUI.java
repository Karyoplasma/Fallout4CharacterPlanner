package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class CharPlannerGUI {
	private Character character = new Character();
	private JFrame frmFalloutCharacter;
	private JTextField textField_Remaining;
	private JTextField textField_Strength;
	private JTextField textField_Perception;
	private JTextField textField_Endurance;
	private JTextField textField_Charisma;
	private JTextField textField_Intelligence;
	private JTextField textField_Agility;
	private JTextField textField_Luck;
	private JTextField textField_CarryWeight;
	private JTextField textField_levelNeeded;
	private JTextPane txtpnIronFist = new JTextPane();
	private JTextPane txtpnBigLeagues = new JTextPane();
	private JTextPane txtpnArmorer = new JTextPane();
	private JTextPane txtpnBlacksmith = new JTextPane();
	private JTextPane txtpnHeavyGunner = new JTextPane();
	private JTextPane txtpnStrongBack = new JTextPane();
	private JTextPane txtpnSteadyAim = new JTextPane();
	private JTextPane txtpnBasher = new JTextPane();
	private JTextPane txtpnRooted = new JTextPane();
	private JTextPane txtpnPainTrain = new JTextPane();
	JTextPane txtpnPickpocket = new JTextPane();
    JTextPane txtpnRifleman = new JTextPane();
    JTextPane txtpnAwareness = new JTextPane();
    JTextPane txtpnLocksmith = new JTextPane();
    JTextPane txtpnDemolitionExpert = new JTextPane();
    JTextPane txtpnNightPerson = new JTextPane();
    JTextPane txtpnRefractor = new JTextPane();
    JTextPane txtpnSniper = new JTextPane();
    JTextPane txtpnPenetrator = new JTextPane();
    JTextPane txtpnConcentratedFire = new JTextPane();
    JTextPane txtpnToughness = new JTextPane();
    JTextPane txtpnLeadBelly = new JTextPane();
    JTextPane txtpnLifeGiver = new JTextPane();
    JTextPane txtpnChemResistant = new JTextPane();
    JTextPane txtpnAquaboy = new JTextPane();
    JTextPane txtpnRadResistant = new JTextPane();
    JTextPane txtpnAdamantiumSkeleton = new JTextPane();
    JTextPane txtpnCannibal = new JTextPane();
    JTextPane txtpnGhoulish = new JTextPane();
    JTextPane txtpnSolarPowered = new JTextPane();
    JTextPane txtpnCapCollector = new JTextPane();
    JTextPane txtpnLadyKiller = new JTextPane();
    JTextPane txtpnLoneWanderer = new JTextPane();
    JTextPane txtpnAttackDog = new JTextPane();
    JTextPane txtpnAnimalFriend = new JTextPane();
    JTextPane txtpnLocalLeader = new JTextPane();
    JTextPane txtpnPartyBoy = new JTextPane();
    JTextPane txtpnInspirational = new JTextPane();
    JTextPane txtpnWastelandWhisperer = new JTextPane();
    JTextPane txtpnIntimidation = new JTextPane();
    JTextPane txtpnVans = new JTextPane();
    JTextPane txtpnMedic = new JTextPane();
    JTextPane txtpnGunNut = new JTextPane();
    JTextPane txtpnHacker = new JTextPane();
    JTextPane txtpnScrapper = new JTextPane();
    JTextPane txtpnScience = new JTextPane();
    JTextPane txtpnChemist = new JTextPane();
    JTextPane txtpnRoboticsExpert = new JTextPane();
    JTextPane txtpnNuclearPhysicist = new JTextPane();
    JTextPane txtpnNerdRage = new JTextPane();
	JTextPane txtpnGunslinger = new JTextPane();
    JTextPane txtpnCommando = new JTextPane();
    JTextPane txtpnSneak = new JTextPane();
    JTextPane txtpnMisterSandman = new JTextPane();
    JTextPane txtpnActionBoy = new JTextPane();
    JTextPane txtpnMovingTarget = new JTextPane();
    JTextPane txtpnNinja = new JTextPane();
    JTextPane txtpnQuickHands = new JTextPane();
    JTextPane txtpnBlitz = new JTextPane();
    JTextPane txtpnGunFu = new JTextPane();
	JTextPane txtpnFortuneFinder = new JTextPane();
    JTextPane txtpnScrounger = new JTextPane();
    JTextPane txtpnBloodyMess = new JTextPane();
    JTextPane txtpnMysteriousStranger = new JTextPane();
    JTextPane txtpnIdiotSavant = new JTextPane();
    JTextPane txtpnBetterCriticals = new JTextPane();
    JTextPane txtpnCriticalBanker = new JTextPane();
    JTextPane txtpnGrimReapersSprint = new JTextPane();
    JTextPane txtpnFourLeafClover = new JTextPane();
    JTextPane txtpnRicochet = new JTextPane();
    JCheckBox chckbxSurvival = new JCheckBox("Survival");
    JCheckBox chckbxLuckBobblehead = new JCheckBox("Luck Bobblehead");
    JCheckBox chckbxAgilityBobblehead = new JCheckBox("Agility Bobblehead");
    JCheckBox chckbxIntelligenceBobblehead = new JCheckBox("Intelligence Bobblehead");
    JCheckBox chckbxCharismaBobblehead = new JCheckBox("Charisma Bobblehead");
    JCheckBox chckbxEnduranceBobblehead = new JCheckBox("Endurance Bobblehead");
    JCheckBox chckbxPerceptionBobblehead = new JCheckBox("Perception Bobblehead");
    JCheckBox chckbxStrengthBobblehead = new JCheckBox("Strength Bobblehead");
	private StringBuilder builder = new StringBuilder();
	private JTextPane[] strengthPerks = new JTextPane[]{txtpnIronFist, txtpnBigLeagues, txtpnArmorer, txtpnBlacksmith, txtpnHeavyGunner, txtpnStrongBack, txtpnSteadyAim, txtpnBasher,txtpnRooted, txtpnPainTrain};
	private JTextPane[] perceptionPerks = new JTextPane[]{txtpnPickpocket, txtpnRifleman, txtpnAwareness, txtpnLocksmith, txtpnDemolitionExpert, txtpnNightPerson, txtpnRefractor, txtpnSniper, txtpnPenetrator, txtpnConcentratedFire};
	private JTextPane[] endurancePerks = new JTextPane[]{txtpnToughness, txtpnLeadBelly, txtpnLifeGiver, txtpnChemResistant, txtpnAquaboy, txtpnRadResistant, txtpnAdamantiumSkeleton, txtpnCannibal, txtpnGhoulish, txtpnSolarPowered};
	private JTextPane[] charismaPerks = new JTextPane[]{txtpnCapCollector, txtpnLadyKiller, txtpnLoneWanderer, txtpnAttackDog, txtpnAnimalFriend, txtpnLocalLeader, txtpnPartyBoy, txtpnInspirational, txtpnWastelandWhisperer, txtpnIntimidation};
	private JTextPane[] intelligencePerks = new JTextPane[]{txtpnVans, txtpnMedic, txtpnGunNut, txtpnHacker, txtpnScrapper, txtpnScience, txtpnChemist, txtpnRoboticsExpert, txtpnNuclearPhysicist, txtpnNerdRage};
	private JTextPane[] agilityPerks = new JTextPane[]{txtpnGunslinger, txtpnCommando, txtpnSneak, txtpnMisterSandman, txtpnActionBoy, txtpnMovingTarget, txtpnNinja, txtpnQuickHands, txtpnBlitz, txtpnGunFu};
	private JTextPane[] luckPerks = new JTextPane[]{txtpnFortuneFinder, txtpnScrounger, txtpnBloodyMess, txtpnMysteriousStranger, txtpnIdiotSavant, txtpnBetterCriticals, txtpnCriticalBanker, txtpnGrimReapersSprint, txtpnFourLeafClover, txtpnRicochet};
	private final JCheckBox chckbxSpecialBook = new JCheckBox("S.P.E.C.I.A.L Book");
	private JTextField textField_HitPoints;
	private JTextField textField_ActionPoints;
	private JTextField textField_loadCharacter;
	private JTextField textField_getShareLink;
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
		frmFalloutCharacter.setBounds(0, 0, 1109, 993);
		frmFalloutCharacter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setBorder(new EmptyBorder(0, 0, 0, 0));
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        container.setPreferredSize(new Dimension(500, 250));
        container.setLayout(null);
        
        JLabel lblCarryWeight = new JLabel("Carry Weight:");
        lblCarryWeight.setBounds(265, 40, 90, 20);
        container.add(lblCarryWeight);
        
        textField_CarryWeight = new JTextField();
        textField_CarryWeight.setText("210");
        textField_CarryWeight.setHorizontalAlignment(SwingConstants.LEFT);
        textField_CarryWeight.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_CarryWeight.setEditable(false);
        textField_CarryWeight.setBounds(360, 40, 30, 20);
        container.add(textField_CarryWeight);
        textField_CarryWeight.setColumns(10);
        
        
        chckbxSurvival.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        	}
        });
        chckbxSurvival.setBounds(360, 10, 75, 20);
        container.add(chckbxSurvival);
        
        JButton btnDecreaseStrength = new JButton("<");
        btnDecreaseStrength.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(0, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Strength.setText(String.valueOf(character.special[0].getAttributeLevel()));
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivateStrengthPerks();
        		
        	}
        });
        
        JLabel lblStrength = new JLabel("Strength");
        lblStrength.setBounds(60, 10, 80, 20);
        container.add(lblStrength);
        
        JLabel lblPerception = new JLabel("Perception");
        lblPerception.setBounds(60, 35, 80, 20);
        container.add(lblPerception);
        
        JLabel lblEndurance = new JLabel("Endurance");
        lblEndurance.setBounds(60, 60, 80, 20);
        container.add(lblEndurance);
        
        JLabel lblCharisma = new JLabel("Charisma");
        lblCharisma.setBounds(60, 85, 80, 20);
        container.add(lblCharisma);
        
        JLabel lblIntelligence = new JLabel("Intelligence");
        lblIntelligence.setBounds(60, 110, 80, 20);
        container.add(lblIntelligence);
        
        JLabel lblAgility = new JLabel("Agility");
        lblAgility.setBounds(60, 135, 80, 20);
        container.add(lblAgility);
        
        JLabel lblLuck = new JLabel("Luck");
        lblLuck.setBounds(60, 160, 80, 20);
        container.add(lblLuck);
        
        JLabel lblStats = new JLabel("Stats:");
        lblStats.setBounds(265, 10, 46, 20);
        container.add(lblStats);
        
        JLabel lblRemaining = new JLabel("Remaining:");
        lblRemaining.setBounds(10, 200, 70, 20);
        container.add(lblRemaining);
        btnDecreaseStrength.setBounds(10, 10, 45, 20);
        container.add(btnDecreaseStrength);
        
        JButton btnDecreasePerception = new JButton("<");
        btnDecreasePerception.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(1, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivatePerceptionPerks();
        	}
        });
        
        JButton btnIncreaseStrength = new JButton(">");
        btnIncreaseStrength.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		character.changeAttribute(0, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Strength.setText(String.valueOf(character.special[0].getAttributeLevel()));
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activateStrengthPerks();
        	}
        });
        btnIncreaseStrength.setBounds(175, 10, 45, 20);
        container.add(btnIncreaseStrength);
        btnDecreasePerception.setBounds(10, 35, 45, 20);
        container.add(btnDecreasePerception);
        
        JButton btnDecreaseEndurance = new JButton("<");
        btnDecreaseEndurance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(2, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Endurance.setText(String.valueOf(character.special[2].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivateEndurancePerks();
        	}
        });
        
        JButton btnIncreasePerception = new JButton(">");
        btnIncreasePerception.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(1, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activatePerceptionPerks();
        	}
        });
        btnIncreasePerception.setBounds(175, 35, 45, 20);
        container.add(btnIncreasePerception);
        btnDecreaseEndurance.setBounds(10, 60, 45, 20);
        container.add(btnDecreaseEndurance);
        
        JButton btnDecreaseCharisma = new JButton("<");
        btnDecreaseCharisma.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(3, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Charisma.setText(String.valueOf(character.special[3].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivateCharismaPerks();
        	}
        });
        
        JButton btnIncreaseEndurance = new JButton(">");
        btnIncreaseEndurance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(2, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Endurance.setText(String.valueOf(character.special[2].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activateEndurancePerks();
        	}
        });
        btnIncreaseEndurance.setBounds(175, 60, 45, 20);
        container.add(btnIncreaseEndurance);
        btnDecreaseCharisma.setBounds(10, 85, 45, 20);
        container.add(btnDecreaseCharisma);
        
        JButton btnDecreaseIntelligence = new JButton("<");
        btnDecreaseIntelligence.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(4, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Intelligence.setText(String.valueOf(character.special[4].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivateIntelligencePerks();
        	}
        });
        
        JButton btnIncreaseCharisma = new JButton(">");
        btnIncreaseCharisma.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(3, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Charisma.setText(String.valueOf(character.special[3].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activateCharismaPerks();
        	}
        });
        btnIncreaseCharisma.setBounds(175, 85, 45, 20);
        container.add(btnIncreaseCharisma);
        btnDecreaseIntelligence.setBounds(10, 110, 45, 20);
        container.add(btnDecreaseIntelligence);
        
        JButton btnDecreaseAgility = new JButton("<");
        btnDecreaseAgility.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(5, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Agility.setText(String.valueOf(character.special[5].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		textField_ActionPoints.setText(character.getActionPoints());
        		deactivateAgilityPerks();
        	}
        });
        
        JButton btnIncreaseIntelligence = new JButton(">");
        btnIncreaseIntelligence.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(4, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Intelligence.setText(String.valueOf(character.special[4].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activateIntelligencePerks();
        	}
        });
        btnIncreaseIntelligence.setBounds(175, 110, 45, 20);
        container.add(btnIncreaseIntelligence);
        btnDecreaseAgility.setBounds(10, 135, 45, 20);
        container.add(btnDecreaseAgility);
        
        JButton btnDecreaseLuck = new JButton("<");
        btnDecreaseLuck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(6, false);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Luck.setText(String.valueOf(character.special[6].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		deactivateLuckPerks();
        	}
        });
        
        JButton btnIncreaseAgility = new JButton(">");
        btnIncreaseAgility.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(5, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Agility.setText(String.valueOf(character.special[5].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		textField_ActionPoints.setText(character.getActionPoints());
        		activateAgilityPerks();
        	}
        });
        btnIncreaseAgility.setBounds(175, 135, 45, 20);
        container.add(btnIncreaseAgility);
        btnDecreaseLuck.setBounds(10, 160, 45, 20);
        container.add(btnDecreaseLuck);
        
        JButton btnIncreaseLuck = new JButton(">");
        btnIncreaseLuck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.changeAttribute(6, true);
        		textField_Remaining.setText(character.printRemaining());
        		textField_Luck.setText(String.valueOf(character.special[6].getAttributeLevel()));
        		textField_levelNeeded.setText(character.getLevelNeeded());
        		textField_HitPoints.setText(character.getHitPoints());
        		activateLuckPerks();
        	}
        });
        btnIncreaseLuck.setBounds(175, 160, 45, 20);
        container.add(btnIncreaseLuck);
        
        textField_Remaining = new JTextField();
        textField_Remaining.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Remaining.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_Remaining.setText("22");
        textField_Remaining.setEditable(false);
        textField_Remaining.setBounds(85, 200, 20, 20);
        container.add(textField_Remaining);
        textField_Remaining.setColumns(10);
        
        textField_Strength = new JTextField();
        textField_Strength.setEditable(false);
        textField_Strength.setText("1");
        textField_Strength.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Strength.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Strength.setBounds(145, 10, 25, 20);
        container.add(textField_Strength);
        textField_Strength.setColumns(10);
        
        textField_Perception = new JTextField();
        textField_Perception.setText("1");
        textField_Perception.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Perception.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Perception.setEditable(false);
        textField_Perception.setBounds(145, 35, 25, 20);
        container.add(textField_Perception);
        textField_Perception.setColumns(10);
        
        textField_Endurance = new JTextField();
        textField_Endurance.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Endurance.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Endurance.setText("1");
        textField_Endurance.setEditable(false);
        textField_Endurance.setBounds(145, 60, 25, 20);
        container.add(textField_Endurance);
        textField_Endurance.setColumns(10);
        
        textField_Charisma = new JTextField();
        textField_Charisma.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Charisma.setEditable(false);
        textField_Charisma.setText("1");
        textField_Charisma.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Charisma.setBounds(145, 85, 25, 20);
        container.add(textField_Charisma);
        textField_Charisma.setColumns(10);
        
        textField_Intelligence = new JTextField();
        textField_Intelligence.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Intelligence.setEditable(false);
        textField_Intelligence.setText("1");
        textField_Intelligence.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Intelligence.setBounds(145, 110, 25, 20);
        container.add(textField_Intelligence);
        textField_Intelligence.setColumns(10);
        
        textField_Agility = new JTextField();
        textField_Agility.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Agility.setEditable(false);
        textField_Agility.setText("1");
        textField_Agility.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Agility.setBounds(145, 135, 25, 20);
        container.add(textField_Agility);
        textField_Agility.setColumns(10);
        
        textField_Luck = new JTextField();
        textField_Luck.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_Luck.setText("1");
        textField_Luck.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Luck.setEditable(false);
        textField_Luck.setBounds(145, 160, 25, 20);
        container.add(textField_Luck);
        textField_Luck.setColumns(10);
        
        JLabel lblLevelNeeded = new JLabel("Level needed:");
        lblLevelNeeded.setBounds(115, 200, 80, 20);
        container.add(lblLevelNeeded);
        
        textField_levelNeeded = new JTextField();
        textField_levelNeeded.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField_levelNeeded.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_levelNeeded.setEditable(false);
        textField_levelNeeded.setText("1");
        textField_levelNeeded.setBounds(200, 200, 25, 20);
        container.add(textField_levelNeeded);
        textField_levelNeeded.setColumns(10);
        
        chckbxStrengthBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxStrengthBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		character.setBobblehead(0, chckbxStrengthBobblehead.isSelected());
        		textField_Strength.setText(String.valueOf(character.special[0].getAttributeLevel()));
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        		if (chckbxStrengthBobblehead.isSelected()){
        			activateStrengthPerks();
        		} else {
        			deactivateStrengthPerks();
        		}
        	}
        });
        chckbxStrengthBobblehead.setBounds(10, 240, 150, 20);
        container.add(chckbxStrengthBobblehead);
        txtpnIronFist.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        txtpnIronFist.setToolTipText("Channel your chi to unleash devastating fury! Punching attacks do 20% more damage to your opponent.");
        txtpnIronFist.setEditable(false);
        txtpnIronFist.setBackground(Color.CYAN);
        txtpnIronFist.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 0);
        	}
        });
        txtpnIronFist.setText("Iron Fist" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnIronFist.setBounds(10, 265, 150, 55);
        container.add(txtpnIronFist);
        
        txtpnBigLeagues.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBigLeagues.setEditable(false);
        txtpnBigLeagues.setBackground(new Color(255,255,255));
        txtpnBigLeagues.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 1);
        	}
        });
        txtpnBigLeagues.setText("Big Leagues" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnBigLeagues.setToolTipText("Swing for the fences! Do 20% more melee weapon damage.");
        txtpnBigLeagues.setBounds(10, 320, 150, 55);
        container.add(txtpnBigLeagues);
        
        txtpnArmorer.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnArmorer.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 2);
        	}
        });
        txtpnArmorer.setToolTipText("Protect yourself from the dangers of the Wasteland with access to base level and Rank 1 armor mods.");
        txtpnArmorer.setEditable(false);
        txtpnArmorer.setText("Armorer" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnArmorer.setBounds(10, 375, 150, 55);
        container.add(txtpnArmorer);
        
        txtpnBlacksmith.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBlacksmith.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 3);
        	}
        });
        txtpnBlacksmith.setToolTipText("Fire up the forge and gain access to base level and Rank 1 melee weapon mods.");
        txtpnBlacksmith.setEditable(false);
        txtpnBlacksmith.setText("Blacksmith" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnBlacksmith.setBounds(10, 430, 150, 55);
        container.add(txtpnBlacksmith);
        
        txtpnHeavyGunner.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnHeavyGunner.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 4);
        	}
        });
        txtpnHeavyGunner.setToolTipText("Thanks to practice and conditioning, heavy guns do 20% more damage.");
        txtpnHeavyGunner.setEditable(false);
        txtpnHeavyGunner.setText("Heavy Gunner" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnHeavyGunner.setBounds(10, 485, 150, 55);
        container.add(txtpnHeavyGunner);
        
        txtpnStrongBack.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnStrongBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 5);
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        	}
        });
        txtpnStrongBack.setToolTipText("What are you, part pack mule? Gain +25 to carry weight");
        txtpnStrongBack.setEditable(false);
        txtpnStrongBack.setText("Strong Back" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnStrongBack.setBounds(10, 540, 150, 55);
        container.add(txtpnStrongBack);
        
        txtpnSteadyAim.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnSteadyAim.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 6);
        	}
        });
        txtpnSteadyAim.setToolTipText("Stay on target! Hip-fire accuracy is improved when firing any gun.");
        txtpnSteadyAim.setEditable(false);
        txtpnSteadyAim.setText("Steady Aim" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnSteadyAim.setBounds(10, 595, 150, 55);
        container.add(txtpnSteadyAim);
        
        txtpnBasher.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBasher.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 7);
        	}
        });
        txtpnBasher.setToolTipText("Get up close and personal! Gun bashing does 25% more damage.");
        txtpnBasher.setEditable(false);
        txtpnBasher.setText("Basher" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnBasher.setBounds(10, 650, 150, 55);
        container.add(txtpnBasher);
        
        txtpnRooted.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRooted.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 8);
        	}
        });
        txtpnRooted.setToolTipText("You're part tree! While standing still, you gain +25 Damage Resistance and your melee and unarmed attacks deal 25% more damage.");
        txtpnRooted.setEditable(false);
        txtpnRooted.setText("Rooted" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnRooted.setBounds(10, 705, 150, 55);
        container.add(txtpnRooted);
        
        txtpnPainTrain.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnPainTrain.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 9);
        	}
        });
        txtpnPainTrain.setToolTipText("Choo Choo! All aboard! While wearing Power Armor, sprinting into enemies hurts and staggers them. (Robots and oversized enemies are immune to the stagger.)");
        txtpnPainTrain.setEditable(false);
        txtpnPainTrain.setText("Pain Train" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnPainTrain.setBounds(10, 760, 150, 55);
        container.add(txtpnPainTrain);
        
        chckbxPerceptionBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(1, chckbxPerceptionBobblehead.isSelected());
        		textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
        		if (chckbxPerceptionBobblehead.isSelected()){
            		activatePerceptionPerks();
        		} else {
        			deactivatePerceptionPerks();
        		}
        	}
        });
        chckbxPerceptionBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxPerceptionBobblehead.setBounds(160, 240, 150, 20);
        container.add(chckbxPerceptionBobblehead);
        
        txtpnPickpocket.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 10);
        	}
        });
        txtpnPickpocket.setToolTipText("Your quick hands and sticky fingers make picking pockets 25% easier.");
        txtpnPickpocket.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnPickpocket.setEditable(false);
        txtpnPickpocket.setBackground(Color.CYAN);
        txtpnPickpocket.setText("Pickpocket" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnPickpocket.setBounds(160, 265, 150, 55);
        container.add(txtpnPickpocket);
        
        txtpnRifleman.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 11);
        	}
        });
        txtpnRifleman.setToolTipText("Keep your distance long and your kill-count high. Attacks with non-automatic rifles do 20% more damage\t.");
        txtpnRifleman.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRifleman.setEditable(false);
        txtpnRifleman.setText("Rifleman" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnRifleman.setBounds(160, 320, 150, 55);
        container.add(txtpnRifleman);
        
        txtpnAwareness.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 12);
        	}
        });
        txtpnAwareness.setToolTipText("To defeat your enemies, know their weaknesses! You can view a target's specific damage resistances in V.A.T.S.");
        txtpnAwareness.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnAwareness.setEditable(false);
        txtpnAwareness.setText("Awareness" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnAwareness.setBounds(160, 375, 150, 55);
        container.add(txtpnAwareness);
        
        txtpnLocksmith.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 13);
        	}
        });
        txtpnLocksmith.setToolTipText("Your nimble fingers allow you to pick advanced locks.");
        txtpnLocksmith.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLocksmith.setEditable(false);
        txtpnLocksmith.setText("Locksmith" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnLocksmith.setBounds(160, 430, 150, 55);
        container.add(txtpnLocksmith);
        
        txtpnDemolitionExpert.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 14);
        	}
        });
        txtpnDemolitionExpert.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnDemolitionExpert.setEditable(false);
        txtpnDemolitionExpert.setText("Demolition Expert" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnDemolitionExpert.setBounds(160, 485, 150, 55);
        container.add(txtpnDemolitionExpert);
        
        txtpnNightPerson.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 15);
        	}
        });
        txtpnNightPerson.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnNightPerson.setEditable(false);
        txtpnNightPerson.setText("Night Person" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnNightPerson.setToolTipText("You are a creature of the night! Gain +2 to Intelligence and Perception between the hours of 6:00 p.m. and 6:00 a.m.");
        txtpnNightPerson.setBounds(160, 540, 150, 55);
        container.add(txtpnNightPerson);
        
        txtpnRefractor.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 16);
        	}
        });
        txtpnRefractor.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRefractor.setEditable(false);
        txtpnRefractor.setText("Refractor" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnRefractor.setToolTipText("You must be part mirror! Instantly gain +10 Energy Resistance.");
        txtpnRefractor.setBounds(160, 595, 150, 55);
        container.add(txtpnRefractor);
        
        txtpnSniper.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 17);
        	}
        });
        txtpnSniper.setToolTipText("It's all about focus. You have improved control and can hold your breath longer when aiming with scopes.\t");
        txtpnSniper.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnSniper.setEditable(false);
        txtpnSniper.setText("Sniper" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnSniper.setBounds(160, 650, 150, 55);
        container.add(txtpnSniper);
        
        txtpnPenetrator.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 18);
        	}
        });
        txtpnPenetrator.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnPenetrator.setEditable(false);
        txtpnPenetrator.setText("Penetrator" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnPenetrator.setToolTipText("There's no place to hide! In V.A.T.S. you can target an enemy's body parts that are blocked by cover, with a decrease in accuracy.");
        txtpnPenetrator.setBounds(160, 705, 150, 55);
        container.add(txtpnPenetrator);
        
        txtpnConcentratedFire.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 19);
        	}
        });
        txtpnConcentratedFire.setToolTipText("Stay Focused! In V.A.T.S. every attack on the same body part gains +10% accuracy.");
        txtpnConcentratedFire.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnConcentratedFire.setEditable(false);
        txtpnConcentratedFire.setText("Concentrated Fire" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnConcentratedFire.setBounds(160, 760, 150, 55);
        container.add(txtpnConcentratedFire);
       
        chckbxEnduranceBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(2, chckbxEnduranceBobblehead.isSelected());
        		textField_Endurance.setText(String.valueOf(character.special[2].getAttributeLevel()));
        		textField_HitPoints.setText(character.getHitPoints());
        		if (chckbxEnduranceBobblehead.isSelected()){
            		activateEndurancePerks();
        		} else {
        			deactivateEndurancePerks();
        		}
        	}
        });
        chckbxEnduranceBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxEnduranceBobblehead.setBounds(310, 240, 150, 23);
        container.add(chckbxEnduranceBobblehead);
        
        txtpnToughness.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 20);
        	}
        });
        txtpnToughness.setToolTipText("If nothing else, you can take a beating! Instantly gain +10 Damage Resistance.");
        txtpnToughness.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnToughness.setEditable(false);
        txtpnToughness.setBackground(Color.CYAN);
        txtpnToughness.setText("Toughness" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnToughness.setBounds(310, 265, 150, 55);
        container.add(txtpnToughness);
        
        txtpnLeadBelly.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 21);
        	}
        });
        txtpnLeadBelly.setToolTipText("Your digestive tract has adjusted to the weirdness of the Wasteland! Take less radiation from eating or drinking.");
        txtpnLeadBelly.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLeadBelly.setEditable(false);
        txtpnLeadBelly.setText("Lead Belly" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnLeadBelly.setBounds(310, 320, 150, 55);
        container.add(txtpnLeadBelly);
        
        txtpnLifeGiver.setToolTipText("You embody wellness! Instantly gain +20 maximum Health.");
        txtpnLifeGiver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 22);
        	}
        });
        txtpnLifeGiver.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLifeGiver.setEditable(false);
        txtpnLifeGiver.setText("Lifegiver" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnLifeGiver.setBounds(310, 375, 150, 55);
        container.add(txtpnLifeGiver);
        
        txtpnChemResistant.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 23);
        	}
        });
        txtpnChemResistant.setToolTipText("All the rush without the hassle! You're 50% less likely to get addicted when consuming Chems.");
        txtpnChemResistant.setEditable(false);
        txtpnChemResistant.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnChemResistant.setText("Chem Resistant" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnChemResistant.setBounds(310, 430, 150, 55);
        container.add(txtpnChemResistant);
        
        txtpnAquaboy.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 24);
        	}
        });
        txtpnAquaboy.setToolTipText("Water is your ally. You no longer take radiation damage from swimming, and can breathe underwater.");
        txtpnAquaboy.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnAquaboy.setEditable(false);
        txtpnAquaboy.setText("Aquaboy" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnAquaboy.setBounds(310, 485, 150, 55);
        container.add(txtpnAquaboy);
        
        txtpnRadResistant.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 25);
        	}
        });
        txtpnRadResistant.setToolTipText("Exposure to the Wasteland has made you more resilient, instantly granting +10 Radiation Resistance.");
        txtpnRadResistant.setEditable(false);
        txtpnRadResistant.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRadResistant.setText("Rad Resistant" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnRadResistant.setBounds(310, 540, 150, 55);
        container.add(txtpnRadResistant);
        
        txtpnAdamantiumSkeleton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 26);
        	}
        });
        txtpnAdamantiumSkeleton.setToolTipText("Your skeleton has been infused with indestructible metal, reducing limb damage by 30%.");
        txtpnAdamantiumSkeleton.setEditable(false);
        txtpnAdamantiumSkeleton.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnAdamantiumSkeleton.setText("Adamantium Skeleton" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnAdamantiumSkeleton.setBounds(310, 595, 150, 55);
        container.add(txtpnAdamantiumSkeleton);
        
        txtpnCannibal.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 27);
        	}
        });
        txtpnCannibal.setToolTipText("Feast on mortal flesh to heal your wounds! Eating human corpses restores Health. Each corpse for this rank heals a total of 25 health.");
        txtpnCannibal.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnCannibal.setEditable(false);
        txtpnCannibal.setText("Cannibal" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnCannibal.setBounds(310, 650, 150, 55);
        container.add(txtpnCannibal);
        
        txtpnGhoulish.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 28);
        	}
        });
        txtpnGhoulish.setToolTipText("Sure, you're still human - on the outside! Radiation now regenerates your lost Health.");
        txtpnGhoulish.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnGhoulish.setEditable(false);
        txtpnGhoulish.setText("Ghoulish" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnGhoulish.setBounds(310, 705, 150, 55);
        container.add(txtpnGhoulish);
        
        txtpnSolarPowered.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 29);
        	}
        });
        txtpnSolarPowered.setToolTipText("Catch some rays! Gain +2 to Strength and Endurance between the hours of 6:00a.m. and 6:00p.m.");
        txtpnSolarPowered.setEditable(false);
        txtpnSolarPowered.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnSolarPowered.setText("Solar Powered" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnSolarPowered.setBounds(310, 760, 150, 55);
        container.add(txtpnSolarPowered);
        
        chckbxCharismaBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(3, chckbxCharismaBobblehead.isSelected());
        		textField_Charisma.setText(String.valueOf(character.special[3].getAttributeLevel()));
        		if (chckbxCharismaBobblehead.isSelected()){
            		activateCharismaPerks();
        		} else {
        			deactivateCharismaPerks();
        		}
        	}
        });
        chckbxCharismaBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxCharismaBobblehead.setBounds(460, 240, 150, 20);
        container.add(chckbxCharismaBobblehead);
        
        txtpnCapCollector.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 30);
        	}
        });
        txtpnCapCollector.setToolTipText("You've mastered the art of the deal! Buying and selling prices at vendors are better. (10% extra when selling, 10% off when buying)");
        txtpnCapCollector.setEditable(false);
        txtpnCapCollector.setBackground(Color.CYAN);
        txtpnCapCollector.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnCapCollector.setText("Cap Collector" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnCapCollector.setBounds(460, 265, 150, 55);
        container.add(txtpnCapCollector);
        
        txtpnLadyKiller.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 31);
        	}
        });
        txtpnLadyKiller.setToolTipText("You're charming... and dangerous. Women suffer +5% damage in combat, and are easier to persuade in dialogue.");
        txtpnLadyKiller.setEditable(false);
        txtpnLadyKiller.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLadyKiller.setText("Lady Killer" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnLadyKiller.setBounds(460, 320, 150, 55);
        container.add(txtpnLadyKiller);
        
        txtpnLoneWanderer.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 32);
        		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
        		textField_ActionPoints.setText(character.getActionPoints());
        	}
        });
        txtpnLoneWanderer.setToolTipText("Who needs friends, anyway? When adventuring without a companion, you take 15% less damage and carry weight increases by 50.");
        txtpnLoneWanderer.setEditable(false);
        txtpnLoneWanderer.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLoneWanderer.setText("Lone Wanderer" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnLoneWanderer.setBounds(460, 375, 150, 55);
        container.add(txtpnLoneWanderer);
        
        txtpnAttackDog.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 33);
        	}
        });
        txtpnAttackDog.setToolTipText("Your faithful canine companion can hold an enemy, giving you a greater chance to hit them in V.A.T.S.");
        txtpnAttackDog.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnAttackDog.setEditable(false);
        txtpnAttackDog.setText("Attack Dog" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnAttackDog.setBounds(460, 430, 150, 55);
        container.add(txtpnAttackDog);
        
        txtpnAnimalFriend.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 34);
        	}
        });
        txtpnAnimalFriend.setToolTipText("Commune with beasts! With your gun, aim at any animal below your level and gain a chance to pacify it.");
        txtpnAnimalFriend.setEditable(false);
        txtpnAnimalFriend.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnAnimalFriend.setText("Animal Friend" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnAnimalFriend.setBounds(460, 485, 150, 55);
        container.add(txtpnAnimalFriend);
        
        txtpnLocalLeader.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 35);
        	}
        });
        txtpnLocalLeader.setToolTipText("As the ruler everyone turns to, you are able to establish supply lines between your workshop settlements.");
        txtpnLocalLeader.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnLocalLeader.setEditable(false);
        txtpnLocalLeader.setText("Local Leader" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnLocalLeader.setBounds(460, 540, 150, 55);
        container.add(txtpnLocalLeader);
        
        txtpnPartyBoy.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 36);
        	}
        });
        txtpnPartyBoy.setToolTipText("Nobody has a good time like you! There's no chance you'll get addicted to alcohol.");        
        txtpnPartyBoy.setEditable(false);
        txtpnPartyBoy.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnPartyBoy.setText("Party Boy" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnPartyBoy.setBounds(460, 595, 150, 55);
        container.add(txtpnPartyBoy);
        
        txtpnInspirational.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 37);
        	}
        });
        txtpnInspirational.setToolTipText("Because you lead by example, your companion does more damage in combat, and cannot hurt you.");
        txtpnInspirational.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnInspirational.setEditable(false);
        txtpnInspirational.setText("Inspirational" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnInspirational.setBounds(460, 650, 150, 55);
        container.add(txtpnInspirational);
        
        txtpnWastelandWhisperer.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 38);
        	}
        });
        txtpnWastelandWhisperer.setToolTipText("Master the post-apocalypse! With your gun, aim at any Wasteland creature below your level and gain a chance to pacify it.");
        txtpnWastelandWhisperer.setEditable(false);
        txtpnWastelandWhisperer.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnWastelandWhisperer.setText("Wasteland Whisperer" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnWastelandWhisperer.setBounds(460, 705, 150, 55);
        container.add(txtpnWastelandWhisperer);
        
        txtpnIntimidation.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 39);
        	}
        });
        txtpnIntimidation.setToolTipText("Time to show everyone who's boss! With your gun, aim at any human opponent below your level and gain a chance to pacify them.");
        txtpnIntimidation.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnIntimidation.setEditable(false);
        txtpnIntimidation.setText("Intimidation" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnIntimidation.setBounds(460, 760, 150, 55);
        container.add(txtpnIntimidation);
       
        chckbxIntelligenceBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(4, chckbxIntelligenceBobblehead.isSelected());
        		textField_Intelligence.setText(String.valueOf(character.special[4].getAttributeLevel()));
        		if (chckbxIntelligenceBobblehead.isSelected()){
            		activateIntelligencePerks();
        		} else {
        			deactivateIntelligencePerks();
        		}
        	}
        });
        chckbxIntelligenceBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxIntelligenceBobblehead.setBounds(610, 240, 150, 20);
        container.add(chckbxIntelligenceBobblehead);
        
        txtpnVans.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		vansSkill(e, 40);
        		//clickedOnPerk(e, 40);
        	}
        });
        txtpnVans.setToolTipText("Let Vault-Tec guide you! The path to your closest quest target is displayed in V.A.T.S. Long pressing the V.A.T.S. button out of combat will result in a ghost trail on the ground showing you the pathway to quest targets. Most useful in multi-story buildings.");
        txtpnVans.setBackground(Color.CYAN);
        txtpnVans.setEditable(false);
        txtpnVans.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnVans.setText("V.A.N.S" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnVans.setBounds(610, 265, 150, 55);
        container.add(txtpnVans);
        
        txtpnMedic.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 41);
        	}
        });
        txtpnMedic.setToolTipText("Is there a doctor in the house? Stimpaks restore 40% of lost Health, and RadAway removes 40% of radiation.");
        txtpnMedic.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnMedic.setEditable(false);
        txtpnMedic.setText("Medic" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnMedic.setBounds(610, 320, 150, 55);
        container.add(txtpnMedic);
        
        txtpnGunNut.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println(e.getSource().equals(txtpnGunNut));
        		clickedOnPerk(e, 42);
        		
        	}
        });
        txtpnGunNut.setToolTipText("You gain access to base level and Rank 1 gun mods.");
        txtpnGunNut.setEditable(false);
        txtpnGunNut.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnGunNut.setText("Gun Nut" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnGunNut.setBounds(610, 375, 150, 55);
        container.add(txtpnGunNut);
        
        txtpnHacker.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 43);
        	}
        });
        txtpnHacker.setToolTipText("Knowledge of cutting-edge computer encryption allows you to hack Advanced terminals.");
        txtpnHacker.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnHacker.setEditable(false);
        txtpnHacker.setText("Hacker" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnHacker.setBounds(610, 430, 150, 55);
        container.add(txtpnHacker);
        
        txtpnScrapper.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 44);
        	}
        });
        txtpnScrapper.setToolTipText("Waste not, want not! You can salvage uncommon components like screws, aluminum, and copper when scrapping weapons and armor.");
        txtpnScrapper.setEditable(false);
        txtpnScrapper.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnScrapper.setText("Scrapper" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnScrapper.setBounds(610, 485, 150, 55);
        container.add(txtpnScrapper);
        
        txtpnScience.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 45);
        	}
        });
        txtpnScience.setToolTipText("Take full advantage of advanced technology with access to base level and Rank 1 high-tech mods.");
        txtpnScience.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnScience.setEditable(false);
        txtpnScience.setText("Science!" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnScience.setBounds(610, 540, 150, 55);
        container.add(txtpnScience);
        
        txtpnChemist.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 46);
        	}
        });
        txtpnChemist.setToolTipText("Any chems you take last 50% longer. Far out.");
        txtpnChemist.setEditable(false);
        txtpnChemist.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnChemist.setText("Chemist" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnChemist.setBounds(610, 595, 150, 55);
        container.add(txtpnChemist);
        
        txtpnRoboticsExpert.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 47);
        	}
        });
        txtpnRoboticsExpert.setToolTipText("Machines will always serve humans, if you have anything to say about it. Hack a robot, and gain a chance to power it on or off, or initiate a self-destruct.");
        txtpnRoboticsExpert.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRoboticsExpert.setEditable(false);
        txtpnRoboticsExpert.setText("Robotics Expert" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnRoboticsExpert.setBounds(610, 650, 150, 55);
        container.add(txtpnRoboticsExpert);
        
        txtpnNuclearPhysicist.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 48);
        	}
        });
        txtpnNuclearPhysicist.setToolTipText("You've learned to split the atom... and command it. Radiation weapons do 50.5% more damage and Fusion Cores last an extra 25% longer.\t");
        txtpnNuclearPhysicist.setEditable(false);
        txtpnNuclearPhysicist.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnNuclearPhysicist.setText("Nuclear Physicist" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnNuclearPhysicist.setBounds(610, 705, 150, 55);
        container.add(txtpnNuclearPhysicist);
        
        txtpnNerdRage.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 49);
        	}
        });
        txtpnNerdRage.setToolTipText("Genius. Is. ANGRY! When your Health drops below 20%, time slows and you gain +20 Damage resistance and do 20% more damage while the effect lasts.");
        txtpnNerdRage.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnNerdRage.setEditable(false);
        txtpnNerdRage.setText("Nerd Rage!" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnNerdRage.setBounds(610, 760, 150, 55);
        container.add(txtpnNerdRage);
        
        chckbxAgilityBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(5, chckbxAgilityBobblehead.isSelected());
        		textField_Agility.setText(String.valueOf(character.special[5].getAttributeLevel()));
        		textField_ActionPoints.setText(character.getActionPoints());
        		if (chckbxAgilityBobblehead.isSelected()){
            		activateAgilityPerks();
        		} else {
        			deactivateAgilityPerks();
        		}
      
        	}
        });
        chckbxAgilityBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxAgilityBobblehead.setBounds(760, 240, 150, 20);
        container.add(chckbxAgilityBobblehead);
        
        txtpnGunslinger.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 50);
        	}
        });
        txtpnGunslinger.setToolTipText("Channel the spirit of the old west! Non-automatic pistols do 20% more damage.");
        txtpnGunslinger.setBackground(Color.CYAN);
        txtpnGunslinger.setEditable(false);
        txtpnGunslinger.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnGunslinger.setText("Gunslinger" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnGunslinger.setBounds(760, 265, 150, 55);
        container.add(txtpnGunslinger);
        
        txtpnCommando.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 51);
        	}
        });
        txtpnCommando.setToolTipText("Rigorous combat training means automatic weapons do 20% more damage");
        txtpnCommando.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnCommando.setEditable(false);
        txtpnCommando.setText("Commando" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnCommando.setBounds(760, 320, 150, 55);
        container.add(txtpnCommando);
        
        txtpnSneak.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 52);
        	}
        });
        txtpnSneak.setToolTipText("You are now 30% harder to detect while sneaking, and no longer trigger floor-based traps.");
        txtpnSneak.setEditable(false);
        txtpnSneak.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnSneak.setText("Sneak" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/5");
        txtpnSneak.setBounds(760, 375, 150, 55);
        container.add(txtpnSneak);
        
        txtpnMisterSandman.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 53);
        	}
        });
        txtpnMisterSandman.setToolTipText("As an agent of death, you can instantly kill a sleeping person. Your silenced weapons do an additional 15% sneak attack damage.");
        txtpnMisterSandman.setEditable(false);
        txtpnMisterSandman.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnMisterSandman.setText("Mister Sandman" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnMisterSandman.setBounds(760, 430, 150, 55);
        container.add(txtpnMisterSandman);
        
        txtpnActionBoy.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 54);
        	}
        });
        txtpnActionBoy.setToolTipText("There's no time to waste! Action Points regenerate 25% faster.");       
        txtpnActionBoy.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnActionBoy.setEditable(false);
        txtpnActionBoy.setText("Action Boy" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnActionBoy.setBounds(760, 485, 150, 55);
        container.add(txtpnActionBoy);
        
        txtpnMovingTarget.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 55);
        	}
        });
        txtpnMovingTarget.setToolTipText("They can't hurt what they can't hit! Get 25+ Damage Resistance and 25+ Energy Resistance when you're sprinting.");
        txtpnMovingTarget.setEditable(false);
        txtpnMovingTarget.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnMovingTarget.setText("Moving Target" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnMovingTarget.setBounds(760, 540, 150, 55);
        container.add(txtpnMovingTarget);
        
        txtpnNinja.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 56);
        	}
        });
        txtpnNinja.setToolTipText("Trained as a shadow warrior, your ranged sneak attacks do 2.5x normal damage and your melee attacks do 4x normal damage.");
        txtpnNinja.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnNinja.setEditable(false);
        txtpnNinja.setText("Ninja" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnNinja.setBounds(760, 595, 150, 55);
        container.add(txtpnNinja);
        
        txtpnQuickHands.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 57);
        	}
        });
        txtpnQuickHands.setToolTipText("In combat, there's no time to hesitate. You can reload all guns faster.");        
        txtpnQuickHands.setEditable(false);
        txtpnQuickHands.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnQuickHands.setText("Quick Hands" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnQuickHands.setBounds(760, 650, 150, 55);
        container.add(txtpnQuickHands);
        
        txtpnBlitz.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 58);
        	}
        	
        });
        txtpnBlitz.setToolTipText("Find the gap and make the tackle! V.A.T.S. melee distance is increased significantly.");       
        txtpnBlitz.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBlitz.setEditable(false);
        txtpnBlitz.setText("Blitz" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/2");
        txtpnBlitz.setBounds(760, 705, 150, 55);
        container.add(txtpnBlitz);
        
        txtpnGunFu.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 59);
        	}
        });
        txtpnGunFu.setToolTipText("You've learned to apply ancient martial arts to gunplay! Do 25% more damage to your second V.A.T.S. target and beyond.");
        txtpnGunFu.setEditable(false);
        txtpnGunFu.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnGunFu.setText("Gun Fu" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnGunFu.setBounds(760, 760, 150, 55);
        container.add(txtpnGunFu);
        
        chckbxLuckBobblehead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setBobblehead(6, chckbxLuckBobblehead.isSelected());
        		textField_Luck.setText(String.valueOf(character.special[6].getAttributeLevel()));
        		if (chckbxLuckBobblehead.isSelected()){
            		activateLuckPerks();
        		} else {
        			deactivateLuckPerks();
        		}
        	}
        });
        chckbxLuckBobblehead.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbxLuckBobblehead.setBounds(910, 240, 150, 23);
        container.add(chckbxLuckBobblehead);
        
        txtpnFortuneFinder.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 60);
        	}
        });
        txtpnFortuneFinder.setToolTipText("You find more bottle caps in containers.");        
        txtpnFortuneFinder.setEditable(false);
        txtpnFortuneFinder.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnFortuneFinder.setBackground(Color.CYAN);
        txtpnFortuneFinder.setText("Fortune Finder" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnFortuneFinder.setBounds(910, 265, 150, 55);
        container.add(txtpnFortuneFinder);
        
        txtpnScrounger.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 61);
        	}
        });
        txtpnScrounger.setToolTipText("You find more ammunition in containers.");        
        txtpnScrounger.setEditable(false);
        txtpnScrounger.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnScrounger.setText("Scrounger" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnScrounger.setBounds(910, 320, 150, 55);
        container.add(txtpnScrounger);
        
        txtpnBloodyMess.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 62);
        	}
        });
        txtpnBloodyMess.setToolTipText("+5% bonus damage means enemies will sometimes explode into a gory red paste. Watch out for flying eyeballs!");
        txtpnBloodyMess.setEditable(false);
        txtpnBloodyMess.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBloodyMess.setText("Bloody Mess" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnBloodyMess.setBounds(910, 375, 150, 55);
        container.add(txtpnBloodyMess);
        
        txtpnMysteriousStranger.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 63);
        	}
        	
        });
        txtpnMysteriousStranger.setToolTipText("Who is he? Why does he help? Who cares! The Mysterious Stranger will appear occasionally in V.A.T.S. to lend a hand, with deadly efficiency...");
        txtpnMysteriousStranger.setEditable(false);
        txtpnMysteriousStranger.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnMysteriousStranger.setText("Mysterious Stranger" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnMysteriousStranger.setBounds(910, 430, 150, 55);
        container.add(txtpnMysteriousStranger);
        
        txtpnIdiotSavant.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 64);
        	}
        });
        txtpnIdiotSavant.setToolTipText("You're not stupid! Just... different. Randomly receive 3x XP from any action, and the lower your Intelligence, the greater the chance.");
        txtpnIdiotSavant.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnIdiotSavant.setEditable(false);
        txtpnIdiotSavant.setText("Idiot Savant" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnIdiotSavant.setBounds(910, 485, 150, 55);
        container.add(txtpnIdiotSavant);
        
        txtpnBetterCriticals.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 65);
        	}
        });
        txtpnBetterCriticals.setToolTipText("Advanced training for enhanced combat effectiveness! Criticals do 50% more extra damage.");
        txtpnBetterCriticals.setEditable(false);
        txtpnBetterCriticals.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnBetterCriticals.setText("Better Criticals" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnBetterCriticals.setBounds(910, 540, 150, 55);
        container.add(txtpnBetterCriticals);
        
        txtpnCriticalBanker.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 66);
        	}
        });
        txtpnCriticalBanker.setToolTipText("You're a patient battlefield tactician, and can save a Critical Hit, to be used in V.A.T.S. when you need it most.");
        txtpnCriticalBanker.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnCriticalBanker.setEditable(false);
        txtpnCriticalBanker.setText("Critical Banker" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnCriticalBanker.setBounds(910, 595, 150, 55);
        container.add(txtpnCriticalBanker);
        
        txtpnGrimReapersSprint.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 67);
        	}
        });
        txtpnGrimReapersSprint.setToolTipText("Death becomes you! Any kill in V.A.T.S. has a 15% chance to restore all Action Points.\t");
        txtpnGrimReapersSprint.setEditable(false);
        txtpnGrimReapersSprint.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnGrimReapersSprint.setText("Grim Reaper's Sprint" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnGrimReapersSprint.setBounds(910, 650, 150, 55);
        container.add(txtpnGrimReapersSprint);
        
        txtpnFourLeafClover.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 68);
        	}
        });
        txtpnFourLeafClover.setToolTipText("Feeling Lucky? You should! Each hit in V.A.T.S. has a chance of filling your Critical meter.");
        txtpnFourLeafClover.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnFourLeafClover.setEditable(false);
        txtpnFourLeafClover.setText("Four Leaf Clover" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/4");
        txtpnFourLeafClover.setBounds(910, 705, 150, 55);
        container.add(txtpnFourLeafClover);
        
        txtpnRicochet.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		clickedOnPerk(e, 69);
        	}
        });
        txtpnRicochet.setToolTipText("What goes around comes around! Any enemy's ranged attacks will sometimes ricochet back and instantly kill them. The closer you are to death, the higher the chance.");
        
        txtpnRicochet.setEditable(false);
        txtpnRicochet.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtpnRicochet.setText("Ricochet" + System.getProperty("line.separator") + System.getProperty("line.separator") + "0/3");
        txtpnRicochet.setBounds(910, 760, 150, 55);
        container.add(txtpnRicochet);
        
        chckbxSpecialBook.setSelected(true);
        chckbxSpecialBook.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		character.setSpecialBook(chckbxSpecialBook.isSelected());
        		textField_Remaining.setText(character.printRemaining());
        		textField_levelNeeded.setText(character.getLevelNeeded());
        	}
        });
        chckbxSpecialBook.setBounds(10, 183, 160, 20);
        
        container.add(chckbxSpecialBook);
        
        JLabel lblHitPoints = new JLabel("Hit Points:");
        lblHitPoints.setBounds(265, 65, 90, 20);
        container.add(lblHitPoints);
        
        JLabel lblActionPoints = new JLabel("Action Points:");
        lblActionPoints.setBounds(265, 90, 90, 20);
        container.add(lblActionPoints);
        
        textField_HitPoints = new JTextField();
        textField_HitPoints.setHorizontalAlignment(SwingConstants.LEFT);
        textField_HitPoints.setBorder(null);
        textField_HitPoints.setEditable(false);
        textField_HitPoints.setText("85");
        textField_HitPoints.setBounds(360, 65, 30, 20);
        container.add(textField_HitPoints);
        textField_HitPoints.setColumns(10);
        
        textField_ActionPoints = new JTextField();
        textField_ActionPoints.setHorizontalAlignment(SwingConstants.LEFT);
        textField_ActionPoints.setEditable(false);
        textField_ActionPoints.setBorder(null);
        textField_ActionPoints.setText("70");
        textField_ActionPoints.setBounds(360, 90, 30, 20);
        container.add(textField_ActionPoints);
        textField_ActionPoints.setColumns(10);
        
        textField_loadCharacter = new JTextField();
        textField_loadCharacter.setHorizontalAlignment(SwingConstants.CENTER);
        textField_loadCharacter.setBounds(10, 905, 875, 23);
        container.add(textField_loadCharacter);
        textField_loadCharacter.setColumns(10);
        
        JButton btnLoadCharacter = new JButton("Load Character");
        btnLoadCharacter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		loadCharacter();
        	}
        });
        btnLoadCharacter.setBounds(900, 905, 160, 23);
        container.add(btnLoadCharacter);
        
        JButton btnGetShareLink = new JButton("Get Share Link");
        btnGetShareLink.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String s = getShareLink();
        		textField_getShareLink.setText(s);
        	}
        });
        btnGetShareLink.setBounds(900, 875, 160, 23);
        container.add(btnGetShareLink);
        
        textField_getShareLink = new JTextField();
        textField_getShareLink.setHorizontalAlignment(SwingConstants.CENTER);
        textField_getShareLink.setBounds(10, 875, 875, 23);
        container.add(textField_getShareLink);
        textField_getShareLink.setColumns(10);
        
        
        centerTextPanes();
        frmFalloutCharacter.getContentPane().add(scrollPane);
	
	}
	
	protected void killPerks(int i) {
			JTextPane pane;
			int attributeLvl = character.special[i].getAttributeLevel();
			if (attributeLvl == 10){
				return;
			}
			int perk = (i * 10) + attributeLvl;
			System.out.println(perk);
			System.out.println(character.perks[perk].level);
			while (character.perks[perk].level > 0){
				character.unskillPerk(perk);
			}
			pane = this.getPaneArray(i)[attributeLvl];
			textField_levelNeeded.setText(character.getLevelNeeded());
			textField_HitPoints.setText(character.getHitPoints());
			textField_ActionPoints.setText(character.getActionPoints());
			textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
			builder.setLength(0);
			builder.append(character.perks[perk].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));
			builder.append(character.perks[perk].level).append("/").append(character.perks[perk].perk.getRanks());
			pane.setText(builder.toString());
			builder.setLength(0);
			builder.append(character.perks[perk].perk.getDescription(Math.max(character.perks[perk].level - 1, 0)));
			pane.setToolTipText(builder.toString());
			
	}
	
	protected JTextPane[] getPaneArray(int i){
		switch (i) {
		case 0: return this.strengthPerks;
		case 1: return this.perceptionPerks;
		case 2: return this.endurancePerks;
		case 3: return this.charismaPerks;
		case 4: return this.intelligencePerks;
		case 5: return this.agilityPerks;
		case 6: return this.luckPerks;
		default:	return null;
		}
	}

	public void clickedOnPerk(MouseEvent e, int index){
		JTextPane pane = (JTextPane) e.getSource();
		if (SwingUtilities.isLeftMouseButton(e)){
			character.skillPerk(index);
			textField_levelNeeded.setText(character.getLevelNeeded());
			textField_HitPoints.setText(character.getHitPoints());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));        		builder.append(character.perks[index].level).append("/").append(character.perks[index].perk.getRanks());
			pane.setText(builder.toString());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getDescription(Math.max(character.perks[index].level - 1, 0)));
			pane.setToolTipText(builder.toString());
		}
		if (SwingUtilities.isRightMouseButton(e)){
			character.unskillPerk(index);
			textField_levelNeeded.setText(character.getLevelNeeded());
			textField_HitPoints.setText(character.getHitPoints());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));
			builder.append(character.perks[index].level).append("/").append(character.perks[index].perk.getRanks());
			pane.setText(builder.toString());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getDescription(Math.max(character.perks[index].level - 1, 0)));
			pane.setToolTipText(builder.toString());
		}
	}
	
	public void vansSkill(MouseEvent e, int index){
		JTextPane pane = (JTextPane) e.getSource();
		if (SwingUtilities.isLeftMouseButton(e)){
			if (character.perks[index].level == 2){
				return;
			}
			character.skillPerk(index);
			textField_levelNeeded.setText(character.getLevelNeeded());
			textField_HitPoints.setText(character.getHitPoints());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));        		builder.append(character.perks[index].level).append("/").append(character.perks[index].perk.getRanks());
			pane.setText(builder.toString());
			if (character.perks[index].level == 2)
				{
					character.special[1].addBobblehead();
					character.special[1].addBobblehead();
					textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
					activatePerceptionPerks();
				}
			builder.setLength(0);
			builder.append(character.perks[index].perk.getDescription(Math.max(character.perks[index].level - 1, 0)));
			pane.setToolTipText(builder.toString());
		}
		if (SwingUtilities.isRightMouseButton(e)){
			character.unskillPerk(index);
			textField_levelNeeded.setText(character.getLevelNeeded());
			textField_HitPoints.setText(character.getHitPoints());
			builder.setLength(0);
			builder.append(character.perks[index].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));
			builder.append(character.perks[index].level).append("/").append(character.perks[index].perk.getRanks());
			pane.setText(builder.toString());
			if (character.perks[index].level == 1)
			{
				character.special[1].removeBobblehead();
				character.special[1].removeBobblehead();
				textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
				deactivatePerceptionPerks();
			}
			builder.setLength(0);
			builder.append(character.perks[index].perk.getDescription(Math.max(character.perks[index].level - 1, 0)));
			pane.setToolTipText(builder.toString());
		}
	}
	public void deactivateStrengthPerks(){
		killPerks(0);
		for (int i = character.special[0].getAttributeLevel(); i < 10; i++){
			strengthPerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateStrengthPerks(){
		
		for (int i = character.special[0].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			strengthPerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivatePerceptionPerks(){
		killPerks(1);
		for (int i = character.special[1].getAttributeLevel(); i < 10; i++){
			perceptionPerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activatePerceptionPerks(){
		
		for (int i = character.special[1].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			perceptionPerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivateEndurancePerks(){
		killPerks(2);
		for (int i = character.special[2].getAttributeLevel(); i < 10; i++){
			endurancePerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateEndurancePerks(){
		
		for (int i = character.special[2].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			endurancePerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivateCharismaPerks(){
		killPerks(3);
		for (int i = character.special[3].getAttributeLevel(); i < 10; i++){
			charismaPerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateCharismaPerks(){
		
		for (int i = character.special[3].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			charismaPerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivateIntelligencePerks(){
		killPerks(4);
		for (int i = character.special[4].getAttributeLevel(); i < 10; i++){
			intelligencePerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateIntelligencePerks(){
		
		for (int i = character.special[4].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			intelligencePerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivateAgilityPerks(){
		killPerks(5);
		for (int i = character.special[5].getAttributeLevel(); i < 10; i++){
			agilityPerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateAgilityPerks(){
		
		for (int i = character.special[5].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			agilityPerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	public void deactivateLuckPerks(){
		killPerks(6);
		for (int i = character.special[6].getAttributeLevel(); i < 10; i++){
			luckPerks[i].setBackground(new Color(255,255,255));
		}
	}
	
	public void activateLuckPerks(){
		
		for (int i = character.special[6].getAttributeLevel(); i > 0; i--){	
			if (i == 11){
				return;
			}
			luckPerks[i - 1].setBackground(Color.CYAN);
		}
	}
	
	
	public void centerTextPanes(){
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyledDocument doc;
		for (JTextPane pane : strengthPerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : perceptionPerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : endurancePerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : charismaPerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : intelligencePerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : agilityPerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		for (JTextPane pane : luckPerks){
			doc = pane.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
	}
	
	protected String getShareLink() {
			builder.setLength(0);
			if (this.chckbxSpecialBook.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxStrengthBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxPerceptionBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxEnduranceBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxCharismaBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxIntelligenceBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxAgilityBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			if (this.chckbxLuckBobblehead.isSelected()){
				builder.append("t,");
			} else {
				builder.append("f,");
			}
			for (int i = 0; i <= 6; i++){
				builder.append(character.special[i].getAttributeLevel()).append(",");
			}
			for (int i = 0; i <= 69; i++){
				builder.append(character.perks[i].level).append(",");
			}
			if (this.chckbxSurvival.isSelected()){
				builder.append("t");
			} else {
				builder.append("f");
			}
		
			return builder.toString();
	}
	
	protected void loadCharacter(){
		boolean[] heads = new boolean[7];
		String[] data = textField_loadCharacter.getText().split(",");
		this.character = new Character();
		if (data[0].equals("t")){
			chckbxSpecialBook.setSelected(true);
		} else {
			chckbxSpecialBook.setSelected(false);
			character.setSpecialBook(false);
		}
		if (data[1].equals("t")){
			chckbxStrengthBobblehead.setSelected(true);
			character.setBobblehead(0, true);
			heads[0] = true;
		} else {
			chckbxStrengthBobblehead.setSelected(false);
			heads[0] = false;
		}
		if (data[2].equals("t")){
			chckbxPerceptionBobblehead.setSelected(true);
			character.setBobblehead(1, true);
			heads[1] = true;
		} else {
			chckbxPerceptionBobblehead.setSelected(false);
			heads[1] = false;
		}
		if (data[3].equals("t")){
			chckbxEnduranceBobblehead.setSelected(true);
			character.setBobblehead(2, true);
			heads[2] = true;
		} else {
			chckbxEnduranceBobblehead.setSelected(false);
			heads[2] = false;
		}
		if (data[4].equals("t")){
			chckbxCharismaBobblehead.setSelected(true);
			character.setBobblehead(3, true);
			heads[3] = true;
		} else {
			chckbxCharismaBobblehead.setSelected(false);
			heads[3] = false;
		}
		if (data[5].equals("t")){
			chckbxIntelligenceBobblehead.setSelected(true);
			character.setBobblehead(4, true);
			heads[4] = true;
		} else {
			chckbxIntelligenceBobblehead.setSelected(false);
			heads[4] = false;
		}
		if (data[6].equals("t")){
			chckbxAgilityBobblehead.setSelected(true);
			character.setBobblehead(5, true);
			heads[5] = true;
		} else {
			chckbxAgilityBobblehead.setSelected(false);
			heads[5] = false;
		}
		if (data[7].equals("t")){
			chckbxLuckBobblehead.setSelected(true);
			character.setBobblehead(6, true);
			heads[6] = true;
		} else {
			chckbxLuckBobblehead.setSelected(false);
			heads[6] = false;
		}
		if (data[data.length-1].equals("t")){
			chckbxSurvival.setSelected(true);
		} else {
			chckbxSurvival.setSelected(false);
		}
		for (int i = 8; i <= 14; i++){
			int level = Integer.valueOf(data[i]);
			if (heads[i-8]){
				level--;
			}
			for (int k = 1; k < level; k++){
				this.character.changeAttribute(i-8, true);
			}
		}
		for (int i = 15; i < data.length - 2; i++){
			int level = Integer.valueOf(data[i]);
			for (int k = 0; k < level; k++){
				this.character.skillPerk(i-15);
			}
		}
		updateAllFields();
	}

	private void updateAllFields() {
		textField_Strength.setText(String.valueOf(character.special[0].getAttributeLevel()));
		textField_Perception.setText(String.valueOf(character.special[1].getAttributeLevel()));
		textField_Endurance.setText(String.valueOf(character.special[2].getAttributeLevel()));
		textField_Charisma.setText(String.valueOf(character.special[3].getAttributeLevel()));
		textField_Intelligence.setText(String.valueOf(character.special[4].getAttributeLevel()));
		textField_Agility.setText(String.valueOf(character.special[5].getAttributeLevel()));
		textField_Luck.setText(String.valueOf(character.special[6].getAttributeLevel()));
		textField_Remaining.setText(character.printRemaining());
		textField_levelNeeded.setText(character.getLevelNeeded());
		textField_HitPoints.setText(character.getHitPoints());
		textField_CarryWeight.setText(character.getCarryWeight(chckbxSurvival.isSelected()));
		textField_ActionPoints.setText(character.getActionPoints());
		int i = 0;
		for (JTextPane pane : strengthPerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : perceptionPerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : endurancePerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : charismaPerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : intelligencePerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : agilityPerks){
			updateTextPane(i, pane);
			i++;
		}
		for (JTextPane pane : luckPerks){
			updateTextPane(i, pane);
			i++;
		}
		loadAllPerks();
	}
	
	private void loadAllPerks(){
		for (int i = character.special[0].getAttributeLevel(); i < 10; i++){
			strengthPerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[1].getAttributeLevel(); i < 10; i++){
			perceptionPerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[2].getAttributeLevel(); i < 10; i++){
			endurancePerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[3].getAttributeLevel(); i < 10; i++){
			charismaPerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[4].getAttributeLevel(); i < 10; i++){
			intelligencePerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[5].getAttributeLevel(); i < 10; i++){
			agilityPerks[i].setBackground(new Color(255,255,255));
		}
		for (int i = character.special[6].getAttributeLevel(); i < 10; i++){
			luckPerks[i].setBackground(new Color(255,255,255));
		}
		
	}
	
	private void updateTextPane(int perk, JTextPane pane){
		builder.setLength(0);
		builder.append(character.perks[perk].perk.getName()).append((System.getProperty("line.separator"))).append((System.getProperty("line.separator")));
		builder.append(character.perks[perk].level).append("/").append(character.perks[perk].perk.getRanks());
		pane.setText(builder.toString());
		builder.setLength(0);
		builder.append(character.perks[perk].perk.getDescription(Math.max(character.perks[perk].level - 1, 0)));
		pane.setToolTipText(builder.toString());
		pane.setBackground(Color.CYAN);
	}
}
