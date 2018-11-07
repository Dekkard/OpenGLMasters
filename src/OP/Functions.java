/*Teste inicial de captura de eventos do teclado para 
 * interação com o usuário, funções de teste implementadas:
 * - cor, mover, rotacionar, mudar escala, espelhar (efeito fantasma)
 * */
package OP;
import java.awt.Dimension;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

public class Functions extends GLJPanel implements GLEventListener, KeyListener {

	public static void main(String[] args) {
		JFrame window = new JFrame("Trabalho de CG");
		GLCapabilities caps = new GLCapabilities(null);
		Functions panel = new Functions();
		window.setContentPane(panel);
		window.pack();
		window.setLocation(300,100);//localiza��o da janela1
		window.setResizable(true);//redimensionar janela
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar janel
		window.setVisible(true);
		panel.requestFocusInWindow();
	}

	private float rotateX, rotateY, rotateZ;   //Rotação sobre eixos, controladas pelo teclado
	private float moveX, moveY; //Movimentação sobre eixos, controladas pelo teclado
	private float scale_init; //Escala, controladas pelo teclado
	private int  rgb[] = {1,1,1}; //Vetor para alteração de cor, controladas pelo teclado
	
<<<<<<< HEAD
	public Functions() {
		setPreferredSize( new Dimension(500,500) );
		addGLEventListener(this);
=======
	public Functions(GLCapabilities capabilities) {
		super(capabilities);
		setPreferredSize( new Dimension(500,500) );//plotando as dimens�es para 500x500
		addGLEventListener(this);//
>>>>>>> refs/remotes/origin/master
		addKeyListener(this);
		rotateX = 0;
		rotateY = 0;
		rotateZ = 0;
		moveX = 0;
		moveY = 0;
		scale_init = 1;
	}
	
	// ----------------- define o método de desenho ----------

	private void square(GL2 gl, float r, float g, float b) {
		
		gl.glLineWidth(3);
		gl.glColor3f(r,g,b);         // A cor do polígono
		gl.glTranslatef(moveX,moveY,0);    // Define a posição inicial
		gl.glScalef(scale_init, scale_init, 0);
		gl.glNormal3f(0,0,1);        // Vetor normal para o polígono (atualmente em default).
		gl.glBegin(GL2.GL_POLYGON);//desenho do polígono
		gl.glVertex2f(0.1f,0.1f);
		gl.glVertex2f(0.3f,0.3f);
		gl.glVertex2f(0.1f,0.5f);
		gl.glVertex2f(0.2f,0.7f);
		gl.glVertex2f(0.4f,0.8f);
		gl.glVertex2f(0.5f,0.6f);
		gl.glVertex2f(0.3f,0.4f);
		gl.glVertex2f(0.4f,0.2f);	              
		gl.glEnd();		
	}
	private void plane(GL2 gl) 
	{
		gl.glLineWidth(3);
		gl.glPushMatrix();
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(0.0f,-1.0f);
		gl.glVertex2f(0.0f,1.0f);
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		gl.glVertex2f(-1.0f,0.0f);
		gl.glVertex2f(1.0f,0.0f);
		gl.glEnd();
		gl.glPopMatrix(); 
	}

	private void cube(GL2 gl) {
		gl.glPushMatrix();
		square(gl,rgb[0], rgb[1], rgb[2]); // Cor de definição é branca 
		gl.glPopMatrix();
	}
	
	// ---------------  Métodos para GLEventListener interface -----------

	public void display(GLAutoDrawable drawable) {	
		   // chamado quando o painel precisa ser desenhado
		
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0,0,0,0);
		gl.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );

		gl.glMatrixMode(GL2.GL_PROJECTION);  // Configura a projeção.
		gl.glLoadIdentity();
		gl.glOrtho(-1,1,-1,1,-2,2);
		gl.glMatrixMode(GL2.GL_MODELVIEW);

		gl.glLoadIdentity();             // Configura a transformação de exibição do modelo.
		gl.glRotatef(rotateZ,0,0,1);
		gl.glRotatef(rotateY,0,1,0);
		gl.glRotatef(rotateX,1,0,0);
		cube(gl);
		GL2 gl2 = drawable.getGL().getGL2();
		plane(gl2);
		gl2.glRotatef(rotateY,0,0,1);
		gl2.glRotatef(rotateY,0,1,0);
		gl2.glRotatef(rotateX,1,0,0);
	}

	public void init(GLAutoDrawable drawable) {
		   // chamado quando o painel é criado
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0.8F, 0.8F, 0.8F, 1.0F);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glEnable(GL2.GL_LIGHT0);
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
	}

	public void dispose(GLAutoDrawable drawable) {
		// chamado quando o painel está sendo descartado
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// chamado quando o usuário redimensiona a janela
	}
	// ------------ Métodos da KeyListener interface ------------

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			 switch( key )
	    	 {
	    	     case KeyEvent.VK_ENTER:
	    	             break;
	    	     case KeyEvent.VK_ESCAPE:
	    	             break;
	    	     case KeyEvent.VK_UP:
	    	    	 moveY += 0.1;
	    	             break;
	    	     case KeyEvent.VK_DOWN:
	    	    	 moveY -= 0.1;
	    	             break;
	    	     case KeyEvent.VK_LEFT:
	    	    	 moveX -= 0.1;
	    	             break;
	    	     case KeyEvent.VK_RIGHT:
	    	    	 moveX += 0.1;
	    	             break;
	    	     case KeyEvent.VK_R:
	    	    	 rgb[0] = 1;
	    	    	 rgb[1] = 0;
	    	    	 rgb[2] = 0;
	    	             break;
	    	     case KeyEvent.VK_G:
	    	    	 rgb[0] = 0;
	    	    	 rgb[1] = 1;
	    	    	 rgb[2] = 0;
	    	             break;
	    	     case KeyEvent.VK_B:
	    	    	 rgb[0] = 0;
	    	    	 rgb[1] = 0;
	    	    	 rgb[2] = 1;
	    	             break;
	    	     case KeyEvent.VK_I:
	    	    	 scale_init += 0.1;
	    	             break;
	    	     case KeyEvent.VK_O:
	    	    	 scale_init -= 0.1;
	    	             break;
	    	     case KeyEvent.VK_PAGE_UP:
	    	    	 rotateZ += 15;
	    	             break;
	    	     case KeyEvent.VK_PAGE_DOWN:
	    	    	 rotateZ -= 15;
	    	             break;
	    	     case KeyEvent.VK_X:
	    	    	 moveX *= -1;
	    	    	 //scale_init *= -1;
	    	             break;
	    	     case KeyEvent.VK_Y:
	    	    	 moveY *= -1;
	    	     	 //scale_init *= -1;
	    	             break;
	    	     case KeyEvent.VK_HOME:
	    	    		rotateX = rotateY = rotateZ = 0;
	    	             break;
	    	     default:
	    	 }      
			repaint();
		}
		// Outros métodos da KeyListener interface
		public void keyReleased(KeyEvent e) { 
		}

		public void keyTyped(KeyEvent e) { 
		}

}
