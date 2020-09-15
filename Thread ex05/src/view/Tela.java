package view;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadCorrida;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;
import javax.swing.SwingConstants;
public class Tela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCarro1 = new JLabel("Carro1");
		lblCarro1.setBounds(15, 90, 42, 17);
		lblCarro1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarro1.setForeground(Color.RED);
		
		JButton btnCorrida = new JButton("Come\u00E7ar corrida");
		btnCorrida.setBounds(62, 256, 111, 23);
		
		JTextArea textPerdedor = new JTextArea();
		textPerdedor.setBounds(309, 268, 89, 24);
		
		JTextArea textVencedor = new JTextArea();
		textVencedor.setBounds(309, 233, 89, 24);
		
		JLabel lblNewLabel = new JLabel("Vencedor");
		lblNewLabel.setBounds(238, 238, 61, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Perdedor");
		lblNewLabel_1.setBounds(238, 273, 61, 14);
		
		JLabel lblCarro2 = new JLabel("Carro2");
		lblCarro2.setBounds(15, 154, 42, 17);
		lblCarro2.setForeground(Color.BLUE);
		lblCarro2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setLayout(null);
		contentPane.add(btnCorrida);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textPerdedor);
		contentPane.add(lblNewLabel);
		contentPane.add(textVencedor);
		contentPane.add(lblCarro2);
		contentPane.add(lblCarro1);
		
		JLabel lblNewLabel_2 = new JLabel("|");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(650, 72, 46, 103);
		contentPane.add(lblNewLabel_2);
	ActionListener Corrida = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		btnCorrida.setVisible(false);
		   for (int i = 0; i < 2; i++) {
			   Thread ThreadCorrida = new ThreadCorrida(lblCarro1, lblCarro2, i, textPerdedor,textVencedor,btnCorrida );
			   textVencedor.setText("");
				textPerdedor.setText("");
				ThreadCorrida.start();
		   }
		}
	};
	btnCorrida.addActionListener(Corrida);
	}
}
