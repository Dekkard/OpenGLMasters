package CG;

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

@SuppressWarnings("all")
public class Frame implements GLEventListener {
	static public List<String> lista;
	public static Float X, Y;
	public String name;
	public static Float[] Colors;

	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	}

	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
	}

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
		
		Frame b1 = Frame.drawEvent(FileHandling.Load("form4.txt"), -0.2f, 0.2f, 1.0f, 0.0f, 0.0f);
		glcanvas.addGLEventListener(b1);
		glcanvas.display();
		Frame b2 = Frame.drawEvent(FileHandling.Load("form4.txt"), 0.2f, 0.0f, 0.0f, 1.0f, 0.0f);
		glcanvas.addGLEventListener(b2);
		glcanvas.display();
	}

	public static Frame drawEvent(List<String> forma, float x, float y, float c_r, float c_g, float c_b) {
		lista = forma;
		X = x;
		Y = y;
		Float[] color = { c_r, c_g, c_b };
		Colors = color;
		return new Frame();
	}

}
