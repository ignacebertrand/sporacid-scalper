<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getAttribute("context");
%>
<html>
	<head>
		<title>Billets Sporacid</title>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/site.css" />
		<link rel="stylesheet" type="text/css" href="<%=contextAttr%>/styles/admin.css" />
		<script type="text/javascript" src="<%=contextAttr%>/scripts/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="<%=contextAttr%>/scripts/site-scripts.js"></script>
        <script type="text/javascript" src="<%=contextAttr%>/scripts/jquery.maskedinput.min.js"></script>
        <script type="text/javascript" src="<%=contextAttr%>/scripts/jquery.ui.datepicker-fr.js"></script>
        <script type="text/javascript" src="<%=contextAttr%>/scripts/jquery.ui.timepicker.js"></script>
        <script type="text/javascript" src="<%=contextAttr%>/scripts/jquery.ui.timepicker-fr.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
	</head>
	<body>
		<div class="header">
			<div class="header-logo"></div>
		</div>
		
		<div class="main-container">
			
			<%-- Include the menu container in the page --%>
			<jsp:include page="partial-views/menu.jsp"></jsp:include>
			
			<div class="content">
				<form name="add-events" action="" method="get">
					<h2>Ajouter un spectacle</h2>
					<div class="add-event-description">
						<h3>Détail du spectacle</h3><br/>
                        <div class="add-event-description-item">
						    <label for="type" class="generic-label">Types :</label>
						    <input type="radio" name="type" value="aucun"/>Aucun
						    <input type="radio" name="type" value="humour"/>Humour
						    <input type="radio" name="type" value="musique"/>Musique <br/>
                        </div>
                        <div class="add-event-description-item">
							<label for="artiste" class="generic-label">Artiste :</label>
							<input type="text" name="artiste" class="generic-textbox" /><br/>
                        </div>
                        <div class="add-event-description-item">
							<label for="nomSpectacle" class="generic-label">Nom du spectacle :</label>
							<input type="text" name="nomSpectacle" class="generic-textbox"/><br/>
                        </div>
                        <div class="add-event-description-item">
							<label for="select_category" class="generic-label">Catégories :</label>
							<select id="select_category" class="generic-select">
								<option value="-1">Aucune</option>
								<option value="1">Blues</option>
								<option value="2">Classique</option>
								<option value="3">Heavy Metal</option>
								<option value="4">Jazz</option>
								<option value="5">Rock</option>
							</select><br/>
                        </div>
                        <div class="add-event-item-controller">
                            <input type="submit" value="Sauvegarder" id="add-event-representation-button" class="generic-button"/>
                        </div>
					</div>
					<div class="add-event-representations">
                        <table class="add-representations-table">
                            <tr>
                                <td><h3>Représentations</h3><br/></td>
                            </tr>
                            <tr>
                                <td><label class="generic-label">Date</label></td>
                                <td><label class="generic-label">Salle</label></td>
                                <td><label class="generic-label">Début</label></td>
                                <td><label class="generic-label">Fin</label></td>
                                <td><label class="generic-label">Prix</label></td>
                            </tr>
                            <tr>
                                <td><input type="text" name="date" class="generic-datepicker generic-textbox"/></td>
                                <td>
                                    <select id="select-place" class="generic-select">
							            <option value="-1">Aucun</option>
							            <option value="1">Métropolis</option>
							            <option value="2">Olympia</option>
							            <option value="3">Centre Bell</option>
							            <option value="4">Stade olympique</option>
							            <option value="5">Place des Arts</option>
						            </select>
                                </td>
                                <td><input type="text" name="start-time" class="generic-timepicker generic-textbox"/></td>
                                <td><input type="text" name="end-time" class="generic-timepicker generic-textbox"/></td>
                                <td><input type="text" name="ticket-cost" class="ticket-cost generic-textbox"/></td>
                            </tr>
                        </table>
                        <div class="representation-list-item-controller">
                            <div class="generic-button add-event-representation-button">
						        Ajouter une représentation
					        </div>
                        </div>
					</div>
				</form>
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
				$(".generic-datepicker").datepicker($.datepicker.regional["fr"])
                .mask("99/99/9999");

				$(".generic-timepicker").timepicker($.timepicker.regional["fr"])
                .mask("99:99");

				$(".ticket-cost").mask("999.99");
			}
		);
	</script>
</html>