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
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cadastro_usuario extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Usu;
	private JTextField email;
	private JTextField Telefone;
	private JTextField Senha;
	private JTextField Departamento;
	private JTextField tfBuscaUsu;
	private JTextField tfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_usuario frame = new Cadastro_usuario();
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
	public Cadastro_usuario() {
		setTitle("Faz tudo");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionarios");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 5, 736, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 170, 90, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(44, 232, 90, 32);
		contentPane.add(lblNewLabel_1_1);
		
		Nome = new JTextField();
		Nome.setBounds(131, 172, 519, 31);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DEPARTAMENTO");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(5, 269, 129, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		Usu = new JTextField();
		Usu.setBounds(131, 138, 129, 23);
		contentPane.add(Usu);
		Usu.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Usuario");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(31, 137, 90, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JFormattedTextField CPF = new JFormattedTextField();
		CPF.setBounds(145, 236, 163, 26);
		contentPane.add(CPF);
		try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.#.###.##/##")));
            
            JButton Confirmar = new JButton("Confirmar ");
            Confirmar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            try {
            	
            	Connection c2 = Conexao.faz_conexao();
            	String sql = "insert into dados_senhas(usuario,senha,CPF,departamento,NOME,email,telefone)VALUES (?,?,?,?,?,?,?)";
            	
            	PreparedStatement stmt = c2.prepareStatement(sql);
            	
            	stmt.setString(1,Usu.getText());
            	stmt.setString(2,Senha.getText());
            	stmt.setString(3,CPF.getText());
            	stmt.setString(4,Departamento.getText());
            	stmt.setString(5,Nome.getText());
            	stmt.setString(6,email.getText());
            	stmt.setString(7,Telefone.getText());
            	
            	stmt.execute();
            	
            	stmt.close();
            	c2.close();
            	
            	JOptionPane.showMessageDialog(Confirmar,"Usuario foi cadastrado!");
            	
            // Apos cadastrado o usuario os campos sao limpos	
            	Nome.setText("");
        		CPF.setText("");
        		Usu.setText("");
        		email.setText("");
        		Senha.setText("");
        		Telefone.setText("");
        		Departamento.setText("");
        	
            	
            	
            }catch(SQLException e1) {
            	
            	
            	e1.printStackTrace();
            }
            		
            		
            		
            		
            	}
            });
            Confirmar.setFont(new Font("Arial", Font.BOLD, 15));
            Confirmar.setBackground(Color.GREEN);
            Confirmar.setBounds(31, 403, 117, 34);
            contentPane.add(Confirmar);
            
            JButton Limpa = new JButton("Limpar");
            Limpa.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		tfBuscaUsu.setText("");
                    tfID.setText("");
            		Nome.setText("");
            		CPF.setText("");
            		Usu.setText("");
            		email.setText("");
            		Senha.setText("");
            		Telefone.setText("");
            		Departamento.setText("");
            	
            	
            	}
            });
            Limpa.setFont(new Font("Arial", Font.BOLD, 15));
            Limpa.setBounds(158, 403, 117, 34);
            contentPane.add(Limpa);
            
            JButton Cancelar = new JButton("Cancelar");
            Cancelar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            	System.exit(0);	
            	}
            });
            Cancelar.setBackground(Color.RED);
            Cancelar.setFont(new Font("Arial", Font.BOLD, 15));
            Cancelar.setBounds(285, 403, 117, 34);
            contentPane.add(Cancelar);
            
            JLabel lblNewLabel_1_3 = new JLabel("Email");
            lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 14));
            lblNewLabel_1_3.setBounds(31, 312, 90, 32);
            contentPane.add(lblNewLabel_1_3);
            
            email = new JTextField();
            email.setBounds(139, 317, 223, 25);
            contentPane.add(email);
            email.setColumns(10);
            
            JLabel lblNewLabel_1_3_1 = new JLabel("Telefone");
            lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 14));
            lblNewLabel_1_3_1.setBounds(44, 349, 90, 32);
            contentPane.add(lblNewLabel_1_3_1);
            
            Telefone = new JTextField();
            Telefone.setBounds(143, 354, 230, 25);
            contentPane.add(Telefone);
            Telefone.setColumns(10);
            
            JLabel lblNewLabel_1_4 = new JLabel("Senha");
            lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 14));
            lblNewLabel_1_4.setBounds(31, 202, 90, 32);
            contentPane.add(lblNewLabel_1_4);
            
            Senha = new JTextField();
            Senha.setBounds(131, 207, 208, 24);
            contentPane.add(Senha);
            Senha.setColumns(10);
            
            Departamento = new JTextField();
            Departamento.setBounds(141, 273, 221, 27);
            contentPane.add(Departamento);
            Departamento.setColumns(10);
            
            JLabel lblNewLabel_2 = new JLabel("Buscar usu\u00E1rio");
            lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
            lblNewLabel_2.setForeground(new Color(0, 0, 0));
            lblNewLabel_2.setBounds(31, 48, 117, 29);
            contentPane.add(lblNewLabel_2);
            
            JButton btnNewButton = new JButton("Busca");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		try {
            			Connection co2 = Conexao.faz_conexao();
            			
            			String sql3 = "select * from dados_senhas where usuario = ?";
            			
            	        PreparedStatement stmt3 =co2.prepareStatement(sql3);
            	        
            	        stmt3.setString(1,tfBuscaUsu.getText());
            			
            	        ResultSet rs =stmt3.executeQuery();
            	        
            	        while(rs.next()) {
            	        	
            	        	tfID.setText(rs.getString("id"));
            	        	Usu.setText(rs.getString("usuario"));     	
            	        	Senha.setText(rs.getString("senha"));
            	        	CPF.setText(rs.getString("CPF"));
            	        	Departamento.setText(rs.getString("departamento"));
            	        	Nome.setText(rs.getString("NOME"));
            	        	email.setText(rs.getString("email"));
            	        	Telefone.setText(rs.getString("telefone"));
            	        }
            	        
            	        rs.close();
            	        co2.close();
            	        
            		}catch(SQLException e3) {
            			
            			e3.printStackTrace();
            		}
            		
            		
            	}
            });
            btnNewButton.setBounds(285, 48, 89, 23);
            contentPane.add(btnNewButton);
            
            tfBuscaUsu = new JTextField();
            tfBuscaUsu.setBounds(145, 48, 125, 25);
            contentPane.add(tfBuscaUsu);
            tfBuscaUsu.setColumns(10);
            
            JLabel lblNewLabel_1_5 = new JLabel("ID");
            lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 14));
            lblNewLabel_1_5.setBounds(31, 104, 90, 32);
            contentPane.add(lblNewLabel_1_5);
            
            tfID = new JTextField();
            tfID.setColumns(10);
            tfID.setBounds(131, 104, 129, 23);
            contentPane.add(tfID);
        } catch (java.text.ParseException ex) { 
            ex.printStackTrace();
        }
	}
}
