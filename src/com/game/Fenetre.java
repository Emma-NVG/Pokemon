package com.game;

import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	public static Scene scene;
	
	public Fenetre() throws IOException
	{
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Jeu Pokemon");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(Map.xMap*16,Map.yMap*16);	// nombre tile*nombre pixels par tile (16 ici)
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		scene = new Scene();
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
	}
	
}
