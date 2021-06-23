package br.com.exames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import br.com.exames.bean.Exame;
import br.com.exames.factory.ConnectionFactory;

public class ExameDAO {
	
	/*
	 * CRUD
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	
	//CREATE exame
	public void saveExame(Exame exame) {
		
		String sql = "INSERT INTO exame(codExame, nomeExame) "
				+ "VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores para a query
			pstm.setString(1, exame.getCodExame());
			pstm.setString(2, exame.getNomeExame());
			
						
			//Executar a query
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		
			
		}finally {
			//Fechar as conexoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	//CREATE exame pela ágina
		public static int  salvarExame(Exame a) {
			
			int status = 0;
			
			String sql = "INSERT INTO exame(codExame, nomeExame) "
					+ "VALUES (?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;	
						
			try {
				//Criar uma conexao com o banco de dados
				conn = ConnectionFactory.createConnectionToSQL();
				
				//Criamos uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				//Adicionar os valores para a query
				pstm.setString(1, a.getCodExame());
				pstm.setString(2, a.getNomeExame());
				
							
status=pstm.executeUpdate();
				
			}catch (Exception e) {
				System.out.println(e);
			}
			return status;
			
		}
		
	

		
		
	//READ exame
	public List<Exame> getExames(){
		
		String sql = "SELECT * FROM exame";
		
		List<Exame> exames = new ArrayList<Exame>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Exame exame = new Exame();
				
				//Recuperar codExame
				exame.setCodExame(rset.getString("codExame"));
				//Recuperar o nomeExame
				exame.setNomeExame(rset.getString("nomeExame"));
								
				exames.add(exame);
			}				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//Fechar as conexoes
				try {
					if(rset != null) {
						rset.close();
					}
					if(pstm !=null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return exames;
		}
	
	//UPDATE exame
	public void updateExame(Exame exame) {
		String sql = "UPDATE exame SET nomeExame = ?"+ 
		"WHERE codExame = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, exame.getNomeExame());
			pstm.setString(2, exame.getCodExame());
			
			
			//Executar a query
			pstm.execute();
			
		}catch	(Exception e){
			e.printStackTrace();
		}finally	{
			//Fechar as conexoes
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	//DELETE exame
	public void deleteByCodExame(String codExame) {
		
		String sql = "DELETE FROM exame WHERE codExame = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, codExame);
			
			//Executar a query
			pstm.execute();
			
		}catch	(Exception e){
			e.printStackTrace();
		}finally	{
			//Fechar as conexoes
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	}





	


			
		
		
	
		
		
	
	
		
	
	
	


