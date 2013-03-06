<%@ page import="sporacidscalper.model.beans.ArtisteBean"%>
<%@ page import="sporacidscalper.model.beans.TypeSpectacleBean"%>
<%@ page import="sporacidscalper.model.beans.SalleBean"%>
<%@ page import="sporacidscalper.model.beans.TypeSpectacleBean"%>
<%@ page import="java.util.ArrayList;"%>
	
<!DOCTYPE html>
<%
	// Get the context url prefix 
	String contextAttr = (String) request.getContextPath();

	ArrayList<ArtisteBean> listeArtistes = (ArrayList<ArtisteBean>) request.getAttribute("listeArtistes");
	ArrayList<SalleBean> listeSalles = (ArrayList<SalleBean>) request.getAttribute("listeSalles");
	ArrayList<TypeSpectacleBean> listeTypesSpectacle = (ArrayList<TypeSpectacleBean>) request.getAttribute("listeTypesSpectacle");

%>
<html>
<head>
<title>Billets Sporacid</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=contextAttr%>/styles/site.css" />
<link rel="stylesheet" type="text/css"
	href="<%=contextAttr%>/styles/admin.css" />
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/jquery-1.9.0.min.js"></script>
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/site-scripts.js"></script>
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/jquery.maskedinput.min.js"></script>
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/jquery.ui.datepicker-fr.js"></script>
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/jquery.ui.timepicker.js"></script>
<script type="text/javascript"
	src="<%=contextAttr%>/scripts/jquery.ui.timepicker-fr.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
</head>
<body>

	<%-- Include the header in the page --%>
	<jsp:include page="partial-views/header.jsp"></jsp:include>

	<div class="main-container">

		<%-- Include the menu container in the page --%>
		<jsp:include page="partial-views/menu.jsp"></jsp:include>

		<div class="content">
			<form method="POST" action="<%=contextAttr%>/admin/ajouter-spectacle">
				<h2>Ajouter un spectacle</h2>
				<div class="add-event-description">
					<h3>Détail du spectacle</h3>
					<br />
						<div class="add-event-description-item">
 							<label for="type" class="generic-label">Type :</label>								
							<select id="select-TypeSpectacle" class="generic-select">
								<% for (int i = 0; i < listeTypesSpectacle.size(); i++) {
										TypeSpectacleBean type = listeTypesSpectacle.get(i);
								%>
									<option value=<%=type.getId()%>><%=type.getNom()%></option>
								<% } %>
							</select>
						</div>
						<div class="add-event-description-item">
							<label for="artiste" class="generic-label">Artistes :</label> 
							<select id=select_artiste class="generic-listbox select-artiste" name="artistes" size="5" multiple="multiple">
								<% for (int i = 0; i < listeArtistes.size(); i++)  {
										ArtisteBean artistes = listeArtistes.get(i);
								%>
									<option value=<%=artistes.getId()%>><%=artistes.getNom()%></option>
								<% } %>
							</select>
	
						</div>
						<div class="add-event-description-item">
							<label for="nomSpectacle" class="generic-label">Nom du spectacle :</label> 
							<input type="text" name="nomSpectacle" class="generic-textbox" />
							<br />
						</div>
	
	
						<div class="add-event-description-item">
							<label for="posterUrl" class="generic-label">URL du poster:</label> 
							<input type="text" name="posterUrl" class="generic-textbox" />
							<br />
						</div>
	
						<div class="add-event-description-item">
							<label for="description" class="generic-label">Description du Spectacle:</label> 
							<textarea name="description" class="generic-textarea"></textarea>
						</div>

					</div>
					<div class="add-event-representations">
						<h3>Représentations</h3> 
						<table class="add-representations-table">
							<tr>
								<th><label class="generic-label">Date</label></th>
								<th><label class="generic-label">Salle</label></th>
								<th><label class="generic-label">Début</label></th>
								<th><label class="generic-label">Fin</label></th>
								<th><label class="generic-label">Prix</label></th>
							</tr>
							<tr class="add-representations-table-model-row">
								<td><input type="text" name="date" class="generic-datepicker" /></td>
								<td>
									<select id="select-place" class="generic-select">
									<%	for (int i = 0; i < listeSalles.size(); i++) 
										{
											SalleBean salle = listeSalles.get(i);
								    %>
											<option value=<%=salle.getId()%>><%=salle.getNom()%></option>
									<%
										}
									%>
									</select>
								</td>
								<td><input type="text" name="start-time" class="generic-timepicker" /></td>
								<td><input type="text" name="end-time" class="generic-timepicker" /></td>
								<td><input type="text" name="ticket-cost" class="generic-textbox ticket-cost" /></td>
								<td><div class="generic-button representation-table-add-item-button">&nbsp;</div></td>
							</tr>
						</table>
					</div>
					
						
					<div class="add-event-item-controller">
							<div class="generic-button add-event-representation-button">
								Sauvegarder
							</div>
						<!-- <input type="submit" value="Sauvegarder"
							id="add-event-representation-button" class="generic-button" /> -->
					</div>
				</div>
			</form>
		</div>
	</div>
	<%-- Include the footer in the page --%>
	<jsp:include page="partial-views/footer.jsp"></jsp:include>

