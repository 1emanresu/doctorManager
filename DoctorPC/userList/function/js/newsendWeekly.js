/*@Author hongwx*/

/*点击更多按钮，展开或收起*/
$('.more').click(function(){
	var text1 = $('.morethen').html();
	if(text1 == '更多'){
		$('.span-img img').addClass('flip');
		$('.morethen').html('');
		$('.morethen').html('收起');
		$('.more-span').show();
	}else{
		$('.span-img img').removeClass('flip');
		$('.morethen').html('');
		$('.morethen').html('更多');
		$('.more-span').hide();
	}
})

