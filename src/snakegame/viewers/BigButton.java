package snakegame.viewers;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BigButton extends JButton{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 823916396398596298L;

	public BigButton(String text){
		
		try {
			this.setIcon(new ImageIcon(getClass().getResource("images/bigBtn.jpg")));
		} catch (Exception e) {}
		
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setText(text);
		this.setPreferredSize(getPreferredSize());
		//this.setBorder(new LineBorder(new Color(167,160,108)));
		
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