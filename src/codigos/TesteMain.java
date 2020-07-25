package codigos;

import java.io.IOException;
import java.util.ArrayList;

public class TesteMain {

	public static <E> void main(String[] args) throws IOException {
			ArrayList <Atividade> lista = new ArrayList<>();	
			RegistroFinados listaReg = new RegistroFinados();
//			for(int i = 0; i < 2; i++) {
//				Atividade ativ = new Atividade();
//				ativ.preenherAtividade();
//				lista.add(ativ);
//			}
			
			for(int i = 0; i < 4; i++) {
				System.out.println("morte");
				Finado nees = new Finado();
				String iD = EntradaTeclado.leString();
				nees.setDataDeNascimento(iD);
				listaReg.incluirRegistro(nees);
				
			}
			
			RegistroFinados.ordenaLista(listaReg.lista, "DATAFALESC");
			
			for(int i =0; i < 4; i++) {
				System.out.println(listaReg.lista.get(i).getDataDeNascimento());
			}
			
//			ManipularCSV.LeituraAtividade("Atividade.csv", lista);
//			ManipularCSV.EscreverAtividade("Atividade.csv", lista);
			System.out.println(lista.size());
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getTitulo());
			}
			
			
			
	}

}
