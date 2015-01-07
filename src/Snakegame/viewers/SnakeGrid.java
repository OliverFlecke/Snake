import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Point;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class SnakeGrid extends JPanel /*implements GameListener*/ {
	private Dimension gridSize;
	private ArrayList<Point> snakePos;


	public SnakeGrid(Dimension gridSize) {
		super();
		this.gridSize=gridSize;

		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(gridSize.height, gridSize.width, 1, 1));
		this.setPreferredSize(gridSize);

		snakePos = new ArrayList<Point>();
		snakePos.add(new Point(5,1));
		snakePos.add(new Point(5,2));
		snakePos.add(new Point(5,3));
		snakePos.add(new Point(5,4));


	}

	public SnakeGrid(int n, int m) {
		super();
		this.gridSize= new Dimension(n,m);

		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(gridSize.height, gridSize.width));
		this.setPreferredSize(gridSize);

		snakePos = new ArrayList<Point>();
		snakePos.add(new Point(5,1));
		snakePos.add(new Point(5,2));
		snakePos.add(new Point(5,3));
		snakePos.add(new Point(5,4));

}


	public void updateGrid(){
		this.repaint();
	}



    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawSnake(g2);

    }

	public void clearCanvas(Graphics g) {
		g.clearRect(0, 0, gridSize.width, gridSize.height);
	}

       	
	public void drawSnake(Graphics2D g2){
		    for (Point currentPos : snakePos){
	    	g2.fillRect(currentPos.x*20, currentPos.y*20, 20,20);
        }

	}
}