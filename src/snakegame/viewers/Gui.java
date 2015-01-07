
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;


public class Gui extends JFrame{

	private SnakeGrid snakeGrid;


public Gui(){
	super();

	this.snakeGrid = new SnakeGrid(500, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setIconImage(new ImageIcon("icon.png").getImage());
	this.getContentPane().add(snakeGrid, BorderLayout.CENTER);
	this.setLocationRelativeTo(null);
	this.pack();
	this.setVisible(true);

	}
}