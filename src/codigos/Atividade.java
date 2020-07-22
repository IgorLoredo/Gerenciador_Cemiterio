package codigos;

import java.io.IOException;

public class Atividade {
	private String titulo;
	private String descricao;
	private String data;
	private String horario;
	private String tipo;
	
	public Atividade(String titulo, String descricao, String data, String horario, String tipo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
		this.tipo = tipo;
	}
	
	
	public void preenherAtividade() throws IOException {
		String aux;
		System.out.println("Titulo: ");
		aux = EntradaTeclado.leString();
		this.titulo = aux;
		
		System.out.println("Descrição: ");
		aux = EntradaTeclado.leString();
		this.descricao = aux;
		
		System.out.println("Data: ");		
		aux = EntradaTeclado.leString();
		this.data = aux;
		
		System.out.println("Horario: ");
		aux = EntradaTeclado.leString();
		this.horario = aux;
		
		System.out.println("Tipo: ");
		aux = EntradaTeclado.leString();
		this.tipo = aux;
		
	}
	
	
	public String getTitulo() {
		return this.titulo;
	}


	public String getDescricao() {
		return this.descricao;
	}


	public String getData() {
		return this.data;
	}


	public String getHorario() {
		return this.horario;
	}


	public String getTipo() {
		return this.tipo;
	}
	
}
