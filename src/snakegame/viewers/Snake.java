package snakegame.viewers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Snake extends GenericDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -647167119165272436L;
	
	
	//Create the buttons
	JButton startGameBtn = new JButton("Start Game");
	
	//Make JLabel
	JLabel snake = new JLabel("SNAKE");
	
	//Make a JPanel to hold the btns and the labels
	JPanel btnShelf = new JPanel();
	JPanel dimensionsShelf = new JPanel();
	
	//Make two textJpanels
	TextJPanel widthPanel = new TextJPanel();
	TextJPanel heightPanel = new TextJPanel();
	
	public Snake(){
		
		//Set labelName for txtPanels.
		widthPanel.setLblName("Width:");
		heightPanel.setLblName("Height:");
		widthPanel.setTxt(10);
		heightPanel.setTxt(10);
		
		
		//Adding btns and labels to shelf
		btnShelf.add(startGameBtn);
		
		
		
		
		//setting up the dimensionsShelf
		dimensionsShelf.setLayout(new FlowLayout());
		dimensionsShelf.add(widthPanel);
		dimensionsShelf.add(heightPanel);
		this.getContentPane().add(dimensionsShelf, BorderLayout.CENTER);
		
		//setting up Label and btn
		this.getContentPane().add(snake, BorderLayout.NORTH);
		this.getContentPane().add(btnShelf, BorderLayout.SOUTH);
		
		this.pack();
		
		
		startGameBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				View view = new View(widthPanel.getTxt(), heightPanel.getTxt());
				closeFrame();
			}
		});

				
	}
	
		
}
