package br.com.CG;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Frame implements GLEventListener {

	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glBegin(GL2.GL_POLYGON );// static field
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glVertex3f(0.50f, -0.50f, 0);
		gl.glVertex3f(-0.50f, 0.50f, 0);
		gl.glVertex3f(-0.50f, -0.50f, 0);
		gl.glEnd();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
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
	
	public static GLCanvas drawCanvas() {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Frame b = new Frame();
		glcanvas.addGLEventListener(b);
		
//		glcanvas.setSize(400, 400);
//		
//		JPanel panel = new JPanel();
//		
//		panel.add(glcanvas);
//		panel.setSize(panel.getPreferredSize());
//		panel.setVisible(true);
		
		return glcanvas;
	}
}
