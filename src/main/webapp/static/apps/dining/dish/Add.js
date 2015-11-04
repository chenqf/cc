define([
    'jquery',
    'Util',
    'text!../../../template/dining/dish/addTpl.html',
],
function ($,Util,addTpl) {
	
	return {
		initPage:function(options){
			this._loadAddPage();
			this._bindEvent();
		},
		_loadAddPage:function(){
			Util.pageContent({
				parent:$('#content'),
				template:addTpl
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#submit":$.proxy(this.submit,this)
			})
		},
		submit:function(e){
			var name = $('#name').val(),
				image = $('#image').val(),
				price = $('#price').val(),
				describe = $('#describe').val();
			if(name && image && price && describe){
				Util.post({
					url:'dish/add',
					data:{
						fkDiningId:$.cookie('diningId'),
						name:name,
						image:image,
						price:price,
						describe:describe
					},
					success:function(data){
						require(['dish/List'],function(Page){
							Page.initPage();
						})
					}
				})
			}
		}
	}
});
