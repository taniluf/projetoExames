<%@page import="br.com.exames.dao.ExameDAO" %>
<jsp:useBean id="a" class="br.com.exames.bean.Exame"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	int i = ExameDAO.salvarExame(a);
	if(i > 0){
		response.sendRedirect("addexamesuccess.jsp");
	}else{
		response.sendRedirect("addexameerror.jsp");
	}
%>