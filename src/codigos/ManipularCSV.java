package codigos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ManipularCSV {	

	public static void LerContato(String path, ArrayList <Finado> lista) throws FileNotFoundException {
		String csvSqlite = ";";
		String line = "";
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		try {
			while((line = buffRead.readLine())!=null) {
				
				String [] stateStrings = line.split(csvSqlite);
				Contato contato = new Contato(stateStrings[5], stateStrings[6], stateStrings[7],
													stateStrings[8], stateStrings[9], stateStrings[10]);
				int conventendo = Integer.parseInt(stateStrings[0]);
				Finado finado = new Finado(conventendo, stateStrings[1], stateStrings[2], 
														stateStrings[3], stateStrings[4], stateStrings[5], contato);
				
				lista.add(finado);
			}
			
		} catch (Exception e) {
			System.out.println("ERRO LEITURA");
			e.printStackTrace();
		}finally {
			try {
				buffRead.close();
			} catch (Exception e2) {
				System.out.println("ERRO FECHAR ARQUIVO!!");
			}
		}
		
	}	
	public static void EscreverContato (String path, ArrayList <Finado> lista) {
		FileWriter fileWriter = null;
		try {			
			//nome, sobrenome, cpf, data de nascimento, telefone grau de paranteco
			 fileWriter = new FileWriter(path);
//			 fileWriter.append("ID,nome, sobrenome,CPF,dataDeNascimento,telefone,Endereco,Lote,posX,posY\n");
			int tam = lista.size();
			for(int i =0; i < tam; i++) {
				// adiciona o finado
				fileWriter.append(String.valueOf( lista.get(i).getID()));
				fileWriter.append(";");	
				fileWriter.append(lista.get(i).getCPF()); // 0
				fileWriter.append(";");	
				fileWriter.append(lista.get(i).getNome());
				fileWriter.append(";");	
				fileWriter.append(lista.get(i).getSobrenome());
				fileWriter.append(";");	
				fileWriter.append(lista.get(i).getDataDeNascimento());
				fileWriter.append(";");	
				fileWriter.append(lista.get(i).getDataSepultamento());
				fileWriter.append(";");				
				// adiciona o parente responsavel do finado
				fileWriter.append(lista.get(i).Parente.getNome()); // 5
				fileWriter.append(";");		
				fileWriter.append(lista.get(i).Parente.getSobrenome());
				fileWriter.append(";");		
				fileWriter.append(lista.get(i).Parente.getCPF());
				fileWriter.append(";");		
				fileWriter.append(lista.get(i).Parente.getDataDeNascimento());
				fileWriter.append(";");		
				fileWriter.append(lista.get(i).Parente.getTelefone());
				fileWriter.append(";");		
				fileWriter.append(lista.get(i).Parente.getGrauParentesco()); // 10
				fileWriter.append("\n");					
			}
			 
		} catch (Exception e) {
			System.out.println("ERRO ESCRITA!!");
			 e.printStackTrace();
			 
		}finally {
			try { 
				fileWriter.flush();
				fileWriter.close();
				System.out.println("Arquivo atualizado!!!");
			} catch (Exception e) {
				    e.printStackTrace();
			}
		
		}
	}
	
	
	@SuppressWarnings("null")
	public static void EscreverAtividade(String path, ArrayList<Atividade> Lista) throws IOException{
		FileWriter fileWriter = null;		
		
		try {			
			 fileWriter = new FileWriter(path);			
			 // escrendo titulo, data, horario, horario, tipo, descrição
			 int tam =  Lista.size();
			 for(int i = 0; i < tam; i++) {
				fileWriter.append(Lista.get(i).getTitulo());				
				fileWriter.append(";");	
				fileWriter.append(Lista.get(i).getDescricao());
				fileWriter.append(";");	
				fileWriter.append(Lista.get(i).getData());
				fileWriter.append(";");	
				fileWriter.append(Lista.get(i).getHorario());
				fileWriter.append(";");	
				fileWriter.append(Lista.get(i).getTipo());	
				fileWriter.append(";");	
				fileWriter.append("\n");				
			 }	 			 
		} catch (Exception e) {
			System.out.println("ERRO ESCRITA!!");
			 e.printStackTrace();
			 
		}finally {
			try { 
				fileWriter.flush();
				fileWriter.close();
				System.out.println("Arquivo Atividades atualizado!!!");
			} catch (Exception e) {
				    e.printStackTrace();
			}
		
		}
	}
	
	public static void LeituraAtividade(String path, ArrayList<Atividade> Lista) throws IOException {
		String csvSqlite = ",";
		String line = " ";
//		FileReader read = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-16"));

		 try{	
			while((line = buffRead.readLine())  != null) {
				// leitura das atividades
				String [] state = line.split(csvSqlite);
				Atividade ativ = new Atividade(state[0], state[1], state[2],state[3] , state[4]);
				Lista.add(ativ);
			}
			System.out.println("Leitura terminada");
		} catch (Exception e) {
			System.out.println("ERRO AO LER ARQUIVO DE ATIVIDADES");
			e.getLocalizedMessage();
		}finally {
			try {
				buffRead.close();
			} catch (Exception e2) {
				System.out.println("ERRO FECHAR ARQUIVO");
			}
		}	
		
	}

	
		
}
