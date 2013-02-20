<%@ page import="sporacidscalper.model.beans.SpectacleBean" %>
<%@ page import="sporacidscalper.model.beans.NouvelleBean" %>

<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
	NouvelleBean[] listeNouvelles = (NouvelleBean[]) request.getAttribute("listeNouvelles");
	SpectacleBean[] listeProchainsSpectacles = (SpectacleBean[]) request.getAttribute("listeProchainsSpectacles");
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

		<%-- Include the header in the page --%>
		<jsp:include page="partial-views/header.jsp"></jsp:include>
		
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
						
							<% for(int i = 0; i < 5 && i < listeProchainsSpectacles.length; i++) { %>
							
								<% SpectacleBean spectacle = listeProchainsSpectacles[i]; %>
								
								<div class="upcoming-shows-spinner-item">
									<div class="upcoming-shows-spinner-item-image" 
										 style="background-image: url(<%=spectacle.getPosterUrl()%>);">
									</div>
									<div class="upcoming-shows-spinner-item-description">
										<%=spectacle.getDescription()%>
									</div>
								</div>
							
							<% } %>
							
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
		
		<%-- Include the footer in the page --%>
		<jsp:include page="partial-views/footer.jsp"></jsp:include>
		
	</body>
	
	<script type="text/javascript">
	
		// Length in miliseconds between each of the spinner thread's execution
		var cSpinnerSpinLength = 5000;
		
		// Length in milliseconds for the fade in/out of the spin
		var cSpinnerFadeLength = 350;
	
		$(document).ready(
			function()
			{
				var spinner = $(".upcoming-shows-spinner-container");
				var spinnerButtons = spinner.find(".upcoming-shows-spinner-button");
				var spinnerItems = spinner.find(".upcoming-shows-spinner-item");
					
				for(var i = spinnerItems.length; i < spinnerButtons.length; i++)
					spinnerButtons.eq(i).addClass("is-disabled");
					
				// Thread to turn the container into a spinner
				var fctThreadSpinner = function()
				{
					var selectedButton = spinnerButtons.filter(".is-selected");
					var index = spinnerButtons.index(selectedButton);
					var buttonToClick = spinnerButtons.eq(index + 1);

					if(buttonToClick.hasClass("is-disabled"))
						buttonToClick = spinnerButtons.eq(0);
					
					buttonToClick.click();
				};
				
				var threadSpinner = setInterval(fctThreadSpinner, cSpinnerSpinLength);
				
				// On button click, reset the thread
				spinner.find(".upcoming-shows-spinner-button, .upcoming-shows-spinner-back, .upcoming-shows-spinner-next").click(
					function(event)
					{
						clearInterval(threadSpinner);
						threadSpinner = setInterval(fctThreadSpinner, cSpinnerSpinLength);
					}
				);
				
				//Individual tab click handling
				//Shows the chosen spinner item
				spinner.find(".upcoming-shows-spinner-button").click(
					function()
					{
						var index = spinnerButtons.index(this);
						var itemToShow = spinnerItems.eq(index);
		
						if(itemToShow.length === 1)
						{
							spinnerButtons.removeClass("is-selected");
							$(this).addClass("is-selected");
							
							spinnerItems.not(":eq(" +  index + ")").hide();
							itemToShow.fadeIn(cSpinnerFadeLength); 
						}
					}
				);
				
				//Next tab click handling
				//Shows the next spinner item
				spinner.find(".upcoming-shows-spinner-back").click(
					function()
					{
						var index = spinnerItems.index($(".upcoming-shows-spinner-item:visible")) - 1;
						
						if(index >= 0)
						{
							var itemToShow = spinnerItems.eq(index);
							
							if(itemToShow.length === 1)
							{
								spinnerButtons.removeClass("is-selected");
								spinnerButtons.eq(index).addClass("is-selected");
								
								spinnerItems.not(":eq(" +  index + ")").hide();
								itemToShow.fadeIn(cSpinnerFadeLength); 
							}
						}
					}
				);
				
				//Previous tab click handling
				//Shows the previous spinner item
				spinner.find(".upcoming-shows-spinner-next").click(
					function()
					{
						var index = spinnerItems.index($(".upcoming-shows-spinner-item:visible")) + 1;
						
						if(index <= spinnerItems.length)
						{
							var itemToShow = spinnerItems.eq(index);
							
							if(itemToShow.length === 1)
							{
								spinnerButtons.removeClass("is-selected");
								spinnerButtons.eq(index).addClass("is-selected");
								
								spinnerItems.not(":eq(" +  index + ")").hide();
								itemToShow.fadeIn(cSpinnerFadeLength); 
							}
						}
					}
				);
			}
		);
	</script>
</html>