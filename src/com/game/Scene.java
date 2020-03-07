package com.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.swing.JPanel;

import com.characters.Dresseur;
import com.map.Map;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	private int dx;
	private int dy;

	public Dresseur dresseur;
	public Map map1;
	public int[][] collisionMap;

	public Scene() throws IOException {
		super();

		this.dx = 0;
		this.dy = 0;

		dresseur = new Dresseur(0, 0,16,26);
		map1 = new Map();
		this.map1 = map1.matriceToMap(map1.loadFile("C:\\Users\\Emma\\git\\Pokemon\\src\\com\\map\\map1.txt"));
		this.collisionMap=map1.matriceToCollision(map1.loadFile("C:\\Users\\Emma\\git\\Pokemon\\src\\com\\map\\map1.txt"));
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	// Getters
	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	
	// Setters
	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	// Methodes
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		dresseur.deplacementDresseur(map1,collisionMap);

		int xOffset;
		int yOffset = -16;
		for (int y = 0; y < map1.getHeight(); y++) {
			yOffset += 16;
			xOffset = 0;
			for (int x = 0; x < map1.getWidth(); x++) {
				g2.drawImage(map1.getTile(x, y).getImage(), xOffset, yOffset, null);
				xOffset += 16;
			}
		}
		g2.drawImage(this.dresseur.walkAnimation("dresseur", 25), dresseur.getxDresseur(), dresseur.getyDresseur(), null);
	}
}
