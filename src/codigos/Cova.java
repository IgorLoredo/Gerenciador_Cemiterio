package codigos;

public class Cova{
	Finado finado;
	int posX,posY;
	String Id;
	String Lote;
		
	public Cova(Finado user,int posX,int posY) {
			this.finado = user;
			this.posX = posX;
			this.posY = posY;
	}
	
	public Cova(String Nome,String id, String lote){
		this.Lote = lote;
		this.Id = id;
	}
	
	@Override
	public String toString() {
		/*String r = "Nome: " + this.nome + " "+ this.sobrenome + "\nCPF: "+
					this.CPF + "\nNome do Familiar: " + "\nEndereco: " + this.endereco 
					+ "\nData de Nascimento: " + this.dataDeNascimento + "\nTelefone: " + this.telefone
					+ "\nID: " + this.Id + "\n";*/
		return "";
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
