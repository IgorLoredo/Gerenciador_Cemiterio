package codigos;

import java.io.IOException;
import java.util.ArrayList;

public class TesteMain {

	public static <E> void main(String[] args) throws IOException {
			ArrayList <Atividade> lista = new ArrayList<>();		
//			for(int i = 0; i < 2; i++) {
//				Atividade ativ = new Atividade();
//				ativ.preenherAtividade();
//				lista.add(ativ);
//			}
		
			
//			ManipularCSV.leCSV(nomeArquivo, lista);
			ManipularCSV.LeituraAtividade("arqAtividae.csv", lista);
			ManipularCSV.EscreverAtividade("arqAtividae.csv", lista);
	}

}
