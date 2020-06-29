package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import codigos.Cova;

public class teste1 {

	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException  {
		
		ConexaoSQLite con = new ConexaoSQLite();
		Banco_dados banco = new Banco_dados();
		String tbFuncionarios = "funcionarios";
		String tbPessoa = "tbl_pessoa";
		banco.criarTabela(tbFuncionarios); 
		banco.criarTabela(tbPessoa); 
		
//		String sql = "SELECT * FROM tbl_pessoa " +
//				"WHERE id = ?;";
//		
//		banco.criarPreparedState(sql);
		
		ResultSet resultset = null;
		PreparedStatement prepare = null;
		
		Cova cova1 = new Cova("igor");
		Cova cova2 = new Cova("noem");
		cova1.setCPF("1111");
		
		String sqlInsert = " INSERT INTO tbl_pessoa ("
				+ "id,"
				+ "nome,"
				+ "Sobrenome,"
				+ "CPF,"
				+ "NomeParente,"
				+ "DataNascimento,"
				+ "Endereco,"
				+ "Lote,"
				+ "PosX,"
				+ "PosY,"				
				+ "DataEnterro,"
				+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?)"
				+ ";";		
				
		PreparedStatement nova = con.criarPreparedState(sqlInsert);
		nova.setString(1, cova1.getCPF());
		nova.setString(2,cova1.getNome());
		nova.setString(3, cova1.getCPF());
		nova.setString(4, cova1.getCPF());
		nova.setString(5, cova1.getCPF());
		nova.setString(6, cova1.getCPF());
		nova.setString(7, cova1.getCPF());
		nova.setString(8, cova1.getCPF());
		
				
		nova.executeUpdate();
	}

}
