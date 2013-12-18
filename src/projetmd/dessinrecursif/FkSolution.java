package projetmd.dessinrecursif;

import java.awt.Graphics;

public class FkSolution extends AbstractSolution {

	private static final long serialVersionUID = 8609272255252772320L;

	public FkSolution(int profondeur) {
		super(profondeur);
	}

	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		int x = arg[0];
		int y = arg[1];
		int diameter = arg[2];
		int depth = arg[3];
		
		if(depth == 0){return;}

		drawingArea.drawOval(x, y, diameter, diameter);
		
		drawSolutionk(drawingArea, x + diameter, y + diameter/4, diameter/2, depth-1);	
		drawSolutionk(drawingArea, x + diameter/4, y + diameter, diameter/2, depth-1);
	}

}
