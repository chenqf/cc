define([
    'jquery',
    'Util',
    'text!../../../template/admin/dining/listTpl.html',
],
function ($,Util,listTpl) {
	
	return {
		initPage:function(){
			this._loadListPage();
			this._bindEvent();
		},
		_loadListPage:function(){
			Util.ajax({
				url:'dining/query',
				success:function(data){
					Util.pageContent({
						parent:$('#content'),
						data:data,
						template:listTpl
					})
				}
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#editDining":$.proxy(this.editDiningHandler,this),
				"#deleteDining":$.proxy(this.deleteDiningHandler,this),
				"#addDining":$.proxy(this.addDiningHandler,this)
			})
		},
		addDiningHandler:function(){
			require(['dining/Add'],function(Page){
				Page.initPage();
			})
		},
		editDiningHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				require(['dining/Edit'],function(Page){
					Page.initPage({id:id});
				})
			}
		},
		deleteDiningHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				Util.post({
					url:'dining/delete',
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
