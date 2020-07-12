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

public class Eventos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventos frame = new Eventos();
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
	public Eventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollLista = new JScrollPane();
		
		JScrollPane scrollLocal = new JScrollPane();
		
		JScrollPane scrollData = new JScrollPane();
		
		JScrollPane scrollFuncionarios = new JScrollPane();
		
		JButton btnAplicar = new JButton("Aplicar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollLocal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollData, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollFuncionarios, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
							.addComponent(btnAplicar))
						.addComponent(scrollLista, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollLocal, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
							.addComponent(scrollData, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollFuncionarios, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
							.addComponent(btnAplicar)))
					.addGap(18)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList listFuncionarios = new JList();
		listFuncionarios.setModel(new AbstractListModel() {
			String[] values = new String[] {"Funcionarios", "Zeladores", "Limpeza", "Coveiros", "Jardineiro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollFuncionarios.setViewportView(listFuncionarios);
		
		JList listData = new JList();
		listData.setModel(new AbstractListModel() {
			String[] values = new String[] {"Selecione um periodo", "Ate uma semana", "Ate um mes", "Ate tres meses", "Ate 6 meses"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollData.setViewportView(listData);
		
		
		JList listLocal = new JList();
		listLocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLocal.setModel(new AbstractListModel() {
			String[] values = new String[] {"Selecione um local", "Capela", "Cemiterio", "Cemiterio", "Salao"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollLocal.setViewportView(listLocal);
		
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
