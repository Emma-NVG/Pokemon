package com.game;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Map {
	private Image[][] tilesMap;
	public static final int xMap=25;
	public static final int yMap=15;
	 
	public Map() {
		 tilesMap = new Image[xMap][yMap]; //dimension en nb tile
	}
	 
	//Getter
	public int getWidth() {
			 return tilesMap.length; 
	}
	public int getHeight() {
			 return tilesMap[0].length;
	} 
	public Image getTile(int x, int y) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()){
			return null;
	    }
		else {
			return tilesMap[x][y];
		}
	}
		
	//Setter
	public void setTile(int x, int y, Image tile) {
		tilesMap[x][y] = tile;
	}
	
	//Méthodes
	public Map loadMap(String filename) throws IOException{

		ArrayList<String> listLinesFile = new ArrayList<String>();
		int width = 0;
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		//met les lignes (hors commentaires)du fichier dans un array
		while (true) {
			 String line = reader.readLine();
			
			 // sort du while quand il n'y a plus rien à lire et ferme le file
			 if (line == null) {
				 reader.close();
				 break;
			 }
			 // lit toutes les lignes sauf celles commençant par # (comment)
			 if (!line.startsWith("#")) {
				 listLinesFile.add(line); //ajoute la ligne lue à l'array
				 width = Math.max(width, line.length());
			 }
		 }
		
		//parse chaque ligne pour voir les tiles
		Map newMap = new Map();
		String lineTemp; //ligne courante
		char ch; //caractère courant
		
		for (int y=0; y<listLinesFile.size(); y++) {
			 lineTemp = (String)listLinesFile.get(y); //prends la ligne y de l'Array et on la stock dans line
			 for (int x=0; x<lineTemp.length(); x++) {
				 	ch = lineTemp.charAt(x); //dans la ligne lu on prends le caractère position x
				 	newMap.setTile(x, y, this.toImg(ch));
			 }
		 }
		return newMap;
	}		
	
	public Image toImg(char tile) {
		ImageIcon tileIcon = new ImageIcon(getClass().getResource("/images/tileset/"+tile+".png"));
	    Image imgTile = tileIcon.getImage();
	    return imgTile;
	}
	
}
