package codigos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RegistroFinados {
	ArrayList<Finado> registro = null;
	public RegistroFinados(ArrayList<Finado> lista) {
		if(lista != null) {
			registro = lista;
		}
	}

	public static ArrayList<Finado> ordenaLista(ArrayList<Finado> lista, String ordenarPor){
		
		switch(ordenarPor) {
		case "ID":
			Collections.sort(lista, new Comparator<Finado>() {

				@Override
				public int compare(Finado ID1, Finado ID2){
					
					return ID1.getID()> ID2.getID() ? 1:0; // operador tenario
				}
			});
			break;
		case "NOME": 
			Collections.sort(lista, new Comparator<Finado>() {
		        @Override
		        public int compare(Finado fin1, Finado fin2)
		        {

		            return  fin1.getNome().compareTo(fin2.getNome());
		        }
		    });
			
			
			break;
		case "DATANASC":
			Collections.sort(lista, new Comparator<Finado>() {
				@Override
				public int compare(Finado fin1, Finado fin2) {	
					return fin1.getDataDeNascimento().compareTo(fin1.getDataDeNascimento());
				}
			});
			
			break;
		case "DATAFALESC": 
			Collections.sort(lista,new Comparator<Finado>() {

				@Override
				public int compare(Finado fin1, Finado fin2) {
					return fin1.getDataSepultamento().compareTo(fin2.getDataSepultamento());
				}				
				});
			
			break;
		
		}
		
		
		return null;
	}
}