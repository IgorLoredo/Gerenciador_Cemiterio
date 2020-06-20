package codigos;

public abstract class Funcionario extends Dados{
	private boolean ativo = true;
	private String ID;
	private String dataContratacao;
	
	
	Funcionario(String Nome) {
		super(Nome);
	}

}
