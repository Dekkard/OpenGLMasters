package Demos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Dimension;

public class Teste1 {

    private static int contador = 0;

    public static void main(String[] args) {

        //janela
        final JFrame janela = new JFrame("Test JTextField Generation");

        //posicionamento sem nenhum layout, isto é, absoluto
        janela.getContentPane().setLayout(null);

        //adiciona listener do mouse
        janela.getContentPane().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {

                //adiciona dinamicamente no clique
                final JTextField textField = new JTextField("Caixa " + ++contador);
                textField.setBounds(event.getX(), event.getY(), 200, 30);
                janela.getContentPane().add(textField);

            }
        });

        //exibe a janela
        janela.setSize(600,  600);
        janela.setVisible(true);

    }
}
