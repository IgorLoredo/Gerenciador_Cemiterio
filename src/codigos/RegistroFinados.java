package codigos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class RegistroFinados {
	public ArrayList<Finado> lista = null;
	private int numRegistrados;
	
	public RegistroFinados() {
		lista = new ArrayList<Finado>();
		numRegistrados = 0;
	}
	
	public RegistroFinados(ArrayList<Finado> lista) {
		if(lista != null) {
			this.lista = lista;
			numRegistrados = lista.size();
		}
	}
	
	public int getNumRegistros() {
		return this.numRegistrados;
	}
	
	public boolean incluirRegistro(Finado reg) {
		if(lista.add(reg)) {
			numRegistrados++;
			return true;
		}
		return false;
	}
	
	public Finado buscaRegristo(String key, String busca) {
		switch (busca) { // pesquisa por nome, id e cpf
		case "ID":
			for(int i =0 ; i < lista.size();i++) {
				if(lista.get(i).getID() == Integer.valueOf(key)) { 
					return lista.get(i);
				}
			}
			break;

		case "NOME":
			for(int i =0; i < this.lista.size();i++) {
				if(this.lista.get(i).getNome().compareTo(key) == 0 ) {
					return lista.get(i);
				}
			}
			break;
			
		case "CPF":
			for(int i =0; i < this.lista.size();i++) {
				if(this.lista.get(i).getCPF().compareTo(key) == 0 ) {
					return lista.get(i);
				}
			}
			break;
		default:
			break;
		}
		return null;
	}

	public static void ordenaLista(ArrayList<Finado> lista, String ordenarPor){
		
		switch(ordenarPor) { // ordenaçção por id, nome e data de nascimento e morte 
		case "ID":
			Collections.sort(lista, new Comparator<Finado>() {

				@Override
				public int compare(Finado ID1, Finado ID2){
					
					return Integer.compare(ID1.getID(), ID2.getID()); // metodo de comparação 
				}
			});
			break;
			
		case "NOME": 
			Collections.sort(lista, new Comparator<Finado>() {
		        @Override
		        public int compare(Finado fin1, Finado fin2){ // 
		        	//  metodos de comparação
		            return  (fin1.getNome()+" "+fin1.getSobrenome()).compareTo(fin2.getNome()+" "+fin2.getSobrenome());
		        } 
		    });			
			break;
			
		case "DATANASC":			
			Collections.sort(lista, new Comparator<Finado>() {
				@Override
				public int compare(Finado fin1, Finado fin2) {	
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		            Date date1 = null;
		            Date date2 = null;
					try {
						date1 = sdf.parse(fin1.getDataDeNascimento());
						date2 = sdf.parse(fin2.getDataDeNascimento());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return date1.compareTo(date2); // metodo de comparação 
				}
			});			
			break;
			
		case "DATAFALEC": 
			Collections.sort(lista,new Comparator<Finado>() {

				@Override
				public int compare(Finado fin1, Finado fin2) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		            Date date1 = null;
		            Date date2 = null;
					try {
						date1 = sdf.parse(fin1.getDataSepultamento());
						date2 = sdf.parse(fin2.getDataSepultamento());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return date1.compareTo(date2);// metodo de comparação 
				}				
				});
			break;
		}
	}
}