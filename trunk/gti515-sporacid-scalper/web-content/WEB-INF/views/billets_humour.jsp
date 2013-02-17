<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
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
				<ul class="event-list">
					<li class="event-list-item">
						<div class="event-list-item-image" style="background-image: url(../styles/images/francois_bellefeuille.jpg);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title">François Bellefeuille part à la conquête du 450</h1>
							<h2 class="event-list-item-content-artists">François Bellefeuille</h2>
							<p class="event-list-item-content-desc">Ya pas juste Montréal quand même !</p>
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
							<div class="generic-button event-list-item-disponibility-button">
								Disponibilité...
							</div>
							<div class="generic-button event-list-item-addtocart-button">
								Ajouter au panier
							</div>
						</div>
					</li>
                    <li class="event-list-item">
						<div class="event-list-item-image" style="background-image: url(../styles/images/les_bobos.jpg);"></div>
						<div class="event-list-item-content">
							<h1 class="event-list-item-content-title">Les bobos en show</h1>
							<h2 class="event-list-item-content-artists">Marc Labrèche et Anne Dorval</h2>
							<p class="event-list-item-content-desc">On achète nos billets de loterie de façon ironique avec un second degré sans aucune intention de gagner! On est fous comme ça!</p>
							<div class="event-list-item-tags-container">
								<a class="event-list-item-tag" href="#a">Étienne Maxou</a>
								<a class="event-list-item-tag" href="#b">Sandrine Maxou</a>
								<a class="event-list-item-tag" href="#c">Restos branchés</a>
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
							<div class="generic-button event-list-item-disponibility-button">
								Disponibilité...
							</div>
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
				
			}
		);
	</script>
</html>