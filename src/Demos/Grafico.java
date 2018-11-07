package Demos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 Classe que testa o uso de eventos e gráficos em applets
 */
public class Grafico extends JApplet implements KeyListener, MouseMotionListener, MouseListener
{	//Guarda a coluna em que o mouse se encontra
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x = 0;
	//Guarda a linha em que o mouse se encontra
	private int y = 0;
	//Guarda a mensagem que fala qual evento de mouse está acontecendo
	private String msg = "";
  	//Guarda a mensagem que fala qual evento de tecla está acontecendo
  	private String keyMsg="";
	//Acontece quando uma tecla é pressionada
	public void keyPressed(KeyEvent e)
	{  keyMsg = "Pressionado a tecla "+e.getKeyChar();
		}
	//Acontece quando uma tecla é solta
	public void keyReleased(KeyEvent e)
	{  keyMsg = "Soltou a tecla "+e.getKeyChar();
		}
	//Acontece enquando uma tecla esta sendo segurada
	public void keyTyped(KeyEvent e)
	{  keyMsg = "Est� pressionando a tecla "+e.getKeyChar();
		}
	//Acontece quando o mouse est� sendo clicado e move
	public void mouseDragged(MouseEvent e)
	{ 	x = e.getX();
		y = e.getY();
		repaint();
		}
	//Acontece quando o mouse move
	public void mouseMoved(MouseEvent e)
	{	x = e.getX();
		y = e.getY();
		repaint();
		}
	//Acontece quando o bot�o do mouse � apertado
	public void mouseClicked(MouseEvent e)
	{  msg = "Mouse Clicado";
		}
	//Acontece quando o mouse entra no componente
	public void mouseEntered(MouseEvent e)
 	{	msg="Mouse Entrou";
		}
	//Acontece quando o mouse sai do componente
 	public void mouseExited(MouseEvent e)
 	{	msg="Mouse Saiu";
		}
	//Acontece enquanto o bot�o do mouse est� sendo preciosado
 	public void mousePressed(MouseEvent e)
	{	msg="Mouse Pressionando...";
		}
 	//Acontece quando o bot�o do mouse � solto
 	public void mouseReleased(MouseEvent e)
 	{  msg="Mouse Soltou";
		}
	//Adiociona os "ouvidores" de mouse e de tecla
	public void start()
	{	addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		}
	//Escreve as mensagens na tela
	public void paint(Graphics g)
	{	g.setFont(new Font("Tahoma", Font.PLAIN, 12));
		g.clearRect(0,0,getHeight(),getWidth());
		g.drawString("A posis�o (x,y) do mouse �: ("+x+","+y+")", 1, getHeight()-10);
		g.drawString(msg, 1, getHeight()-30);
		g.drawString(keyMsg, 1, getHeight()-50);
		}
	}