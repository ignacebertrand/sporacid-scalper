/*
* Document ready event handler for the site's generic calls.
*/
$(document).ready(
	function()
	{
		//Shows the server message with a timeout (Hide it after a certain number of milliseconds)
		setServerMessageTimer();
		
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
				var submenu = $(this).find(".sub-menu-container");
				
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
		//functionality, but are two representations of it.
		//Clicking the button will redirect to the same link as the desc.
		$(".shopping-cart-button").click(
			function(event)
			{
				window.location = $(".shopping-cart-desc").attr("href");
			}
		);
		

		// Business rule 10
		// Free reservations in the shopping cart if there's 10 min of inactivity
		setTimeout(libererReservations, 10 * 60 * 1000);
		
		// Free reservations in the shopping cart if the client quits
		window.onbeforeunload = libererReservations;
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

/*
 * Free reservation in the shopping cart
 */
function libererReservations()
{
	// Submit an empty form to access the POST method
	$("<form></form>").attr("action", "/gti515-sporacid-scalper/panier-achat/supprimer-panier-achat").attr("method", "POST").submit();
}

/*
 * 
 */
function setServerMessageTimer()
{
   //Used to clear the timeout
   var timeoutIdentifier = -1;

   //Set the timeout in a function because we'll call it a couple of times.
   var timeout = function (pTimeoutTime, pFadeOutTime)
   {
      timeoutIdentifier = setTimeout(
         function ()
         {
            $(".application-messages").fadeOut(pFadeOutTime, "linear",
               function ()
               {
                  $(this).remove();
               }
            );
         }
      , pTimeoutTime);
   };

   //Basically we want the message to dissappear unless we hover on it.
   //When hovered in the message will last forever,
   //When hovered out, the timeout is reset.
   $(".application-messages").mouseover(
      function ()
      {
         $(this).stop();
         $(this).css("opacity", "1");

         clearTimeout(timeoutIdentifier);

         $(this).one("mouseout",
            function ()
            {
               timeout(350, 350);
            }
         );
      }
   );

   timeout(1000, 500);
}