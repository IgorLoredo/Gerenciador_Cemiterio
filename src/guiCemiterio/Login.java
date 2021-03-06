package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigos.RegistroFinados;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textUsuario;
	private JButton btnEntrar;
	RegistroFinados registro = null;

	public Login() {
		registro = new RegistroFinados();
		setTitle("Gerenciador de Cemiterio - Login");
		initComponents();
		eventsHandler();
	}
	
	public Login(RegistroFinados reg) {
		registro = reg;
		setTitle("Gerenciador de Cemiterio - Login");
		initComponents();
		eventsHandler();
	}
	
	
	private void eventsHandler() {
		// Limpa o texto escrito em Usuario
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textUsuario.setText("");
			}
		});
		
		// Limpa o texto escrito no campo de senha
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
			}
		});
		
		// Verifica usuario e senha
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = "admin";
				char[] senha = {'1', '2', '3'};
				
				if(textUsuario.getText().equals(usuario) 
						&& Arrays.equals(senha, passwordField.getPassword())) {
					Login.this.dispose();
					new Home(registro).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,
			                "Usuario e/ou senha incorretos\nDica: admin | 123");
				}
				
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ######################## CODIGO ABAIXO GERADO PELA IDE ECLIPSE #############################
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(Login.class.getResource("/recursos/christian-cross-symbol(1).png")));
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(0, 0, 0));
		
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEntrar.setBackground(new Color(204, 0, 51));
		
		passwordField = new JPasswordField();
		
		passwordField.setText("Senha");
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
		passwordField.setBackground(Color.LIGHT_GRAY);
		
		textUsuario = new JTextField();
		
		textUsuario.setText("Usuario");
		textUsuario.setFont(new Font("Dialog", Font.PLAIN, 16));
		textUsuario.setColumns(10);
		textUsuario.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(167, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
							.addGap(156))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblIcon)
							.addGap(210))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcon)
					.addGap(18)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
