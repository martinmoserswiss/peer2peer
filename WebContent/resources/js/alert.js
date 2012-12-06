/*! jQuery Alert Plugin - v0.1 - 10/9/2012
* Copyright (c) 2012 Marc Wacker; Licensed MIT, GPL */


(function($) {

	$.extend($.fn, {
		appendAlertHandler: function() {

			if(!this.length) {
				return;
			}
			
			var alertHandler = $.data(this[0], 'alertHandler');
			if( alertHandler ) {
				return alertHandler;
			}
			
			alertHandler = new $.alertHandler( this );
			$.data(this[0], 'alertHandler', alertHandler);
			
			this.alertDelegate( "a.close", "click", function(ev) {
				alertHandler.hide();
			});
			
			return alertHandler;
		}
	});

	//constructor for alertHandler
	$.alertHandler = function( alertContainer ) {
		this.settings = $.extend( {}, $.alertHandler.defaults );
		this.init( alertContainer );
	};

	
	$.extend($.alertHandler, {

		defaults: {
			alertTypes: [ "error", "success", "notification" ]
			
		},
	
		
		prototype: {
			init: function( alertContainer ) {
				this.alertContainer = alertContainer;
				
				//construct default layout
				this.alertContainer.html(
					'<div class=\"alert-icon\"></div>' +
					'<div class="alert-content">default test notification text</div>' +
					'<div class="alert-buttons"><a class="close">X</a></div>' 
				);
				
				this.alertContainer.hide();
				
			},
			
			display: function( type, msg, duration, instant ) {
				alertContainer = this.alertContainer;
				
				//remove current alert classes if they exist
				$.each(this.settings.alertTypes, function(key, value) { 
					alertContainer.removeClass("alert-" + value);
				});

				//check if type is valid
				if($.inArray(type, this.settings.alertTypes) == -1)
					return;
				
				alertContainer.addClass( "alert-" + type );
				alertContainer.find(".alert-content").html(msg);
				
				var fadeInTime = 0;
				if( instant !== true )
					fadeInTime = 500;
					
				if(alertContainer.is(':visible') && fadeInTime > 0)
					alertContainer.fadeOut( 150, $.proxy(function() { alertContainer.fadeIn( 150, $.proxy(function() 
							{ 
								if( duration > 0 )
									setTimeout( $.proxy(function() { this.hide(); }, this), duration ); 
							}, this)); }, this));
				else
					alertContainer.fadeIn( fadeInTime, $.proxy(function() 
							{ 
								if( duration > 0 )
									setTimeout( $.proxy(function() { this.hide(); }, this), duration ); 
							}, this));


			},
				
			hide: function() {

				this.alertContainer.slideUp(500);
			}
		}
	
		
	});
			
		
	$.extend($.fn, {
		alertDelegate: function(delegate, type, handler) {
			return this.bind(type, function(event) {
				var target = $(event.target);
				if (target.is(delegate)) {
					return handler.apply(target, arguments);
				}
			});
		}
	});


	

})(jQuery);

$(function() {
	//demo output
	/*
	demoAlertHanlder = $(".alert").appendAlertHandler();
	var currentExample = 0;
	var exampleArray = new Array();
	exampleArray[0] = new Array('notification', 'notification alert example');
	exampleArray[1] = new Array('success', 'success alert example');
	exampleArray[2] = new Array('error', 'error alert example');
	
	var currentDuration = 0;
	var exampleDuration= new Array();
	exampleDuration[0] = 0;
	exampleDuration[1] = 3000;
	
	
	setInterval( function() {
		
			demoAlertHanlder.display( exampleArray[currentExample][0], exampleArray[currentExample][1], exampleDuration[currentDuration] );
			currentExample = (currentExample+1)%exampleArray.length;
			if(currentExample%exampleArray.length == 0)
				currentDuration = (currentDuration+1)%exampleDuration.length;
	}, 5000);

	demoAlertHanlder.display( exampleArray[2][0], exampleArray[2][1], 0 );/*/
	alertHandler = $(".alert").appendAlertHandler();/**/
});



