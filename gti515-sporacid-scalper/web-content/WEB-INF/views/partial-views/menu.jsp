<%@page import="java.text.NumberFormat"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="sporacidscalper.controller.viewcontroller.util.SessionUtil"%>
<%@page import="sporacidscalper.controller.viewcontroller.PanierAchatController"%>

<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();

	// Get shopping cart associated values in the session
	Integer shoppingCartItemCount = (Integer) request.getSession().getAttribute(SessionUtil.cCleSessionCompteurItemPanierAchat);
	Double shoppingCartTotal = (Double) request.getSession().getAttribute(SessionUtil.cCleSessionTotalPanierAchat);
	
	// Get a currency formatter from the application context, because we don't have a front controller; we'd need
	// to set the formatter in every controllers which is very unpractical
	NumberFormat currencyFormatter = WebApplicationContextUtils.getWebApplicationContext(application).getBean("currencyFormatter", NumberFormat.class);
%>
	
<%-- Include the messages container in the page --%>
<jsp:include page="messages.jsp"></jsp:include>
			
<div class="menu-container">
	<ul class="menu">
		<li id="accueil_menu_item" class="menu-item">
			<a href="<%=contextAttr%>/accueil">Accueil</a>
		</li>
		<li class="menu-item">
			<a>Spectacles</a>
			<div class="sub-menu-container">
				<ul class="sub-menu">
					<li class="sub-menu-item">
						<a href="<%=contextAttr%>/billets/liste-billets">Tous les billets</a>
					</li>
				</ul>
			</div>
		</li>
<!-- 		<li id="admin_menu_item" class="menu-item"> -->
<%-- 			<a href="<%=contextAttr%>/administration/admin">Admin</a> --%>
<!-- 		</li> -->
	</ul>
	<div class="shopping-cart-controller">
		<a class="shopping-cart-desc" href="<%=contextAttr%>/panier-achat/panier-achat">
			
			<% if(shoppingCartItemCount != null && shoppingCartItemCount != 0) { %>
				<span class="shopping-cart-counter"><%=shoppingCartItemCount %></span> item(s) dans le panier 
			<% } else { %>
				Aucun item dans le panier 
			<% } %>
			
			(Total: <span class="shopping-cart-total"><%=(shoppingCartTotal != null ? currencyFormatter.format(shoppingCartTotal) : currencyFormatter.format(0.0)) %>)</span>
		</a>
		<div class="shopping-cart-button generic-button"></div>
	</div>
</div>