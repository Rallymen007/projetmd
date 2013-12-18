package projetmd.dessinrecursif;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class AbstractSolution extends Frame {
	private static final long serialVersionUID = -2485987969579948950L;
	protected static final int WIDTH = 600;
	protected static final int HEIGHT = 600;
	protected int profondeur;

	public AbstractSolution(int profondeur) {
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBackground (Color.white);
		this.profondeur=profondeur;
		addWindowListener(new WindowHandler());
		setTitle("Dessins recursifs au niveau : "+profondeur);
	}

	private class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {System.exit(0);}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		int frameHeight = getSize().height;
		int frameWidth = getSize().width;   
		g2d.setColor(Color.black);
		
		drawSolutionk(g2d, frameWidth/10, frameHeight/10, frameWidth/3, profondeur);
	}

	/** drawSolutionk 
	 *  Produit un dessin recursif
	 * Parametres: 
	 *    Graphics drawingArea : L'objet graphique dans lequel on dessine
	 *    int ... arg : les coordonnées, longueur et autres si besoin, et profondeur de récursivité
	 **/ 
	public abstract void drawSolutionk(Graphics drawingArea, int ... arg) ;

}

