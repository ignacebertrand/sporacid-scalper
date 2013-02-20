<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/billets_musique.css" />
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
				<h2>Billets de musique</h2>
				<div class="event-filters-container">
					<label for="select_category" class="generic-label">Catégories :</label>
					<select id="select_category" class="generic-select">
						<option value="-1">Tout</option>
						<option value="1">Blues</option>
						<option value="2">Classique</option>
						<option value="3">Heavy Metal</option>
						<option value="4">Jazz</option>
						<option value="5">Rock</option>
					</select>
					<label for="textbox_search_criteria" class="generic-label">Recherche par mot clé :</label>
					<input type="text" id="textbox_search_criteria" class="generic-textbox" />
				</div>
				
				<form method="POST" action="<%=contextAttr%>/panier-achat/ajouter-item-panier-achat">
					<input type="hidden" id="hiddenQuantite" name="quantite" />
					<input type="hidden" id="hiddenSpectacleId" name="spectacleId" />
					<input type="hidden" id="hiddenRepresentationId" name="representationId" />
					<input type="hidden" id="hiddenTypeBilletId" name="typeBilletId" />
				</form>
				
				<ul class="event-list">
                    <li class="event-list-item">
						<div class="event-list-item-image" style="background-image: url(../styles/images/trois_accords.jpg);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title">Tournée J'aime ta grand-mère</h1>
							<h2 class="event-list-item-content-artists">Les Trois Accords</h2>
							<p class="event-list-item-content-desc">Souligne l'importance et le potentiel de nos aînés.</p>
							<div class="event-list-item-tags-container">
								<a class="event-list-item-tag" href="#a">Club d'âge d'or</a>
								<a class="event-list-item-tag" href="#b">Association Je protège nos aînés</a>
								<a class="event-list-item-tag" href="#c">Les couches Depends</a>
								<a class="event-list-item-tag" href="#d">Parrainer un aîné</a>
							</div>
						</div>
						<div class="event-list-item-controller">
							<label class="generic-label">Représentation :</label>
							<select class="generic-select event-list-item-representation-select">
								<option value="-1">-----</option>
								<option value="1">Le 13/13/2013 à 6h66</option>
							</select>
							<label class="generic-label">Quantité :</label>
							<select class="generic-select event-list-item-quantity-select">
								<option value="-1">--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
<!-- 							<div class="generic-button event-list-item-disponibility-button"> -->
<!-- 								Disponibilité... -->
<!-- 							</div> -->
							<div class="generic-button event-list-item-addtocart-button">
								Ajouter au panier
							</div>
						</div>
					</li>
					<li class="event-list-item">
						<div class="event-list-item-image" style="background-image: url(../styles/images/decrepit-birth-event.jpg);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title">Lancement d'album Decrepit Birth</h1>
							<h2 class="event-list-item-content-artists">Decrepit Birth + invités</h2>
							<h3 class="event-list-item-content-datelocation">Le 13/13/2013 au Club Soda</h3>
							<p class="event-list-item-content-desc">Le nouvel album de Decrepit Birth, Polarity est maitenant en vente.</p>
							<div class="event-list-item-tags-container">
								<a class="event-list-item-tag" href="#a">Heavy Metal</a>
								<a class="event-list-item-tag" href="#b">Death Metal</a>
								<a class="event-list-item-tag" href="#c">Technical Metal</a>
								<a class="event-list-item-tag" href="#d">Sporacid Blast Records</a>
							</div>
						</div>
						<div class="event-list-item-controller">
							<label class="generic-label">Représentation :</label>
							<select class="generic-select event-list-item-representation-select">
								<option value="-1">-----</option>
								<option value="1">Le 13/13/2013 à 6h66</option>
							</select>
							<label class="generic-label">Quantité :</label>
							<select class="generic-select event-list-item-quantity-select">
								<option value="-1">--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
<!-- 							<div class="generic-button event-list-item-disponibility-button"> -->
<!-- 								Disponibilité... -->
<!-- 							</div> -->
							<div class="generic-button event-list-item-addtocart-button">
								Ajouter au panier
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		
		<%-- Include the footer in the page --%>
		<jsp:include page="partial-views/footer.jsp"></jsp:include>
		
	</body>
	
	<script type="text/javascript">
		$(document).ready(
			function()
			{
				$(".event-list-item-addtocart-button").click(
					function()
					{
						$("form #hiddenQuantite").val("4");
						$("form #hiddenSpectacleId").val("1");
						$("form #hiddenRepresentationId").val("1");
						$("form #hiddenTypeBilletId").val("1");
						
						$("form").submit(
							/*function()
							{
								// Prevent redirection
								return false;
							}*/
						);
					}
				);
				
				//Mock of wait time for server response.
// 				$(".event-list-item-disponibility-button").click(
// 					function()
// 					{
// 						var text = "Disponibilité";
// 						var onText = "<span class='disponibility-button-onchar'>.</span>";
// 						var disponibilityButton = $(this);
						
// 						$("body").css("cursor", "wait");
						
// 						disponibilityButton.html(text + onText + "..");
// 						window.setTimeout(
// 							function()
// 							{
// 								disponibilityButton.html(text + "." + onText + ".");
// 								window.setTimeout(
// 									function()
// 									{
// 										disponibilityButton.html(text + ".." + onText);
// 										window.setTimeout(function()
// 										{
// 											$("body").css("cursor", "default");
// 											disponibilityButton.hide();
// 											disponibilityButton.parents(".event-list-item").find(".event-list-item-addtocart-button").css("display", "inline-block");
// 										}, 500);
// 									}
// 								,  500);
// 							}
// 						,  500);
						
// 					}
// 				);
			}
		);
		
	</script>
</html>