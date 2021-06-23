<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do Agendamento</title>
</head>
<body>

	<%@page import="br.com.exames.bean.Agenda, br.com.exames.dao.AgendaDAO" %>
	
	<%
		String id = request.getParameter("id");
		Agenda agenda = AgendaDAO.getRegistroByID(Integer.parseInt(id));
	 %>

</body>

	<h1>Edição do Agendamento</h1>
	
	<form action="editagenda.jsp" method="post">
		<input type="hidden" name="id" value="<%=agenda.getId()%>"/>
		<table>
			<tr>
				<td>CPF: </td>
				<td><output name="numCPF" oninput="<%=agenda.getNumCPF() %>"></output></td> 
			</tr>
			<tr>
			<tr>
				<td>Cod. Exame: </td>
				<td>
					<select name="codExame" >
						<option>00001-Hemograma</option>
						<option>00002-Ultrassom</option>
						<option>00003-Densitometria</option>
						<option>00004-Tomografia</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Data Exame: </td>
				<td><input type="date" name="dataExame" value="<%=agenda.getDataExame() %>"/></td>
			</tr>
			<tr>
				<td>Hora Exame: </td>
				<td><input type="text" name="horaExame" value="<%=agenda.getHoraExame() %>"/></td>
			</tr>
			<tr>
			<td>Obs. Resultado do Exame : </td>
			<td><textarea name="ObsResultExame" rows="3" cols="50"></textarea></td>
		</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar"/></td>
			</tr>
			
			
			
		</table>
	
	
	</form>
	
	
	

</html>








