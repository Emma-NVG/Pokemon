package com.map;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Map {
	private Tile[][] tilesMap;
	public static final int xMap = 25;
	public static final int yMap = 15;

	public Map() {
		tilesMap = new Tile[xMap][yMap]; // dimension en nb tile
	}

	// Getter
	public int getWidth() {
		return tilesMap.length;
	}

	public int getHeight() {
		return tilesMap[0].length;
	}

	public Tile getTile(int x, int y) {
		Tile tile;
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			return null;
		} else {
			return tile=tilesMap[x][y];
		}
	}

	// Setter
	public void setTile(int x, int y,Tile tile) {
		tilesMap[x][y] = tile;
	}

	// Méthodes
	public ArrayList<String> loadFile(String filename) throws IOException {
		// met les lignes (hors commentaires)du fichier dans un array
		int width = 0;
		ArrayList<String> listLinesFile = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		while (true) {
			String line = reader.readLine();

			if (line == null) {
				reader.close();
				break;
			}
			if (!line.startsWith("#")) {
				listLinesFile.add(line);
				width = Math.max(width, line.length());
			}
		}
		return listLinesFile;
	}

	public Map matriceToMap(ArrayList<String> listLinesFile) throws IOException {
		// parse chaque ligne pour avoir les tiles
		Map newMap = new Map();
		String lineCourante;
		char characterCourant;

		for (int y = 0; y < listLinesFile.size(); y++) {
			lineCourante = (String) listLinesFile.get(y);
			for (int x = 0; x < lineCourante.length(); x++) {
				characterCourant = lineCourante.charAt(x);
				newMap.setTile(x, y, new Tile(x,y,toImg(characterCourant),characterCourant));
			}
		}
		return newMap;
	}
	
	public int[][] matriceToCollision(ArrayList<String> listLinesFile){
		int[][] collisionTab=new int[xMap][yMap];
		String lineCourante;
		char characterCourant;

		for (int y = 0; y < listLinesFile.size(); y++) {
			lineCourante = (String) listLinesFile.get(y);
			for (int x = 0; x < lineCourante.length(); x++) {
				characterCourant = lineCourante.charAt(x);
				if((characterCourant!='A')&&(characterCourant!='B')) {
					collisionTab[x][y]=1;
				}else {
					collisionTab[x][y]=0;
				}
			}
		}
		return collisionTab;
	}
	
	public Image toImg(char tile) {
		ImageIcon tileIcon = new ImageIcon(getClass().getResource("/images/tileset/" + tile + ".png"));
		Image imgTile = tileIcon.getImage();
		return imgTile;
	}
}

