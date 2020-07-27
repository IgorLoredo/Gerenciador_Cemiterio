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
	
	private Finado fin = null;
	private JTextPane txtDescricao;
	private JPanel panel_2;
	private JLabel lblSobre;

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
		// Busca e imprime registro
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
		
		// Visualiza o registro anterior
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(fin != null) {
					int index = (fin.getID() - 1000)-1;
					try {
						fin = registro.lista.get(index);
						imprimeInformacoes(fin);
					} catch(IndexOutOfBoundsException e1) {
						System.out.println("Não ha regitro anterior");
					} 
				}
			}
		});
		
		// Visualiza o proximo registro
		btnProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(fin != null) {
					int index = (fin.getID() - 1000)+1;
					try {
						fin = registro.lista.get(index);
						imprimeInformacoes(fin);
					} catch(IndexOutOfBoundsException e1) {
						System.out.println("Não ha regitro posterior");
					} 
				}
			}
		});
		
		// Volta para Home
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Memorial.this.dispose();
			}
		});
	}
	
	private void imprimeInformacoes(Finado fin) {
		lblSobre.setText("Sobre " + fin.getNome());
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
		setBounds(100, 100, 670, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		btnVoltar.setBounds(539, 476, 117, 25);
		contentPane.add(btnVoltar);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(12, 45, 644, 419);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtDescricao = new JTextPane();
		txtDescricao.setForeground(Color.BLACK);
		txtDescricao.setBounds(16, 66, 257, 177);
		panel_2.add(txtDescricao);
		txtDescricao.setBackground(Color.WHITE);
		txtDescricao.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(285, 44, 347, 363);
		panel_2.add(panel_1);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(49, 12, 256, 256);
		panel_1.add(panel);
		panel.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 256, 256);
		panel.add(lblFoto);
		
		lblNome = new JLabel("Nome Completo do Finado");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(12, 280, 323, 26);
		panel_1.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		
		lblDataNascimento = new JLabel("dd/mm/aaaa");
		lblDataNascimento.setForeground(Color.BLACK);
		lblDataNascimento.setBounds(111, 310, 139, 26);
		panel_1.add(lblDataNascimento);
		lblDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataNascimento.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		
		lblDataFalec = new JLabel("dd/mm/aaaa");
		lblDataFalec.setForeground(Color.BLACK);
		lblDataFalec.setBounds(111, 337, 139, 26);
		panel_1.add(lblDataFalec);
		lblDataFalec.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataFalec.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("Memorial as vitimas do COVID-19");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 644, 32);
		panel_2.add(lblNewLabel);
		
		lblSobre = new JLabel("Sobre ");
		lblSobre.setForeground(Color.BLACK);
		lblSobre.setFont(new Font("Courier 10 Pitch", Font.BOLD, 16));
		lblSobre.setBounds(16, 44, 257, 27);
		panel_2.add(lblSobre);
	}
}
