package codigos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ManipularCSV {	

	public static void LeituraCSVFinados(String path, 
			RegistroFinados reg) throws FileNotFoundException {
		
		String line = "";
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		try {
			while((line = buffRead.readLine())!=null) {
				if(line.equals("")) break;
				String [] stateStrings = line.split(";");
				// Le campos do CSV e instancia um registro de finado
				Finado finado = new Finado(
						Integer.parseInt(stateStrings[0]), stateStrings[1], stateStrings[2], 
						stateStrings[3], stateStrings[4], stateStrings[5], stateStrings[6], 
						new Contato(
								stateStrings[7], stateStrings[8],
								stateStrings[9], stateStrings[10], 
								stateStrings[11], stateStrings[12],
								stateStrings[13])
						);
				
				reg.incluirRegistro(finado);
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
	
	public static void EscreverCSVFinados (String path, ArrayList <Finado> lista) throws IOException {
		FileWriter fileWriter = null;			
		//nome, sobrenome, cpf, data de nascimento, telefone grau de paranteco
		fileWriter = new FileWriter(path);

		for(Finado fin : lista) {
			// adiciona o finado
			fileWriter.append(String.valueOf( fin.getID()));
			fileWriter.append(";");	
			fileWriter.append(fin.getNome());
			fileWriter.append(";");	
			fileWriter.append(fin.getSobrenome());
			fileWriter.append(";");	
			fileWriter.append(fin.getCPF());
			fileWriter.append(";");	
			fileWriter.append(fin.getDataDeNascimento());
			fileWriter.append(";");	
			fileWriter.append(fin.getDataSepultamento());
			fileWriter.append(";");				
			fileWriter.append(fin.getDescricao());
			fileWriter.append(";");	
				
			// Adiciona o parente responsavel do finado
			fileWriter.append(fin.parente.getNome());
			fileWriter.append(";");		
			fileWriter.append(fin.parente.getSobrenome());
			fileWriter.append(";");		
			fileWriter.append(fin.parente.getCPF());
			fileWriter.append(";");		
			fileWriter.append(fin.parente.getDataDeNascimento());
			fileWriter.append(";");		
			fileWriter.append(fin.parente.getTelefone());
			fileWriter.append(";");		
			fileWriter.append(fin.parente.getGrauParentesco());
			fileWriter.append(";");	
			fileWriter.append(fin.parente.getEmail());
			fileWriter.append("\n");					
		}
		try { 
			fileWriter.flush();
			fileWriter.close();
			System.out.println("Arquivo atualizado");
		} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Erro ao fechar arquivo");
		}
		
	}	
	
	@SuppressWarnings("null")
	public static void EscreverAtividade(String path, ArrayList<Atividade> Lista) throws IOException{
		FileWriter fileWriter = null;		
		
		try {			
			 fileWriter = new FileWriter(path);			
			 // escrendo titulo, data, horario, horario, tipo, descri��o
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
