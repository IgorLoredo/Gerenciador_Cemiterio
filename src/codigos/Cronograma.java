package codigos;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cronograma {
	public ArrayList <Atividade> cronograma;
	
	public Cronograma(ArrayList <Atividade> cronograma) {
		this.cronograma = cronograma;
	}
	
	public void addEvento(Atividade a) {
		this.cronograma.add(a);
	}
		
	@SuppressWarnings("null")
	public ArrayList<Atividade> pesquisaData(String data1, String data2){
		ArrayList<Atividade> listaDividida = null;
		for(int i=0; i < this.cronograma.size();i++) {
			if(this.cronograma.get(i).getData().compareTo(data1) >= 0 || this.cronograma.get(i).getData().compareTo(data2) <= 0 ) {				
				listaDividida.add(this.cronograma.get(i));
			}
		}
		Cronograma.SortAtividade(listaDividida);
		return listaDividida;
	}
	
	public void escreverCronograma(String path) throws IOException { // encapsulamento da classe
		try {
			ManipularCSV.EscreverAtividade(path,this.cronograma);
			System.out.println("Cronograma Gravado");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRO AO GRAVAR CRONOGRAMA!!");
			e.getLocalizedMessage();
		}		
	}
	
	public void lerCronograma(String path) {// encapulamento da classe 
		try {
			ManipularCSV.LeituraAtividade(path, this.cronograma);
			System.out.println("Cronograma preenchido!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AO LER CRONOGRAMA");
			e.getLocalizedMessage();
		}
	}
	
	public static void SortAtividade(ArrayList<Atividade> lista) {
		Collections.sort(lista,new Comparator<Atividade>(				
				) {
					@Override
					public int compare(Atividade ativ1, Atividade ativ2) {
						return ativ1.getData().compareTo(ativ2.getData());
					}
		});
	}
	
	
}
