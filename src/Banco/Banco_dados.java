package Banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_dados {
	
	
	private String NOME_TABELA;
	
	public Boolean criarBanco(String nomeBanco, String tabela) {
		String sql = "CREATE TABLE IF NOT EXISTS " +
						this.NOME_TABELA
						+ "(" 
						+ "id text PRIMARY KEY,"
						+ "nome";
		return true;
	}
	
	
	
	public String getNOME_TABELA() {
		return this.NOME_TABELA;
	}
	
	public void setNOME_TABELA(String nOME_TABELA) {
		this.NOME_TABELA = nOME_TABELA;
	}
	

	
	
}

public void criarTabela() {
	// criando a tabela
	String sql = "CREATE TABLE IF NOT EXISTS tbl_pessoa"
			+ "("
			+ "id integer PRIMARY KEY,"
			+ "nome text NOT NULL,"
			+ "idpro integer"
			+ ");";
	/// comegar agora
	boolean contectou = false;
	try {
		contectou = this.con1.contectar();
		Statement stmt = this.con1.CriarStatement();
		stmt.execute(sql);
		System.out.println("banco foi criado");
	} catch (SQLException e) {
			
	}finally {
		if(contectou) {
			this.con1.descontectar();
		}
	}
	
	
	
public class BancoDados extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final String NOME_TABELA = "usuario";
    public static final int VERSAO_BANCO = 1;

    public BancoDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);

    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table if not exists " +
                "usuario(_id integer primary key autoincrement, " +
                "nome text not null," +
                "login text not null," +
                " senha text not null," +
                " email text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {

    }
}