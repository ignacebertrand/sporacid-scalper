<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
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
				<ul class="shopping-cart-item-list">
					<li class="shopping-cart-item">
						<div class="shopping-cart-item-image" style="background-image: url(../styles/images/decrepit-birth-event.jpg);"></div>
						<div class="shopping-cart-item-content">
							<div class="shopping-cart-item-desc">
								<h1 class="shopping-cart-item-title">Lancement d'album Decrepit Birth &nbsp; &nbsp; (Prix : 49.99$)</h1>
								<h2 class="shopping-cart-item-artists">Decrepit Birth + invités</h2>
							</div>
							<div class="shopping-cart-item-controller">
								<label class="generic-label">Représentation :</label>
								<select class="generic-select shopping-cart-item-representation-select">
									<option value="-1">-----</option>
									<option value="1" selected="selected">Le 13/13/2013 à 6h66</option>
								</select>
								<label class="generic-label">Quantité :</label>
								<select class="generic-select shopping-cart-item-quantity-select">
									<option value="-1">--</option>
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
								</select>
								<label class="generic-label ">Total :</label>
								<span class="shopping-cart-item-total">49.99$</span>
							</div>
						</div>
					</li>
				</ul>
				
				<div class="shopping-cart-item-list-controller">
					<label class="generic-label">Total :</label>
					<span class="shopping-cart-item-list-total">49.99$</span>
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
			}
		);
	</script>
</html>