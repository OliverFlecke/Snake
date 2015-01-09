package snakegame.viewers;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GenericDialog extends JFrame{

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7708768979344316720L;
	protected JLabel background;
	


	public GenericDialog(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setIconImage(new ImageIcon("images\\icon.png").getImage());
		this.setPreferredSize(getPreferredSize());
		this.setResizable(false);
		
		
		//Adding a background
        background=new JLabel(new ImageIcon(GenericDialog.class.getResource("images\\snakeMenuBG.jpg")));
        this.add(background);
        
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
		
	
		
	protected void closeFrame(){
		this.dispose();
		
	}
		

	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(450, 275);

		
	}
}
