package br.com.exame.aplicacao;





import br.com.exames.bean.Agenda;
import br.com.exames.bean.Cliente;
import br.com.exames.bean.Exame;
import br.com.exames.dao.AgendaDAO;
import br.com.exames.dao.ClienteDAO;
import br.com.exames.dao.ExameDAO;
public class main2 {

	public static void main(String[] args) {


//-------------------------------Tabela Agenda---------------------------------		
		
		AgendaDAO agendaDao = new AgendaDAO();
		
		Agenda agenda = new Agenda();
		
		
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
	}
}
		


