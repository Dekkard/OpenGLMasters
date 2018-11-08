package CG;

import java.nio.IntBuffer;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;


public class Selecao implements MouseListener{
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
	
	public static void processHits(int hits, IntBuffer buffer) {
		System.out.println("---------------------------------");
		System.out.println(" HITS: " + hits);
		int offset = 0;
		int names;
		float z1, z2;
		for (int i = 0; i < hits; i++) {
			System.out.println("- - - - - - - - - - - -");
			System.out.println(" hit: " + (i + 1));
			names = buffer.get(offset);
			offset++;
			z1 = (float) (buffer.get(offset) & 0xffffffffL) / 0x7fffffff;
			offset++;
			z2 = (float) (buffer.get(offset) & 0xffffffffL) / 0x7fffffff;
			offset++;
			System.out.println(" number of names: " + names);
			System.out.println(" z1: " + z1);
			System.out.println(" z2: " + z2);
			System.out.println(" names: ");

			for (int j = 0; j < names; j++) {
				System.out.print("       " + buffer.get(offset));
				if (j == (names - 1))
					System.out.println("<-");
				else
					System.out.println();
				offset++;
			}
			System.out.println("- - - - - - - - - - - -");
		}
		System.out.println("---------------------------------");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseWheelMoved(MouseEvent e) {}
}