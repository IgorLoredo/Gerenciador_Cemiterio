package codigos;

public class Finado extends Dados {
	public int ID;
	String DataSepultamento;
	public Contato Parente;
	
	public Finado(int ID,String nome, String sobrenome,
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
	
	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}
}
