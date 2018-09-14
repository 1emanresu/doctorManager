/*@author wangzw*/

function clickShowMore(num){
	$(".div_firstDiagnose_show1").find(".item").removeClass("active");
	$("#div_firstDiagnose_container").css("display","block");
	$(".a_firstDiagnose_href").attr("href","#carousel-345482");
	$(".div_firstDiagnose_show1").find(".item").eq(num).addClass("active");
} 

$('.carousel').carousel({
	pause: true,
	interval: false
}); 
function showMore(num){
	$("#div_firstDiagnose_container").css("display","none");
	$(".a_firstDiagnose_href").attr("href","#carousel-345483");
	$(".div_firstDiagnose_show2").find(".item").removeClass("active");
	$(".div_firstDiagnose_show2").find(".item").eq(num).addClass("active");
	$(".img_firstDiagnose_popup_middle").modal("show");
}
function showMoreImg(num){
	$(".div_firstDiagnose_sh").find(".item").removeClass("active");
	$(".div_firstDiagnose_sh").find(".item").eq(num).addClass("active");
}
function showDate(num){
	for(var i=1;i<=7;i++){
		$(".btn"+i).css("display","none");
		$("#btn"+i).removeClass("back");
		$("#btn"+i).find("img").attr("src","images/img_"+i+".png");
	}
	$("#btn"+num).find("img").attr("src","images/imgs_"+num+".png");
	$("#btn"+num).addClass("back");
	$(".btn"+num).css("display","block");
}

$("#save").click(function(){
	$("#div_firstDiagnose_four a").click();
})
$("#cancle").click(function(){
	$("#div_firstDiagnose_three a").click();
})
