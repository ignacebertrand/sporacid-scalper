<%
	String[] messages = new String[] { "message1", "message2", "message3" };
%>

<div class="application-messages">
	
	<div class="application-messages-header">
		Veuillez prendre note des messages suivants
	</div>
	
	<table><tr><td>
	
		<% for(String message : messages) { %>
			<div class="application-message"><%=message %></div>
		<% } %>
	
	</td></tr></table>
	
</div>