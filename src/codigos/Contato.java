package codigos;

public class Contato extends Dados {
	String telefone;
	String email;
	String grauParentesco;
	
	public Contato() {
		this.telefone = null;
		this.grauParentesco = null;
	}

	public Contato(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			String telefone, String grauParentesco,
			String email) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		this.telefone = telefone;
		this.grauParentesco = grauParentesco;
		this.email = email;
		
	}
	
	public String toString() {
		 String nome = "nome: " + this.nome + " "+ this.sobrenome + "\nCPF: "+
				this.CPF + "\nnome do Familiar: " + "\nData de Nascimento: " 
				+ this.dataDeNascimento + "\ntelefone: "+ this.telefone +"\nEmail: "
					+ this.email +"\nGrau Parentesco: "+  this.grauParentesco;	
		 return nome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGrauParentesco() {
		return this.grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
