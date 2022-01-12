package Classes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Cadastro_Pedido extends JFrame {

	private JPanel contentPane;
	private JTextField Comida;
	private JTextField Sabor;
	private JTextField textField_2;
	private JTextField qtde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Pedido frame = new Cadastro_Pedido();
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
	public Cadastro_Pedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Cadastro do pedido");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Arial", Font.BOLD, 18));
		Title.setBounds(69, 11, 382, 38);
		contentPane.add(Title);
		
		JButton Confirmar = new JButton("Confirmar");
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
					Connection co2 = Conexao.faz_conexao();
					
					String sql1 = "insert into t_cad_pedidos(TIPO,SABORES,QUANTIDADE) VALUES(?,?,?);";
					
					PreparedStatement stmt = co2.prepareStatement(sql1);
					
					stmt.setString(1,Comida.getText());
					stmt.setString(2,Sabor.getText());
					stmt.setString(3,qtde.getText());
					
					stmt.execute();
	            	
					JOptionPane.showMessageDialog(Confirmar,"Pedido foi cadastrado com sucesso!");
			    	
					
			    Confirmando_Dados frame = new Confirmando_Dados();
			    frame.setVisible(true);
				
						
			    stmt.close();
            	co2.close();						
				
				}catch(SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
				
				
			}
		});
		Confirmar.setFont(new Font("Arial", Font.BOLD, 15));
		Confirmar.setBackground(Color.GREEN);
		Confirmar.setBounds(70, 279, 109, 38);
		contentPane.add(Confirmar);
		
		JButton Cancela = new JButton("Cancelar");
		Cancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		Cancela.setFont(new Font("Arial", Font.BOLD, 15));
		Cancela.setBackground(Color.RED);
		Cancela.setBounds(368, 279, 109, 38);
		contentPane.add(Cancela);
		
		JButton Limpar = new JButton("Limpar");
		Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Comida.setText("");
				Comida.setText("");
				qtde.setText("");
			}
		});
		Limpar.setFont(new Font("Arial", Font.BOLD, 15));
		Limpar.setBackground(Color.LIGHT_GRAY);
		Limpar.setBounds(214, 279, 109, 38);
		contentPane.add(Limpar);
		
		JLabel lblNewLabel_1 = new JLabel("O que deseja?");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 118, 117, 25);
		contentPane.add(lblNewLabel_1);
		
		Comida = new JTextField();
		Comida.setBounds(175, 119, 303, 25);
		contentPane.add(Comida);
		Comida.setColumns(10);
		
		Sabor = new JTextField();
		Sabor.setColumns(10);
		Sabor.setBounds(175, 155, 303, 25);
		contentPane.add(Sabor);
		
		JLabel lblNewLabel_1_1 = new JLabel("Qual Sabor?");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 154, 117, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Buscar Pedido");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 60, 117, 25);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 60, 186, 25);
		contentPane.add(textField_2);
		
		JButton BuscarPed = new JButton("Buscar");
		BuscarPed.setBounds(333, 60, 118, 25);
		contentPane.add(BuscarPed);
		
		qtde = new JTextField();
		qtde.setBounds(175, 220, 86, 20);
		contentPane.add(qtde);
		qtde.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(20, 217, 117, 25);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
