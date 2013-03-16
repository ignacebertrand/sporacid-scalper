/*
* Document ready event handler for spinner elements
*/
$(document).ready(
	function()
	{
		
		var pager = $(".event-list-pager");
		var pagerButtons = pager.find(".event-list-pager-button");
		var pages = $(".event-list");
			
		pagerButtons.first().addClass("is-selected");
		
		//Individual tab click handling
		//Shows the chosen spinner item
		pagerButtons.click(
			function()
			{
				var index = pagerButtons.index(this);
				var pageToShow = pages.eq(index);

				if(pageToShow.length === 1)
				{
					pagerButtons.removeClass("is-selected");
					$(this).addClass("is-selected");
					
					pages.not(":eq(" +  index + ")").hide();
					pageToShow.show(); 
				}
			}
		);
		
//		//Next tab click handling
//		//Shows the next spinner item
//		spinner.find(".upcoming-shows-spinner-back").click(
//			function()
//			{
//				var index = spinnerItems.index($(".upcoming-shows-spinner-item:visible")) - 1;
//				
//				if(index >= 0)
//				{
//					var itemToShow = spinnerItems.eq(index);
//					
//					if(itemToShow.length === 1)
//					{
//						spinnerButtons.removeClass("is-selected");
//						spinnerButtons.eq(index).addClass("is-selected");
//						
//						spinnerItems.not(":eq(" +  index + ")").hide();
//						itemToShow.fadeIn(cSpinnerFadeLength); 
//					}
//				}
//			}
//		);
//		
//		//Previous tab click handling
//		//Shows the previous spinner item
//		spinner.find(".upcoming-shows-spinner-next").click(
//			function()
//			{
//				var index = spinnerItems.index($(".upcoming-shows-spinner-item:visible")) + 1;
//				
//				if(index <= spinnerItems.length)
//				{
//					var itemToShow = spinnerItems.eq(index);
//					
//					if(itemToShow.length === 1)
//					{
//						spinnerButtons.removeClass("is-selected");
//						spinnerButtons.eq(index).addClass("is-selected");
//						
//						spinnerItems.not(":eq(" +  index + ")").hide();
//						itemToShow.fadeIn(cSpinnerFadeLength); 
//					}
//				}
//			}
//		);
	}
);
