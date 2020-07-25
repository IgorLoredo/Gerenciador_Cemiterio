package codigos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RegistroFinados {
	public ArrayList<Finado> lista = null;
	private int numRegistrados;
	
	public RegistroFinados() {
		lista = new ArrayList<Finado>();
		numRegistrados = 0;
	}
	
	public RegistroFinados(ArrayList<Finado> lista) {
		if(lista != null) {
			lista = lista;
			numRegistrados = lista.size();
		}
	}
	
	public int getNumRegistros() {
		return numRegistrados;
	}
	
	public boolean incluirRegistro(Finado reg) {
		if(lista.add(reg)) {
			numRegistrados++;
			//lista.sort();
			return true;
		}
		return false;
	}

	public static ArrayList<Finado> ordenaLista(ArrayList<Finado> lista, String ordenarPor){
		
		switch(ordenarPor) {
		case "ID":
			Collections.sort(lista, new Comparator<Finado>() {

				@Override
				public int compare(Finado ID1, Finado ID2){
					
					return Integer.compare(ID1.getID(), ID2.getID());
				}
			});
			break;
		case "NOME": 
			Collections.sort(lista, new Comparator<Finado>() {
		        @Override
		        public int compare(Finado fin1, Finado fin2)
		        {

		            return  (fin1.getNome()+" "+fin1.getSobrenome()).compareTo(fin2.getNome()+" "+fin2.getSobrenome());
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