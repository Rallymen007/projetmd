package projetmd.dessinrecursif;

import java.awt.Graphics;

public class F2kSolution extends AbstractSolution {
	private static final long serialVersionUID = 2843902737032060770L;
	
	private static final int DRAW_UP = 1;
	private static final int DRAW_DOWN = 2;
	private static final int DRAW_LEFT = 4;
	private static final int DRAW_RIGHT = 8;
	
	private static final int DRAW_ULR = 13;
	private static final int DRAW_DLR = 14;
	private static final int DRAW_LUD = 7;
	private static final int DRAW_RUD = 11;
	private static final int DRAW_ALL = 15;

	public F2kSolution(int profondeur) {
		super(profondeur);
	}

	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		int diameter = arg[2];
		int x = arg[0];
		int y = arg[1];
		int depth = arg[3];
		int toDraw = DRAW_ALL;
		
		if(arg.length == 5){
			toDraw = arg[4];
		}
		
		if(depth == 0){return;}

		drawingArea.drawOval(x - diameter/2, y - diameter/2, diameter, diameter);
		
		if((toDraw & DRAW_UP) != 0){
			drawSolutionk(drawingArea, x, y - 3*diameter/4, diameter/2, depth-1, DRAW_ULR);
		}
		if((toDraw & DRAW_DOWN) != 0){
			drawSolutionk(drawingArea, x, y + 3*diameter/4, diameter/2, depth-1, DRAW_DLR);
		}
		if((toDraw & DRAW_LEFT) != 0){
			drawSolutionk(drawingArea, x - 3*diameter/4, y, diameter/2, depth-1, DRAW_LUD);
		}
		if((toDraw & DRAW_RIGHT) != 0){
			drawSolutionk(drawingArea, x + 3*diameter/4, y, diameter/2, depth-1, DRAW_RUD);
		}
	}

}
