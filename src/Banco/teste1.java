package Banco;

import java.sql.SQLException;

public class teste1 {

	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException  {
		
		ConexaoSQLite con = new ConexaoSQLite();
		Banco_dados banco = new Banco_dados();
//		con.contectar();
//		con.descontectar();
		banco.criarTabela();
//		String sql = "SELECT * FROM tbl_pessoa " +
//				"WHERE id = ?;";
//		banco.criarPreparedState(sql);
//		ResultSet resultset = null;
//		PreparedStatement prepare = null;
//		
//		Cova cova1 = new Cova("igor");
//		Cova cova2 = new Cova("noem");
//		
//		String sqlInsert = " INSERT INTO tbl_pessoa ("
//				+ "id,"
//				+ "nome,"
//				+ "CPF"
//				+ ") VALUES (?,?,?)"
//				+ ";";
//		
//		PreparedStatement nova = con.criarPreparedState(sqlInsert);
//		nova.setString(1, cova1.getCPF());
//		nova.setString(2,cova1.getNome());
		
	
		
		
		
	}

}
