<%@page import="br.com.exames.dao.AgendaDAO" %>
<jsp:useBean id="a" class="br.com.exames.bean.Agenda"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	int i = AgendaDAO.salvarAgendamento(a);
	if(i > 0){
		response.sendRedirect("addagendamentosuccess.jsp");
	}else{
		response.sendRedirect("addagendamentoerror.jsp");
	}
%>
	