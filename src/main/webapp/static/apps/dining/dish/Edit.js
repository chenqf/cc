define([
    'jquery',
    'Util',
    'text!../../../template/dining/dish/editTpl.html',
],
function ($,Util,editTpl) {
	
	return {
		initPage:function(options){
			this._loadEditPage(options.id);
			this._bindEvent();
		},
		_loadEditPage:function(id){
			Util.ajax({
				url:'dish/getById',
				data:{
					id:id
				},
				success:function(data){
					Util.pageContent({
						parent:$('#content'),
						data:data,
						template:editTpl
					})
				}
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#submit":$.proxy(this.submit,this)
			})
		},
		submit:function(e){
			var id = $('#dishId').val(),
				name = $('#name').val(),
				image = $('#image').val(),
				price = $('#price').val(),
				describe = $('#describe').val();
			if(isNaN(price)){
				Util.alert('价格输入有误，请重试')
			}else if(id && name && image && price && describe){
				Util.post({
					url:'dish/edit',
					data:{
						id:id,
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
			}else{
				Util.alert('信息输入有误，请重试')
			}
		}
	}
});
