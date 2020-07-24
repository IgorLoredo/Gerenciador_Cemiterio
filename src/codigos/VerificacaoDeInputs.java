package codigos;

import java.io.IOException;
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
		boolean stringValida = false;
		
		
		return stringValida;
	}
	
	//Utiliza expressões regulares para verificar se um documento eh valido
	public static boolean verificaDocumento(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no documento
		
		
		return stringValida;
	}
	
	//Utiliza expressões regulares para verificar se uma data eh valida
	public static boolean verificaData(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no documento
		
		
		return stringValida;
	}
	
	
	// Utiliza expressões regulares para verificar se um email eh valido
	public static boolean verificaEmail(String s) {
		boolean stringValida = false;
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
		
		return stringValida;
	}
	
	public static boolean verificaTelefone(String s) {
		boolean stringValida = false;
		// Verifica se existe algum caracter nao numerico no telefone
		
		
		return stringValida;
	}
}
