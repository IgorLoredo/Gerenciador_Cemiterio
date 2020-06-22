package guiCemiterio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel lblIgor;
	private JPanel panelBusca;

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
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelBusca = new JPanel();
		
		panelBusca.setBackground(SystemColor.control);
		panelBusca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lblIgor = new JLabel("");
		lblIgor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIgor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(lblIgor, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(lblIgor, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JLabel lblBuscaIcon = new JLabel("");
		lblBuscaIcon.setIcon(new ImageIcon(Home.class.getResource("/recursos/home/search.png")));
		
		JLabel lblBusca = new JLabel("Busca");
		lblBusca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusca.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		GroupLayout gl_panelBusca = new GroupLayout(panelBusca);
		gl_panelBusca.setHorizontalGroup(
			gl_panelBusca.createParallelGroup(Alignment.LEADING)
				.addComponent(lblBuscaIcon)
				.addComponent(lblBusca, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
		);
		gl_panelBusca.setVerticalGroup(
			gl_panelBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusca.createSequentialGroup()
					.addComponent(lblBuscaIcon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBusca, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
		);
		panelBusca.setLayout(gl_panelBusca);
		contentPane.setLayout(gl_contentPane);
		actionHandler();
	}
	
	private void actionHandler() {
		panelBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblIgor.setText("Igor Viado");
			}
		});
	}
}
