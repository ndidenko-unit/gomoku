import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

//	private int difficulty;
//	private boolean computerStarts; TODO drop, moved to GameSettings
	
	private JPanel boardPanel;
	private JPanel setupPanel;
// 	private final JPanel difficultyPanel;
	private JPanel startingPlayerPanel;
	
	
	private JButton buttonStart;
// 	private final JRadioButton rbNormal;
// 	private final JRadioButton rbHard;
	
	private JRadioButton rbHuman;
	private JRadioButton rbComputer;
	
// 	private final ButtonGroup bgDifficulty ;
	private ButtonGroup bgStartingPlayer;
	
// 	private final JLabel taDifficulty;
	private JLabel taStartingPlayer;
	
	public MainGUI(String title) {
		super();
		configureChildElements();
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(getScreenCenter(setupPanel.getPreferredSize()));
		pack();
	}

	private void configureChildElements() {
		setupPanel = new JPanel();
		setupPanel.setLayout(new BoxLayout(setupPanel, BoxLayout.PAGE_AXIS));
// 		difficultyPanel = new JPanel();
		startingPlayerPanel = new JPanel();

		buttonStart = new JButton("Start Game");

// 		rbNormal = new JRadioButton("Normal (Faster)");
// 		rbHard = new JRadioButton("Hard (Slower)");

		rbHuman = new JRadioButton("Human");
		rbComputer = new JRadioButton("Computer");

// 		bgDifficulty = new ButtonGroup();
		bgStartingPlayer = new ButtonGroup();

// 		bgDifficulty.add(rbNormal);
// 		bgDifficulty.add(rbHard);

		bgStartingPlayer.add(rbHuman);
		bgStartingPlayer.add(rbComputer);

// 		taDifficulty = new JLabel("Difficulty: ");
		taStartingPlayer = new JLabel("starts first.");

// 		rbNormal.setSelected(true);
		rbComputer.setSelected(true);

// 		difficultyPanel.add(taDifficulty);
// 		difficultyPanel.add(rbNormal);
// 		difficultyPanel.add(rbHard);

		startingPlayerPanel.add(rbComputer);
		startingPlayerPanel.add(rbHuman);
		startingPlayerPanel.add(taStartingPlayer);

// 		setupPanel.add(difficultyPanel);
		setupPanel.add(startingPlayerPanel);
		setupPanel.add(buttonStart);

		add(setupPanel);
	}

	private Point getScreenCenter(Dimension windowSize) {
		Dimension screenSize = getToolkit().getScreenSize();
		int x = screenSize.width / 2 - windowSize.width / 2;
		int y = screenSize.height / 2 - windowSize.height / 2;
		return new Point(x, y);
	}

	/*
	 * 	Reads components to fetch and return the chosen settings.
	 */
	public GameSettings fetchSettings() {
// 		if( rbNormal.isSelected() ) {
// 			difficulty = 3;
// 		} else difficulty = 4;
		GameSettings.FirstMove firstMove = rbComputer.isSelected() ? GameSettings.FirstMove.COMPUTER : GameSettings.FirstMove.HUMAN;
		return new GameSettings(firstMove, 4);
	}

	public void listenGameStartButton(ActionListener listener) {
		buttonStart.addActionListener(listener);
	}

	public void attachBoard(JPanel board) {
		boardPanel = board;
	}

	public void showBoard() {
		setContentPane(boardPanel);
		setLocation(getScreenCenter(boardPanel.getPreferredSize()));
		invalidate();
		validate();
		pack();
	}
}
