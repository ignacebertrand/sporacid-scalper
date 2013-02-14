<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
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
		<div class="header">
			<div class="header-logo"></div>
		</div>
		
		<div class="main-container">
			
			<%-- Include the menu container in the page --%>
			<jsp:include page="partial-views/menu.jsp"></jsp:include>

			<div class="content">
				<h2>Paiement sécurisé</h2>
				<h3>Informations livraison</h3>
				<div class="payment-description-item">
					<label for="name" class="generic-label">Nom :</label>
					<input type="text" name="name" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="streetnb" class="generic-label">No de rue :</label>
					<input type="text" name="streetnb" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="streetnb" class="generic-label">No appart :</label>
					<input type="text" name="streetnb" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="street" class="generic-label">Rue :</label>
					<input type="text" name="street" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="city" class="generic-label">Ville :</label>
					<input type="text" name="city" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="province" class="generic-label">Province :</label>
					<input type="text" name="province" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="postalcode" class="generic-label">Code Postal :</label>
					<input type="text" name="postalcode" class="generic-textbox" />
				</div>
				<h3>Informations paiement</h3>
				<div class="payment-description-item">
					<label for="name" class="generic-label">Nom :</label>
					<input type="text" name="name" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="cardnb" class="generic-label">No carte :</label>
					<input type="text" name="cardnb" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="expirationdate" class="generic-label">Date expiration :</label>
					<input type="text" name="expirationdate" class="generic-textbox" />
				</div>
				<div class="payment-description-item">
					<label for="cvvcode" class="generic-label">Code CVV :</label>
					<input type="text" name="cvvcode" class="generic-textbox" />
				</div>
				
				<div class="payment-controller">
					<div class="generic-button event-list-item-disponibility-button">
						Confirmer le paiement
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer">
			© Copyright Sporacid Studio 2013
		</div>
		
	</body>
	
	<script type="text/javascript">
	
		$(document).ready(
			function()
			{
				
			}
		);
	</script>
</html>