package Classes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Confirmando_Dados extends JFrame {

	private JPanel contentPane;
	private JTextField Endereco;
	private JTextField Conf_Comida;
	private JTextField Busca_Ped;
	private JTextField Nome_Cli;
	private JTextField Cliente;
	private JTextField Paga;
	private JTextField Conf_Sabores;
	private JTextField Qtde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmando_Dados frame = new Confirmando_Dados();
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
	/**
	 * 
	 */
	/**
	 * 
	 */
	public Confirmando_Dados() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Confirma\u00E7\u00E3o de Dados");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 11, 240, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 80, 56, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(326, 80, 44, 25);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Forma de pagamento:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 116, 123, 25);
		contentPane.add(lblNewLabel_3);

		JRadioButton Band1 = new JRadioButton("ELO");
		Band1.setFont(new Font("Arial", Font.BOLD, 11));
		Band1.setBounds(165, 151, 56, 23);
		contentPane.add(Band1);

		JLabel lblNewLabel_4 = new JLabel("Bandeira do cart\u00E3o:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 152, 148, 19);
		contentPane.add(lblNewLabel_4);

		JRadioButton Band2 = new JRadioButton("VISA");
		Band2.setFont(new Font("Arial", Font.BOLD, 11));
		Band2.setBounds(223, 151, 56, 23);
		contentPane.add(Band2);

		JRadioButton Band3 = new JRadioButton("MasterCard");
		Band3.setFont(new Font("Arial", Font.BOLD, 11));
		Band3.setBounds(281, 151, 109, 23);
		contentPane.add(Band3);

		JFormattedTextField CPF = new JFormattedTextField();
		try {
			CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
					new javax.swing.text.MaskFormatter("###.#.###.##/##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		CPF.setBounds(380, 81, 163, 25);
		contentPane.add(CPF);

		JLabel lblNewLabel_5 = new JLabel("Endere\u00E7o:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 182, 123, 34);
		contentPane.add(lblNewLabel_5);

		Endereco = new JTextField();
		Endereco.setBounds(143, 181, 374, 34);
		contentPane.add(Endereco);
		Endereco.setColumns(10);

		JTextPane OBS = new JTextPane();
		OBS.setBounds(116, 227, 366, 65);
		contentPane.add(OBS);

		JButton Confirmar = new JButton("Confirmar");
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Nome_Cli.getText().equals("")) {

					JOptionPane.showMessageDialog(Confirmar,
							"Campos Nome obrigatorios estão nulos, favor preencher antes de confirmar o pedido");

				} else if (CPF.getText().equals("")) {

					JOptionPane.showMessageDialog(Confirmar,
							"Campo CPF é obrigatorio, favor preencher antes de confirmar o pedido");

				} else if (Endereco.getText().equals("")) {

					JOptionPane.showMessageDialog(Confirmar,
							"Endereco CPF é obrigatorio, favor preencher antes de confirmar o pedido");

				} else {

					JOptionPane.showMessageDialog(Confirmar, "Seu pedido está em andamento. Por favor aguarde!");

				}

			}
		});
		Confirmar.setFont(new Font("Arial", Font.BOLD, 15));
		Confirmar.setBackground(Color.GREEN);
		Confirmar.setBounds(154, 408, 109, 38);
		contentPane.add(Confirmar);

		JButton Cancela = new JButton("Cancelar");
		Cancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		Cancela.setFont(new Font("Arial", Font.BOLD, 15));
		Cancela.setBackground(Color.RED);
		Cancela.setBounds(408, 408, 109, 38);
		contentPane.add(Cancela);

		JLabel lblNewLabel_6 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 227, 96, 25);
		contentPane.add(lblNewLabel_6);

		JButton Voltar = new JButton("Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cadastro_Pedido frame = new Cadastro_Pedido();

				frame.setVisible(true);
			}
		});
		Voltar.setFont(new Font("Arial", Font.BOLD, 15));
		Voltar.setBounds(273, 409, 117, 36);
		contentPane.add(Voltar);

		JLabel lblNewLabel_6_1 = new JLabel("Pedido");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(10, 339, 96, 25);
		contentPane.add(lblNewLabel_6_1);

		Conf_Comida = new JTextField();
		Conf_Comida.setBounds(98, 342, 181, 20);
		contentPane.add(Conf_Comida);
		Conf_Comida.setColumns(10);

		JLabel lblNewLabel_6_1_1 = new JLabel("Buscar pedido");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6_1_1.setBounds(10, 303, 121, 25);
		contentPane.add(lblNewLabel_6_1_1);

		Busca_Ped = new JTextField();
		Busca_Ped.setBounds(143, 303, 86, 20);
		contentPane.add(Busca_Ped);
		Busca_Ped.setColumns(10);

		JButton BuscaCli = new JButton("Buscar");
		BuscaCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection co = Conexao.faz_conexao();

					String sql1 = "select * from t_glb_cliente where id like ?";

					PreparedStatement stmt = co.prepareStatement(sql1);

					stmt.setString(1, "%" + Cliente.getText());

					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {

						Nome_Cli.setText(rs.getString("razao_social"));
						CPF.setText(rs.getString("cli_cnpj"));
						Paga.setText(rs.getString("pagamento"));
						Endereco.setText(rs.getString("cli_endereco"));
					}

					stmt.close();
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
			}
		});
		BuscaCli.setBounds(293, 47, 89, 23);
		contentPane.add(BuscaCli);

		Nome_Cli = new JTextField();
		Nome_Cli.setColumns(10);
		Nome_Cli.setBounds(76, 83, 240, 20);
		contentPane.add(Nome_Cli);

		JLabel lblNewLabel_4_1 = new JLabel("Buscar Cliente");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(10, 50, 148, 19);
		contentPane.add(lblNewLabel_4_1);

		Cliente = new JTextField();
		Cliente.setColumns(10);
		Cliente.setBounds(165, 50, 118, 20);
		contentPane.add(Cliente);

		JButton BuscaPedido = new JButton("Buscar");
		BuscaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Connection co = Conexao.faz_conexao();

					String sql1 = "select * from t_cad_pedidos where id like ?";

					PreparedStatement stmt = co.prepareStatement(sql1);

					stmt.setString(1, "%" + Busca_Ped.getText());

					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						Conf_Comida.setText(rs.getString("TIPO"));
					    Conf_Sabores.setText(rs.getString("SABORES"));
						Qtde.setText(rs.getString("QUANTIDADE"));
						
					}

					stmt.close();
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		BuscaPedido.setBounds(239, 303, 89, 23);
		contentPane.add(BuscaPedido);

		Paga = new JTextField();
		Paga.setBounds(143, 118, 173, 20);
		contentPane.add(Paga);
		Paga.setColumns(10);
		
		Conf_Sabores = new JTextField();
		Conf_Sabores.setBounds(98, 377, 292, 20);
		contentPane.add(Conf_Sabores);
		Conf_Sabores.setColumns(10);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Sabores");
		lblNewLabel_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6_1_2.setBounds(10, 375, 96, 25);
		contentPane.add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("Quantidade");
		lblNewLabel_6_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6_1_2_1.setBounds(289, 339, 96, 25);
		contentPane.add(lblNewLabel_6_1_2_1);
		
		Qtde = new JTextField();
		Qtde.setBounds(396, 342, 86, 20);
		contentPane.add(Qtde);
		Qtde.setColumns(10);

	}
}
