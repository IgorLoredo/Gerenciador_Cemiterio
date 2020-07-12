package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelFuncionarios = new JPanel();
		panelFuncionarios.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Cemiterio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JButton btnBuscar = new JButton("Buscar Finado");
		
		JButton btnIncluirFinado = new JButton("Incluir Finado");
		
		JButton btnCronograma = new JButton("Cronograma");
		
		JButton btnVerificarCripta = new JButton("Verificar Disponibilidade de Cripta");
		btnVerificarCripta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnReservarCripta = new JButton("Reservar Cripta");
		GroupLayout gl_panelFuncionarios = new GroupLayout(panelFuncionarios);
		gl_panelFuncionarios.setHorizontalGroup(
			gl_panelFuncionarios.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelFuncionarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelFuncionarios.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
						.addComponent(btnCronograma, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIncluirFinado, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificarCripta, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReservarCripta, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelFuncionarios.setVerticalGroup(
			gl_panelFuncionarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFuncionarios.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIncluirFinado)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVerificarCripta)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReservarCripta)
					.addGap(12)
					.addComponent(btnCronograma)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panelFuncionarios.setLayout(gl_panelFuncionarios);
		
		JPanel panelFuncionarios_1 = new JPanel();
		panelFuncionarios_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Funcionarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JButton btnBuscarFuncionario_1 = new JButton("Buscar Funcionario");
		
		JButton btnCronogramaGrupo_1 = new JButton("Conograma de Equipes");
		GroupLayout gl_panelFuncionarios_1 = new GroupLayout(panelFuncionarios_1);
		gl_panelFuncionarios_1.setHorizontalGroup(
			gl_panelFuncionarios_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelFuncionarios_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelFuncionarios_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscarFuncionario_1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
						.addComponent(btnCronogramaGrupo_1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelFuncionarios_1.setVerticalGroup(
			gl_panelFuncionarios_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFuncionarios_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBuscarFuncionario_1)
					.addGap(18)
					.addComponent(btnCronogramaGrupo_1)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		panelFuncionarios_1.setLayout(gl_panelFuncionarios_1);
		
		JButton btnSalvarESair = new JButton("Salvar e  Sair");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelFuncionarios_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelFuncionarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(364, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(566, Short.MAX_VALUE)
					.addComponent(btnSalvarESair, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelFuncionarios, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelFuncionarios_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnSalvarESair, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		
		tableModel.addColumn("Horario");
		tableModel.addColumn("Em nome de:");
		contentPane.setLayout(gl_contentPane);

		}
}
