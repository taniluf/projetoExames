
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Visualização dos agendamentos</title>
</head>
<body>
	<%@ page import="br.com.exames.dao.*, br.com.exames.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
	
	<h1>Listagem de Agendamentos</h1>
	
	<% 
	
	String pageid = request.getParameter("page");
	int id = Integer.parseInt(pageid);
	int total = 20;
	
	if(id==1){}
	else{
		id = id -1;
		id = id * total +1;
	}
	
	
	List<Agenda> list=AgendaDAO.getAllAgendas();
	request.setAttribute("list", list);
	%>

	<table>
		<tr><th>ID</th><th>CPF</th><th>Cod.Exame</th><th>Data</th><th>Hora</th><th>Obs</th></tr>
		<c:forEach items="${list}" var="agenda">
			<tr>
			<td>${agenda.getId()}</td>
			<td>${agenda.getNumCPF()}</td>
			<td>${agenda.getNomePessoa()}</td>
			<td>${agenda.getCodExame()}</td>
			<td>${agenda.getNomeExame()}</td>
			<td>${agenda.getData()}</td>
			<td>${agenda.getHora()}</td>
			<td>${agenda.getObsResultExame()}</td>
			<td><a href="editagendamento.jsp?id=${agenda.getId()}">Editar</a></td>
			<td><a href="deleteagenda.jsp?id=${agenda.getid()}">Excluir</a></td>
		</tr>	
		</c:forEach>
	
	</table>
	
</body>
</html>