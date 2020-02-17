package com.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.characters.Dresseur;

@SuppressWarnings("serial")
public class Scene extends JPanel{

		private ImageIcon icoFond;
	    private Image imgFond1;
	  
	    private int dx;
	    private int dy;
	    private int xDresseur;//position horizontale du joueur 
	    private int yDresseur; //position verticale du joueur
	    
	    public Dresseur dresseur; //instance de Dresseur qui représente le joueur

	    public Scene(){
	    	super();
	    	
	    	this.dx=0;
	    	this.dy=0;
	    	this.xDresseur= 290;
	    	this.yDresseur = 20;
	    	
	        icoFond = new ImageIcon(getClass().getResource("/images/bourd_palette.png"));
	        this.imgFond1 = this.icoFond.getImage();
	        dresseur = new Dresseur(200,0);
	        
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
	        g2.drawImage(this.imgFond1,0, 0, null);
	        //g2.drawImage(this.dresseur.getImgDresseur(),this.xDresseur, this.yDresseur, null);
	        g2.drawImage(this.dresseur.walk("dresseur",25),this.xDresseur, this.yDresseur, null);
	    } 
	    public void deplacementDresseur() {
	    	this.xDresseur = this.xDresseur - this.dx;
	    	this.yDresseur = this.yDresseur - this.dy;
	    }

		


}

