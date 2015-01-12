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


public class RunSnake extends GenericDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -647167119165272436L;
	
	
	//Set up the playerPanel for singleplayer
	PlayerPanel playerPanel = new PlayerPanel(1);
	
	//List of names for player creation in game
	ArrayList<String> names = new ArrayList<String>();
		
	//Create the buttons
	JButton startGameBtn = new JButton("Start Game");
	JButton controlsbtn = new JButton("Controls");
	JButton highScoreBtn = new JButton("HighScore");
	
	//creating a combobox
	String[] numbOfPlayers = {"1","2","3","4"};
	JComboBox<String> comboPlayers = new JComboBox<String>(numbOfPlayers);
	
	//Make JLabel
	JLabel snake = new JLabel("SNAKE", SwingConstants.CENTER);

	
	//Make a JPanel to hold the btns and the labels
	JPanel btnShelf = new JPanel();
	JPanel dimensionsShelf = new JPanel();
	
	//Make textJpanels
	TextJPanel widthPanel = new TextJPanel("Width:");
	TextJPanel heightPanel = new TextJPanel("Height:");
	
	public RunSnake(){
		
		//Setting up combobox
		comboPlayers.setSelectedIndex(0);
		
		//Set labelName for txtPanels.
		widthPanel.setTxt(Integer.toString(40));
		heightPanel.setTxt(Integer.toString(40));
		
		//Making shelfs transparent
		btnShelf.setOpaque(false);
		dimensionsShelf.setOpaque(false);
		
		
		//Setting up layout and adding buttons to shelf
		btnShelf.setLayout(new FlowLayout());
		btnShelf.add(startGameBtn);
		btnShelf.add(highScoreBtn);
		btnShelf.add(controlsbtn);
		
		snake.setPreferredSize(new Dimension(300,40));
		dimensionsShelf.setPreferredSize(new Dimension(300,40));
		
		
		//Set up enterkey to trigger Jbutton
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
		
		
		startGameBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new View(Integer.parseInt(widthPanel.getTxt()), Integer.parseInt(heightPanel.getTxt()), playerPanel.names());
				
				closeFrame();
			}
		});

				
	}
		
}
