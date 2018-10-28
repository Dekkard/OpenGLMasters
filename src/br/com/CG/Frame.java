package br.com.CG;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import br.com.Thready.Data;
import br.com.Thready.Load;

public class Frame implements GLEventListener {
	static public List<String> lista;

	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	public void display(GLAutoDrawable drawable) {
//		BlockingQueue<Data> msg = new ArrayBlockingQueue<Data>(1);
//		Read ready = new Read(msg);
//		ready.start();
		
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POLYGON);// static field

		gl.glColor3f(1.0f, 0.0f, 0.0f);
		
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			String ver3 = it.next();
			gl.glVertex3f(Float.parseFloat(ver1), Float.parseFloat(ver2), Float.parseFloat(ver3));
		}

//		gl.glVertex3f(0.50f, -0.50f, 0);
//		gl.glVertex3f(-0.50f, 0.50f, 0);
//		gl.glVertex3f(-0.50f, -0.50f, 0);
		gl.glEnd();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		BlockingQueue<Data> msg = new ArrayBlockingQueue<Data>(1);
		Load loady = new Load(msg, "triangulo.txt");
		loady.run();
		lista = loady.lista;
		// getting the capabilities object of GL2 profile
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Frame b = new Frame();
		glcanvas.addGLEventListener(b);
		glcanvas.setSize(400, 400);

		// creating frame
		final JFrame frame = new JFrame("Basic Frame");

		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);
	}

	public static GLCanvas drawCanvas(String forma) {
		BlockingQueue<Data> msg = new ArrayBlockingQueue<Data>(1);
		Load loady = new Load(msg, forma);
		loady.run();
		lista = loady.lista;
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Frame b = new Frame();
		glcanvas.addGLEventListener(b);

		return glcanvas;
	}
}
