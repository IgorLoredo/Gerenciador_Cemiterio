package codigos;

import java.io.IOException;
import java.util.regex.Pattern;

public class VerificacaoDeInputs {

	public VerificacaoDeInputs() {
		
	}
	
	/*
	 *  Utiliza express천es regulares para verificar se
	 *  um nome ou sobrenome eh valido
	 */
	public static boolean verificaNome(String s) {
		// Verifica se existe algum caracter nao alfabetico no nome
		boolean stringValida = false;
		if(Pattern.compile("[0-9\\._!@#$%�&*()_�={}?:/;><,]").matcher(s).find()) {
			stringValida =true;
			return stringValida;
		}
		
		return stringValida;
	}
	
	//Utiliza express천es regulares para verificar se um documento eh valido
	public static boolean verificaDocumento(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no documento
		if(!Pattern.compile("^([0-9])\\w+").matcher(s).find()) {
			stringValida =true;
			return stringValida;
		}
		
		return stringValida;
	}
	
	//Utiliza express천es regulares para verificar se uma data eh valida
	public static boolean verificaData(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no documento
		if(!Pattern.compile("^([0-9])\\w+").matcher(s).find()) {
			stringValida =true;
			return stringValida;
		}		
		return stringValida;
	}
	
	
	// Utiliza express천es regulares para verificar se um email eh valido
	public static boolean verificaEmail(String s) {
		boolean stringValida = false;
		String sep = "@";
		
		Pattern separador = Pattern.compile(sep);
		String[] lista = separador.split(s);
		
		// Procura um caractere especial invalido na primeira parte do email
		boolean primeiraParte = Pattern.matches("^[-.@_a-z0-9]+$/gi", lista[0]);
		boolean segundaParte = Pattern.matches("^[-.@_a-z0-9]+$/gi", lista[1]);
		// Separa a segunda parte. Ex.: gmail.com -> (gmail) (com)
		
		/*
		 *  Verifica se as duas partes possuem apenas caracteres
		 *  alfabeticos minusculos
		 */			
		if(primeiraParte || segundaParte){			
			stringValida = true;
		}
			
		return stringValida;
	}
	
	public static boolean verificaTelefone(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no telefone
		if(!Pattern.compile("^([0-9])\\w+").matcher(s).find()) {
			stringValida =true;
			return stringValida;
		}				
		return stringValida;
	}
}
