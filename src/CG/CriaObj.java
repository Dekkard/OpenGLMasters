package CG;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CriaObj extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanel pnl = new JPanel();
					CriaObj frame = new CriaObj(pnl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriaObj(JPanel pnl) {
		List<String> lista = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 340);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		JPanel panel = new JPanel();
		panel.setBounds(0, 261, 284, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);

		txtName = new JTextField();
		txtName.setBounds(66, 8, 108, 20);
		txtName.setText("");
		panel.add(txtName);
		txtName.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = new ArrayList<>();
				if (!txtName.getText().isEmpty()) {
					list.add(txtName.getText());
					System.out.print(txtName.getText());
					Iterator<String> it = lista.iterator();
					while(it.hasNext()) {
						String tmp = it.next();
						list.add(tmp);
						System.out.print(" "+tmp);
					}
					FileHandling.Save(list);
					pnl.repaint();
					pnl.revalidate();
					dispose();
				}
				else {
					panel_1.add(new JLabel("Caixa do nome vazio!"));
					panel_1.revalidate();
				}
			}
		});
		btnSalvar.setBounds(185, 7, 89, 23);
		panel.add(btnSalvar);

		
		panel_1.setBounds(0, 0, 284, 261);
		contentPane.add(panel_1);
		
		panel_1.getRootPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				JRadioButton b1 = new JRadioButton(); // adiciona dinamicamente no clique
				double x = (double) event.getX() / (double) panel_1.getWidth();
				double y = (double) event.getY() / (double) panel_1.getHeight();
				// final JTextField textField = new JTextField("o"+x+"-"+y);
				System.out.println("x, y:" + (x - 0.5f) + "," + -(y - 0.5f));
				b1.setBounds(event.getX() - 10, event.getY() - 10, 20, 20);
				b1.setSelected(true);
				panel_1.getRootPane().add(b1);
				lista.add(String.valueOf((float) x - 0.5f));
				lista.add(String.valueOf((float) -(y - 0.5f)));
				lista.add("0.0");
			}
		});
	}
}
