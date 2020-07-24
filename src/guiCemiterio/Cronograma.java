package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cronograma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	private JTextField txtDataInicio;
	private JTextField txtDataFinal;
	private JButton btnVoltar;
	private JButton btnAplicar;

	private void eventsHandler() {
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cronograma.this.dispose();
			}
		});
		
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
					Cronograma frame = new Cronograma();
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
	public Cronograma() {
		initComponents();
		eventsHandler();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollLista = new JScrollPane();
		
		btnAplicar = new JButton("Aplicar");
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setText("dd/mm/aaaa");
		txtDataInicio.setColumns(10);
		
		JLabel lblA = new JLabel("a");
		
		txtDataFinal = new JTextField();
		txtDataFinal.setText("dd/mm/aaaa");
		txtDataFinal.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPeriodo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblA)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAplicar))
						.addComponent(scrollLista, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriodo)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblA)
						.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAplicar)
						.addComponent(btnVoltar))
					.addGap(18)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
		tableModel.addColumn("Data");
		tableModel.addColumn("Horario");
		tableModel.addColumn("Local");
		tableModel.addColumn("Funcionarios");
		tableModel.addColumn("Falecido(a)");
		tableModel.addColumn("Responsavel");
		tableModel.addColumn("Descricao");
		
		scrollLista.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
