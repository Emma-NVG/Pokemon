package com.map;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Tile {
	public static final int tileWidth =16;
	public static final int tileHeight=16;
	private Image tileImage;
	private int xTile;
	private int yTile;
	private char tile;
	
	public Tile(int xTile, int yTile, Image tileImage,char tile) {
		this.tileImage = tileImage;
		this.xTile = xTile;
		this.yTile = yTile;
		this.tile=tile;
	}
	
	public char getCharTile() {
		return tile;
	}
	public Image getImage() {
		return tileImage;
	}
	
	
	public Rectangle getTileBounds() {
		return new Rectangle(xTile,yTile,tileWidth,tileHeight);
	}
	public Image toImg(char tile) {
		ImageIcon tileIcon = new ImageIcon(getClass().getResource("/images/tileset/" + tile + ".png"));
		Image imgTile = tileIcon.getImage();
		return imgTile;
	}
	
	
}
