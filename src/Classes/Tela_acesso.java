package Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class Tela_acesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_acesso frame = new Tela_acesso();
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
	public Tela_acesso() {
		setType(Type.POPUP);
		setBackground(new Color(178, 34, 34));
		setForeground(Color.WHITE);
		setResizable(false);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 305);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbUsuario = new JLabel("Usuario");
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lbUsuario.setBounds(42, 62, 74, 47);
		contentPane.add(lbUsuario);

		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lbSenha.setBounds(42, 120, 64, 40);
		contentPane.add(lbSenha);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(116, 73, 344, 29);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Arial", Font.BOLD, 14));
		pfSenha.setBounds(116, 127, 344, 29);
		contentPane.add(pfSenha);
		
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_senhas where usuario=? and  senha=?";

					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2, new String(pfSenha.getPassword()));

					ResultSet rs = stmt.executeQuery();
					
					
					if (rs.next()) {

						JOptionPane.showMessageDialog(null, "Logado com sucesso!");
						Tela_Inicio frame = new Tela_Inicio();
						 
						frame.setVisible(true);
						
					}else if ((tfUsuario.getText().equals(""))) {
					
					JOptionPane.showMessageDialog(null,"Usuario ou Senha nao podem ser nulos");
					
					}else if (pfSenha.getPassword().equals(null)) {

						JOptionPane.showMessageDialog(null, "Usuario ou Senha nao podem ser nulos");
					}else {
						
						JOptionPane.showMessageDialog(null, "Usuário e senha Incorretos! Verifique novamente.");
					}

					stmt.close();
					con.close();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(101, 210, 139, 40);
		contentPane.add(btnNewButton);

		JButton Cancel = new JButton("Cancelar");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		Cancel.setBackground(Color.RED);
		Cancel.setBounds(250, 210, 139, 40);
		contentPane.add(Cancel);
		
		JLabel lblNewLabel = new JLabel("JH Pizzaria");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 22, 357, 29);
		contentPane.add(lblNewLabel);
		
		JButton Redefinir_Senha = new JButton("Redefinir a senha");
		Redefinir_Senha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Redefinir_Senha frame = new Redefinir_Senha();
			frame.setVisible(true);
			}
		});
		Redefinir_Senha.setBounds(135, 167, 130, 23);
		contentPane.add(Redefinir_Senha);
		
		JButton Novo_cadastro = new JButton("Novo aqui? Se cadastre");
		Novo_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_usuario frame = new Cadastro_usuario();
				frame.setVisible(true);
				
			}
		});
		Novo_cadastro.setBounds(275, 167, 157, 23);
		contentPane.add(Novo_cadastro);
	}
}
