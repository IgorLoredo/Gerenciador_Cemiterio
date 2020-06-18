
public class Lote extends Cova{
	String IDLote;
	int MaxQuantCovas;
	int LotacaoAtual;
	
	Lote(String Nome) {
		super(Nome);
		this.IDLote = Nome;
		// padrao
		this.MaxQuantCovas = 100;
		this.LotacaoAtual = 0;
	}
	
	Lote(String IDLote,int Quant){
		super(IDLote);
		this.MaxQuantCovas = Quant;
		this.LotacaoAtual = 0;
	}

	public void setIDlote(String id) {
		this.IDLote =id;
	}
	
	public void setMaxQuantCovas(int max) {
		this.MaxQuantCovas = max;
	}
	
	public void setLotacaoAtual(int atual) {
		this.LotacaoAtual =  atual;
	}
	
	public String getIDLOTE() {
		return this.IDLote;
	}
	
	public int getMaxQuantCovas() {
		return this.MaxQuantCovas;
	}
	
	public int getLotacaoAtual() {
		return this.LotacaoAtual;
	}
	
}
