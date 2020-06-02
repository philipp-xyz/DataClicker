package main.dataclicker.minigames.DataPONG;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_W) {
			Variables.moveUp = true;
			
		}else if(e.getKeyCode()== KeyEvent.VK_S) {
			Variables.moveDown = true;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			Variables.moveUpopponent = true;
		}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			Variables.moveDownopponent = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()== KeyEvent.VK_W) {
			Variables.moveUp = false;
		}else if(e.getKeyCode()== KeyEvent.VK_S) {
			Variables.moveDown = false;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			Variables.moveUpopponent = false;
		}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			Variables.moveDownopponent = false;
		}
	}

}
