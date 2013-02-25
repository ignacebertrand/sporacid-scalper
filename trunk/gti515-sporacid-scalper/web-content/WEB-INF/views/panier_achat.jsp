<!DOCTYPE html>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.NumberFormat"%>

<%@page import="sporacidscalper.model.beans.PanierAchatBean" %>
<%@page import="sporacidscalper.model.beans.ItemPanierAchatBean"%>
<%@page import="sporacidscalper.model.beans.SpectacleBean"%>
<%@page import="sporacidscalper.model.beans.RepresentationBean"%>
<%@page import="sporacidscalper.model.beans.TypeBilletRepresentationBean"%>
<%@page import="sporacidscalper.model.beans.TypeBilletBean"%>
<%@page import="sporacidscalper.model.beans.ArtisteBean"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
	PanierAchatBean panierAchat = (PanierAchatBean) request.getAttribute("panierAchat");
	DateFormat dateFormatter = (DateFormat) request.getAttribute("dateFormatter");
	NumberFormat currencyFormatter = (NumberFormat) request.getAttribute("currencyFormatter");
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
				
				<ul class="shopping-cart-item-list">
					<% for(ItemPanierAchatBean item : panierAchat.getItems()) { %>
					<%
						// Get the upper references if they exist.
						// (We expect the controller to set those references for the view)
						TypeBilletRepresentationBean typeBilletRepresentation = item.getBilletRepresentation();
						RepresentationBean representation = null;
						SpectacleBean spectacle = null;
						
						if(typeBilletRepresentation != null)
						{
							representation = typeBilletRepresentation.getRepresentationReference();
							
							if(representation != null)
							{
								spectacle = representation.getSpectacleReference();
							}
						}
						
						// Instantiate default object because we don't want the presentation
						// to fail (Null reference).
						if(typeBilletRepresentation == null)
							typeBilletRepresentation = item.getBilletRepresentation();
						
						if(representation == null)
							representation = new RepresentationBean();
						
						if(spectacle == null)
							spectacle = new SpectacleBean();
						
						String artistesDesc = spectacle.getArtistes();
						
						String itemTitle = spectacle.getDescription() + "  -  " + 
								typeBilletRepresentation.getType().getNom() + "  -  Prix unitaire : " +
								currencyFormatter.format(typeBilletRepresentation.getPrix());
					%>	
					
						<li class="shopping-cart-item">
						
							<input class="shopping-cart-item-id" type="hidden" value="<%=item.getId()%>" />
							<input class="shopping-cart-item-spectacle-id" type="hidden" value="<%=spectacle.getId()%>" />
							
							<div class="shopping-cart-item-image" style="background-image: url(../<%=spectacle.getPosterUrl()%>);"></div>
							<div class="shopping-cart-item-content">
								<div class="shopping-cart-item-desc">
									<h1 class="shopping-cart-item-title"><%=itemTitle%></h1>
									<h2 class="shopping-cart-item-artists"><%=artistesDesc%></h2>
								</div>
								<%-- Controller to give an opportunity for the client to modify his shopping cart --%>
								<div class="shopping-cart-item-controller">
									<label class="generic-label">Représentation :</label>
									<select class="generic-select shopping-cart-item-representation-select">
									
										<%-- Iterate through all available representations for the show --%>
										<% for(RepresentationBean availableRepr : spectacle.getRepresentations()) { %>
											<% boolean isSelected = availableRepr.equals(representation); %>
											<option value="<%=availableRepr.getId()%>" <%=(isSelected ? "selected=\"selected\"" : "" )%>>
												Représentation du <%=dateFormatter.format(availableRepr.getDateDebutRepresentation())%>
											</option>
										<% } %>
										
									</select>
									<label class="generic-label">Billet :</label>
									<select class="generic-select shopping-cart-item-tickettype-select">
									
										<%-- Populate a TypeBilletBean array according to the TypeBilletRepresentationBean --%>
										<%-- list for the representation --%>
										<% 
											TypeBilletBean[] typesBillet = new TypeBilletBean[representation.getTypesBillet().size()];
										
											int i = 0;
											for(TypeBilletRepresentationBean availableTypeBillet : representation.getTypesBillet())
												typesBillet[i] = availableTypeBillet.getType();
										%>
									
										<%-- Iterate through all available ticket types for the show --%>
										<% for(TypeBilletBean availableTypeBillet : typesBillet) { %>
											<% boolean isSelected = availableTypeBillet.equals(typeBilletRepresentation.getType()); %>
											<option value="<%=availableTypeBillet.getId()%>" <%=(isSelected ? "selected=\"selected\"" : "" )%>>
												<%=availableTypeBillet.getNom() %>
											</option>
										<% } %>
										
									</select>
									<label class="generic-label">Quantité :</label>
									<select class="generic-select shopping-cart-item-quantity-select">
										<%-- It is a business rule that we cannot have more than 6 tickets for a representation --%>
										<%-- This logic could be moved someday because the view shouldn't know about business rules --%>
										<%-- However, I think it would be an overkill for a 1 to 6 loop. --%>
										<% int selectedQuantity = item.getQuantite(); %>
										<% for(int iQuantity = 1; iQuantity <= 6; iQuantity++) { %>
											<option value="<%=iQuantity%>" <%=(selectedQuantity == iQuantity ? "selected=\"selected\"" : "" )%>>
												<%=iQuantity%>
											</option>
										<% } %>
									</select>
									<label class="generic-label">Total :</label>
									<span class="shopping-cart-item-total"><%=currencyFormatter.format(item.getTotal())%></span>
									<div class="generic-button shopping-cart-delete-item-button">&nbsp;</div>
								</div>
							</div>
						</li>
							
					<% } %>
				</ul>
				
				<div class="shopping-cart-item-list-controller">
					<label class="generic-label">Total :</label>
					<span class="shopping-cart-item-list-total"><%=currencyFormatter.format(panierAchat.getTotal())%></span>
					<div class="generic-button shopping-cart-item-list-checkout-button">
						Procéder au paiement
					</div>
				</div>
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
						window.location = "<%=contextAttr%>/paiement/paiement-securise";
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