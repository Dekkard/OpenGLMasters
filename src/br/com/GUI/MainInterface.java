package br.com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import com.jogamp.opengl.awt.GLCanvas;

import br.com.CG.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;

public class MainInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel.setBounds(10, 11, 588, 518);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

//		JPanel glPanel = new JPanel();
//		glPanel.setBounds(50, 50, 568, 496);
//		glPanel = Frame.drawFrame();
//		panel.add(glPanel);

		GLCanvas glcanvas = new GLCanvas();
		glcanvas = Frame.drawCanvas("retangulo.txt");
		glcanvas.setSize(588, 518);
//		panel.add(glcanvas);

		/* Painel Scroll com os objetos a serem adicionados */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(608, 11, 166, 518);
		frame.getContentPane().add(scrollPane);

		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		for (int i = 0; i < 8; i++) {
			JButton btnAddobjeto = new JButton("AddObjeto" + (i + 1));
			GridBagConstraints gbc_btnAddobjeto = new GridBagConstraints();
			gbc_btnAddobjeto.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnAddobjeto.gridx = 0;
			gbc_btnAddobjeto.gridy = i;
			panel_1.add(btnAddobjeto, gbc_btnAddobjeto);
		}

		/* Fim Painel de scroll */

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
	}
}
