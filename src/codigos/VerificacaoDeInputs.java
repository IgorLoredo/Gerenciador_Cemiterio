package codigos;

import java.util.regex.Pattern;

public class VerificacaoDeInputs {

	public VerificacaoDeInputs() {
		
	}
	
	/*
	 *  Utiliza expressões regulares para verificar se
	 *  um nome ou sobrenome eh valido
	 */
	public static boolean verificaNome(String s) {
		// Verifica se existe algum caracter nao alfabetico no nome
		
		return false;
	}
	
	//Utiliza expressões regulares para verificar se um documento eh valido
	public static boolean verificaDocumento(String s) {
		// Verifica se existe algum caracter nao numerico no documento
		
		return false;
	}
	
	
	// Utiliza expressões regulares para verificar se um email eh valido
	public static boolean verificaEmail(String s) {
		String sep = "@";
		
		Pattern separador = Pattern.compile(sep);
		String[] lista = separador.split(s);
		
		// Procura um caractere especial invalido na primeira parte do email
		boolean primeiraParte = Pattern.matches("//W", lista[0]);
		
		// Separa a segunda parte. Ex.: gmail.com -> (gmail) (com)
		
		/*
		 *  Verifica se as duas partes possuem apenas caracteres
		 *  alfabeticos minusculos
		 */
		
		
		return (!primeiraParte);
	}
}
