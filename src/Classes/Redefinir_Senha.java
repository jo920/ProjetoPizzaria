package Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Redefinir_Senha extends JFrame {

	private JPanel contentPane;
	private JTextField Usu_Redefini;
	private JTextField Senha_Redefini;
	private JButton Confi_redef;
	private JButton Limpa_rede;
	private JButton Cancel_redefi;
	private JLabel ID;
	private JTextField tfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Redefinir_Senha frame = new Redefinir_Senha();
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
	public Redefinir_Senha() {
		setTitle("Redefinir Senha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Redefinir Senha");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 178, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 93, 94, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 126, 94, 22);
		contentPane.add(lblNewLabel_1_1);

		Usu_Redefini = new JTextField();
		Usu_Redefini.setBounds(114, 96, 184, 20);
		contentPane.add(Usu_Redefini);
		Usu_Redefini.setColumns(10);

		Senha_Redefini = new JTextField();
		Senha_Redefini.setColumns(10);
		Senha_Redefini.setBounds(114, 129, 184, 20);
		contentPane.add(Senha_Redefini);

		Confi_redef = new JButton("Confirmar");
		Confi_redef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Usu_Redefini.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe o usuário que deseja redefinir");
				}else {
					try {
						Connection co3 = Conexao.faz_conexao();

						String sql = "update dados_senhas set usuario=?, senha=? where id=?";
						
						PreparedStatement stmt = co3.prepareStatement(sql);
						
						stmt.setString(1,Usu_Redefini.getText());
						stmt.setString(2,Senha_Redefini.getText());
						stmt.setString(3, tfID.getText());
						
						stmt.execute();
						
						JOptionPane.showMessageDialog(null, "Senha redefinida com sucesso!");
						
						stmt.close();
						co3.close();
						
						JOptionPane.showMessageDialog(null,"Senha redefinida!");
						
					} catch (SQLException e5) {

						e5.printStackTrace();
					}

				}

			}
		});
		Confi_redef.setBackground(Color.GREEN);
		Confi_redef.setBounds(36, 218, 114, 32);
		contentPane.add(Confi_redef);

		Limpa_rede = new JButton("Limpa");
		Limpa_rede.setBackground(Color.LIGHT_GRAY);
		Limpa_rede.setBounds(155, 218, 114, 32);
		contentPane.add(Limpa_rede);

		Cancel_redefi = new JButton("Cancelar");
		Cancel_redefi.setBackground(Color.RED);
		Cancel_redefi.setBounds(279, 218, 114, 32);
		contentPane.add(Cancel_redefi);
		
		ID = new JLabel("ID");
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("Arial", Font.BOLD, 18));
		ID.setBounds(10, 60, 94, 22);
		contentPane.add(ID);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(114, 63, 94, 20);
		contentPane.add(tfID);
	}
}
