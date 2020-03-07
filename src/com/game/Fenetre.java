package com.game;

import java.io.IOException;
import javax.swing.JFrame;

import com.map.Map;
import com.map.Tile;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	public static Scene scene;
	
	public Fenetre() throws IOException{
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Jeu Pokemon");
		//fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setUndecorated(true);
		fenetre.setSize(Map.xMap*Tile.tileWidth,Map.yMap*Tile.tileHeight); //fenetre.setSize((Map.xMap*16)+15,(Map.yMap*16)+37);	// nombre tile*nombre pixels par tile (16 ici)
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		scene = new Scene();
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
	}
	
}
