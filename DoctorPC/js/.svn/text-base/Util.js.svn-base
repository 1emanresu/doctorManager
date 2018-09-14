//计算当前孕周--通用方法 参数为时间格式1990-1-1,返回json
function getWeeks(date1) {
	if(date1 == "" || date1 == undefined || date1 == null) {
		return '';
	}
	var date2 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}

//计算一个时间里孕妇的孕周，参数1 末次月经，，参数2指定时间
function getWeeksToDate(date1, date2) {
	if(date1 == "" || date1 == undefined || date1 == null) {
		return '';
	}
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}

//返回一个时间加上几天后的时间参数1 加的天数   参数2 指定时间
function DateAdd(number, date1) {
	date1.setDate(date1.getDate() + number);
	return date1;
}
//日期格式转换，把时间戳格式转换为2017-12-12格式
function getDateString(mydate) {
	var d = new Date(mydate);
	//格式化日，如果小于9，前面补0  
	var day = ("0" + d.getDate()).slice(-2);
	//格式化月，如果小于9，前面补0  
	var month = ("0" + (d.getMonth() + 1)).slice(-2);
	//拼装完整日期格式  
	var date1 = d.getFullYear() + "-" + (month) + "-" + (day);
	return date1;

}
//輸出下拉框weeksQuery
function prfweeksQuery() {
	var str = "";
	str = str.concat('<option value="1-41">选择孕周</option>');
	str = str.concat('<option value="6-13">6-13周</option>');
	str = str.concat('<option value="14-20">14-20周</option>');
	str = str.concat('<option value="20-24">20-24周</option>');
	str = str.concat('<option value="24-28">24-28周</option>');
	str = str.concat('<option value="28-32">28-32周</option>');
	str = str.concat('<option value="33-36">33-36周</option>');
	str = str.concat('<option value="37-41">37-41周</option>');
	return str;
}

//返回预产期-参数为时间类型
function getBudgetDate(date1) {
	var date2 = new Date(date1);
	date2.setDate(date1.getDate() + 280);
	var times = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
	return times;
}

//long类型转为时间类型
function longToDate(long) {
	var myDate = new Date(long);
	var date2 = myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" + myDate.getDate();
	return date2;
}

//计算剩余天数
function surplusDay(date2) {
	var date1 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	return days;
}

//undefined处理
function un(data) {
	if(data == undefined) {
		return "-";
	}
	return data;
}

