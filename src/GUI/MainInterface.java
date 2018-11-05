package GUI;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import CG.FileHandling;
import CG.Frame;

public class MainInterface {
	List<String> lista = new ArrayList<>();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		FileHandling FH = new FileHandling();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 588, 518);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

//		JPanel glPanel = new JPanel();
//		glPanel.setBounds(50, 50, 568, 496);
//		glPanel = Frame.drawFrame();
//		panel.add(glPanel);

		// getting the capabilities object of GL2 profile
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		glcanvas.setSize(588, 518);
//		panel.add(glcanvas);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(608, 11, 166, 91);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblPontoDePlotagem = new JLabel("Ponto de Plotagem");
		lblPontoDePlotagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontoDePlotagem.setBounds(10, 11, 146, 14);
		panel_3.add(lblPontoDePlotagem);

		JLabel lblEixoX = new JLabel("Eixo X");
		lblEixoX.setHorizontalAlignment(SwingConstants.CENTER);
		lblEixoX.setBounds(10, 36, 46, 14);
		panel_3.add(lblEixoX);

		JLabel lblEixoY = new JLabel("Eixo Y");
		lblEixoY.setHorizontalAlignment(SwingConstants.CENTER);
		lblEixoY.setBounds(10, 61, 46, 14);
		panel_3.add(lblEixoY);

		textField = new JTextField();
		textField.setBounds(66, 36, 86, 20);
		textField.setText("0.0");
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 58, 86, 20);
		textField_1.setText("0.0");
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		/* Painel Scroll 1 com os objetos a serem adicionados */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(608, 113, 166, 246);
		frame.getContentPane().add(scrollPane);

		/* Inicio do painel scroll 2 */
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(608, 370, 166, 159);
		frame.getContentPane().add(scrollPane_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		/* Fim Painel scroll 2 */

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		for (int i = 0; i < FH.getDirSize(); i++) {
			List<String> lista = FileHandling.Load("form" + (i + 1) + ".txt");
			String name = lista.iterator().next();
			JButton btnAddobjeto = new JButton(name);
			btnAddobjeto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText() == null || textField_1.getText() == null) {
						
					}
					Frame f = Frame.drawEvent(lista, Float.parseFloat(textField.getText() + "f"),
							Float.parseFloat(textField_1.getText() + "f"), 1.0f, 1.0f, 1.0f);
					glcanvas.addGLEventListener(f);
					
					glcanvas.display();
					glcanvas.revalidate();
					final int pos = glcanvas.getGLEventListenerCount();
					
					Frame f1 = (Frame) glcanvas.getGLEventListener(pos-1);
					for (String str : f1.lista) {
						System.out.println(str);
					}
					System.out.println("Contador de Objetos: " + pos + "\nNome:" + f.name);
					System.out.printf("%d,%d\n",glcanvas.getGLEventListenerCount(),pos);
					JLabel lblLabel = new JLabel(f.name);
					lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblLabel = new GridBagConstraints();
					gbc_lblLabel.gridx = 0;
					gbc_lblLabel.gridy = pos-1;

					JButton btnButton = new JButton("Deletar");
					btnButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							glcanvas.disposeGLEventListener(glcanvas.getGLEventListener(pos-1),true);
							glcanvas.revalidate();
							
							panel_2.remove(lblLabel);
							panel_2.remove(btnButton);
							panel_2.revalidate();
							System.out.printf("%d,%d\n",glcanvas.getGLEventListenerCount(),pos);
						}
					});
					GridBagConstraints gbc_btnButton = new GridBagConstraints();
					gbc_btnButton.gridx = 1;
					gbc_btnButton.gridy = pos-1;

					panel_2.add(lblLabel, gbc_lblLabel);
					panel_2.add(btnButton, gbc_btnButton);
					panel_2.revalidate();

				}
			});
			GridBagConstraints gbc_btnAddobjeto = new GridBagConstraints();
			gbc_btnAddobjeto.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnAddobjeto.gridx = 0;
			gbc_btnAddobjeto.gridy = i;
			panel_1.add(btnAddobjeto, gbc_btnAddobjeto);
		}
		/* Fim Painel de scroll 1 */

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

		JMenuItem mntmHabilitarCanvas = new JMenuItem("Habilitar Canvas");
		mntmHabilitarCanvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.add(glcanvas);
			}
		});
		mnArquivo.add(mntmHabilitarCanvas);
		mnArquivo.add(mntmSair);

		JMenu mnObjetos = new JMenu("Objetos");
		menuBar.add(mnObjetos);

		JMenuItem mntmApagarTudo = new JMenuItem("Apagar Tudo(broken)");
		mntmApagarTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				glcanvas.destroy();
			}
		});
		mnObjetos.add(mntmApagarTudo);
	}
}
