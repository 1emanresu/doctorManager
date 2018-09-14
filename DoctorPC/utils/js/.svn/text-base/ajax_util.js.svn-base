/**********************************************************************
 *                           ajax请求工具类                   	    			  *
 *                     注：基于jquery.ajax的二次封装      	   	       		  *
 * ********************************************************************/
//var address = "http://www.yunjimedical.com/";	//请求地址头
var address="http://120.76.194.76/";
var addressEnd = ".do";							//请求地址尾
/**
 * 使用说明：
	ajax({
		type: "get",
		url: "项目名称/RequestMapping...",
		async: true,
		data: {
			data:'data'
		},
		success: function (result) {
			console.log(result);
		}
	});
 * @param {Object} ajaxInfo
 */
var ajax = function (ajaxInfo) {
	//ajax请求路径拼接
	if (!(ajaxInfo.url.startsWith("http://") || ajaxInfo.url.startsWith("https://"))){
		ajaxInfo.url = address + ajaxInfo.url;
	}
	if (!ajaxInfo.url.endsWith(addressEnd)){
		ajaxInfo.url = ajaxInfo.url + ".do";
	}
	//默认请求参数（可拓展）
	var defaultInfo = {
		error: function (XMLHttpRequest, textStatus, errorThrown) {//请求错误时的处理
		    //console.log(XMLHttpRequest);
		    var errorMsg = "";
		    //错误信息提示
		    switch (XMLHttpRequest.status){
		    	case 400:
		    		errorMsg = "服务器不理解请求的语法，请检查传参格式。";
		    		break;
		    	case 401:
		    		errorMsg = "请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。";
		    		break;
		    	case 403:
		    		errorMsg = "服务器拒绝请求。";
		    		break;
		    	case 404:
		    		errorMsg = "服务器找不到请求的网页，请检查url。";
		    		break;
		    	case 405:
		    		errorMsg = "禁用请求中指定的方法。";
		    		break;
		    	case 406:
		    		errorMsg = "无法使用请求的内容特性响应请求的网页。";
		    		break;
		    	case 408:
		    		errorMsg = "服务器等候请求时发生超时";
		    		break;
		    	case 409:
		    		errorMsg = "服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息。";
		    		break;
		    	case 411:
		    		errorMsg = "服务器不接受不含有效内容长度标头字段的请求。";
		    		break;
		    	case 413:
		    		errorMsg = "服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。";
		    		break;
		    	case 414:
		    		errorMsg = "请求的 URI（通常为网址）过长，服务器无法处理。";
		    		break;
		    	case 415:
		    		errorMsg = "请求的格式不受请求页面的支持。";
		    		break;
		    	case 416:
		    		errorMsg = "如果页面无法提供请求的范围，则服务器会返回此状态代码。";
		    		break;
		    	case 500:
		    		errorMsg = "服务器内部错误，无法完成请求。";
		    		break;
		    	case 501:
		    		errorMsg = "服务器不具备完成请求的功能。";
		    		break;
		    	case 502:
		    		errorMsg = "错误网关。";
		    		break;
		    	case 503:
		    		errorMsg = "服务器目前无法使用（由于超载或停机维护）。";
		    		break;
		    	case 504:
		    		errorMsg = "网关超时。";
		    		break;
		    	default:
		    		errorMsg = XMLHttpRequest.statusText;
		    		break;
		    }
		    //输出错误信息到控制台
		    console.error("请求错误：" + ajaxInfo.url
		    		+ "\n  错误码：" + XMLHttpRequest.status
		    		+ "\n  错误原因：" + errorMsg);
		}
	};
	//合并默认请求参数及用户传入参数
	$.extend(defaultInfo, ajaxInfo);
	//执行Ajax请求
	$.ajax(defaultInfo);
	//以下方法可能可行，可以试验
}

String.prototype.startsWith = function (str) {     
    var reg = new RegExp("^" + str);     
    return reg.test(this);        
}

String.prototype.endsWith=function (str) {     
    var reg = new RegExp(str + "$");     
    return reg.test(this);        
}