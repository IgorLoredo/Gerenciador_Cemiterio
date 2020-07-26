package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import codigos.Finado;
import codigos.RegistroFinados;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Busca extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private boolean verificaTexto = false;
	private JButton btnAplicar;
	private JButton btnVoltar;
	private JList<String[]> list;
	RegistroFinados registro;
	
	public Busca() {
		setTitle("Gerenciador de Cemiterio - Busca");
		initComponents();
		handleEvents();
	}
	
	public Busca(RegistroFinados registro) {
		setTitle("Gerenciador de Cemiterio - Busca");
		this.registro = registro;
		initComponents();
		handleEvents();
	}
	
	private void handleEvents() {
		
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(list.getSelectedIndex()) {
				case 0: // Busca por ID
					RegistroFinados.ordenaLista(registro.lista, "ID");
					break;
				case 1: // Busca por nome
					RegistroFinados.ordenaLista(registro.lista, "NOME");
					break;
				case 2:// Busca por data de nascimento
					break;
				case 3: // Busca por data de falecimento
					break;
				}
				
				tableModel.setNumRows(0);
				for(Finado finado : registro.lista) {
					tableModel.addRow(new String[] {
						String.valueOf(finado.getID()),
						finado.getNome()+" "+finado.getSobrenome(),
						finado.getDataDeNascimento(),
						finado.getDataSepultamento(),
					});
				}
			}
		});
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busca.this.dispose();
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
					Busca frame = new Busca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAplicar = new JButton("Aplicar");
		
		btnAplicar.setForeground(new Color(0, 0, 0));
		btnAplicar.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBuscarPor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAplicar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 431, Short.MAX_VALUE)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
							.addComponent(btnAplicar)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBuscarPor, Alignment.LEADING))
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);
		tableModel.addColumn("ID");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Data de Nasc.");
		tableModel.addColumn("Data Falesc.");
		for(Finado finado : registro.lista) {
			tableModel.addRow(new String[] {
				String.valueOf(finado.getID()),
				finado.getNome()+" "+finado.getSobrenome(),
				finado.getDataDeNascimento(),
				finado.getDataSepultamento(),
			});
		}
		
		
		list = new JList<String[]>();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"ID", "Nome", "Data de Nascimento", "Data de Falecimento"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
}
