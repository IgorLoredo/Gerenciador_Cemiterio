package codigos;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import guiCemiterio.*;

public class Main {

	public static void main(String[] args) {
		RegistroFinados registro = new RegistroFinados();
		
		// Faz a leitura do csv e transfere para o ArrayList
		try {
			ManipularCSV.LeituraCSVFinados("Finados.csv", registro.lista);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
		}
		
		// Inicia a tela de Login
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
