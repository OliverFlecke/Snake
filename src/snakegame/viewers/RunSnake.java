package snakegame.viewers;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class RunSnake extends GenericDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -647167119165272436L;
	
	//List of names for player creation in game
	ArrayList<String> names = new ArrayList<String>();
		
	//Create the buttons
	JButton startGameBtn = new JButton("Start Game");
	
	//Make JLabel
	JLabel snake = new JLabel("SNAKE", SwingConstants.CENTER);

	
	//Make a JPanel to hold the btns and the labels
	JPanel btnShelf = new JPanel();
	JPanel dimensionsShelf = new JPanel();
	
	//Make two textJpanels
	TextJPanel widthPanel = new TextJPanel("Width:");
	TextJPanel heightPanel = new TextJPanel("Height:");
	TextJPanel namePanel1 = new TextJPanel("Name:");
	
	public RunSnake(){
		
		//Set labelName for txtPanels.
		widthPanel.setTxt(10);
		heightPanel.setTxt(10);
		
		//Making shelfs transparent
		btnShelf.setOpaque(false);
		dimensionsShelf.setOpaque(false);
		
		
		//Adding btns and labels to shelf
		btnShelf.add(startGameBtn);
		
		snake.setPreferredSize(new Dimension(300,40));
		dimensionsShelf.setPreferredSize(new Dimension(300,40));
		
		
		//Set up enterkey to trigger Jbutton
		startGameBtn.setMnemonic(10);
		
		//setting up the dimensionsShelf
		dimensionsShelf.setLayout(new FlowLayout());
		dimensionsShelf.add(widthPanel);
		dimensionsShelf.add(heightPanel);
		
		background.setLayout(new GridLayout(4,0));
		background.add(snake);
		background.add(namePanel1);
		background.add(dimensionsShelf);
		background.add(btnShelf);


		this.pack();
		
		
		startGameBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				createListOfNames(); 	

				new View(Integer.parseInt(widthPanel.getTxt()), Integer.parseInt(heightPanel.getTxt()), names);

				closeFrame();
			}

			private void createListOfNames() {
				names.add(namePanel1.getTxt());
				
			}
		});

				
	}
	
		
}
