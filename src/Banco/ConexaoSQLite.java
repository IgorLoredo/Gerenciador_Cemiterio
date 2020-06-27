package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;  


public class ConexaoSQLite {
	 Connection conecao;
	 // conctando ao banco de dados passando o nome do arquivo
	 public boolean contectar() {
		
		 try { 		
				 String url = "jdbc:sqlite:banco_dados/banco.db";
				 this.conecao = DriverManager.getConnection(url);
				 System.out.println("Conectando banco ...");					 
	
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.out.println("Erro ao conectar com banco de dados...");
			return false;
		}
		 
		return true;
	 }
	 
	 // desconando do bando sem passar o nome
	 public boolean descontectar() {
		 try {
			if(this.conecao.isClosed() == false) {
				this.conecao.close();
			}
			System.out.println("Desconectando ...");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		 
		 return true;
	 }
	 
		/// é o criar o sql
	@SuppressWarnings("exports")
	public Statement criarStatement() {
		try {
				return this.conecao.createStatement();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("exports")
	public PreparedStatement criarPreparedState(String sql) {
		try {
			return this.conecao.prepareStatement(sql);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public  Connection getConcecao() {
		return this.conecao;
	}
	
}
