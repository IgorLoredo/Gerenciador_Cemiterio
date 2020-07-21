package codigos;

import java.util.ArrayList;

public class TesteMain {

	public static <E> void main(String[] args) {
			ArrayList <Cova> lista = new ArrayList<>();
			Cova NewCova = new Cova();
			NewCova.finado.setNome("igor");
			lista.add(NewCova);
			ManipularCSV.escreveCSV("aquivo.csv", lista);
//			ManipularCSV.leCSV(nomeArquivo, lista);

	}

}
