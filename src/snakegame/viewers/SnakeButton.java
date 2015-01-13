package snakegame.viewers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SnakeButton extends JButton{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 823916396398596298L;

	public SnakeButton(String text, PlayerPanel parentwindow){
		
		
		this.setIcon(new ImageIcon(SnakeButton.class.getResource("images\\smallBtn.jpg")));
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setText(text);
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
