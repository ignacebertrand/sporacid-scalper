<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="sporacidscalper.view.presentation.IPresentationBillets"%>
<%@ page import="sporacidscalper.model.beans.SpectacleBean"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();
	List<SpectacleBean> listeSpectacles = (List<SpectacleBean>) request.getAttribute("listeSpectacles");
	IPresentationBillets presentation = (IPresentationBillets) request.getAttribute("presentationBillets");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr %>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr %>/styles/billets_musique.css" />
		<script type="text/javascript" src="<%=contextAttr %>/scripts/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="<%=contextAttr %>/scripts/site-scripts.js"></script>
	</head>
	<body>

		<%-- Include the header in the page --%>
		<jsp:include page="partial-views/header.jsp"></jsp:include>
		
		<div class="main-container">
			
			<%-- Include the menu container in the page --%>
			<jsp:include page="partial-views/menu.jsp"></jsp:include>

			<div class="content">
				<h2>Billets d'humour</h2>
				<div class="event-filters-container">
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
					<%for(SpectacleBean spectacle : listeSpectacles){
					//spectacle.getArtistes()
					%>
					<li class="event-list-item">
						<div class="event-list-item-image" style="background-image: url(../<%=spectacle.getPosterUrl()%>);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title"><%=spectacle.getNom()%></h1>
							<%=presentation.getAppendedArtists(spectacle.getArtistes())%>
							<p class="event-list-item-content-desc"><%=spectacle.getDescription()%></p>
							<div class="event-list-item-tags-container">
								<a class="event-list-item-tag" href="#a">Châteauguay</a>
								<a class="event-list-item-tag" href="#b">Varennes</a>
								<a class="event-list-item-tag" href="#c">Le Gardeur</a>
								<a class="event-list-item-tag" href="#d">St-Eustache</a>
							</div>
						</div>
						<div class="event-list-item-controller">
							<label class="generic-label">Représentation :</label>
							<select class="generic-select event-list-item-representation-select">
								<option value="-1">-----</option>
								<%=presentation.getRepresentationsListIem(spectacle.getRepresentations())%>
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
			}
		);
	</script>
</html>