package guiCemiterio;

import codigos.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import codigos.VerificacaoDeInputs;

import java.util.regex.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Incluir extends JFrame {
	// Variaveis geradas pela IDE Eclipse
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField txtDigiteODocumento;
	private JTextField txtDataNascimento;
	private JTextField textDataFalecimento;
	private JTextField textContatoNome;
	private JTextField textContatoSobrenome;
	private JTextField textContatoDocumento;
	private JTextField txtEmailContato;
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
	private JPanel panel_1;
	private JLabel lblIcone;
	private JTextField txtContatoDataNascimento;
	
	// Variaveis
	RegistroFinados registro;
	String caminhoImagemFinado = null;
	boolean imagemValida = false;
	
	public Incluir(RegistroFinados registro) {
		this.registro = registro;
		initComponents();
		eventsHandler();
	}
	
	public Incluir() {
		initComponents();
		eventsHandler();
	}
	
	private void eventsHandler() {
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Abre o gerenciador de arquivo, inicialmente na pasta de fotos pre-selecionadas
				JFileChooser jfc = new JFileChooser("fotosReferencia");
				jfc.setDialogTitle("Selecione uma imagem");
				jfc.setAcceptAllFileFilterUsed(false);
				// Filtra as extensoes de arquivos suportadas, nesse caso,, unicamente JPEG
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpg");
				jfc.addChoosableFileFilter(filter);
		
				int returnValue = jfc.showOpenDialog(null);
				
				// Verifica se algum arquivo foi selecionado
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					// Armazena o PATH da imagem selecionada
					caminhoImagemFinado = selectedFile.getAbsolutePath();
					imagemValida = true;
					lblFotocaminho.setText(caminhoImagemFinado);
					
					// Poe a imagem na tela
					lblIcone.setText("");
					lblIcone.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
				} else lblIcone.setText("Foto Invalida");
			}
		});
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Volta a tela Home
				Incluir.this.dispose();
			}
		});
		
		btnSalvarESair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msgErro="";
				if(VerificacaoDeInputs.verificaNome(textNome.getText()))
					msgErro += "Nome Invalido\n";
				if(VerificacaoDeInputs.verificaNome(textSobrenome.getText()))
					msgErro += "Sobrenome Invalido\n";
				if(VerificacaoDeInputs.verificaData(txtDataNascimento.getText()))
					msgErro += "Data de Nascimento Invalida\n";
				if(VerificacaoDeInputs.verificaData(textDataFalecimento.getText()))
					msgErro += "Data de Falecimento Invalida\n";
				if(VerificacaoDeInputs.verificaDocumento(txtDigiteODocumento.getText()))
					msgErro += "Documento Invalido\n";
				
				if(VerificacaoDeInputs.verificaNome(textContatoNome.getText()))
					msgErro += "Nome do Responsavel Invalido\n";
				if(VerificacaoDeInputs.verificaNome(textContatoSobrenome.getText()))
					msgErro += "Sobrenome do Responsavel Invalido\n";
				if(VerificacaoDeInputs.verificaNome(textContatoGraudeParentesco.getText()))
					msgErro += "Grau de Parentesco Invalido\n";
				if(VerificacaoDeInputs.verificaDocumento(textContatoDocumento.getText()))
					msgErro += "Documento do Responsavel Invalido\n";
				if(VerificacaoDeInputs.verificaEmail(txtEmailContato.getText()))
					msgErro += "Email Invalido\n";
				if(VerificacaoDeInputs.verificaTelefone(textTelefone.getText()))
					msgErro += "Telefone Invalido\n";
				if(!imagemValida)
					msgErro += "Imagem Invalida\n";
				
				
				if(msgErro.equals("")) {
					Finado fin = new Finado(registro.getNumRegistros()+1000,
							textNome.getText(), textSobrenome.getText(),
							txtDigiteODocumento.getText(), txtDataNascimento.getText(),
							textDataFalecimento.getText(), txtDescricao.getText(),
							new Contato(textContatoNome.getText(),
									textContatoSobrenome.getText(), textContatoDocumento.getText(),
									txtContatoDataNascimento.getText(),textTelefone.getText(),
									textContatoGraudeParentesco.getText(),
									txtEmailContato.getText()));
					
					try {
						copiaImagem(caminhoImagemFinado, String.valueOf(fin.getID()));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao copiar imagem para o banco");
					}
					registro.incluirRegistro(fin);
					JOptionPane.showMessageDialog(null, "Registro incluido com sucesso");
					Incluir.this.dispose();			
				} else {
					// Painel de mensagem com mensagens de erro
					JOptionPane.showMessageDialog(null,
			                "Verifique estes campos:\n"+msgErro);
				}
				
				
				// Apos verificar se o conteudo dos campos de texto sao validos
				// criamos um cadastro e adicionamos no registro geral 
						
				
				// Verifica se a inclusao foi feita corretamente
			}
			
		});
	}
	
	private void copiaImagem(String caminhoImagem, String idFinado) throws IOException {
		Files.copy(Paths.get(caminhoImagem), 
				Paths.get(System.getProperty("user.dir")+"/fotos/"+idFinado+".jpg"),
				REPLACE_EXISTING);
		
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
					Incluir frame = new Incluir(new RegistroFinados());
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
		setTitle("Gerenciador de Cemiterio - Incluir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		JPanel contentPane = new JPanel();
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
		
		JPanel pnlContato = new JPanel();
		pnlContato.setBackground(new Color(255, 255, 153));
		pnlContato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		scrollPane = new JScrollPane();
		
		lblDescricao = new JLabel("Descricao:");
		
		btnSalvarESair = new JButton("Salvar e Sair");
		
		btnVoltar = new JButton("Voltar");
				
		lblFoto = new JLabel("Foto:");
		
		btnProcurar = new JButton("Procurar");
		
		
		lblFotocaminho = new JLabel("");
		
		lblImagem = new JLabel("");
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDescricao)
							.addGap(282)
							.addComponent(lblFoto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFotocaminho))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagem)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnProcurar))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDataDeNascimento)
										.addComponent(lblDocumento))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtDataNascimento)
										.addComponent(txtDigiteODocumento, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDataDeFalecimento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textDataFalecimento, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSobrenome)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textSobrenome, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(514)
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSalvarESair))
						.addComponent(pnlContato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
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
					.addComponent(pnlContato, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescricao)
						.addComponent(lblFoto)
						.addComponent(lblFotocaminho))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblImagem))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProcurar))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(btnSalvarESair)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnVoltar)
							.addContainerGap())))
		);
		panel_1.setLayout(null);
		
		lblIcone = new JLabel("Foto Invalida");
		
		lblIcone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcone.setBounds(0, 0, 256, 256);
		panel_1.add(lblIcone);
		
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
		textContatoDocumento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		txtEmailContato = new JTextField();
		txtEmailContato.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtEmailContato.setText("example@exam.com");
		txtEmailContato.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
		textTelefone.setText("Ex.: 21999341232");
		textTelefone.setColumns(10);
		
		JLabel lblGrauDeParentesco = new JLabel("Grau de parentesco:");
		
		textContatoGraudeParentesco = new JTextField();
		textContatoGraudeParentesco.setFont(new Font("Dialog", Font.PLAIN, 14));
		textContatoGraudeParentesco.setColumns(10);
		
		JLabel lblContatoDataDeNascimento = new JLabel("Data de nasc:");
		
		txtContatoDataNascimento = new JTextField();
		txtContatoDataNascimento.setText("dd/mm/aaaa");
		txtContatoDataNascimento.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtContatoDataNascimento.setColumns(10);
		GroupLayout gl_pnlContato = new GroupLayout(pnlContato);
		gl_pnlContato.setHorizontalGroup(
			gl_pnlContato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContato.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlContato.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContato.createSequentialGroup()
							.addGroup(gl_pnlContato.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlContato.createSequentialGroup()
									.addComponent(lblTelefone)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
									.addComponent(lblGrauDeParentesco))
								.addGroup(gl_pnlContato.createSequentialGroup()
									.addComponent(lblContatoNome)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textContatoNome, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblContatoSobrenome))
								.addGroup(gl_pnlContato.createSequentialGroup()
									.addComponent(lblContatoDocumento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textContatoDocumento, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
									.addComponent(lblEmail)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlContato.createParallelGroup(Alignment.LEADING)
								.addComponent(textContatoSobrenome, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addComponent(txtEmailContato, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addComponent(textContatoGraudeParentesco, 282, 282, 282)))
						.addGroup(gl_pnlContato.createSequentialGroup()
							.addComponent(lblContatoDataDeNascimento, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtContatoDataNascimento, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlContato.setVerticalGroup(
			gl_pnlContato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContato.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContatoNome)
						.addComponent(textContatoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContatoSobrenome)
						.addComponent(textContatoSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlContato.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblContatoDocumento)
							.addComponent(textContatoDocumento, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtEmailContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEmail)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlContato.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGrauDeParentesco)
							.addComponent(textContatoGraudeParentesco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTelefone)
							.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlContato.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContatoDataDeNascimento)
						.addComponent(txtContatoDataNascimento, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		pnlContato.setLayout(gl_pnlContato);
		contentPane.setLayout(gl_contentPane);
	}
}
