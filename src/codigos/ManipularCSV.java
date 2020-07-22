package codigos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManipularCSV {	
	
	public ManipularCSV() {
		
	}

	public static <E> void leCSV(String nomeArquivo, ArrayList <Cova> lista) {
		try {
			
			
		} catch (Exception e) {
			System.out.println("ERRO LEITURA");
			e.printStackTrace();
		}
		
	}
	
	public static <E> void escreveCSV(String path, ArrayList <Cova> lista) {
		FileWriter fileWriter = null;
		try {			
			 fileWriter = new FileWriter(path);
			 fileWriter.append("ID,nome, sobrenome,CPF,dataDeNascimento,telefone,Endereco,Lote,posX,posY\n");
			 
			 // escrendo
			 for(int i = 0; i < lista.size(); i++) {
				 System.out.println("igor");
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
				System.out.println( Lista.get(i).getTitulo());
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
		String csvSqlite = ";";
		String line = "";
		FileWriter fileWriter = null;		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		
		try {	
			while((line = buffRead.readLine()) != null) {
				// leitura das atividades
				String [] state = line.split(csvSqlite);
				Atividade ativ = new Atividade(state[0], state[1], state[2],state[3] , state[4]);
				Lista.add(ativ);
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				buffRead.close();
			} catch (Exception e2) {
				System.out.println("ERRO FECHAR ARQUIVO");
			}
		}		
		
	}
	
	public static void EscritaFuncionariosCSV(String pathFun, ArrayList<Funcionario> ListaFuncionarios ) {
			FileReader fileRead = null;
			try {
				 fileWriter = new FileWriter(pathFun);
			}
			
		}
		
}
