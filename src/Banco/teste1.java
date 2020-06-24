package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class teste1 {

	public static void main(String[] args)  {
		
		ConexaoSQLite con = new ConexaoSQLite();
		String banco = "ex.db";
		con.contectar();
		con.descontectar();
		ResultSet resultset = null;
		PreparedStatement prepare = null;

	}

}
