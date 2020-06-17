
public class Lote extends Cova{
	String IDLote;
	int MaxQuantCovas;
	int LotacaoAtual;
	
	Lote(String Nome) {
		super(Nome);
		this.IDLote = Nome;
	}
	
	Lote(int Quant){
		this.MaxQuantCovas = Quant;
	}

}
