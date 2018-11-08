package Demos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Teste1 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		// janela
		final JFrame janela = new JFrame("Test JTextField Generation");
		janela.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// exibe a janela
		janela.setBounds(0, 0, 300, 300);
		janela.setVisible(true);
		// posicionamento sem nenhum layout, isto é, absoluto
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		// adiciona listener do mouse
		janela.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				JRadioButton b1 = new JRadioButton(); // adiciona dinamicamente no clique
				double x = (double) event.getX() / (double) janela.getWidth();
				double y = (double) event.getY() / (double) janela.getHeight();
				// final JTextField textField = new JTextField("o"+x+"-"+y);
				System.out.println("x, y:" + event.getX() + "," + event.getY());
				b1.setBounds(event.getX() - 10, event.getY() - 10, 20, 20);
				b1.setSelected(true);
				janela.getContentPane().add(b1);
				lista.add(String.valueOf((float)x));
				lista.add(String.valueOf((float)y));
			}
		});
		
		JLabel lbl = new JLabel("Nome");
		lbl.setBounds(20, 235, 40, 25);
		janela.add(lbl);
		JTextField name = new JTextField("");
		name.setBounds(80, 235, 80, 25);
		janela.add(name);
		JButton btn = new JButton("Salvar");
		btn.setBounds(180,235, 80, 25);
		janela.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		janela.repaint();
	}
}
