package codigos;

public abstract class Funcionario extends Dados{
	private boolean ativo = false;	
	private String dataContratacao;
	String telefone;
	Endereco endereco;
	
	public Funcionario(String nome, String sobrenome,
			String CPF, String dataDeNascimento,
			String telefone, String estado,
			String cidade, String rua, String num) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		endereco = new Endereco(estado, cidade, rua, num);
		
	}
	
	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDataContratacao() {
		return this.dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	

}
