package Banco;

import java.sql.SQLException;
import java.sql.Statement;

public class Banco_dados {
	
	private ConexaoSQLite conxaoSQLite;

	private static String NOME_TABELA;
	
	public ConexaoSQLite getConxaoSQLite() {
		return conxaoSQLite;
	}
	
	public String getNOME_TABELA() {
		return Banco_dados.NOME_TABELA;
	}
	
	public void setNOME_TABELA(String nOME_TABELA) {
		Banco_dados.NOME_TABELA = nOME_TABELA;
	}
	
	@SuppressWarnings("exports")
	public Statement criarPreparedState(String sql) {
		return this.conxaoSQLite.criarPreparedState(sql);
	}
	
	public Boolean criarTabela(String tabela) {
		setNOME_TABELA(tabela);
		String sql = "CREATE TABLE IF NOT EXISTS " +
						Banco_dados.NOME_TABELA
						+ " (" 
						+ "id text PRIMARY KEY,"
						+ "Nome text NOT NULL,"
						+ "Sobrenome text NOT NULL,"
						+ "CPF text NOT NULL,"
						+ "NomeParente text NOT NULL,"
						+ "DataNascimento text NOT NULL,"
						+ "Endereco text NOT NULL,"
						+ "Lote text NOT NULL,"
						+ "PosX integer,"
						+ "PosY integer,"
						+ "DataEnterro integer,"
						+ ");";
		
		boolean contectou = false;
		try {
			contectou = this.conxaoSQLite.contectar();
			Statement stmt = this.conxaoSQLite.criarStatement();
			stmt.execute(sql);
			System.out.println("Banco criado "+ "com a tabela"+ tabela);
		} catch (SQLException e) {
			return false;
			
		}finally {
			if(contectou) {
				this.conxaoSQLite.descontectar();
			}
		}
		
		return true;
	}
	
		
	
}


