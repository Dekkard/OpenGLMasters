package Demos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import CG.FileHandling;
import CG.ObjectGeo;


public class Teste1 {

    private static int contador = 0;

    public static void main(String[] args) {

        //janela
        final JFrame janela = new JFrame("Test JTextField Generation");

        //posicionamento sem nenhum layout, isto �, absoluto
        janela.getContentPane().setLayout(null);

        //adiciona listener do mouse
        janela.getContentPane().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {

            	JRadioButton b1 = new JRadioButton();                //adiciona dinamicamente no clique
            	int x = event.getX()-25;
            	int y =event.getY()-15;
                //final JTextField textField = new JTextField("o"+x+"-"+y);
                System.out.println("x, y:"+x+","+y);
                b1.setBounds(event.getX()-25, event.getY()-15, 50, 30);
                janela.getContentPane().add(b1);
            }
        });

        //exibe a janela
        janela.setSize(600,  600);
        janela.setVisible(true);

    }
}
