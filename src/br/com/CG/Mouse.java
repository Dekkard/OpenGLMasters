package br.com.CG;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class Mouse implements MouseListener{
	static final int NOTHING = 0, UPDATE = 1, SELECT = 2;
	int cmd = UPDATE;
	public int click_x,click_y, move_x,move_y;
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		cmd = SELECT;
		click_x = e.getX();
		click_y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		move_x = e.getX();
		move_y = e.getY();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseWheelMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
