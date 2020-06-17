


public class Cova extends Dados{
	int posX,posY;
	String Id;
	String Lote;
		
	Cova(String Nome) {
		super(Nome);
		
	}
	
	public  String toString() {
		String r = "Nome: " + this.Nome + " "+ this.Sobrenome + "\nCPF: "+
					this.CPF + "\nNome do Familiar: "+ this.NomeParente + "\nEndereco: " + this.Endereco 
					+ "\nData de Nascimento: " + this.DataDeNascimento + "\nTelefone: " + this.Telefone
					+ "\nID: " + this.Id + "\n";	
		return r;
	}
	
	
	

}
