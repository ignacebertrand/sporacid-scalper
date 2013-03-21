<%@page import="sporacidscalper.view.presentation.IPresentationAccueil"%>
<%@page import="java.util.List" %>
<%@page import="sporacidscalper.model.beans.SpectacleBean" %>
<%@page import="sporacidscalper.model.beans.NouvelleBean" %>

<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();

	@SuppressWarnings("unchecked")
	List<NouvelleBean> listeNouvelles = (List<NouvelleBean>)request.getAttribute("listeNouvelles");
	
	@SuppressWarnings("unchecked")
	List<SpectacleBean> listeProchainsSpectacles = (List<SpectacleBean>) request.getAttribute("listeProchainsSpectacles");
	IPresentationAccueil presentation = (IPresentationAccueil) request.getAttribute("presentationAccueil");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/accueil.css" />
		<script type="text/javascript" src="<%=contextAttr%>/scripts/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="<%=contextAttr%>/scripts/site-scripts.js"></script>
		<script type="text/javascript" src="<%=contextAttr%>/scripts/spinner-script.js"></script>
	</head>
	<body>

		<%-- Include the header in the page --%>
		<jsp:include page="partial-views/header.jsp"></jsp:include>
		
		<div class="main-container">
			
			<%-- Include the menu container in the page --%>
			<jsp:include page="partial-views/menu.jsp"></jsp:include>
			
			<div class="content">
			
				<div class="content-left-section">
					
					<%=presentation.presenterProchainSpectacles(listeProchainsSpectacles) %>
					
					<div class="content-sections-separation"></div>
					
				</div>
				
				<div class="content-right-section">
				
					<%=presentation.presenterNouvelles(listeNouvelles) %>
					
				</div>
				
			</div>
		</div>
		
		<%-- Include the footer in the page --%>
		<jsp:include page="partial-views/footer.jsp"></jsp:include>
		
	</body>
</html>