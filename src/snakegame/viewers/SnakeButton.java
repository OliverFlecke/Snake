package snakegame.viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SnakeButton extends JButton{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 823916396398596298L;

	public SnakeButton(String text, PlayerPanel parentwindow){
		this.setText(text);
		
		
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


	
		
	
}
