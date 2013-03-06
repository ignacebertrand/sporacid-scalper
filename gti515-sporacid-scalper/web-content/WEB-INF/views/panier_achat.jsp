<!DOCTYPE html>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.NumberFormat"%>

<%@page import="sporacidscalper.view.presentation.IPresentationPanierAchat" %>
<%@page import="sporacidscalper.model.beans.PanierAchatBean"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();
	PanierAchatBean panierAchat = (PanierAchatBean) request.getAttribute("panierAchat");
	IPresentationPanierAchat presentation = (IPresentationPanierAchat) request.getAttribute("presentationPanierAchat");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/panier_achat.css" />
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
				<h2>Votre panier d'achat</h2>
				<hr />
				<br />
				
				<%-- Form to be submitted and filled through javascript --%>
				<form id="formModifierItemPanierAchat" method="POST" action="<%=contextAttr%>/panier-achat/supprimer-item-panier-achat">
					<input type="hidden" id="hiddenItemId" name="itemId" />
					<input type="hidden" id="hiddenQuantite" name="quantite" />
					<input type="hidden" id="hiddenSpectacleId" name="spectacleId" />
					<input type="hidden" id="hiddenRepresentationId" name="representationId" />
					<input type="hidden" id="hiddenTypeBilletId" name="typeBilletId" />
				</form>
				
				<!-- Delegate presentation to the presentation logic class -->
				<%=presentation.presenterPanierAchat(panierAchat) %>
			
			</div>
		</div>
		
		<%-- Include the footer in the page --%>
		<jsp:include page="partial-views/footer.jsp"></jsp:include>
		
	</body>
	
	<script type="text/javascript">
		$(document).ready(
			function()
			{
				$(".shopping-cart-item-list-checkout-button").click(
					function()
					{
						if($(".shopping-cart-item").length > 0)
							window.location = "<%=contextAttr%>/paiement/paiement-securise";
						else
						{
							var messages = ["Votre panier d'achat est vide.", "Impossible de procéder au paiement."];
							showMessages(messages);
						}
					}
				);
				
				$(".shopping-cart-delete-item-button").click(
					function()
					{
						var item = $(this).parents(".shopping-cart-item");
						submitForm(item, "<%=contextAttr%>/panier-achat/supprimer-item-panier-achat");
					}
				);
				
				$(".shopping-cart-item .shopping-cart-item-representation-select, " +
			 	  ".shopping-cart-item .shopping-cart-item-tickettype-select, " +	
				  ".shopping-cart-item .shopping-cart-item-quantity-select").change(
					function() 
					{
						var item = $(this).parents(".shopping-cart-item");
						submitForm(item, "<%=contextAttr%>/panier-achat/modifier-item-panier-achat");
					}
				);
			}
		);
		
		function submitForm(item, url)
		{
			var wrappedItem = $(item);
			
			if(wrappedItem.hasClass("shopping-cart-item") && url)
			{
				var itemId = wrappedItem.find(".shopping-cart-item-id").val();
				var quantite = wrappedItem.find(".shopping-cart-item-quantity-select option:selected").val();
				var spectacleId = wrappedItem.find(".shopping-cart-item-spectacle-id").val();
				var representationId = wrappedItem.find(".shopping-cart-item-representation-select option:selected").val();
				var typeBilletId = wrappedItem.find(".shopping-cart-item-tickettype-select option:selected").val();
				
				var form = $("form#formModifierItemPanierAchat").attr("action", url);
				
				form.find("#hiddenItemId").val(itemId);
				form.find("#hiddenQuantite").val(quantite);
				form.find("#hiddenSpectacleId").val(spectacleId);
				form.find("#hiddenRepresentationId").val(representationId);
				form.find("#hiddenTypeBilletId").val(typeBilletId);
				
				form.submit();
			}
		}
	</script>
</html>