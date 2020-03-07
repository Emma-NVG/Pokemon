package com.characters;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import com.game.Fenetre;
import com.map.Map;


public class Character {
	private boolean walk; //vrai quand le personnage marche
	private boolean toRight; //vrai quand le personnage est tourné vers la droite
	private boolean toUp; //vrai quand le personnage est tourné vers le haut
	private boolean toDown;
	private boolean toLeft;
	
	private int xDresseur;
	private int yDresseur;
	protected int width;
	protected int height;
	public int compteur;
	
	public Character(int xDresseur, int yDresseur,int width, int height) {
		this.xDresseur = xDresseur;
		this.yDresseur = xDresseur;
		this.width=width;
		this.height=height;
		this.walk = false;
		this.toRight = false;
		this.toLeft = false;
		this.toUp = false;
		this.toDown = true;
		this.compteur =0;
	}
	
	
	//Getters
	public boolean getWalk() {
		return walk;
	}
	public boolean getToRight() {
		return toRight;
	}
	public boolean getToLeft() {
		return toLeft;
	}
	public boolean getToUp() {
		return toUp;
	}
	public boolean getToDown() {
		return toDown;
	}
	public Rectangle getBounds() {
		return new Rectangle(xDresseur,yDresseur,width,height);
	}
	public int getxDresseur() {
		return xDresseur;
	}

	public int getyDresseur() {
		return yDresseur;
	}

	
	//Setters
	public void setWalk(boolean walk) {
		this.walk = walk;
	}
	public void setToRight(boolean toRight) {
		this.toRight = toRight;
	}
	public void setToLeft(boolean toLeft) {
		this.toLeft = toLeft;
	}
	public void setToUp(boolean toUp) {
		this.toUp = toUp;
	}
	public void setToDown(boolean toDown) {
		this.toDown = toDown;
	}
	public int setxDresseur(int xDresseur) {
		return this.xDresseur = xDresseur;
	}
	public int setyDresseur(int yDresseur) {
		return this.yDresseur = yDresseur;
	}
	
	public Image walkAnimation(String nom, int frequence) {
		String stg;
		ImageIcon icon;
		Image img;
		
		//personnage à l'arrêt
		this.compteur++;
		if ((this.walk==false)||((this.walk)&&(this.compteur / frequence == 0))) {
			if (this.toRight) {stg = "/images/marcheCotedroit.png";}
			else if(this.toUp) {stg = "/images/marcheDos.png";}
			else if(this.toDown) {stg = "/images/marcheFace.png";}
			else {stg = "/images/marcheCotegauche.png";}
		}
		//personnage en mouvement
		else {
			if(this.toRight) {stg = "/images/marchedroitCotedroit.png";}
			else if(this.toUp) {stg = "/images/marchedroitDos.png";}
			else if(this.toLeft) {stg = "/images/marchedroitCotegauche.png";}
			else if(this.toDown) {stg = "/images/marchedroiteFace.png";}
			else {stg = "/images/marcheDos.png";}
		}
		if(this.compteur == 2*frequence) {this.compteur =0;}
				
		icon = new ImageIcon(getClass().getResource(stg));
		img = icon.getImage();
		return img;
	}
	
	public void deplacementDresseur(Map map1,int[][] collisionMap) {
		
		this.xDresseur = this.xDresseur - Fenetre.scene.getDx();
    	this.yDresseur = this.yDresseur - Fenetre.scene.getDy();
    	
		if (xDresseur < 0) xDresseur=0;
		else if (yDresseur < 0) yDresseur=0;
		else if (xDresseur > 382) xDresseur=382;
		else if (yDresseur > 214) yDresseur=214;
		else {
			collision(map1,collisionMap);
		}
	}


	public void collision(Map map1,int[][] collisionMap) {
		if (getWalk()) {
			if (getToRight()) {
				int rightTiles=(getxDresseur()+16)/16;
				int i=0;
				while(i<1) {
					int y=((getyDresseur()+16)+i*16)/16;
					if (collisionMap[rightTiles][y]==1) { setxDresseur(getxDresseur() + Fenetre.scene.getDx()); }
					i++;
				}
			}else if(getToLeft()) {
				int leftTiles=(getxDresseur()/16);
				int i=0;
				while(i<1) {
					int y=((getyDresseur()+16)+i*16)/16;
					if (collisionMap[leftTiles][y]==1) { setxDresseur(getxDresseur() + Fenetre.scene.getDx()); }
					i++;
				}
			}else if(getToUp()) {
				int upTiles=(getyDresseur()+16)/16;
				int i=0;
				while(i<2) {
					int x=(getxDresseur()+i*16)/16;
					if (collisionMap[x][upTiles]==1) { setyDresseur(getyDresseur() + Fenetre.scene.getDy()); }
					i++;
				}
			}else if (getToDown()){
				int downTiles=(getyDresseur()+24)/16;
				int i=0;
				while(i<2) {
					int x=(getxDresseur()+i*16)/16;
					if (collisionMap[x][downTiles]==1) { setyDresseur(getyDresseur() + Fenetre.scene.getDy()); }
					i++;
				}
			}else{
			}
		}
	}
}
