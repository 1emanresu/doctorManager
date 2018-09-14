var back = sessionStorage.getItem('backonly');
$(function(){
	showHead();
})
function showHead(){
	if(back == 1){
		$('.return2').show();
		$('.return3').hide();
	}else{
		$('.return2').hide();
		$('.return3').show();
	}
	
}
