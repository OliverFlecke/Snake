package snakegame.viewers;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GenericDialog extends JFrame{

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7708768979344316720L;



	public GenericDialog(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.setPreferredSize(getPreferredSize());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
		
	
		
	protected void closeFrame(){
		this.dispose();
		
	}
		

	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(300, 150);

		
	}
}