</body>

<script type="text/javascript">
	$(document).ready(
			function() 
			{		

				
				$(".add-event-spectacle-button").click(
						function()
						{
							var name = $(this).parents(".add-events").find(".name").val();
							var type = $(this).parents(".add-events").find(".type").val();
							var artistes = $(this).parents(".add-events").find(".artistes").val();
							var posterUrl = $(this).parents(".add-events").find(".posterUrl").val();
							var description = $(this).parents(".add-events").find(".description").val();
						
							var fakeForm = $("<form></form>")
								.attr("action", "<%=contextAttr%>/administration/ajouter-spectacle")
													.attr("method", "POST");

											fakeForm
													.append($("<input></input>")
															.attr("type",
																	"hidden")
															.attr("name",
																	"name")
															.val(name));
											fakeForm
													.append($("<input></input>")
															.attr("type",
																	"hidden")
															.attr("name",
																	"type")
															.val(type));
											fakeForm
													.append($("<input></input>")
															.attr("type",
																	"hidden")
															.attr("name",
																	"artistes")
															.val(artistes));
											fakeForm
													.append($("<input></input>")
															.attr("type",
																	"hidden")
															.attr("name",
																	"posterUrl")
															.val(posterUrl));
											fakeForm
													.append($("<input></input>")
															.attr("type",
																	"hidden")
															.attr("name",
																	"description")
															.val(description));

											fakeForm.submit();
						});
				
				addRepresentationRow();	
			});
	
	function addRepresentationRow()
	{
		var table = $(".add-representations-table");
		var modelRow = table.find(".add-representations-table-model-row");
		
		if(modelRow.length === 1)
		{
			var cloneRow = modelRow.clone();
			cloneRow.removeClass("add-representations-table-model-row");
			cloneRow.addClass("add-representations-new-table-row");
			table.append(cloneRow);
			
			// Initialisation of the jQuery UI datepicker, timepicker
			initialiseRepresentationRow(cloneRow);
		}
	}
	
	/*
		Initialisation of the jQuery UI datepicker, timepicker
	*/
	function initialiseRepresentationRow(row)
	{
		var wrappedRow = $(row);
		
		if(wrappedRow.hasClass("add-representations-new-table-row"))
		{			
			wrappedRow.find(".generic-datepicker").datepicker($.datepicker.regional["fr"]).mask("99/99/9999");
			wrappedRow.find(".generic-timepicker").timepicker($.timepicker.regional["fr"]).mask("99:99");
			wrappedRow.find(".ticket-cost").mask("999.99");
			
			wrappedRow.find(".representation-table-add-item-button").click(
				function()
				{
					wrappedRow.removeClass("add-representations-new-table-row");
					wrappedRow.addClass("add-representations-added-table-row");
					wrappedRow.find(".representation-table-add-item-button").hide();
					addRepresentationRow();
				});
		}
	}
</script>
</html>