package snakegame.viewers;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class to represent a large button
 */
public class BigButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 823916396398596298L;

	/**
	 * Constructor. Sets the default text on the button
	 * @param text to display on the button
	 */
	public BigButton(String text){
		// Set the icon of the button
		try {
			this.setIcon(new ImageIcon(getClass().getResource("images/bigBtn.jpg")));
		} catch (Exception e) {}
		
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setText(text);
		this.setPreferredSize(getPreferredSize());
		
	}
	
	public void setTxt(String text) {
		this.setText(text);
	}
	
	public int getTxt(){
		return Integer.parseInt(this.getText());
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(100,30);
	}
}