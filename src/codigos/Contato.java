package codigos;

public class Contato extends Dados {
	String telefone;
	String grauParentesco;
	
	public Contato() {
		this.telefone = null;
		this.grauParentesco = null;
	}

	public Contato(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			String telefone, String grauParentesco) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		this.telefone = telefone;
		this.grauParentesco = grauParentesco;
		
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

}
