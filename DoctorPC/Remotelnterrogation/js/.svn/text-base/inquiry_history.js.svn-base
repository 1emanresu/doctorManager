/*历史问诊记录js文件 wuwj*/
var address=sessionStorage.getItem("address");
var mid=sessionStorage.getItem("mid");

$(function(){
	//setCenter('.swiper-container');
	//setCenter('.div_interrogation');
	//setCenter('.div_advice');
})

$("#img_close_weekreport").click(function() {
    $(".swiper-container").hide();
});
$("#img_div_interrogation_close").click(function() {
    $(".div_interrogation").hide();
});
$("#img_div_advice_close").click(function() {
    $(".div_advice").hide();
});
	
function seeBigImg(e){
	var Img = new Image();
	Img.src =$(e).attr("src");
	Img.onload = function() {
		var window_height = window.innerHeight/2;
	    window_width = window.innerWidth/2;
	    details_height =Img.height/2,
	    details_width = Img.width/2,
	    details_top = window_height - details_height,
	    details_left = window_width - details_width;
		$("#img_full").css({
		    top : details_top+"px",
		    left: details_left+"px"
		});
	}
	$("#img_full").attr("src",$(e).attr("src"));
	$("#img_full").show();
	$("#div_full_gray").show();
};
var getWeekreport = function(i) {
	var date1=new Date();
	var year = date1.getFullYear();
	var month = date1.getMonth() + 1;
	if(month < 10) {
		month = "0" + month;
	};
	var strDate = Number(i);
	if(strDate < 10) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator + month + seperator + strDate;
	sessionStorage.setItem("weeklyReportDate",currentdate);
	var week=getWeeks($("#span_endDate").text()).weeks;
	sessionStorage.setItem("week",week);
	$("#iframe_report1").attr("src","weeklyTemplate.html");
	$('.swiper-container').show();
 /*   var reportheight = document.getElementById("iframe_report1").contentDocument.body.scrollHeight,
        iframe_h = $("#iframe_report1").height(),
        iframe_height = iframe_h - 40,
        iframe_count = reportheight/iframe_height;
    $("#iframe_report1").height(iframe_height+"px");
     $(".swiper-wrapper").html("");
    for(var i=1;i<=iframe_count;i++) {
    	var iframe_tmp = "<div class='swiper-slide'>"+
        	"<iframe frameborder='0' height='"+(parseInt(iframe_h)*(i+1)-85)+"px' style='top: -"+((parseInt(iframe_h)*i)-45)+"px' class='iframeReport' src='weeklyTemplate.html'></iframe>"+
        	"<div class = 'divReportCover'></div>"+
        	"</div>";

    }*/
        //$(".swiper-wrapper").append("<iframe height='500px'  src='weeklyTemplate.html'></iframe>");
    
  /*  var mySwiper = new Swiper('.swiper-container',{ 
	    initialSlide: 0,
	    autoplay: false,
    	centeredSlides: true,
    	slidesPerView: 1,
    	grabCursor: true,
    	pagination : '.swiper-pagination', 
    	paginationClickable: true,
    });*/
};
var getInterrogation = function(i) {
	$.ajax({
		type: "post",
		url: address + "inquiryRecord/findRecordByDate.do",
		data: {
			"mid": mid,
			"day":i
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var data = e.data;
			var date = new Date(data.qdate);
			var week=getWeeks(sessionStorage.getItem("enddate"),date).weeks;
			$(".recordgravidaweek").html(week+"周");
			var day=date.getDate();
			var month=date.getMonth()+1;
			var year=date.getFullYear();
			var firstStr=year+"/"+month+"/"+day+"问诊记录";
			$(".div_record_date2").text(firstStr);
			if(month<10){
				month="0"+month
			}
			if(day<10){
				day="0"+day
			}
			var dateStr=year+"-"+month+"-"+day
			$("#span_record_date").text(dateStr);
			var rationalsymptom =data.rationalsymptom;
			if(rationalsymptom==null||rationalsymptom.trim()==""){
				$(".td_rationalsymptom").html("无");
			}else{
				var selfDecrition=rationalsymptom.split("~");
				var secondStr='';
				for(var i=0;i<selfDecrition.length;i++){
					secondStr+=selfDecrition[i]+"<br/>";
				}
				$(".td_rationalsymptom").html(secondStr);
			}
			var thirdStr=data.doctoradvice;
			$(".td_doctor_Advice").html(thirdStr);
			var date2=new Date(data.uploaddate);
			$.ajax({
				type: "post",
				url: address + "abnormityinfo/findWeeklyAbnormityinfo2.do",
				data: {
					"mid": mid,
					"uploaddate":date2
				},
				dataType: "json",
				ContentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(e) {	
					var list=e.data[1];
					var tableStr='';
					$.each(list, function(i) {
						tableStr+="<tr class='tr_add_more'><td id='td_expectDate_title' width='50px' class='tdFontSize'>"+list[i].checkindex.cname+"</td><td id='td_expectDate_detail' class='tdFontSize tdRedWord'>"+list[i].abnormity+"</td></tr>"
					});
					$(".tr_add_more").remove(); 
					$("#table_Abnormal_report").append(tableStr);
					$('#table_Abnormal_report tr').show();
					if(list.length==0){
						$('#table_Abnormal_report tr').hide();
						$("#table_Abnormal_report").after("<div class='tr_add_more' style='margin-top:-10px'>无<div>");
					}
				},
				error: function() {
					
				}
			});
			$.ajax({
				type: "post",
				url: address + "abnormityinfo/findSelfTestAbnormityinfo.do",
				data: {
					"mid": mid,
					"uploaddate":date2
				},
				dataType: "json",
				ContentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(e) {
					var list=e.data;
					var tableStr1='';
					$.each(list, function(i) {
						if(i%3==0){
							tableStr1+="<tr class='tr_add'><td id='td_endDate_title' class='tdFontSize tdcol6Content' colspan='2'>"+list[i]+"</td>";
						}else if(i%3==1){
							tableStr1+="<td id='td_endDate_title' class='tdFontSize tdcol6Content' colspan='2'>"+list[i]+"</td>";
						}else if(i%3==2){
							tableStr1+="<td id='td_endDate_title' class='tdFontSize tdcol6Content' colspan='2'>"+list[i]+"</td></tr>";
						}
						if(i==list.length-1&&i%3!=2){
							tableStr1+="</tr>";
						}
					});
					
					$(".tr_add").remove();
					$("#family_self_test").after(tableStr1);
					if(list.length==0){
						$("#family_self_test").after("<div class='tr_add'>无<div>");
					}
				},
				error: function() {
					
				}
			});
		},
		error: function() {
			
		}
	});	
	$('.div_interrogation').show();
};
var getAdvice = function(i) {
	$.ajax({
		type: "post",
		url: address + "doctorAdvice/findTheRecord.do",
		data: {
			"mid": mid,
			"i":i
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var data=e.data;
			var date = new Date(data.advicedate);
			var week=getWeeks(sessionStorage.getItem("enddate"),date).weeks;
			$(".recordgravidaweek2").html(week+"周");
			var day=date.getDate();
			var month=date.getMonth()+1;
			var year=date.getFullYear();
			var firstStr=year+"/"+month+"/"+day+"医嘱记录";
			$(".div_doctor_Advice_Date").text(firstStr);
			if(month<10){
				month="0"+month
			}
			if(day<10){
				day="0"+day
			}
			var dateStr=year+"-"+month+"-"+day
			$(".td_Advice_Date").text(dateStr);
			
			var secondStr=data.myknowledge;
			$(".td_Doctor_Advice2").text(secondStr);
			var img=data.prescriptionimg;
			if(img!=null){
				$(".tr_prescriptionimg").remove();
				//上传处方暂时没有,临时写死图片地址
				img="images/u16589.png";
				var trStr="<tr class='tr_prescriptionimg'><td id='td_endDate_title' class='tdFontSize' colspan='6' valign='bottom' height='200px'><img ondblclick='seeBigImg(this)' src='"+img+"' width='200px'><span style='display: block; color: red;'>双击查看大图</span></td></tr>";
				$("#tr_prescriptionimg").after(trStr)
			}else{
				$(".tr_prescriptionimg").remove();
				var trStr="<tr class='tr_prescriptionimg'><td>暂无</td></tr>"
				$("#tr_prescriptionimg").after(trStr)
			}
		},
		error: function() {
			
		}
	});
	$('.div_advice').show();
};
