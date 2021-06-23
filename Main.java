package br.com.exame.aplicacao;

import br.com.exames.bean.Agenda;
import br.com.exames.bean.Cliente;
import br.com.exames.bean.Exame;
import br.com.exames.dao.AgendaDAO;
import br.com.exames.dao.ClienteDAO;
import br.com.exames.dao.ExameDAO;


public class Main {

	public static void main(String[] args) {

//-------------------------------Tabela Cliente---------------------------------		

		ClienteDAO clienteDao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		
		//Incluir um registro cliente
		cliente.setNumCPF("12545624434");
		cliente.setNomePessoa("Carla Mendes");
		
		clienteDao.save(cliente);
		
		//Visualização dos registros cliente
		
		for(Cliente c : clienteDao.getClientes()) {
			System.out.println("CPF : " +c.getNumCPF() +							
					" Nome : " + c.getNomePessoa());
					
		}
		//Alterar um registro cliente
		Cliente c1 = new Cliente();
		c1.setNomePessoa("Xiquinha");
		c1.setNumCPF("05452356851");//É o CPF q está no banco de dados
		
		clienteDao.update(c1);
		
		//Deletar um registro cliente
		clienteDao.deleteByCPF("12345624434");
		
				
//-------------------------------Tabela Exame---------------------------------		
		ExameDAO exameDao = new ExameDAO();
		
		Exame exame = new Exame();
		
		//Incluir um registro exame
		exame.setCodExame("12000");
		exame.setNomeExame("Imagem");
				
		exameDao.saveExame(exame);
		
		//Visualização dos registros exame
		
		for(Exame c : exameDao.getExames()) {
			System.out.println("Codigo : " +c.getCodExame() + " Exame : " + c.getNomeExame() +
					" Nome Exame : " + c.getNomeExame());
		}
		
		//Alterar um registro exame
		Exame e1 = new Exame();
		e1.setNomeExame("Sangue");
		e1.setCodExame("12645");//É o cod q está no banco de dados
		
		exameDao.updateExame(e1);
		
		//Deletar um registro exame
		exameDao.deleteByCodExame("23456");
		
			
//-------------------------------Tabela Agenda---------------------------------		
		
		AgendaDAO agendaDao = new AgendaDAO();
		
		Agenda agenda = new Agenda();
		
		//Incluir um registro agenda
		agenda.setId(10);
		agenda.setNumCPF("12545624434");
		agenda.setCodExame("12345");
		agenda.setDataExame("20210818");
		agenda.setHoraExame("1239");
		agenda.setObsResultExame("Sem comentarios");
		
				
		agendaDao.saveAgenda(agenda);
		
		//Visualização dos registros  agenda
		
		for(Agenda c : agendaDao.getAgendas()) {
			System.out.println(" Id : " + c.getId() +
					" CPF : "        + c.getNumCPF() +
					" Cliente: "     + c.getNomePessoa() +
					" Cod Exame : "  + c.getCodExame() +
					" Exame : "      + c.getNomeExame() +							
					" Data Exame : " + c.getDataExame() +
					" Hora Exame : " + c.getHoraExame() +
					" Obs. :"        + c.getObsResultExame());
			
		}
		
		//Alterar um registro agenda
		Agenda a1 = new Agenda();
		a1.setDataExame("20210915");
		a1.setHoraExame("1500");
		a1.setObsResultExame("");
		a1.setId(25);//É o Id q está no banco de dados
		
		agendaDao.updateAgenda(a1);
		
		//Deletar um registro agenda
		
		Agenda a2 = new Agenda();
		agenda.setId(2);
		agendaDao.deleteByAgenda(a2);
		
		
	
		
		
	}

}
