package codigos;

public class Finado extends Dados {
	private int ID;
	private String dataSepultamento;
	private Contato parente;
	private String descricao;
	
	public Finado(int ID,String nome, String sobrenome,
			String CPF, String dataDeNascimento,String Sepultamento,
			String descricao, Contato parente) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		setParente(parente);
		setDataSepultamento(Sepultamento);
		setDescricao(descricao);
		setID(ID);
	}
	
	public String getDataSepultamento() {
		return this.dataSepultamento;
	}

	public void setDataSepultamento(String dataSepultamento) {
		this.dataSepultamento = dataSepultamento;
	}
	
	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public Contato getParente() {
		return parente;
	}

	public void setParente(Contato parente) {
		this.parente = parente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
