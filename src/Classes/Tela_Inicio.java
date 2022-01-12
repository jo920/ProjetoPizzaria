package Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inicio frame = new Tela_Inicio();
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
	public Tela_Inicio() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo JH Pizzaria");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 11, 334, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de pedido");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 82, 144, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton Cad_Usu = new JButton("Clique aqui");
		Cad_Usu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Cadastro_usuario frame = new Cadastro_usuario();
					frame.setVisible(true);
					
				}catch(Exception e1){
					e1.printStackTrace();
					
				}
			}
		});
		Cad_Usu.setFont(new Font("Arial", Font.BOLD, 12));
		Cad_Usu.setForeground(Color.BLACK);
		Cad_Usu.setBounds(530, 83, 169, 40);
		contentPane.add(Cad_Usu);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro de usuario");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(364, 82, 144, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Agenda de clientes");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 133, 144, 40);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Cadastro de clientes");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(351, 133, 169, 40);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton Cad_Client = new JButton("Clique aqui");
		Cad_Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_Cliente frame2 = new Cadastro_Cliente();
				frame2.setVisible(true);
				
			}

			
		});
		Cad_Client.setForeground(Color.BLACK);
		Cad_Client.setFont(new Font("Arial", Font.BOLD, 12));
		Cad_Client.setBounds(530, 134, 169, 40);
		contentPane.add(Cad_Client);
		
		JButton Cad_Pedido = new JButton("Clique aqui");
		Cad_Pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_Pedido frame = new Cadastro_Pedido();
				frame.setVisible(true);
			}
		});
		Cad_Pedido.setForeground(Color.BLACK);
		Cad_Pedido.setFont(new Font("Arial", Font.BOLD, 12));
		Cad_Pedido.setBounds(164, 83, 169, 40);
		contentPane.add(Cad_Pedido);
		
		JButton AgendaClient = new JButton("Clique aqui");
		AgendaClient.setForeground(Color.BLACK);
		AgendaClient.setFont(new Font("Arial", Font.BOLD, 12));
		AgendaClient.setBounds(164, 134, 169, 40);
		contentPane.add(AgendaClient);
	}
}
