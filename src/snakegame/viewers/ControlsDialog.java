package snakegame.viewers;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Dialog for displaying keyboard controls for the four players
 */
public class ControlsDialog extends GenericDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7084455701007894071L;

	/**
	 * Constructor for the controls dialog
	 */
	public ControlsDialog() {
		super("Controls");
		// Change background
		try {
			background.setIcon(new ImageIcon(GenericDialog.class.getResource("images/snakeControlsBG.jpg")));
		} catch (Exception e) { 
			//e.printStackTrace();
		}
        
        //Set close operation to only dispose of the current window
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Resize window
        this.setPreferredSize(getPreferredSize());
		this.pack();
	}
	
	/**
	 * Override the preferred size of the dialog
	 * @return dimension of the dialog
	 */
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(435, 425);
	}
}