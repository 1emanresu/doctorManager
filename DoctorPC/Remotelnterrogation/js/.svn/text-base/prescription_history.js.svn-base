$.fn.datetimepicker.dates['cn'] = {
    days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
    daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
    daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    today: "今天",
    meridiem:[]
};
$(function() {
    $('#datetimepicker').datetimepicker({
    	language: 'cn',
        minView : 'month'
	});
	$('#datetimepicker').datetimepicker().on('changeDate',function(ev){
	    /*var window_height = $(document).height()/2,
	        window_width = $(document).width()/2,
	        details_height = $('.class_serious_risk').height()/2,
	        details_width = $('.class_serious_risk').width()/2,
	        details_top = window_height - details_height,
	        details_left = window_width - details_width;
	    $(".class_serious_risk").css({
	        top : details_top+"px",
	        left: details_left+"px"
	    });*/
	    //setCenter('.class_serious_risk');
	    $(".class_serious_risk").show();
	});
    $("#img_firstDiagnos_serious_close").click(function() {
        $(".class_serious_risk").hide();
    });
});
//var setCenter = function(el) {
//	var window_height = $(document).height()/2,
//	    window_width = $(document).width()/2,
//	    details_height = $(el).height()/2,
//	    details_width = $(el).width()/2,
//	    details_top = window_height - details_height,
//	    details_left = window_width - details_width;
//	$(el).css({
//	    top : details_top+"px",
//	    left: details_left+"px"
//	});
//}
/*var clickDay;
var cld = new Calendar({
	el: 'body',
	value: '', // 默认为new Date();
	callback: function(obj) {
		console.log(JSON.stringify(obj));
		clickDay = obj.day;
		console.log(clickDay);
		//日历点击事件要进行的操作在此做
	}
});
/*获取日期*/
/*var dateObj = new Date();
var nowDate = dateObj.getDate();*/
/*数组表示用药记录日期，通过ajax从后台获取*/
/*var signList = [{
	"signDay": {
		"moth": "8",
		"day": "20"
	},
	"value": "hello"
}, {
	"signDay": {
		"moth": "8",
		"day": "21"
	},
	"value": "hello2"
}];

var canChooses = document.querySelectorAll(".canChoose");
for(i = 0; i < canChooses.length; i++) {
	for(var j = 0; j < signList.length; j++) {
		if((i + 1) == signList[j].signDay.day) {
			canChooses[i].classList.add("chose");
		}
	}
}*/