package guiCemiterio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigos.Finado;
import codigos.RegistroFinados;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Memorial extends JFrame {

	private JPanel contentPane;
	RegistroFinados registro = null;
	private JPanel panel;
	private JLabel lblFoto;
	private JLabel lblDataNascimento;
	private JLabel lblDataFalec;
	private JLabel lblNome;
	private JTextField txtDigiteOId;
	private JButton btnCarregar;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnVoltar;
	
	private boolean registroValido = false;
	private Finado fin = null;
	private JTextPane txtDescricao;

	public Memorial() {
		registro = new RegistroFinados();
		initComponents();
		eventsHandler();
	}
	
	public Memorial(RegistroFinados reg) {
		registro = reg;
		initComponents();
		eventsHandler();
	}
	
	private void eventsHandler() {
		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Busca registro, caso encontre imprime nos campos, caso nao encontre cria um JOption.Pane
				fin = registro.buscaRegristo(txtDigiteOId.getText(), "ID");
				if(fin != null) {
					imprimeInformacoes(fin);
				} else System.out.println("erro");
			}
		});
		
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(fin != null) System.out.println(fin.getNome());
				else System.out.println("erro no anterior");
				if(fin != null) {
					int index = (fin.getID() - 1000)-1;
					if(registro.lista.get(index) != null) {
						fin = registro.lista.get(index);
						imprimeInformacoes(fin);
					}
				}
			}
		});
		
		btnProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(fin != null) System.out.println(fin.getNome());
				else System.out.println("erro no proximo");
				if(fin != null) {
					int index = (fin.getID() - 1000)+1;
					if(registro.lista.get(index) != null) {
						fin = registro.lista.get(index);
						imprimeInformacoes(fin);
					}
				}
			}
		});
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Memorial.this.dispose();
			}
		});
	}
	
	private void imprimeInformacoes(Finado fin) {
		txtDigiteOId.setText(String.valueOf(fin.getID()));
		lblFoto.setIcon(new ImageIcon("fotos/" + 
				String.valueOf(fin.getID()) + ".jpg"));
		lblNome.setText(fin.getNome() + " " + fin.getSobrenome());
		txtDescricao.setText(fin.getDescricao());
		lblDataNascimento.setText("~"+fin.getDataDeNascimento()+"~");
		lblDataFalec.setText("~"+fin.getDataSepultamento()+"~");
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
					Memorial frame = new Memorial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(398, 45, 256, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 256, 256);
		panel.add(lblFoto);
		
		lblDataNascimento = new JLabel("dd/mm/aaaa");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataNascimento.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		lblDataNascimento.setBounds(460, 350, 139, 26);
		contentPane.add(lblDataNascimento);
		
		lblDataFalec = new JLabel("dd/mm/aaaa");
		lblDataFalec.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataFalec.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		lblDataFalec.setBounds(460, 388, 139, 26);
		contentPane.add(lblDataFalec);
		
		lblNome = new JLabel("Nome Completo do Finado");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		lblNome.setBounds(398, 312, 258, 26);
		contentPane.add(lblNome);
		
		txtDigiteOId = new JTextField();
		txtDigiteOId.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDigiteOId.setText("Digite o ID");
		txtDigiteOId.setBounds(28, 7, 114, 26);
		contentPane.add(txtDigiteOId);
		txtDigiteOId.setColumns(10);
		
		btnCarregar = new JButton("Carregar");
		
		btnCarregar.setBounds(154, 8, 117, 25);
		contentPane.add(btnCarregar);
		
		btnProximo = new JButton("Proximo");
		btnProximo.setBounds(412, 8, 117, 25);
		contentPane.add(btnProximo);
		
		btnAnterior = new JButton("Anterior");
		
		btnAnterior.setBounds(283, 8, 117, 25);
		contentPane.add(btnAnterior);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setBounds(539, 426, 117, 25);
		contentPane.add(btnVoltar);
		
		txtDescricao = new JTextPane();
		txtDescricao.setBackground(new Color(255, 255, 153));
		txtDescricao.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 16));
		txtDescricao.setBounds(28, 49, 333, 365);
		contentPane.add(txtDescricao);
	}
}
