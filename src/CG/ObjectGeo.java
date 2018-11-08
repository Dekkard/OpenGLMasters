package CG;

import java.awt.Component;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;

import OP.Operation;

@SuppressWarnings("all")
public class ObjectGeo extends GLJPanel implements GLEventListener, KeyListener , MouseListener {
	static public List<String> lista;
	public static Float X, Y;
	public String name;
	public static Float[] Colors;
	public static byte escolha;

	public void init(GLAutoDrawable drawable) {
	}
	public void dispose(GLAutoDrawable drawable) {}
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POLYGON);// static field
		gl.glColor3f(Colors[0], Colors[1], Colors[2]);
		Iterator<String> it = lista.iterator();
		name = it.next();
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			String ver3 = it.next();
			gl.glVertex3f(Float.parseFloat(ver1) + X, Float.parseFloat(ver2) + Y, Float.parseFloat(ver3));
		}
		gl.glEnd();
	}

	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyPressed(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}

	
	static final int NOTHING = 0, UPDATE = 1, SELECT = 2;
	int cmd = UPDATE;
	public float mouse_x, mouse_y;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.cmd = SELECT;
		mouse_x = Float.intBitsToFloat(e.getX());
		mouse_y = Float.intBitsToFloat(e.getY());
		System.out.println("mouse: " + mouse_x + "," + mouse_y);
		double closest = 1.0f;
		String closestName = null;
		Iterator<String> it = lista.iterator();
		double medX = 0.0;
		double medY = 0.0;
		int cnt = 0;
		String name = it.next();
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			String ver3 = it.next();
			medX += (double) Float.parseFloat(ver1);
			medY += (double) Float.parseFloat(ver2);
			cnt++;
		}
//			System.out.println("média:(" + medX + "," + medY+")  ->"+cnt);
		medX = medX / cnt;
		medY = medY / cnt;
//			System.out.println("média:(" + medX + "," + medY+")");
		double dst = Math.sqrt(
				Math.pow((Math.abs((float) medX - mouse_x)), 2.0) + Math.pow((Math.abs((float) medY - mouse_y)), 2.0));
//			System.out.println("Dist: "+dst);
		if (closest <= dst) {
			closest = dst;
			closestName = name;
		}
		System.out.println(closestName);
	}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	
	
	
	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		glcanvas.setSize(400, 400);

		// creating frame
		final JFrame frame = new JFrame("Basic Frame");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);
		
		ObjectGeo b2 = ObjectGeo.drawEvent(FileHandling.Load("form3.txt"), 0.2f, 0.0f, 0.0f, 0.0f, 1.0f);
		glcanvas.addGLEventListener(b2);
		glcanvas.display();
		
		ObjectGeo b1 = ObjectGeo.drawEvent(FileHandling.Load("form4.txt"), -0.2f, 0.2f, 1.0f, 0.0f, 1.0f);
		glcanvas.addGLEventListener(b1);
		glcanvas.display();

		glcanvas.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_R:
					reshape (glcanvas, 1);
					System.out.println("Tecla Verm.");
					break;
				case KeyEvent.VK_G:
					reshape (glcanvas, 2);
					System.out.println("Tecla Verd.");
					break;
				case KeyEvent.VK_B:
					reshape (glcanvas, 3);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_PAGE_UP:
					reshape(glcanvas,4);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_PAGE_DOWN:
					reshape(glcanvas,5);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_UP:
					reshape(glcanvas,6);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_LEFT:
					reshape(glcanvas,7);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_RIGHT:
					reshape(glcanvas,8);
					System.out.println("Tecla Azulis");
					break;
				case KeyEvent.VK_DOWN:
					reshape(glcanvas,9);
					System.out.println("Tecla Azulis");
					break;
				default:
				}
			}
		});
		glcanvas.addMouseListener(new MouseListener() {
			static final int NOTHING = 0, UPDATE = 1, SELECT = 2;
			int cmd = UPDATE;
			public float mouse_x, mouse_y;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				this.cmd = SELECT;
				mouse_x = Float.intBitsToFloat(e.getX()) / Float.intBitsToFloat(glcanvas.getWidth());
				mouse_y = Float.intBitsToFloat(e.getY()) / Float.intBitsToFloat(glcanvas.getHeight());
//				System.out.println("mouse: " + mouse_x + "," + mouse_y);
				double closest = 1.0f;
				String closestName = null;
				for (int i = 0; i < glcanvas.getGLEventListenerCount(); i++) {
					ObjectGeo obj = (ObjectGeo) glcanvas.getGLEventListener(i);
					
					System.out.println(i+":"+obj.lista.iterator().next());
					Iterator<String> it = obj.lista.iterator();
					double medX = 0.0;
					double medY = 0.0;
					int cnt = 0;
					String name = it.next();
					while (it.hasNext()) {
						String ver1 = it.next();
						String ver2 = it.next();
						String ver3 = it.next();
						medX += (double)Float.parseFloat(ver1);
						medY += (double)Float.parseFloat(ver2);
						cnt++;
					}
//					System.out.println("média:(" + medX + "," + medY+")  ->"+cnt);
					medX = medX/cnt;
					medY = medY/cnt;
//					System.out.println("média:(" + medX + "," + medY+")");
					double dst = Math.sqrt(
							Math.pow((Math.abs((float)medX - mouse_x)), 2.0) 
							+ Math.pow((Math.abs((float)medY - mouse_y)), 2.0));
//					System.out.println("Dist: "+dst);
					if (closest <= dst) {
						closest = dst;
						closestName = name;
					}
				}
				System.out.println(closestName);
			}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseReleased(MouseEvent e) {}
		});
	}

	public static void reshape(GLCanvas glcanvas, int flag) {
		
		if (flag == 1) {
			Colors[0] = 1.0f;
			Colors[1] = Colors[2] = 0.0f;
		}
		if (flag == 2) {
			Colors[0] = Colors[2] = 0.0f;
			Colors[1] = 1.0f;
		}
		if (flag == 3) {
			Colors[0] = Colors[1] = 0.0f;
			Colors[2] = 1.0f;
		}
		if (flag == 4) {
//			Operation.rotate();
		}
		if (flag == 5) {
		}
		if (flag == 6) {
		}
		if (flag == 7) {
		}
		if (flag == 8) {
		}
		if (flag == 9) {
		}
		
		glcanvas.repaint();
	}

	public static ObjectGeo drawEvent(List<String> forma, float x, float y, float c_r, float c_g, float c_b) {
		lista = forma;
		X = x;
		Y = y;
		Float[] color = { c_r, c_g, c_b };
		Colors = color;
		return new ObjectGeo();
	}
}