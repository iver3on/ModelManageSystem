$(document).ready(function() {
	//var x = $.url().param('name');
	$("#changeNameLabel") //所有样式名中含有grayTips的input     
	.each(function(){  		
	var oldVal="3I2O";   //默认的提示性文本  
	$(this).val("3I2O")    
   	.css({"color":"#888"})  //灰色     
   	.focus(function(){     
   		if($(this).val()!=oldVal){$(this).css({"color":"#000"})}else{$(this).val("").css({"color":"#888"})}     
   	}) 
   	.blur(function(){     
   		if($(this).val()==""){$(this).val(oldVal).css({"color":"#888"})}     
   	})     
   	.keydown(function(){$(this).css({"color":"#000"})})             
});
});