<!DOCTYPE html>
<%@page import="sporacidscalper.view.beans.FormulairePaiementSecurise"%>
<%@page import="sporacidscalper.view.presentation.IPresentationPaiement"%>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();
	FormulairePaiementSecurise formulaire = (FormulairePaiementSecurise) request.getAttribute("formulaire");
	IPresentationPaiement presentation = (IPresentationPaiement) request.getAttribute("presentationPaiement");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/paiement.css" />
		<script type="text/javascript" src="<%=contextAttr%>/scripts/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="<%=contextAttr%>/scripts/jquery.maskedinput.min.js"></script>
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
				
					<%=presentation.presenterFormulairePaiement(formulaire) %>
					
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
				
				$(".generic-textbox[name=\"noCivique\"], .generic-textbox[name=\"noAppartement\"]").keydown(onNumericTextboxKeydown);
				$(".generic-textbox[name=\"dateExpiration\"]").mask("99/99");
				$(".generic-textbox[name=\"noCarte\"]").mask("9999999999999999");
				$(".generic-textbox[name=\"codeCvv\"]").mask("999");
				$(".generic-textbox[name=\"codePostal\"]").mask("a9a9a9");
			}
		);
		
		function onNumericTextboxKeydown(event)
		{
			// Allow: backspace, delete, tab, escape, and enter
	        if ( event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 27 || event.keyCode == 13 || 
	             // Allow: Ctrl+A
	            (event.keyCode == 65 && event.ctrlKey === true) || 
	             // Allow: home, end, left, right
	            (event.keyCode >= 35 && event.keyCode <= 39)) {
	                 // let it happen, don't do anything
	                 return;
	        } else {
	            // Ensure that it is a number and stop the keypress
	            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
	                event.preventDefault(); 
	            }
	        }
		}
		
	</script>
</html>