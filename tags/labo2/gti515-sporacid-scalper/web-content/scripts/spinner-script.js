// Length in miliseconds between each of the spinner thread's execution
var cSpinnerSpinLength = 5000;

// Length in milliseconds for the fade in/out of the spin
var cSpinnerFadeLength = 350;

/*
* Document ready event handler for spinner elements
*/
$(document).ready(
	function()
	{
		
		var spinner = $(".upcoming-shows-spinner-container");
		var spinnerButtons = spinner.find(".upcoming-shows-spinner-button");
		var spinnerItems = spinner.find(".upcoming-shows-spinner-item");
			
		spinnerButtons.first().addClass("is-selected");
		
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
