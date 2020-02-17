package com.characters;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Dresseur extends Character {
	 private ImageIcon icoDresseur;
	  private Image imgDresseur;
	  
	public Dresseur(int x, int y) {
		super(x, y);
		this.icoDresseur = new ImageIcon(getClass().getResource("/images/marcheFace.png"));
        this.imgDresseur = this.icoDresseur.getImage();
	}
	
	public Image getImgDresseur(){
		return imgDresseur;
	}
}
