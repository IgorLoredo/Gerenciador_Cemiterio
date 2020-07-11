package codigos;

public class Finado extends Dados {
	Contato contato;
	
	public Finado(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			Contato contato) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		this.contato = contato;
	}

}
