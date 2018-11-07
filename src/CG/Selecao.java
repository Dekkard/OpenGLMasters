package CG;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

import Demos.Picking;

public class Selecao{
	Selecao() {
		GLCapabilities capabilities = new GLCapabilities(null);
		GLCanvas drawable = new GLCanvas(capabilities);
		final Mouse mouse = new Mouse();
		final Animator animator = new Animator(drawable);
		animator.start();
	}
	static class Mouse implements MouseListener {
		static final int NOTHING = 0, UPDATE = 1, SELECT = 2;
		int cmd = UPDATE;
		public int click_x, click_y, move_x, move_y;

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			this.cmd = SELECT;
			click_x = e.getX();
			click_y = e.getY();
		}
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			move_x = e.getX();
			move_y = e.getY();
		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {}
		public void mouseWheelMoved(MouseEvent e) {}
	}
}
