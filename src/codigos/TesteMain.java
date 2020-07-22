package codigos;

import java.io.IOException;
import java.util.ArrayList;

public class TesteMain {

	public static <E> void main(String[] args) throws IOException {
			ArrayList <Atividade> lista = new ArrayList<>();		
			
			
//			ManipularCSV.EscreverAtividade("arqAtividae.csv", lista);
//			ManipularCSV.leCSV(nomeArquivo, lista);
			ManipularCSV.LeituraAtividade("arqAtividae.csv", lista);
	}

}
