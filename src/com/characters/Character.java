package com.characters;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Character {
	private boolean walk; //vrai quand le personnage marche
	private boolean toRight; //vrai quand le personnage est tourné vers la droite
	private boolean toUp; //vrai quand le personnage est tourné vers le haut
	private boolean toDown;
	private boolean toLeft;
	
	private int x, y; //position du personnage
	public int compteur;
	
	public Character(int x, int y) {
		this.x = x;
		this.y = y;
		this.walk = false;
		this.toRight = false;
		this.toLeft = false;
		this.toUp = false;
		this.toDown = true;
		this.compteur =0;
	}
	
	
	//Getters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
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
	
	
	//Setters
	public int setX(int x) {
		return this.x = x;
	}
	public int setY(int y) {
		return this.y = y;
	}
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
	
	public Image walk(String nom, int frequence) {
		String stg;
		ImageIcon icon;
		Image img;
		
		//personnage à l'arrêt ou bord de fenetre
		if (this.walk==false) {
			if (this.toRight) {stg = "/images/marcheCotedroit.png";}
			else if(this.toUp) {stg = "/images/marcheDos.png";}
			else if(this.toDown) {stg = "/images/marcheFace.png";}
			else {stg = "/images/marcheCotegauche.png";}
		}
		//personnage en mouvement
		else {
			this.compteur++;
			//à l'arrêt quand compteur encore trop petit
			if(this.compteur / frequence == 0) {
				if(this.toRight) {stg = "/images/marcheCotedroit.png";}
				else if(this.toUp) {stg = "/images/marcheDos.png";}
				else if(this.toDown) {stg = "/images/marcheFace.png";}
				else {stg = "/images/marcheCotegauche.png";}
			}
			//marche quand compteur assez grand
			else {
				if(this.toRight) {stg = "/images/marchedroitCotedroit.png";}
				else if(this.toUp) {stg = "/images/marchedroitDos.png";}
				else if(this.toLeft) {stg = "/images/marchedroitCotegauche.png";}
				else if(this.toDown) {stg = "/images/marchedroiteFace.png";}
				else {stg = "/images/marcheDos.png";}
			}
			if(this.compteur == 2*frequence) {this.compteur =0;}
		}
		//Affiche le personnage
		icon = new ImageIcon(getClass().getResource(stg));
		img = icon.getImage();
		return img;
	}
}
