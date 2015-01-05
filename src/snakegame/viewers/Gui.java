package snakegame.viewers;

import java.awt.*;
import javax.swing.*;

public class Gui {

	public static void createAndShowGui(){
		//Create and set up the window.
		JFrame main = new JFrame("Snake");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel emptyLabel = new JLabel("");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		main.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		
		main.setIconImage(new ImageIcon("icon.png").getImage());

		//Display the window.
		main.pack();
		main.setVisible(true);
	}

}
