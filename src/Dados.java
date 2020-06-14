
public class Dados {
	String Nome;
	String Sobrenome;
	String CPF;
	String NomeParente;
	String Endereco;
	String DataDeNascimento;
	int Telefone;
	
	Dados(String Nome){
		this.Nome = Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public void setSobrenome(String Sobrenome) {
		this.Sobrenome = Sobrenome;
	}
	
	public void setCPF(String CPF) { 
		this.CPF = CPF;
	}
	
	public void setNomeParente(String Parente) {
		this.NomeParente = Parente;
	}
	
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}
	
	public void setDataDeNascimento(String Data) {
		this.DataDeNascimento = Data;
	}
	
	public void setTelefone(int telefone) {
		this.Telefone = telefone;
	}
	
	public String getNome() {
		return this.Nome;
	}
	
	public String getSobrenome() {
		return this.Sobrenome;
	}

	public String getCPF() {
		return this.CPF;
	}
	
	public String getNomeParente() {
		return this.NomeParente;
	}
	
	public String getEndereco() {
		return this.Endereco;
	}
	
	public String setDataDeNascimento() {
		return this.DataDeNascimento;
	}
	
	public int getTelefone() {
		return this.Telefone;
	}
	
}
