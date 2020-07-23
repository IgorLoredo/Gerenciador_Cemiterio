package codigos;

import java.io.IOException;
import java.util.ArrayList;

public class Cronograma {
	public ArrayList <Atividade> cronograma;
	
	public Cronograma(ArrayList <Atividade> cronograma) {
		this.cronograma = cronograma;
	}
	
	public void addEvento(Atividade a) {
		this.cronograma.add(a);
	}
	
	public ArrayList<Atividade> pesquisaData(//Data 1 e Data 2
			){
		ArrayList<Atividade> listaDividida = null;
		// A partir das datas selecionadas, dividir a lista
		
		
		return listaDividida;
	}
	
	public void escreverCronograma(String path) throws IOException {
		try {
			ManipularCSV.EscreverAtividade(path,this.cronograma);
			System.out.println("Cronograma Gravado");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRO AO GRAVAR CRONOGRAMA!!");
			e.getLocalizedMessage();
		}		
	}
	
	public void lerCronograma(String path) {
		try {
			ManipularCSV.LeituraAtividade(path, this.cronograma);
			System.out.println("Cronograma preenchido!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AO LER CRONOGRAMA");
			e.getLocalizedMessage();
		}
	}
}
