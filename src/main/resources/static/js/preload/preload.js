/*$(function() {
	var screen = $('#loading-screen');
    configureLoadingScreen(screen);
});*/

$(window).bind('beforeunload', function() {
	//console.log("realizando preload");
	$("#preload").removeAttr('style');
});

$(document).on('submit', 'form', function() {
	$("#preload").removeAttr('style');
});

$(window).on("load", function() {
	//console.log("realizando preload D***");
	$("#preload").fadeOut();
});

function preload() {
	$("#preload").delay(200).fadeIn("slow");
}

$(document).on('click', '.prelo', function() {
	$("#preload").removeAttr('style');
});

