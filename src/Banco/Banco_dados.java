package Banco;

import java.sql.SQLException;
import java.sql.Statement;

public class Banco_dados {
	
	private final ConexaoSQLite conxaoSQLite = new ConexaoSQLite();

	public ConexaoSQLite getConxaoSQLite() {
		return conxaoSQLite;
	}
	
	@SuppressWarnings("exports")
	public Statement criarPreparedState(String sql) {
		return this.conxaoSQLite.criarPreparedState(sql);
	}
	
	public Boolean criarTabela(String tabela) {
		// criando tabela
		String sql = "CREATE TABLE IF NOT EXISTS " + tabela
						+ "(" 
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
						+ "DataEnterro integer"
						+ ");";
		
		boolean contectou = false;
		try {

			contectou = this.conxaoSQLite.contectar();
			Statement stmt = this.conxaoSQLite.criarStatement();
			stmt.execute(sql);
			System.out.println("Banco criado com a tabela " +tabela);
			
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


