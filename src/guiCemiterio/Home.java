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

import codigos.ManipularCSV;
import codigos.RegistroFinados;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;
	DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnBuscarFinado;
	private JButton btnVisualizarMemorial;
	private JButton btnRegistrarFinado;
	private JButton btnEditarRegistro;
	private JButton btnSalvarESair;
	// Registros a serem utilizado nas outras funcoes
	private RegistroFinados registro;
	
	public Home() {
		registro = new RegistroFinados();
		initComponents();
		eventsHandler();
	}
	
	public Home(RegistroFinados registro) {
		this.registro = registro;
		initComponents();
		eventsHandler();
	}
	
	private void eventsHandler() {
		// Abre tela de busca
		btnBuscarFinado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Busca frame = new Busca(registro);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// Abre tela de Memorial
		btnVisualizarMemorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Memorial frame = new Memorial(registro);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		// Abre tela de Registro
		btnRegistrarFinado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Incluir frame = new Incluir(registro);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// Abre tela de edicao de registros 
		btnEditarRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditarRegistro frame = new EditarRegistro(registro);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		// Salva alteracoes em um CSV
		btnSalvarESair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ManipularCSV.EscreverCSVFinados("Finados.csv", registro.lista);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Home.this.dispose();
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
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setForeground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagemcampo = new JLabel("");
		lblImagemcampo.setBounds(1, 1, 250, 400);
		lblImagemcampo.setIcon(new ImageIcon(Home.class.getResource("/recursos/campo.jpg")));
		contentPane.add(lblImagemcampo);
		
		btnBuscarFinado = new JButton("Buscar Finado");
		btnBuscarFinado.setBounds(268, 12, 198, 25);
		contentPane.add(btnBuscarFinado);
		
		btnRegistrarFinado = new JButton("Registrar Finado");
		btnRegistrarFinado.setBounds(268, 86, 198, 25);
		contentPane.add(btnRegistrarFinado);
		
		btnEditarRegistro = new JButton("Editar Registro");
		btnEditarRegistro.setBounds(269, 123, 198, 25);
		contentPane.add(btnEditarRegistro);
		
		btnVisualizarMemorial = new JButton("Visualizar Memorial");
		
		btnVisualizarMemorial.setBounds(268, 49, 198, 25);
		contentPane.add(btnVisualizarMemorial);
		
		btnSalvarESair = new JButton("Salvar e Sair");
		
		btnSalvarESair.setBounds(339, 365, 147, 25);
		contentPane.add(btnSalvarESair);
	}
}
