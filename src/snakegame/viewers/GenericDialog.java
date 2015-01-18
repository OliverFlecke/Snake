package snakegame.viewers;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Dialog define default information about our snake frames. 
 */
public class GenericDialog extends JFrame{

	private static final long serialVersionUID = 7708768979344316720L;
	
	// Label for the background
	protected JLabel background;

	/**
	 * Constructor for the general dialog for the snake view. 
	 * @param text to the menu bar
	 */
	public GenericDialog(String text){
		super(text);		// Sets the text of the menubar 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		} catch (Exception e) {	}
		this.setPreferredSize(getPreferredSize());
		this.setResizable(false);
		
		//Adding a background
		try {
			background = (new JLabel(new ImageIcon(getClass().getResource("images/snakeMenuBG.jpg"))));
			this.add(background);
		} catch (Exception e) { }
        
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
			
	/**
	 * Defines what happens when the frame is closed
	 */
	protected void closeFrame(){
		this.dispose();
	}
	
	/**
	 * Override the preferred size
	 */
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(450, 429);
	}
}