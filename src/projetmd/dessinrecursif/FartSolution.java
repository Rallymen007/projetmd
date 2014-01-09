package projetmd.dessinrecursif;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.RoundRectangle2D;

public class FartSolution extends AbstractSolution {
	private static final long serialVersionUID = 2843902737032060770L;

	public FartSolution(int profondeur) {
		super(profondeur);
	}

	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		int x = arg[0];
		int y = arg[1];
		int circleRadius = arg[2];
		int depth = arg[3];
		int movement = 40;
		int off1 = 15;
		int off2 = 20;
		Graphics2D g2d = (Graphics2D) drawingArea;
		
		if(arg.length >= 5){
			movement = arg[4];
		}
		
		if(depth == 0){
			g2d.fill(new RoundRectangle2D.Double(x-2, y-2, 4, 4, 1, 1));
			return;
		}
		
		if(circleRadius > 0){
			g2d.setColor(new Color(0x44, 0, 0));
			//g2d.setColor(new Color(0xFF, 0xE0, 0xC4));
			g2d.fillOval(x-(circleRadius/2), y, circleRadius, circleRadius);
		}
		
		int oldx = x, oldy = y;
		x=x+movement;
		y=y+movement;
		
		g2d.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
		g2d.draw(new CubicCurve2D.Double(oldx, oldy, x+off1, y, x+movement, y+movement-off2, x, y));
		
		//DR
		drawSolutionk(drawingArea, x, y, 0, depth-1, movement);
		
	}

}
