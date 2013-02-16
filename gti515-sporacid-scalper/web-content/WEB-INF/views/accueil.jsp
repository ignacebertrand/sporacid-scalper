<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="sporacidscalper.model.beans.NouvelleBean"%> 

<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");

	NouvelleBean[] listeNouvelles = (NouvelleBean[]) request.getAttribute("listeNouvelles"); 
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/accueil.css" />
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
				<div class="content-left-section">
					<h2>Prochains spectacles</h2>
					<div class="upcoming-shows-spinner-container">
						<ul class="upcoming-shows-spinner-tabs">
							<li class="upcoming-shows-spinner-back">&lt;</li>
							<li class="upcoming-shows-spinner-button is-selected">1</li>
							<li class="upcoming-shows-spinner-button">2</li>
							<li class="upcoming-shows-spinner-button">3</li>
							<li class="upcoming-shows-spinner-button">4</li>
							<li class="upcoming-shows-spinner-button">5</li>
							<li class="upcoming-shows-spinner-next">&gt;</li>
						</ul>
						<div class="upcoming-shows-spinner-content">
							<!--Item 1-->
							<div class="upcoming-shows-spinner-item" style=" display: block;">
								<div class="upcoming-shows-spinner-item-image" 
									 style="background-image: url(styles/images/decrepit-birth-event.jpg);">
								</div>
								<div class="upcoming-shows-spinner-item-description">
									Spectacle Decrepit Birth au club soda le 13/13/2013.
									Prix : 30$
								</div>
							</div>
							<!--Item 2-->
							<div class="upcoming-shows-spinner-item">
								<div class="upcoming-shows-spinner-item-image" 
									 style="background-image: url(styles/images/francois_bellefeuille.jpg);">
								</div>
								<div class="upcoming-shows-spinner-item-description">
									François Bellefeuille part à la conquête du 450.
									Ya pas juste Montréal quand même !
								</div>
							</div>
							<!--Item 3-->
							<div class="upcoming-shows-spinner-item">
								<div class="upcoming-shows-spinner-item-image" 
									 style="background-image: url(styles/images/trois_accords.jpg);">
								</div>
								<div class="upcoming-shows-spinner-item-description">
									Les Trois Accords la tournée J'aime ta grand-mère
								</div>
							</div>
							<!--Item 4-->
							<div class="upcoming-shows-spinner-item">
								<div class="upcoming-shows-spinner-item-image" 
									 style="background-image: url(styles/images/les_bobos.jpg);">
								</div>
								<div class="upcoming-shows-spinner-item-description">
									Marc Labrèche et Anne Dorval présente "Les bobos en show"
								</div>
							</div>
						</div>
					</div>
					<div class="content-sections-separation"></div>
				</div>
				<div class="content-right-section">
					<h2>Nouvelles</h2>
					<div class="news-list-container">
						<ul class="news-list">
							
							<% for(NouvelleBean nouvelle : listeNouvelles) { %>
							
								<li class="news-list-item">
									<h3><%=nouvelle.getTitre()%></h3>
									<p><%=nouvelle.getDescription()%></p>
									<p class="news-signature"><%=nouvelle.getAuteur()%></p>
									<p class="news-date"><%=nouvelle.getDate()%></p>
								</li>
							
							<% } %>
							
						</ul>
						
						<div class="upcoming-shows-spinner-content">
						</div>
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
				var spinner = $(".upcoming-shows-spinner-container");
			
				//Individual tab click handling
				//Shows the chosen spinner item
				spinner.find(".upcoming-shows-spinner-button").click(
					function()
					{
						var index = spinner.find(".upcoming-shows-spinner-button").index(this);
						var itemToShow = spinner.find(".upcoming-shows-spinner-item").eq(index);
		
						if(itemToShow.length === 1)
						{
							spinner.find(".upcoming-shows-spinner-button").removeClass("is-selected");
							$(this).addClass("is-selected");
							spinner.find(".upcoming-shows-spinner-item").hide();
							itemToShow.show();
						}
					}
				);
				
				//Next tab click handling
				//Shows the next spinner item
				spinner.find(".upcoming-shows-spinner-back").click(
					function()
					{
						var index = spinner.find(".upcoming-shows-spinner-item").index($(".upcoming-shows-spinner-item:visible")) - 1;
						
						if(index >= 0)
						{
							var itemToShow = spinner.find(".upcoming-shows-spinner-item").eq(index);
							
							if(itemToShow.length === 1)
							{
								spinner.find(".upcoming-shows-spinner-button").removeClass("is-selected");
								$(".upcoming-shows-spinner-button").eq(index).addClass("is-selected");
								
								spinner.find(".upcoming-shows-spinner-item").hide();
								itemToShow.show();
							}
						}
					}
				);
				
				//Previous tab click handling
				//Shows the previous spinner item
				spinner.find(".upcoming-shows-spinner-next").click(
					function()
					{
						var index = spinner.find(".upcoming-shows-spinner-item").index($(".upcoming-shows-spinner-item:visible")) + 1;
						
						if(index <= spinner.find(".upcoming-shows-spinner-item").length)
						{
							var itemToShow = spinner.find(".upcoming-shows-spinner-item").eq(index);
							
							if(itemToShow.length === 1)
							{
								spinner.find(".upcoming-shows-spinner-button").removeClass("is-selected");
								$(".upcoming-shows-spinner-button").eq(index).addClass("is-selected");
								
								spinner.find(".upcoming-shows-spinner-item").hide();
								itemToShow.show();
							}
						}
					}
				);
			}
		);
	</script>
</html>