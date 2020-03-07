package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Fenetre.scene.dresseur.setWalk(true);
			Fenetre.scene.dresseur.setToUp(false);
			Fenetre.scene.dresseur.setToDown(false);
			Fenetre.scene.dresseur.setToLeft(false);
			Fenetre.scene.dresseur.setToRight(true);
			Fenetre.scene.setDx(-1);
			Fenetre.scene.setDy(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Fenetre.scene.dresseur.setWalk(true);
			Fenetre.scene.dresseur.setToRight(false);
			Fenetre.scene.dresseur.setToUp(false);
			Fenetre.scene.dresseur.setToDown(false);
			Fenetre.scene.dresseur.setToLeft(true);
			Fenetre.scene.setDx(1);
			Fenetre.scene.setDy(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Fenetre.scene.dresseur.setWalk(true);
			Fenetre.scene.dresseur.setToRight(false);
			Fenetre.scene.dresseur.setToDown(false);
			Fenetre.scene.dresseur.setToLeft(false);
			Fenetre.scene.dresseur.setToUp(true);
			Fenetre.scene.setDy(1);
			Fenetre.scene.setDx(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Fenetre.scene.dresseur.setWalk(true);
			Fenetre.scene.dresseur.setToUp(false);
			Fenetre.scene.dresseur.setToRight(false);
			Fenetre.scene.dresseur.setToLeft(false);
			Fenetre.scene.dresseur.setToDown(true);
			Fenetre.scene.setDy(-1);
			Fenetre.scene.setDx(0);
		}
		if (e.getKeyChar() == 'x') {
			System.out.println("Exiting");
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Fenetre.scene.dresseur.setWalk(false);
		Fenetre.scene.setDx(0);
		Fenetre.scene.setDy(0);
	}
}
