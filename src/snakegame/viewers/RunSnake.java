package snakegame.viewers;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class RunSnake extends GenericDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -647167119165272436L;
	
	
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
	TextJPanel namePanel = new TextJPanel("Name:");
	
	public RunSnake(){
		
		//Set labelName for txtPanels.
		widthPanel.setTxt(10);
		heightPanel.setTxt(10);
		
		
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
		this.setLayout(new GridLayout(4,0));
		this.add(snake);
		this.add(namePanel);
		this.add(dimensionsShelf);
		this.add(btnShelf);

		this.pack();
		
		
		startGameBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				new View(widthPanel.getTxt(), heightPanel.getTxt(), namePanel.getTxt());
=======
				new View(Integer.parseInt(widthPanel.getTxt()), Integer.parseInt(heightPanel.getTxt()));
>>>>>>> origin/master
				closeFrame();
			}
		});

				
	}
	
		
}
