package codigos;

public class Endereco {
	private String estado;
	private String cidade;
	private String rua;
	private String num;
	
	public Endereco(String estado, String cidade, String rua, String num) {
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.num = num;;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
