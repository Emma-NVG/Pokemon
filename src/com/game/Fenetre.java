package com.game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	public static Scene scene;
	
	public Fenetre()
	{
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Jeu Pokemon");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(576,463);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		scene = new Scene();
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
	}
	
}
