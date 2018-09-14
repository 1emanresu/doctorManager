/**
 * 方法作用：【格式化时间】
 * 使用方法
 * 示例：
 *      使用方式一：
 *      var now = new Date();
 *      var nowStr = now.dateFormat("yyyy-MM-dd hh:mm:ss");
 *      使用方式二：
 *      new Date().dateFormat("yyyy年MM月dd日");
 *      new Date().dateFormat("MM/dd/yyyy");
 *      new Date().dateFormat("yyyyMMdd");
 *      new Date().dateFormat("yyyy-MM-dd hh:mm:ss");
 * @param format {date} 传入要格式化的日期类型
 * @returns {2015-01-31 16:30:00}
 */
Date.prototype.dateFormat = function(format) {
	var o = {
		"M+": this.getMonth() + 1, //month
		"d+": this.getDate(), //day
		"h+": this.getHours(), //hour
		"m+": this.getMinutes(), //minute
		"s+": this.getSeconds(), //second
		"q+": Math.floor((this.getMonth() + 3) / 3), //quarter
		"S": this.getMilliseconds() //millisecond
	}
	if(/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}
/**********************************************************************
 *                           日期时间工具类                      	    			  *
 *                     注：调用方式，deteUtil.方法名           		       		  *
 * ********************************************************************/
var dateUtil = {
	/*
	 * 方法作用：【取传入日期是星期几】
	 * 使用方法：dateUtil.nowFewWeeks(new Date());
	 * @param date{date} 传入日期类型
	 * @returns {星期四，...}
	 */
	nowFewWeeks: function(date) {
		if(date instanceof Date) {
			var dayNames = new Array("星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
			return dayNames[date.getDay()];
		} else {
			return "Param error,date type!";
		}
	},
	/*
	 * 方法作用：【字符串转换成日期】
	 * 使用方法：dateUtil.strTurnDate("2010-01-01");
	 * @param str {String}字符串格式的日期，传入格式：yyyy-mm-dd(2015-01-31)
	 * @return {Date}由字符串转换成的日期
	 */
	strTurnDate: function(str) {
		var re = /^(\d{4})\S(\d{1,2})\S(\d{1,2})$/;
		var dt;
		if(re.test(str)) {
			dt = new Date(RegExp.$1, RegExp.$2 - 1, RegExp.$3);
		}
		return dt;
	},
	/*
	 * 方法作用：【把指定格式的字符串转换为日期对象】
	 * 使用方法：dateUtil.strFormatToDate("yyyy-mm-dd", "2010-01-01");
	 * @param formatStr {String}字符串的日期格式，传入格式："yyyy-mm-dd"
	 * @param dateStr {String}字符串的日期，传入格式："2010-01-01"
	 * @return {Date}由字符串转换成的日期
	 */
	strFormatToDate: function(formatStr, dateStr) {
		var year = 0;
		var start = -1;
		var len = dateStr.length;
		if((start = formatStr.indexOf('yyyy')) > -1 && start < len) {
			year = dateStr.substr(start, 4);
		}
		var month = 0;
		if((start = formatStr.indexOf('MM')) > -1 && start < len) {
			month = parseInt(dateStr.substr(start, 2)) - 1;
		}
		var day = 0;
		if((start = formatStr.indexOf('dd')) > -1 && start < len) {
			day = parseInt(dateStr.substr(start, 2));
		}
		var hour = 0;
		if(((start = formatStr.indexOf('HH')) > -1 || (start = formatStr.indexOf('hh')) > 1) && start < len) {
			hour = parseInt(dateStr.substr(start, 2));
		}
		var minute = 0;
		if((start = formatStr.indexOf('mm')) > -1 && start < len) {
			minute = dateStr.substr(start, 2);
		}
		var second = 0;
		if((start = formatStr.indexOf('ss')) > -1 && start < len) {
			second = dateStr.substr(start, 2);
		}
		return new Date(year, month, day, hour, minute, second);
	},
	/*
	 * 方法作用：【计算2个日期之间的天数】
	 * 传入格式：Date()
	 * 使用方法：dateUtil.dayMinus(startDate,endDate);
	 * @startDate {Date}起始日期
	 * @endDate {Date}结束日期
	 * @return endDate - startDate的天数差
	 */
	dayMinus: function(startDate, endDate) {
		if(startDate instanceof Date && endDate instanceof Date) {
			var days = Math.floor((endDate - startDate) / (1000 * 60 * 60 * 24));
			return days;
		} else {
			return "Param error,date type!";
		}
	},
	/*
	 * 方法作用：【取得日期所在月的最大天数】
	 * 使用方法：dateUtil.maxDayOfDate(new Date());
	 * @param date{date} 传入日期类型
	 * @return endDate - startDate的天数差
	 */
	maxDayOfDate: function(date) {
		if(date instanceof Date) {
			date.setDate(1);
			date.setMonth(date.getMonth() + 1);
			var time = date.getTime() - 24 * 60 * 60 * 1000;
			var newDate = new Date(time);
			return newDate.getDate();
		} else {
			return "Param error,date type!";
		}
	},
	/*
	 * 方法作用：【传入时间转为年龄（周岁）】
	 * 使用方法：dateUtil.dateToAge('2017-5-2')，类型必须是时间类型带-的;
	 * @param date{date} 传入日期类型
	 * @return age - 年龄
	 */
	dateToAge: function(date) {
		var returnAge;
		var strBirthdayArr = date.split("-");
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
	},
	/*
	 * 方法作用：【long类型转为时间类型】
	 * 使用方法：dateUtil.longToDate(long);
	 * @param long 传入日期类型
	 * @return date - 时间
	 */
	longToDate: function(long) {
		//long类型转为时间类型
			var myDate = new Date(long);
			var date = myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" + myDate.getDate();
			return date;
	}

};

/**********************************************************************
 *                           加载工具类                               					  *
 *                     注：调用方式，loadUtil.方法名                 				  *
 * ********************************************************************/
var loadUtil = {
	/*
	 * 方法说明：【动态加载js文件css文件】
	 * 使用方法：loadUtil.loadjscssfile("http://libs.baidu.com/jquery/1.9.1/jquery.js","js")
	 * @param fileurl 文件路径，
	 * @param filetype 文件类型，支持传入类型，js、css
	 */
	loadjscssfile: function(fileurl, filetype) {
		if(filetype == "js") {
			var fileref = document.createElement('script');
			fileref.setAttribute("type", "text/javascript");
			fileref.setAttribute("src", fileurl);
		} else if(filetype == "css") {
			var fileref = document.createElement('link');
			fileref.setAttribute("rel", "stylesheet");
			fileref.setAttribute("type", "text/css");
			fileref.setAttribute("href", fileurl);
		}
		if(typeof fileref != "undefined") {
			document.getElementsByTagName("head")[0].appendChild(fileref);
		} else {
			alert("loadjscssfile method error!");
		}
	}
};

/**********************************************************************
 *                           字符串操作工具类                          					  *
 *                     注：调用方式，strUtil.方法名                   				  *
 * ********************************************************************/
var strUtil = {
	/*
	 * 方法说明：【判断字符串是否为空】
	 * 使用方法：strUtil.isEmpty("");
	 * @param str 传入的字符串
	 * @returns {Boolean} 为空或空格返回true,不为空返回false
	 */
	isEmpty: function(str) {
		if(null != str && str.length > 0 && "" != str.trim()) {
			return false;
		} else {
			return true;
		}
	},
	/*
	 * 方法说明：【判断两个字符串子否相同】
	 * 使用方法：strUtil.isEquals("str1","str2");
	 * @param str1
	 * @param str2
	 * @returns {Boolean}
	 */
	isEquals: function(str1, str2) {
		if(str1 == str2) {
			return true;
		} else {
			return false;
		}
	},
	/*
	 * 方法说明：【忽略大小写判断字符串是否相同】
	 * 使用方法：strUtil.isEqualsIgnorecase("str1","str2");
	 * @param str1
	 * @param str2
	 * @returns {Boolean}
	 */
	isEqualsIgnorecase: function(str1, str2) {
		if(str1.toUpperCase() == str2.toUpperCase()) {
			return true;
		} else {
			return false;
		}
	},
	/**
	 * 方法说明：【判断是否是数字】
	 * 使用方法：strUtil.isNum("-123.456");
	 * @param value
	 * @returns {Boolean}
	 */
	isNum: function(value) {
		var regExp = /^(\-|\+)?\d+(\.\d+)?$/;
		return regExp.test(value);
	},
	/**
	 * 方法说明：【判断是否是正整数】
	 * 使用方法：strUtil.isInt("123");
	 * @param value
	 * @returns {Boolean}
	 */
	isInt: function(value) {
		var regExp = /^(\+)?\d+$/;
		return regExp.test(value);
	},
	/**
	 * 方法说明：【判断是否是正数】
	 * 使用方法：strUtil.isPositive("123");
	 * @param value
	 * @returns {Boolean}
	 */
	isPositive: function(value) {
		var regExp = /^(\+)?\d+(\.\d+)?$/;
		return regExp.test(value);
	},
	/**
	 * 方法说明：【判断是否是中文】
	 * 使用方法：strUtil.isChine("是");
	 * @param str
	 * @returns {Boolean}
	 */
	isChine: function(str) {
		var reg = /^([u4E00-u9FA5]|[uFE30-uFFA0])*$/;
		if(reg.test(str)) {
			return false;
		}
		return true;
	},
	/**
	 * 方法说明：【判断是否是由字母或数字组成的字符串 】
	 * 使用方法：strUtil.checkLetOrNum("a1b2c3");
	 * @param str
	 * @returns {Boolean}
	 */
	checkLetOrNum: function(str) {
		var regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/;
		return regex.test(str);
	},
	/**
	 * 方法说明：【将字符串转换成数字】
	 * 使用方法：strUtil.stringToNumber("123456");
	 * @param str
	 * @returns {Boolean}
	 */
	stringToNumber: function(str) {
		return Number(str);
	},
	/**
	 * 方法说明：【验证是否全是空格】
	 * 使用方法：strUtil.checkAllSpace("   ");
	 * @param str
	 * @returns {Boolean}
	 */
	checkAllSpace: function(str) {
		var regex = /^\s+$/g
		return regex.test(str);
	},
	/**
	 * 方法说明：【验证身份证号是否正确】
	 * 使用方法：strUtil.isCardNo("4413**************");
	 * @param num
	 * @returns {Boolean}
	 */
	isCardNo: function(num) {
		var len = num.length;
		if(len != 15 && len != 18) {
			alert("输入的身份证号码长度不正确定！应为15位或18位");
			return false;
		}
		var re15 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
		var re18 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9Xx]$/;
		var res = (re15.test(num) || re18.test(num));
		if(res == false) {
			alert("输入的身份证号格式不正确！");
			return false;
		}
		return res;
	},
	/**
	 * 方法说明：【验证是否为电话号码（座机）】
	 * 使用方法：strUtil.isTelephone("0769-1234567");
	 * @param str
	 * @returns {Boolean}
	 */
	isTelephone: function(str) {
		var regex = /^((0\d{2,3}-?)?\d{7,8})$/
		return regex.test(str);
	},
	/**
	 * 方法说明：【验证是否为手机号码（移动手机）】
	 * 使用方法：strUtil.isMobilePhone("1xxxxxxxxxx");
	 * @param str
	 * @returns {Boolean}
	 */
	isMobilePhone: function(str) {
		var regex = /^(1[3584]\d{9})$/
		return regex.test(str);
	},
	/**
	 * 方法说明：【验证是否为电子邮箱】
	 * 使用方法：strUtil.isEmail("xxxxxxxxx@163.com");
	 * @param str
	 * @returns {Boolean}
	 */
	isEmail: function(str) {
		var regex = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		if(str.search(regex) != -1) {
			return true;
		} else {
			alert("电子邮箱格式不正确");
			return false;
		}
	},
	/**
	 * 方法说明：【判断字符串的包含关系】
	 * 使用方法：strUtil.jsContains("String", "str", true);
	 * @param str:原始字符串 
	 * @param substr:子字符串 
	 * @param isIgnoreCase:true忽略大小写,false不忽略
	 * @returns {Boolean}
	 */
	jsContains: function(str, substr, isIgnoreCase) {
		if(isIgnoreCase) {
			str = str.toLowerCase();
			substr = substr.toLowerCase();
		}
		var startChar = substr.substring(0, 1);
		var strLen = substr.length;
		for(var j = 0; j < str.length - strLen + 1; j++) {
			if(str.charAt(j) == startChar) //如果匹配起始字符,开始查找  
			{
				if(str.substring(j, j + strLen) == substr) //如果从j开始的字符与str匹配，那ok  
				{
					return true;
				}
			}
		}
		return false;
	}
};