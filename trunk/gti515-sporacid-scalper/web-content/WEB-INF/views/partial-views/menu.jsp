<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();
%>
<div class="menu-container">
	<ul class="menu">
		<li id="accueil_menu_item" class="menu-item">
			<a href="<%=contextAttr%>/accueil">Accueil</a>
		</li>
		<li class="menu-item">
			<a>Spectacles</a>
			<div class="sub-menu-container">
				<ul class="sub-menu">
					<li id="billets_musique_menu_item" class="sub-menu-item">
						<a href="<%=contextAttr%>/billets/billets-musique">Musique</a>
					</li>
					<li id="billets_humour_menu_item" class="sub-menu-item">
						<a href="<%=contextAttr%>/billets/billets-humour">Humour</a>
					</li>
				</ul>
			</div>
		</li>
		<li id="admin_menu_item" class="menu-item">
			<a href="<%=contextAttr%>/administration/admin">Admin</a>
		</li>
	</ul>
	<div class="shopping-cart-controller">
		<a class="shopping-cart-desc" href="<%=contextAttr%>/panier-achat/panier-achat">
			<span class="shopping-cart-counter">1</span>
			item(s) dans le panier 
			(<span class="shopping-cart-total">49.99$</span>)
		</a>
		<div class="shopping-cart-button generic-button"></div>
	</div>
</div>