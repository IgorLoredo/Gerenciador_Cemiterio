package codigos;

public class Contato extends Dados {
	String telefone;
	String grauParentesco;
	Endereco endereco;
	
	public Contato(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			String telefone, String grauParentesco, String estado,
			String cidade, String rua, String num) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		this.telefone = telefone;
		this.grauParentesco = grauParentesco;
		endereco = new Endereco(estado, cidade, rua, num);
		
	}

}
