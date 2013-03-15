<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="sporacidscalper.view.presentation.IPresentationBillets"%>
<%@page import="sporacidscalper.model.beans.SpectacleBean"%>
<%@page import="sporacidscalper.model.beans.TypeSpectacleBean"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();

	@SuppressWarnings("unchecked")
	List<SpectacleBean> listeSpectacles = (List<SpectacleBean>) request.getAttribute("listeSpectacles");
	
	@SuppressWarnings("unchecked")
	List<TypeSpectacleBean> listeTypes = (List<TypeSpectacleBean>) request.getAttribute("listeTypes");
	
	IPresentationBillets presentation = (IPresentationBillets) request.getAttribute("presentationBillets");
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
						<option value="-1">Toutes</option>
						<%=presentation.getTypesListItem(listeTypes)%>
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
					<%for(SpectacleBean spectacle : listeSpectacles){%>						
					<li class="event-list-item">
					
						<input type="hidden" class="hiddenSpectacleId" value="<%=spectacle.getId()%>"/>
						<div class="event-list-item-image" style="background-image: url(../<%=spectacle.getPosterUrl()%>);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title"><%=spectacle.getNom()%></h1>
							<%=presentation.getAppendedArtists(spectacle.getArtistes())%>
							<p class="event-list-item-content-desc"><%=spectacle.getDescription()%></p>
							<div class="event-list-item-tags-container">
								<%=presentation.getTagsAnchors(spectacle.getArtistes())%>
							</div>
						</div>
						<div class="event-list-item-controller">
							<label class="generic-label">Représentation :</label>
							<select class="generic-select event-list-item-representation-select">
								<option value="-1">-----</option>
								<%=presentation.getRepresentationsListItem(spectacle.getRepresentations())%>
							</select>
							<label class="generic-label">Type :</label>
							<select class="generic-select event-list-item-ticket-type-select">
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
					<%}%>
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
						var item = $(this).parents(".event-list-item");
						
						var qte = item.find(".event-list-item-quantity-select option:selected").val();
						var spectacleId = item.find(".hiddenSpectacleId").val();
						var represId = item.find(".event-list-item-representation-select option:selected").val();
						var typeBilletId = item.find(".event-list-item-ticket-type-select option:selected").val();
						
						if(qte > 0 && spectacleId > 0 && represId > 0 && typeBilletId > 0)
						{
							var form = $("form");
							
							form.find("#hiddenQuantite").val(qte);
							form.find("#hiddenSpectacleId").val(spectacleId);
							form.find("#hiddenRepresentationId").val(represId);
							form.find("#hiddenTypeBilletId").val(typeBilletId);
							
							form.submit();
						}
						else
						{
							var messages = ["Impossible d'ajouter l'item au panier d'achat."];
							showMessages(messages);
						}
					}
				);
				
				$(".event-list-item-representation-select").change(
					function()
					{
						var item = $(this).parents(".event-list-item");
						var spectacleId = item.find(".hiddenSpectacleId").val();
						var represId = item.find(".event-list-item-representation-select option:selected").val();
												
						$.get("<%=contextAttr%>/billets/obtenir-types-billet-representation",
				        	{ spectacleId: spectacleId, representationId: represId },
					        function (response)
					        {				        		
				                var container = item.find(".event-list-item-ticket-type-select");
				                container.empty();
				                container.append(response);
					        }
						);
					}
				);
				/*
				$("#textbox_search_criteria").enterKey(
					function()
					{
						var searchString = $(this).val();
						var item =  $(this).parents(".event-filters-container");
						var searchCategory = item.find("#select_category");
						
						alert("categ String : " + searchCategory + " " + searchString);
					
						window.location=window.location + "?searchCategory=" + searchCategory + "&searchString=" + searchString;
					}
				);*/
				
				$("#select_category").change(
					function()
					{
						var item =  $(this).parents(".event-filters-container");
						var searchCategory = $(this).val();
						var searchString = item.find("#textbox_search_criteria").val();
											
						var url = window.location.toString();
						
						if(url.indexOf('?') > -1)
							url = url.split('?')[0];
						
						window.location = url + "?searchCategory=" + searchCategory + "&searchString=" + searchString;
					}
				);
				
				$('#textbox_search_criteria').keypress(
					function(event)
					{
						var keycode = (event.keyCode ? event.keyCode : event.which);
						
						if(keycode == '13')
						{
							var item =  $(this).parents(".event-filters-container");
							var searchCategory = item.find("#select_category").val();
							var searchString   = $(this).val();
							var url = window.location.toString();
							
							if(url.indexOf('?') > -1)
								url = url.split('?')[0];
							
							window.location = url + "?searchCategory=" + searchCategory + "&searchString=" + searchString;
						}
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