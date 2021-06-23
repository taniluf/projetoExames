package br.com.exames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import br.com.exames.bean.Cliente;
import br.com.exames.factory.ConnectionFactory;

public class ClienteDAO {
	
	/*
	 * CRUD
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	
	//CREATE cliente
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO cliente(numCPF, nomePessoa) "
				+ "VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores para a query
			pstm.setString(1, cliente.getNumCPF());
			pstm.setString(2, cliente.getNomePessoa());
									
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

	//CREATE cliente pagina
		public static int salvarCliente(Cliente a) {
			
			int status = 0;
			
			String sql = "INSERT INTO cliente(numCPF, nomePessoa) "
					+ "VALUES (?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;		
			
			try {
				//Criar uma conexao com o banco de dados
				conn = ConnectionFactory.createConnectionToSQL();
				
				//Criamos uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				//Adicionar os valores para a query
				pstm.setString(1, a.getNumCPF());
				pstm.setString(2, a.getNomePessoa());
										
				//Executar a query
				status=pstm.executeUpdate();
				
			}catch (Exception e) {
				System.out.println(e);
			}
			return status;
			
		}
		
		
	//READ cliente
	public List<Cliente> getClientes() {
	
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
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
				Cliente cliente = new Cliente();
				
				//Recuperar numCPF
				cliente.setNumCPF(rset.getString("numCPF"));
				//Recuperar o nomePessoa
				cliente.setNomePessoa(rset.getString("nomePessoa"));
								
				clientes.add(cliente);
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
			return clientes;
		}
	
	//UPDATE cliente
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nomePessoa = ? "+ 
		"WHERE numCPF = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, cliente.getNomePessoa());
			pstm.setString(2, cliente.getNumCPF());
			
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

	//DELETE cliente
	public void deleteByCPF(String numCPF) {
		
		String sql = "DELETE FROM cliente WHERE numCPF = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, numCPF);
			
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





	


			
		
		
	
		
		
	
	
		
	
	
	

