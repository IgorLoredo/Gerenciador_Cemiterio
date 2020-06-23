package codigos;

public abstract class Funcionario extends Dados{
	private boolean ativo = true;
	private String ID;	
	private String dataContratacao;
	
	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public String getID() {
		return this.ID;
	}


	public void setID(String iD) {
		this.ID = iD;
	}


	public String getDataContratacao() {
		return this.dataContratacao;
	}


	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}



	
	
	Funcionario(String Nome) {
		super(Nome);
	}

}
