package codigos;


public class Cova extends Dados{
	int posX,posY;
	String Id;
	String Lote;
		
	public Cova(String Nome) {
		super(Nome);
			
	}
	
	public Cova(String Nome,String id, String lote){
		super(Nome);
		this.Lote = lote;
		this.Id = id;
	}
	
	public  String toString() {
		String r = "Nome: " + this.Nome + " "+ this.Sobrenome + "\nCPF: "+
					this.CPF + "\nNome do Familiar: "+ this.NomeParente + "\nEndereco: " + this.Endereco 
					+ "\nData de Nascimento: " + this.DataDeNascimento + "\nTelefone: " + this.Telefone
					+ "\nID: " + this.Id + "\n";	
		return r;
	}
	
	public void setPosX(int pos) {
		this.posX = pos;
	}
	
	public void setPosY(int pos) {
		this.posY = pos;
	}
	
	public void setID(String id) {
		this.Id = id;
	}
	
	public void setLote(String lote) {
		this.Lote = lote;
	}

	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public String getLote() {
		return this.Lote;
	}
	
	public void createID() {
		String nome = this.getLote() + this.getPosX() + this.getPosY();
		setID(nome);
	}
	
	
}
