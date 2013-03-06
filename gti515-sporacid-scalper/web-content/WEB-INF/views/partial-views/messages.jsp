<%@page import="sporacidscalper.controller.viewcontroller.util.ApplicationMessages"%>
<%@page import="java.util.List"%>
<%
	List<String> messages = ApplicationMessages.obtenirMessages(request);
%>

<div class="application-messages">
	
	<div class="application-messages-header">
		Veuillez prendre note des messages suivants
		<div class="generic-button application-messages-close-button">
			&nbsp;
		</div>
	</div>
	
	<table><tr><td>
	
		<% for(String message : messages) { %>
			<div class="application-message"><%=message %></div>
		<% } %>
	
	</td></tr></table>
	
</div>