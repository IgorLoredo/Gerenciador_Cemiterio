package guiCemiterio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmGerenciadorDeCemiterio;
	private JTextField textLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmGerenciadorDeCemiterio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		actionHandlers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciadorDeCemiterio = new JFrame();
		frmGerenciadorDeCemiterio.getContentPane().setBackground(SystemColor.control);
		frmGerenciadorDeCemiterio.setFont(new Font("Arial", Font.PLAIN, 12));
		frmGerenciadorDeCemiterio.setTitle("Gerenciador de Cemiterio");
		frmGerenciadorDeCemiterio.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/recursos/icons8-heart-cross-64.png")));
		frmGerenciadorDeCemiterio.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmGerenciadorDeCemiterio.setBounds(100, 100, 518, 377);
		frmGerenciadorDeCemiterio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 18));
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnLogin = new JButton("Entrar");
		
		JLabel lblCruz = new JLabel("");
		lblCruz.setIcon(new ImageIcon(Login.class.getResource("/recursos/christian-cross-symbol(1).png")));
		
		GroupLayout groupLayout = new GroupLayout(frmGerenciadorDeCemiterio.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSenha)
						.addComponent(lblLogin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCruz)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(passwordField)
							.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(408, Short.MAX_VALUE)
					.addComponent(btnLogin)
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblCruz)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		frmGerenciadorDeCemiterio.getContentPane().setLayout(groupLayout);
	}
	
	private void actionHandlers() {
		
	}
}
