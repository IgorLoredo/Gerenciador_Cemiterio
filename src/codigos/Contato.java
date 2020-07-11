package codigos;

public class Contato extends Dados {
	String telefone;
	Endereco endereco;
	
	public Contato(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			String telefone, String estado,
			String cidade, String rua, String num) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		endereco = new Endereco(estado, cidade, rua, num);
		
	}

}
