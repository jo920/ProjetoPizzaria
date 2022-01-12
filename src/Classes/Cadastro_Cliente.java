package Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cadastro_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField Razao;
	private JTextField CNPJ;
	private JTextField Endereço;
	private JTextField TP_Pessoa;
	private JTextField Pagamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Cliente frame = new Cadastro_Cliente();
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
	public Cadastro_Cliente() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(146, 11, 341, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Razao Social");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(38, 82, 115, 30);
		contentPane.add(lblNewLabel_1);

		Razao = new JTextField();
		Razao.setBounds(163, 88, 324, 20);
		contentPane.add(Razao);
		Razao.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("CNPJ OU CPF");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(38, 123, 115, 30);
		contentPane.add(lblNewLabel_1_1);

		CNPJ = new JTextField();
		CNPJ.setColumns(10);
		CNPJ.setBounds(163, 129, 324, 20);
		contentPane.add(CNPJ);

		JLabel lblNewLabel_1_1_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(38, 164, 115, 30);
		contentPane.add(lblNewLabel_1_1_1);

		Endereço = new JTextField();
		Endereço.setColumns(10);
		Endereço.setBounds(163, 170, 324, 20);
		contentPane.add(Endereço);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pagamento");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(38, 205, 115, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tipo de Pessoa");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(38, 246, 115, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JButton btnNewButton = new JButton("Confirmar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((Razao.getText().equals(null)) && (CNPJ.getText().equals(null))) {

					JOptionPane.showMessageDialog(null, "Existem campos obrigatórios que não foram preenchidos.",
							"Campos em branco", JOptionPane.ERROR_MESSAGE);

				} else {
					try {

						Connection conex = Conexao.faz_conexao();

						String sql2 = "insert into t_glb_cliente(razao_social,cli_cnpj,cli_endereco,pagamento,TP_Pessoa)value(?,?,?,?,?)";

						PreparedStatement stmt = conex.prepareStatement(sql2);

						stmt.setString(1, Razao.getText());
						stmt.setString(2, CNPJ.getText());
						stmt.setString(3, Endereço.getText());
						stmt.setString(4, Pagamento.getText());
						stmt.setString(5, TP_Pessoa.getText());

						stmt.execute();

						JOptionPane.showMessageDialog(null, "Cliente cadastrado");

						stmt.close();
						conex.close();
						
						Razao.setText("");
						CNPJ.setText("");
						Endereço.setText("");
						Pagamento.setText("");
						TP_Pessoa.setText("");


					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(38, 427, 115, 30);
		contentPane.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Razao.setText("");
				CNPJ.setText("");
				Endereço.setText("");
				Pagamento.setText("");
				TP_Pessoa.setText("");
			}
		});
		btnLimpar.setBackground(Color.GRAY);
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 15));
		btnLimpar.setBounds(163, 427, 115, 30);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(EXIT_ON_CLOSE);
				
			}
		});
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelar.setBounds(288, 427, 115, 30);
		contentPane.add(btnCancelar);

		TP_Pessoa = new JTextField();
		TP_Pessoa.setBounds(163, 252, 86, 20);
		contentPane.add(TP_Pessoa);
		TP_Pessoa.setColumns(10);
		
		Pagamento = new JTextField();
		Pagamento.setBounds(163, 211, 115, 20);
		contentPane.add(Pagamento);
		Pagamento.setColumns(10);
	}
}
