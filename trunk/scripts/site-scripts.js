/*
* Document ready event handler for the site's generic calls.
*/
$(document).ready(
	function()
	{
		//On window resize, resize the whole document.
		//Keeps the document "full screen"
		$(window).resize(
			function()
			{
				resizeContent();
			}
		);
		resizeContent();
	
		//Bind mouse over and mouse out event for the sub menus.
		//Toggles the sub menu visibility.
		$(".menu-item:has(.sub-menu-container)").mouseover(
			function(event)
			{
				var top = $(this).outerHeight();
				var submenu = $(this).find(".sub-menu-container")
				
				submenu.css("top", top + "px");
				submenu.show();
			}
		).mouseout(
			function(event)
			{
				$(this).find(".sub-menu-container").hide();
			}
		);
		
		//The shopping cart button and the shopping cart desc both offer the same
		//functionnality, but are two representations of it.
		//Clicking the button will redirect to the same link as the desc.
		$(".shopping-cart-button").click(
			function(event)
			{
				window.location = $(".shopping-cart-desc").attr("href");
			}
		);
	}
);

/*
* Resize the content area of the page according to header, footer and menu current height.
*/
function resizeContent()
{		
	//Set the content to fit the browser's height
	var contentHeight = $(window).innerHeight() - $(".header").outerHeight(true) - $(".footer").outerHeight(true) - $(".menu-container").outerHeight(true);
	//Remove top and bottom padding; I don't want to parse them.
	contentHeight -= 60;
	
	$(".content").height(contentHeight);
}