/*根据出生日期算出年龄*/
function getAge(strBirthday) {
	var returnAge;
	var strBirthdayArr = strBirthday.split("-");
	var birthYear = strBirthdayArr[0];
	var birthMonth = strBirthdayArr[1];
	var birthDay = strBirthdayArr[2];

	d = new Date();
	var nowYear = d.getFullYear();
	var nowMonth = d.getMonth() + 1;
	var nowDay = d.getDate();

	if(nowYear == birthYear) {
		returnAge = 0; //同年 则为0岁  
	} else {
		var ageDiff = nowYear - birthYear; //年之差  
		if(ageDiff > 0) {
			if(nowMonth == birthMonth) {
				var dayDiff = nowDay - birthDay; //日之差  
				if(dayDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			} else {
				var monthDiff = nowMonth - birthMonth; //月之差  
				if(monthDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			}
		} else {
			returnAge = ""; //返回-1 表示出生日期输入错误 晚于今天  
		}
	}
	return returnAge; //返回周岁年龄  
}

//返回高危类型
function getHighType(hScore) {
	if(hScore > 0 && hScore <= 5) {
		return "<span style='color:red;'>轻度高危</span>";
	}
	if(hScore > 5 && hScore <= 10) {
		return "<span style='color:red;'>中度高危</span>";
	}
	if(hScore > 10 && hScore <= 15) {
		return "<span style='color:red;'>重度高危</span>";
	}
	if(hScore >= 20) {
		return "<span style='color:red;'>极度高危</span>";
	}
	return "无高危";
}

//获取本个星期的星期天日期--zhangqt
function getSunday() {
	var now = new Date();
	var nowTime = now.getTime();
	var day = now.getDay();
	var oneDayTime = 24 * 60 * 60 * 1000;
	var SundayTime = nowTime + (7 - day) * oneDayTime;
	var mydate = new Date(SundayTime);
	var date = mydate.getFullYear() + "-" + (mydate.getMonth() + 1) + "-" + mydate.getDate();
	return date;
}

//获取当前月份的最后一天
function getLastDay() {
	var mydate = new Date();
	var year = mydate.getFullYear();
	var month = mydate.getMonth() + 1;
	var day = new Date(year, month, 0);
	var lastdate = year + '-' + month + '-' + day.getDate(); //获取月份的最后一天
	return lastdate;
}

//查看原始报告
var absolutePositionFlag = true;
var imgTop = 0;
var imgLeft = 0;
$("body").append("<img id='img_full' src='' onclick='closefullimg()' /><div id='div_full_gray' onclick='closefullimg()'></div>");
$("#img_full").css({
	"z-index": "12",
	"display": "none",
	"position": "fixed",
})
$("#div_full_gray").css({
	"background-color": "black",
	"opacity": "0.7",
	"z-index": "10",
	"position": "fixed",
	"height": "100%",
	"width": "100%",
	"left": "0",
	"top": "0",
	"display": "none",
})

function seeOriginalReport(src) {
	absolutePositionFlag = true;
	$("#img_full").css("position", "fixed");
	if(src == '' || src == undefined) {
		alert("暂无原始报告单");
	} else {
		var Img = new Image();
		Img.src = src;
		Img.onload = function() {
			var window_height = window.innerHeight / 2;
			window_width = window.innerWidth / 2;
			details_height = Img.height / 2,
				details_width = Img.width / 2;
			details_top = window_height - details_height,
				details_left = window_width - details_width;
			if(details_height > window_height) {
				details_top = 0;
			}
			if(details_width > window_width) {
				details_left = 0;
			}
			imgTop = details_top;
			imgLeft = details_left;
			$("#img_full").css({
				top: details_top + "px",
				left: details_left + "px"
			});
			//如果图片过大，让图片按原来的比例自适应屏幕大小，居中显示。
			if(details_width > window_width || details_height > window_height) {
				if((Img.height / Img.width * window.innerWidth) < window.innerHeight) {
					$("#img_full").css("width", window.innerWidth * 0.8 + "px");
					$("#img_full").css("height", Img.height / Img.width * window.innerWidth * 0.8 + "px");
					imgTop = window.innerHeight / 2 - (Img.height / Img.width * window.innerWidth * 0.8 / 2);
					imgLeft = window.innerWidth * 0.1;
				} else {
					$("#img_full").css("width", Img.width / Img.height * window.innerHeight * 0.8 + "px");
					$("#img_full").css("height", window.innerHeight * 0.8 + "px");
					imgTop = window.innerHeight * 0.1;
					imgLeft = window.innerWidth / 2 - (Img.width / Img.height * window.innerHeight * 0.8 / 2);

				}
				$("#img_full").css("left", imgLeft + "px");
				$("#img_full").css("top", imgTop + "px");
			}
		}
		$("#img_full").attr("src", src);
		setTimeout(function() {
			$("#img_full").show();
			$("#div_full_gray").show();
		}, 100);

	}
}
//添加鼠标滚轮事件处理代码  
var myimage = document.getElementById("img_full");
if(myimage.addEventListener) {
	// IE9, Chrome, Safari, Opera  
	myimage.addEventListener("mousewheel", MouseWheelHandler, false);
	// Firefox  
	myimage.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
}
// IE 6/7/8  
else {
	myimage.attachEvent("onmousewheel", MouseWheelHandler);
}
//为了让不同浏览器都能支持的处理做法,我们将对Firefox的detail值取反然后返回1或者-1的其中一个  
function MouseWheelHandler(e) {
	//阻止浏览器默认事件
	if(e && e.preventDefault) {
		e.preventDefault();
	} else {
		window.event.returnValue = false;
		return false;
	}
	if(absolutePositionFlag) {
		$(this).css("position", "absolute");
		$(this).css("top", imgTop + $(document).scrollTop());
		$(this).css("left", imgLeft + $(document).scrollLeft());
		absolutePositionFlag = false;
	}
	// cross-browser wheel delta  
	var e = window.event || e; // old IE support  
	var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail)));
	//现在我们直接决定图片的大小范围。以下代码将图片的宽度范围设置在50-800个像素之间  
	var historyWidth = myimage.width;
	myimage.style.width = Math.max(50, Math.min(2000, myimage.width + (30 * delta))) + "px";
	myimage.style.height = myimage.height * myimage.width / historyWidth + "px";
	var topDistance = (window.innerHeight - myimage.height) / 2 + $(document).scrollTop();
	if(topDistance <= 0) {
		$(this).css("top", 0 + "px");
	} else {
		$(this).css("top", topDistance + "px");
	}
	var leftDistance = (window.innerWidth - myimage.width) / 2 + $(document).scrollLeft();
	if(leftDistance <= 0) {
		$(this).css("left", 0 + "px");
	} else {
		$(this).css("left", leftDistance + "px");
	}
	// 最后一点，我们在方法中返回false是为了终止标准的鼠标滚轮事件处理，以防它上下滑动网页  
	return false;
}
var closefullimg = function() {
	$("#img_full").hide();
	$("#div_full_gray").hide();
}

//计算两个时间差的天数
function datedifference(sDate1, sDate2) { //sDate1和sDate2是2006-12-18格式  
	var dateSpan,
		tempDate,
		iDays;
	sDate1 = Date.parse(sDate1);
	sDate2 = Date.parse(sDate2);
	dateSpan = sDate2 - sDate1;
	dateSpan = Math.abs(dateSpan);
	iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
	return iDays
};