package com.game;

public class Chrono implements Runnable {
	private final int PAUSE = 10;
	@Override
	public void run() {
		while(true) {
			Fenetre.scene.repaint();
			try {
				Thread.sleep(PAUSE);
			}catch(InterruptedException e) {}
		}
	}
}
