package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
	private JTextArea txtrDigiteAqui;
	private boolean verificaTexto = false;
	private JButton btnAplicar;
	private JButton btnVoltar;

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

	/**
	 * Create the frame.
	 */
	public Busca() {
		setTitle("Gerenciador de Cemiterio - Busca");
		initComponents();
		handleEvents();
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
		
		txtrDigiteAqui = new JTextArea();
		
		txtrDigiteAqui.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtrDigiteAqui.setText("Digite aqui");
		
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
							.addGap(13)
							.addComponent(txtrDigiteAqui, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAplicar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrDigiteAqui, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(btnAplicar)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblBuscarPor, Alignment.LEADING))))
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);
		tableModel.addColumn("ID");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Sobrenome");
		tableModel.addColumn("Data de Nasc.");
		tableModel.addColumn("Data Falesc.");
		tableModel.addColumn("Responsavel");
		
		JList<String[]> list = new JList<String[]>();
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
	
	private void handleEvents() {
		txtrDigiteAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!verificaTexto) {
					txtrDigiteAqui.setText("");
					verificaTexto = true;
				}
			}
		});
		
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busca.this.dispose();
			}
		});
	}
}
