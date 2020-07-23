package codigos;

public class Finado extends Dados {
	String DataSepultamento;
	

	public Contato Parente;
	
	public Finado(String nome, String sobrenome,
			String CPF, String dataDeNascimento,String Sepultamento,
			Contato contato) 
	{
		super(nome, sobrenome, CPF, dataDeNascimento);
		this.Parente = contato;
		this.DataSepultamento = Sepultamento;
	}
	
	public Finado() {
		
	}
	
	public String getDataSepultamento() {
		return this.DataSepultamento;
	}

	public void setDataSepultamento(String dataSepultamento) {
		this.DataSepultamento = dataSepultamento;
	}
}
