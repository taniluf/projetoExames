package br.com.exames.factory;


import java.sql.Connection;
import java.sql.DriverManager;




public class ConnectionFactory {
	
	//ATENÇÃO Nome do usuario do banco de dados DEVE SER CRIPTOGRAFADO
	private static final String USERNAME = "sa";
	
	//ATENÇÃO Senha do banco DEVE SER CRIPTOGRAFADA
	private static final String PASSWORD = "tania";
	
	//Caminho do banco de dados
	//private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;database=agenda_exames;integratedSecurity=true;";
	
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;database=agenda_exames;";
	
	/*
	 * Conexao com o banco de dados
	 */
	
	public static Connection createConnectionToSQL() throws Exception {
		//Faz com q a conexão seja carregada pela JVM
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Cria a conexao com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
					
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
	       
        //Recuperar conexao com banco de dados
		Connection con = createConnectionToSQL();
		
		//Testar se a conexao é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
		
	}
	
}
		
   



