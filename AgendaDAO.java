package br.com.exames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import br.com.exames.bean.Agenda;
import br.com.exames.factory.ConnectionFactory;


public class AgendaDAO {
	
	/*
	 * CRUD
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	
	//CREATE agenda
	public void saveAgenda(Agenda agenda) {
		
		String sql = "SET IDENTITY_INSERT agenda ON INSERT INTO agenda(id, numCPF, codExame, dataExame, horaExame, obsResultExame) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null; 
		PreparedStatement pstm = null;		
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores para a query
			pstm.setInt(1, agenda.getId());
			pstm.setString(2, agenda.getNumCPF());
			pstm.setString(3, agenda.getCodExame());
			pstm.setString(4, agenda.getDataExame());
			pstm.setString(5, agenda.getHoraExame());
			pstm.setString(6, agenda.getObsResultExame());
						
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
	
	//CREATE agendamento atraves da pagina
	public static int salvarAgendamento(Agenda a) {
		
		int status = 0;
		
		String sql = "SET IDENTITY_INSERT agenda ON INSERT INTO agenda(id, numCPF, codExame, dataExame, horaExame, obsResultExame) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null; 
		PreparedStatement pstm = null;		
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores para a query
			pstm.setInt(1, a.getId());
			pstm.setString(2, a.getNumCPF());
			pstm.setString(3, a.getCodExame());
			pstm.setString(4, a.getDataExame());
			pstm.setString(5, a.getHoraExame());
			pstm.setString(6, a.getObsResultExame());
						
			//Executar a query
			//Executar a query
			status = pstm.executeUpdate();
		}catch	(Exception e){
			System.out.println(e);
		}
		return status;
		
	}
	
	//READ agenda
	public List<Agenda> getAgendas() {
	
		String sql = "select  agenda.id, cliente.numCPF, cliente.nomePessoa, exame.codExame, exame.nomeExame, agenda.dataExame, agenda.horaExame, agenda.obsResultExame "
				+ "from agenda "
				+ "inner join cliente  on agenda.numCPF = cliente.numCPF "
				+ "inner join exame  on agenda.codExame = exame.codExame ";
		
				
		List<Agenda> agendas = new ArrayList<Agenda>();
		
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
				Agenda agenda = new Agenda();
				
				//Recuperar id
				agenda.setId(rset.getInt("id"));
				//Recuperar numCPF
				agenda.setNumCPF(rset.getString("numCPF"));
				//Recuperar Nome Pessoa
				agenda.setNomePessoa(rset.getString("nomePessoa"));
				//Recuperar o codExame
				agenda.setCodExame(rset.getString("codExame"));
				//Recuperar Nome Exame
				agenda.setNomeExame(rset.getString("nomeExame"));
				//Recuperar a dataExame
				agenda.setDataExame(rset.getString("dataExame"));
				//Recuperar a horaExame
				agenda.setHoraExame(rset.getString("horaExame"));
				//Recuperar a obsResultExame
				agenda.setObsResultExame(rset.getString("obsResultExame"));
				
				
				agendas.add(agenda);
																			
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
			return agendas;
	}
		
			
					
			
	
		
	//GETALL para a lista toda static pela página
	public static List<Agenda> getAllAgendas(){
		
		String sql = "select  agenda.id, cliente.numCPF, cliente.nomePessoa, exame.codExame, exame.nomeExame, agenda.dataExame, agenda.horaExame, agenda.obsResultExame "
				+ "from agenda "
				+ "inner join cliente  on agenda.numCPF = cliente.numCPF "
				+ "inner join exame  on agenda.codExame = exame.codExame ";
		
				
		List<Agenda> list = new ArrayList<Agenda>();
		
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
				
				Agenda agenda = new Agenda();
				
				//Recuperar id
				agenda.setId(rset.getInt("id"));
				//Recuperar numCPF
				agenda.setNumCPF(rset.getString("numCPF"));
				//Recuperar Nome Pessoa
				agenda.setNomePessoa(rset.getString("nomePessoa"));
				//Recuperar o codExame
				agenda.setCodExame(rset.getString("codExame"));
				//Recuperar Nome Exame
				agenda.setNomeExame(rset.getString("nomeExame"));
				//Recuperar a dataExame
				agenda.setDataExame(rset.getString("dataExame"));
				//Recuperar a horaExame
				agenda.setHoraExame(rset.getString("horaExame"));
				//Recuperar a obsResultExame
				agenda.setObsResultExame(rset.getString("obsResultExame"));
				
				
				list.add(agenda);
				
				extracted(list);
				
			}
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	private static void extracted(List<Agenda> list) {
		Collections.sort(list, CompareNomePessoa());
	}
	
	private static Comparator<Agenda> CompareNomePessoa() {
		return null;
	}
					
	int compare(Agenda c3, Agenda c4) { 
		
		if (c3.getNomePessoa().compareTo(c4.getNomePessoa()) >0) {
			if (c3.getNomeExame().compareTo(c4.getNomeExame()) >0){
					return 1;
			}
					return -1;
		}
			return -1;
	}				
	
	
	
			
	

	

	//Paginação
		public static List<Agenda> getRecords(int start, int total){
			List<Agenda> list = new ArrayList<Agenda>();
			
			String sql = "select  agenda.id, cliente.numCPF, cliente.nomePessoa, exame.codExame, exame.nomeExame, agenda.dataExame, agenda.horaExame, agenda.obsResultExame "
					+ "from agenda "
					+ "inner join cliente  on agenda.numCPF = cliente.numCPF "
					+ "inner join exame  on agenda.codExame = exame.codExame "
					+ (start)+ ","+total;
			
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
				
				
				
				while(rset.next()) {
					
					Agenda agenda = new Agenda();
					
					//Recuperar id
					agenda.setId(rset.getInt("id"));
					//Recuperar numCPF
					agenda.setNumCPF(rset.getString("numCPF"));
					//Recuperar Nome Pessoa
					agenda.setNomePessoa(rset.getString("nomePessoa"));
					//Recuperar o codExame
					agenda.setCodExame(rset.getString("codExame"));
					//Recuperar Nome Exame
					agenda.setNomeExame(rset.getString("nomeExame"));
					//Recuperar a dataExame
					agenda.setDataExame(rset.getString("dataExame"));
					//Recuperar a horaExame
					agenda.setHoraExame(rset.getString("horaExame"));
					//Recuperar a obsResultExame
					agenda.setObsResultExame(rset.getString("obsResultExame"));
					
					
					list.add(agenda);
					
										
					
				}
				conn.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			return list;
		}
	
	//Get para um agendamento selecionado pela página
		public static Agenda getRegistroByID(int id){
			
			Agenda agenda = null;
			
			String sql = "SELECT * FROM agenda WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			//Classe que vai recuperar os dados do banco
			ResultSet rset = null;
						
			try {
				//Criar uma conexao com o banco de dados
				conn = ConnectionFactory.createConnectionToSQL();
				
				//Criamos uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				//Adiciona valor
				pstm.setInt(1, id);
				rset = pstm.executeQuery();
 
				while(rset.next()) {
					
					agenda = new Agenda();
					
					//Recuperar id
					agenda.setId(rset.getInt("id"));
					//Recuperar numCPF
					agenda.setNumCPF(rset.getString("numCPF"));
					//Recuperar o nomeExame
					agenda.setCodExame(rset.getString("codExame"));
					//Recuperar a dataExame
					agenda.setDataExame(rset.getString("dataExame"));
					//Recuperar a horaExame
					agenda.setHoraExame(rset.getString("horaExame"));
					//Recuperar a obsResultExame
					agenda.setObsResultExame(rset.getString("obsResultExame"));
					
				}
			}catch (Exception e) {
				System.out.println(e);
			}
				return agenda;
		}
				
			
	//UPDATE agenda
	public void updateAgenda(Agenda agenda) {
		String sql = "UPDATE agenda SET dataExame = ?, horaExame = ?, obsResultExame = ? "+ 
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, agenda.getDataExame());
			pstm.setString(2, agenda.getHoraExame());
			pstm.setString(3, agenda.getObsResultExame());
			pstm.setInt(4, agenda.getId());
			
			
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
	
	//UPDATE agenda pela pagina
	public static int updateAgendaPag(Agenda a) {
		int status = 0;
		
		String sql = "UPDATE agenda SET codExame = ?, dataExame = ?, horaExame = ?, obsResultExame = ? "+ 
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setString(1, a.getCodExame());
			pstm.setString(2, a.getDataExame());
			pstm.setString(3, a.getHoraExame());
			pstm.setString(4, a.getObsResultExame());
			pstm.setInt(5, a.getId());
						
			//Executar a query
			status = pstm.executeUpdate();
		}catch	(Exception e){
			System.out.println(e);
		}
		return status;
		
	}
		
	


	//DELETE
	public void deleteByAgenda(Agenda agenda) {
		
		String sql = "DELETE FROM cliente WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setInt(1, agenda.getId());
			
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
	
	
	
	//Deletar agendamento através da página
	public static int deletarAgenda(Agenda a) {
		
		int status = 0;
			
		String sql = "DELETE FROM cliente WHERE id = ?";
			
		Connection conn = null;
		PreparedStatement pstm = null;
			
			
			
		try {
			//Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToSQL();
			
			//Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setInt(1, a.getId());
				
			//Executar a query
			status=pstm.executeUpdate();
				
		}catch	(Exception e){
			System.out.println(e);	
			}
			return status;
		}
	}
	





	


			
		
		
	
		
		
	
	
		
	
	
	

