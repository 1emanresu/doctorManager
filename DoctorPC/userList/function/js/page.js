/*zhujc 2017-11-01 19:52*/
var prev,next,index=1,eachSize,sum,pageSize,data;
var page={	
	"setPrev":function(index){	
		this.index=index<1?1:index;
	},
	"setNext":function(index){	
		this.index=index>=this.pageSize?this.pageSize:index;	
	},
	"getData":function(list){
		this.data=list;						//数据
		this.sum=list.length;				//数据长度
		this.eachSize=5;					//每页多少？
		this.pageSize=parseInt((this.sum-1)/this.eachSize+1);//多少页？
		this.index=1;	
		this.prev=1;
		this.next=2;
	},
	"showData":function(func){
		var index=(page.index-1)*page.eachSize;
		for(var i = index; i < index+5; i++) {
			var id=	data[i].searchid;
			var a = data[i].value;
			$('#tips').append("<div class='item form-control' id='" + i + "' searchid='"+id+"'>" + a + "</div>");
		}
		
		var i=0,j=0;
		i=j=(this.index-1)*this.eachSize;		
		for(;i<j+5;i++){
			if(this.data[i]!=undefined){
				func(this.data[i]);
			}			
		}
	}
};

	

