package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Incluir extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField txtDigiteODocumento;
	private JTextField txtDataNascimento;
	private JTextField textDataFalecimento;
	private JTextField textContatoNome;
	private JTextField textContatoSobrenome;
	private JTextField textContatoDocumento;
	private JTextField txtExampleexcom;
	private JTextField textTelefone;
	private JTextField textContatoGraudeParentesco;
	private JScrollPane scrollPane;
	private JTextArea txtDescricao;
	private JLabel lblDescricao;
	private JButton btnSalvarESair;
	private JButton btnVoltar;
	private JLabel lblFoto;
	private JButton btnProcurar;
	private JLabel lblFotocaminho;
	private JLabel lblImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incluir frame = new Incluir();
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
	public Incluir() {
		initComponents();
		eventsHandler();
	}
	
	private void initComponents() {
		setTitle("Gerenciador de Cemiterio - Incluir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textNome = new JTextField();
		textNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		
		textSobrenome = new JTextField();
		textSobrenome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textSobrenome.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento:");
		
		txtDigiteODocumento = new JTextField();
		txtDigiteODocumento.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDigiteODocumento.setText("Digite o documento");
		txtDigiteODocumento.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nasc:");
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDataNascimento.setText("dd/mm/aaaa");
		txtDataNascimento.setColumns(10);
		
		JLabel lblDataDeFalecimento = new JLabel("Data de falecimento:");
		
		textDataFalecimento = new JTextField();
		textDataFalecimento.setFont(new Font("Dialog", Font.PLAIN, 14));
		textDataFalecimento.setText("dd/mm/aaaa");
		textDataFalecimento.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		scrollPane = new JScrollPane();
		
		lblDescricao = new JLabel("Descricao:");
		
		btnSalvarESair = new JButton("Salvar e Sair");
		
		btnVoltar = new JButton("Voltar");
				
		lblFoto = new JLabel("Foto:");
		
		btnProcurar = new JButton("Procurar");
		
		lblFotocaminho = new JLabel("");
		
		lblImagem = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescricao)
					.addGap(282)
					.addComponent(lblFoto)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFotocaminho)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(btnProcurar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblImagem)
					.addContainerGap(297, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataDeNascimento)
								.addComponent(lblDocumento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtDataNascimento)
								.addComponent(txtDigiteODocumento, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDataDeFalecimento)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textDataFalecimento, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSobrenome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textSobrenome, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(480)
					.addComponent(btnVoltar)
					.addGap(18)
					.addComponent(btnSalvarESair))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSobrenome)
						.addComponent(textSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeNascimento)
						.addComponent(lblDataDeFalecimento)
						.addComponent(textDataFalecimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumento)
						.addComponent(txtDigiteODocumento, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescricao)
								.addComponent(lblFoto)
								.addComponent(lblFotocaminho))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblImagem)))
						.addComponent(btnProcurar))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvarESair)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(txtDescricao);
		
		JLabel lblContatoNome = new JLabel("Nome:");
		
		textContatoNome = new JTextField();
		textContatoNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textContatoNome.setColumns(10);
		
		JLabel lblContatoSobrenome = new JLabel("Sobrenome:");
		
		textContatoSobrenome = new JTextField();
		textContatoSobrenome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textContatoSobrenome.setColumns(10);
		
		JLabel lblContatoDocumento = new JLabel("Documento:");
		
		textContatoDocumento = new JTextField();
		textContatoDocumento.setFont(new Font("Dialog", Font.PLAIN, 14));
		textContatoDocumento.setText("Digite o documento");
		textContatoDocumento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		txtExampleexcom = new JTextField();
		txtExampleexcom.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtExampleexcom.setText("example@exam.com");
		txtExampleexcom.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
		textTelefone.setText("(--)---------");
		textTelefone.setColumns(10);
		
		JLabel lblGrauDeParentesco = new JLabel("Grau de parentesco:");
		
		textContatoGraudeParentesco = new JTextField();
		textContatoGraudeParentesco.setFont(new Font("Dialog", Font.PLAIN, 14));
		textContatoGraudeParentesco.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTelefone)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(lblGrauDeParentesco))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblContatoNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textContatoNome, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblContatoSobrenome))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblContatoDocumento)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textContatoDocumento, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
							.addComponent(lblEmail)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textContatoSobrenome, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(txtExampleexcom, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(textContatoGraudeParentesco))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContatoNome)
						.addComponent(textContatoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContatoSobrenome)
						.addComponent(textContatoSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblContatoDocumento)
							.addComponent(textContatoDocumento, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtExampleexcom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEmail)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGrauDeParentesco)
								.addComponent(textContatoGraudeParentesco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void eventsHandler() {
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Incluir.this.dispose();
			}
		});
		
		btnSalvarESair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Incluir.this.dispose();
			}
		});
	}

}
