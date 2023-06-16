function configureLoadingScreen(){
    $(document)
        .ajaxStart(function () {
        	$("#preload").removeAttr('style');
        })
        .ajaxStop(function () {        	
        	$("#preload").fadeOut();        	
        });
}
