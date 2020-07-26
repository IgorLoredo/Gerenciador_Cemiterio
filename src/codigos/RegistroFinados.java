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
		return this.numRegistrados;
	}
	
	public boolean incluirRegistro(Finado reg) {
		if(lista.add(reg)) {
			numRegistrados++;
			//RegistroFinados.ordenaLista(this.lista, "ID");
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("null")
	public ArrayList<Finado> buscaRegristo(String key, String busca, int id) {
		ArrayList<Finado> listaretono = null;
		switch (busca) {
		case "ID":
			for(int i =0; i < this.lista.size();i++) {
				if(this.lista.get(i).getID() == id ) {
					listaretono.add(this.lista.get(i));
					return listaretono;
				}
			}
			break;

		case "NOME":
			for(int i =0; i < this.lista.size();i++) {
				if(this.lista.get(i).getNome().compareTo(key) == 0 ) {
					listaretono.add(this.lista.get(i));
					return listaretono;
				}
			}
			break;
			
		case "Cs":
			for(int i =0; i < this.lista.size();i++) {
				if(this.lista.get(i).getCPF().compareTo(key) == 0 ) {
					listaretono.add(this.lista.get(i));
					return listaretono;
				}
			}
			break;
		default:
			break;
		}
		return listaretono;
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
					return fin1.getDataDeNascimento().compareTo(fin2.getDataDeNascimento());
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