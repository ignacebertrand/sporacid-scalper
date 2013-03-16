<!DOCTYPE html>
<%@page import="sporacidscalper.model.beans.TransactionBean"%>
<%@page import="sporacidscalper.view.presentation.IPresentationPaiement"%>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();
	TransactionBean transaction = (TransactionBean) request.getAttribute("transaction");
	IPresentationPaiement presentation = (IPresentationPaiement) request.getAttribute("presentationPaiement");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/paiement.css" />
		<script type="text/javascript" src="<%=contextAttr%>/scripts/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="<%=contextAttr%>/scripts/site-scripts.js"></script>
	</head>
	<body>

		<%-- Include the header in the page --%>
		<jsp:include page="partial-views/header.jsp"></jsp:include>
		
		<div class="main-container">
			
			<%-- Include the menu container in the page --%>
			<jsp:include page="partial-views/menu.jsp"></jsp:include>

			<div class="content">
		
				<form id="formPaiementSecurise" method="POST" action="<%=contextAttr%>/paiement/traiter-paiement-securise">
				
					<%=presentation.presenterFormulairePaiement(transaction) %>
					
				</form>
			</div>
		</div>
		
		<%-- Include the footer in the page --%>
		<jsp:include page="partial-views/footer.jsp"></jsp:include>
		
	</body>
	
	<script type="text/javascript">
		$(document).ready(
			function()
			{
				$(".payment-confirmation-button").click(
					function ()
					{
						$("form#formPaiementSecurise").submit();
					}
				);
			}
		);
	</script>
</html>