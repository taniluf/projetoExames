<%@page import="br.com.exames.dao.AgendaDAO" %>
<jsp:useBean id="a" class="br.com.exames.bean.Agenda"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
int i = AgendaDAO.updateAgendaPag(a);
response.sendRedirect("viewAgenda.jsp");
%>