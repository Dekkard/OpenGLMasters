package CG;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;

@SuppressWarnings("all")
public class ObjectGeo extends GLJPanel implements GLEventListener, KeyListener {
	static public List<String> lista;
	public static Float X, Y;
	public String name;
	public static Float[] Colors;
	public static byte escolha;

	public void init(GLAutoDrawable drawable) {}
	public void dispose(GLAutoDrawable drawable) {}
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POLYGON);// static field
		gl.glColor3f(Colors[0], Colors[1], Colors[2]);
		Iterator<String> it = lista.iterator();
		name = it.next();
		System.out.println(name);
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
		ObjectGeo b1 = ObjectGeo.drawEvent(FileHandling.Load("form4.txt"), -0.2f, 0.2f, 1.0f, 0.0f, 1.0f);
		glcanvas.addGLEventListener(b1);
		glcanvas.display();
		ObjectGeo b2 = ObjectGeo.drawEvent(FileHandling.Load("form4.txt"), 0.2f, 0.0f, 0.0f, 0.0f, 1.0f);
		glcanvas.addGLEventListener(b2);
		glcanvas.display();

		glcanvas.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_PAGE_UP:
				case KeyEvent.VK_PAGE_DOWN:
				case KeyEvent.VK_UP:
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_R:
					changeColor(b2, 1.0f, 0.0f, 0.0f, glcanvas);
					System.out.println("Tecla Verm.");
					break;
				case KeyEvent.VK_G:
					changeColor(b2, 0.0f, 1.0f, 0.0f, glcanvas);
					System.out.println("Tecla Verd.");
					break;
				case KeyEvent.VK_B:
					changeColor(b2, 0.0f, 0.0f, 1.0f, glcanvas);
					System.out.println("Tecla Azulis");
					break;
				default:
				}
			}
		});
	}

	public static void changeColor(ObjectGeo b2, float r, float g, float b, GLCanvas glcanvas) {
		b2 = ObjectGeo.drawEvent(FileHandling.Load("form4.txt"), 0.4f, 0.0f, r, g, b);
		glcanvas.display();
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