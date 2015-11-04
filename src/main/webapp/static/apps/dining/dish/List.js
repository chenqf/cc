define([
    'jquery',
    'Util',
    'text!../../../template/dining/dish/listTpl.html',
],
function ($,Util,listTpl) {
	
	return {
		initPage:function(){
			this._loadListPage();
		},
		_loadListPage:function(){
			var that = this;
			Util.ajax({
				url:'dish/query',
				data:{diningId:$.cookie('diningId')},
				success:function(data){
					Util.pageContent({
						parent:$('#content'),
						data:data,
						template:listTpl,
						callback:function(){
							that._bindEvent();
						}
					})
				}
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#editDish":$.proxy(this.editDishHandler,this),
				"#deleteDish":$.proxy(this.deleteDishHandler,this),
				"#addDish":$.proxy(this.addDishHandler,this)
			})
		},
		addDishHandler:function(){
			require(['dish/Add'],function(Page){
				Page.initPage();
			})
		},
		editDishHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				require(['dish/Edit'],function(Page){
					Page.initPage({id:id});
				})
			}
		},
		deleteDishHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				Util.post({
					url:'dish/delete',
					data:{
						id:id
					},
					success:function(){
						$item.remove();
						Util.alert('删除成功！')
					}
				})
			}
			
		}
	}
});
