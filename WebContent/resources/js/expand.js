
$(function() {

	$("a.expand").click(function() {
		var expandRow = $(this).parents("tr").next("tr.expand-content");
		var expandContent = expandRow.find("div.expand-content");
		var isVisible = expandContent.is(":visible");
		
		if(!isVisible)
			expandRow.show();
		
		expandRow.find("div.expand-content").slideToggle(350, function() {
			if(isVisible)
				expandRow.hide();
		});
		return false;
	});
	
});

