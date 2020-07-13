package codigos;

public abstract class Dados {
	String nome;
	String sobrenome;
	String CPF;
	String dataDeNascimento;
	
	Dados(String nome, String sobrenome, String CPF, String dataDeNascimento){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.CPF = CPF;
		this.dataDeNascimento = dataDeNascimento;
	}


	public  String toString() {
		String r = "nome: " + this.nome + " "+ this.sobrenome + "\nCPF: "+
				this.CPF + "\nnome do Familiar: " + "\nData de Nascimento: " 
				+ this.dataDeNascimento + "\ntelefone: ";	
		return r;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public void setCPF(String CPF) { 
		this.CPF = CPF;
	}

	public void setDataDeNascimento(String Data) {
		this.dataDeNascimento = Data;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getCPF() {
		return this.CPF;
	}
	
	public String getDataDeNascimento() {
		return this.dataDeNascimento;
	}
		
}