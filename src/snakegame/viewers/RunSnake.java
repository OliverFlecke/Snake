package snakegame.viewers;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Startup for the snake game, which includes settings for the game
 */
public class RunSnake extends GenericDialog{
	
	/**
	 * Start of the snake game. Main method for the entire application
	 * @param args
	 */
	public static void main(String[] args) {
		//new RunSnake();
		new RunSnake();
	}
	
	private static final long serialVersionUID = -647167119165272436L;
	
	//Set up the playerPanel for singleplayer
	PlayerPanel playerPanel = new PlayerPanel(1);
	
	//List of names for player creation in game
	ArrayList<String> names = new ArrayList<String>();
		
	//Create the buttons
	JButton startGameBtn = new BigButton("Start Game");
	JButton controlsBtn = new BigButton("Controls");
	JButton highScoreBtn = new BigButton("HighScore");
	
	//creating a combobox
	String[] numbOfPlayers = {"1","2","3","4"};
	JComboBox<String> comboPlayers = new JComboBox<String>(numbOfPlayers);
	
	//Make JLabel
	JLabel snake = new JLabel("", SwingConstants.CENTER);

	//Make a JPanel to hold the btns and the labels
	JPanel btnShelf = new JPanel();
	JPanel dimensionsShelf = new JPanel();
	
	//Make textJpanels
	TextJPanel widthPanel = new TextJPanel("Width:");
	TextJPanel heightPanel = new TextJPanel("Height:");
	
	/**
	 * Constructor. Creates the start dialog with settings for the snake game
	 */
	public RunSnake(){
		super("Start Snake");
		//Setting up combobox
		comboPlayers.setSelectedIndex(0);
		
		//Set labelName for txtPanels.
		widthPanel.setTxt(Integer.toString(30));
		heightPanel.setTxt(Integer.toString(30));

		//Set size
		startGameBtn.setPreferredSize(new Dimension(100,30));
		controlsBtn.setPreferredSize(new Dimension(100,30));
		highScoreBtn.setPreferredSize(new Dimension(100,30));
		
		
		//Making shelfs transparent
		btnShelf.setOpaque(false);
		dimensionsShelf.setOpaque(false);
		
		
		//Setting up layout and adding buttons to shelf
		btnShelf.setLayout(new FlowLayout());
		btnShelf.add(startGameBtn);
		btnShelf.add(highScoreBtn);
		btnShelf.add(controlsBtn);
		
		snake.setPreferredSize(new Dimension(300,40));
		dimensionsShelf.setPreferredSize(new Dimension(300,40));
		
		//Set up enterkey to trigger Jbutton. Used to start the game faster
		startGameBtn.setMnemonic(KeyEvent.VK_ENTER);
		
		//setting up the dimensionsShelf
		dimensionsShelf.setLayout(new FlowLayout());
		dimensionsShelf.add(widthPanel);
		dimensionsShelf.add(heightPanel);
		
		background.setLayout(new GridLayout(5,4));
		background.add(snake);
		background.add(new PlayerSelectPanel(playerPanel));
		background.add(playerPanel);
		background.add(dimensionsShelf);
		background.add(btnShelf);

		this.pack();
		
		/**
		 * Listener for the start game button. Checks the input in the fields, and creates a view
		 * with the given input
		 */
		startGameBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Makes the width and height between 5 and 100
				int width = Integer.parseInt(widthPanel.getTxt());
				if (width > 100) 
					width = 100;
				else if (width < 5) 
					width = 5;
				
				int height = Integer.parseInt(heightPanel.getTxt());
				if (height > 100)
					height = 100;
				else if (height < 5) 
					height = 5;
				
				// Insures the names don't have whitespace
				ArrayList<String> playerNames = new ArrayList<String>();
				for (String name : playerPanel.names()) {
					playerNames.add(name.replaceAll("\\s+", ""));
				}
				
				// Create the view with the game
				new View(width, height,	playerNames);
				closeFrame();
			}
		});
		
		/**
		 * Listener for the highscore. Displays the highscore if pressed
		 */
		highScoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StandAloneHighScore();
			}
		});
		
		/**
		 * Listener for controls button. Shows the controls for the four players in the game
		 */
		controlsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControlsDialog();
			}
		});		
	}		
}