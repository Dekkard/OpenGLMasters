package CG;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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
	static public List<String> listaOrigem;
	static public List<String> listaAtual;
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
		List<String> lista = new ArrayList<>();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_POLYGON);// static field
		gl.glColor3f(Colors[0], Colors[1], Colors[2]);
		Iterator<String> it = listaOrigem.iterator();
		name = it.next();
		lista.add(name);
		while (it.hasNext()) {
			float ver1 = Float.parseFloat(it.next());
			float ver2 = Float.parseFloat(it.next());
			gl.glVertex2f(ver1 + X, ver2 + Y);
			lista.add(String.valueOf(ver1 + X));
			lista.add(String.valueOf(ver2 + Y));
		}
		listaAtual = lista;
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
		Iterator<String> it = listaOrigem.iterator();
		double medX = 0.0;
		double medY = 0.0;
		int cnt = 0;
		String name = it.next();
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			medX += (double) Float.parseFloat(ver1);
			medY += (double) Float.parseFloat(ver2);
			cnt++;
		}
//			System.out.println("m�dia:(" + medX + "," + medY+")  ->"+cnt);
		medX = medX / cnt;
		medY = medY / cnt;
//			System.out.println("m�dia:(" + medX + "," + medY+")");
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
		glcanvas.revalidate();
		
		ObjectGeo b1 = ObjectGeo.drawEvent(FileHandling.Load("form4.txt"), -0.2f, 0.2f, 1.0f, 0.0f, 1.0f);
		glcanvas.addGLEventListener(b1);
		glcanvas.display();
		glcanvas.revalidate();
		
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
					System.out.println("Rota��o Esq.");
					break;
				case KeyEvent.VK_PAGE_DOWN:
					reshape(glcanvas,5);
					System.out.println("Rota��o Dir.");
					break;
				case KeyEvent.VK_UP:
					reshape(glcanvas,6);
					System.out.println("Transl. Cima");
					break;
				case KeyEvent.VK_LEFT:
					reshape(glcanvas,7);
					System.out.println("Transl. Esq.");
					break;
				case KeyEvent.VK_RIGHT:
					reshape(glcanvas,8);
					System.out.println("Transl. Dir.");
					break;
				case KeyEvent.VK_DOWN:
					reshape(glcanvas,9);
					System.out.println("Transl. Baixo");
					break;
				default:
					System.out.println("Tecla qualquer. Cód:"+key);
					break;
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
				double x = (((double) e.getX() / (double) glcanvas.getWidth()) - 0.5) * 2;
				double y = (((double) e.getY() / (double) glcanvas.getHeight()) - 0.5) * (-2);
				double closest = 0.2f;
				String closestName = null;
				for (int i = 0; i < glcanvas.getGLEventListenerCount(); i++) {
					ObjectGeo obj = (ObjectGeo) glcanvas.getGLEventListener(i);
					Iterator<String> it = obj.listaAtual.iterator();
					double medX = 0.0;
					double medY = 0.0;
					int cnt = 0;
					String name = it.next();
					System.out.println(name);
					while (it.hasNext()) {
						String ver1 = it.next();
						String ver2 = it.next();
						String tmp1 = ver1.substring(0, ver1.length() - 1);
						String tmp2 = ver2.substring(0, ver2.length() - 1);
						medX += Double.parseDouble(tmp1);
						medY += Double.parseDouble(tmp2);
						cnt++;
					}
					medX = medX / (double) cnt;
					medY = medY / (double) cnt;
					double dst = Math.sqrt(Math.pow((Math.abs(medX - x)), 2.0) + Math.pow((Math.abs(medY - y)), 2.0));
					System.out.println("Dist: " + dst);
					if (closest >= dst) {
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
		Operation op = new Operation();
		
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
//			op.rotate(glcanvas, 15);
		}
		if (flag == 5) {
			op.rotate((ObjectGeo) glcanvas.getGLEventListener(0), -15);
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
		listaOrigem = forma;
		X = x;
		Y = y;
		Float[] color = { c_r, c_g, c_b };
		Colors = color;
		return new ObjectGeo();
	}
}
