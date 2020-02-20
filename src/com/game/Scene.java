package com.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.characters.Dresseur;

@SuppressWarnings("serial")
public class Scene extends JPanel{

		//private ImageIcon icoFond;
	   // private Image imgFond1;
	  
	    private int dx;
	    private int dy;
	    private int xDresseur;//position horizontale du joueur 
	    private int yDresseur; //position verticale du joueur
	    
	    public Dresseur dresseur; //instance de Dresseur qui représente le joueur
	    public Map map1; 
	    
	    public Scene() throws IOException{
	    	super();
	    	
	    	this.dx=0;
	    	this.dy=0;
	    	this.xDresseur= 290;
	    	this.yDresseur = 20;
	    	
	        /*icoFond = new ImageIcon(getClass().getResource("/images/winter_is_coming.png"));
	        this.imgFond1 = this.icoFond.getImage();*/
	        dresseur = new Dresseur(200,0);
	        
	        map1= new Map();
	        this.map1=map1.loadMap("C:\\Users\\Emma\\git\\Pokemon\\src\\com\\game\\map1.txt");
	        
	        this.setFocusable(true);
	        this.requestFocusInWindow();
	        this.addKeyListener(new Clavier()); //lien avec le clavier
	        Thread chronoEcran = new Thread(new Chrono()); //appel de la boucle permettant de réafficher les images
	        chronoEcran.start();
	    }

	    //Getters
		public int getDx() {
			return dx;
		}
		public int getDy() {
			return dy;
		}
		public int getxDresseur() {
			return xDresseur;
		}
		public int getyDresseur() {
			return yDresseur;
		}

		//Setters
		public void setDx(int dx) {
			this.dx = dx;
		}
		public void setDy(int dy) {
			this.dy = dy;
		}
		
		//Methodes
	    public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        Graphics g2 = (Graphics2D)g;
	        this.deplacementDresseur();
	        //g2.drawImage(this.imgFond1,0, 0, null);
	        //draw du tableau image
	        
	       int xOffset=-16;
	       int yOffset=-16;
	       for (int y=0;y<map1.getHeight();y++) {
	         	yOffset+=16;
	            xOffset=-16;
	         	for(int x=0;x<map1.getWidth();x++) {
	    			g2.drawImage(map1.getTile(x, y),xOffset, yOffset, null);
	    			xOffset+=16;
	  			}
	  		}
	        g2.drawImage(this.dresseur.walk("dresseur",25),this.xDresseur, this.yDresseur, null);
	       
	    } 
	    public void deplacementDresseur() {
	    	this.xDresseur = this.xDresseur - this.dx;
	    	this.yDresseur = this.yDresseur - this.dy;
	    }
	    

		


}

