package snakegame.viewers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SmallButton extends JButton{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 823916396398596298L;

	public SmallButton(String text, PlayerPanel parentwindow){
		
		try {
			this.setIcon(new ImageIcon(getClass().getResource("images/smallBtn.jpg")));
		} catch (Exception e) {}
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setText(text);
		this.setBorder(null);
		this.setPreferredSize(getPreferredSize());
		
		
		this.addActionListener(new ActionListener() { 
		
		public void actionPerformed(ActionEvent e) {
			parentwindow.updatePlayers(getTxt());
		}
		
		});
		
	}
	
	public void setTxt(String text) {
		this.setText(text);
	}
	
	public int getTxt(){
		return Integer.parseInt(this.getText());
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(45,40);

		
	}
	
		
	
}
