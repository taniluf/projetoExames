<%@page import="br.com.exames.dao.ClienteDAO" %>
<jsp:useBean id="a" class="br.com.exames.bean.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	int i = ClienteDAO.salvarCliente(a);
	if(i > 0){
		response.sendRedirect("addclientesuccess.jsp");
	}else{
		response.sendRedirect("addclienteerror.jsp");
	}
%>