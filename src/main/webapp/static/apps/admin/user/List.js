define([
    'jquery',
    'Util',
    'text!../../../template/admin/user/listTpl.html',
],
function ($,Util,listTpl) {
	
	return {
		initPage:function(){
			this._loadListPage();
			this._bindEvent();
		},
		_loadListPage:function(){
			Util.ajax({
				url:'user/query',
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
				"#editUser":$.proxy(this.editUserHandler,this),
				"#deleteUser":$.proxy(this.deleteUserHandler,this),
				"#addUser":$.proxy(this.addUserHandler,this)
			})
		},
		addUserHandler:function(){
			require(['user/Add'],function(Page){
				Page.initPage();
			})
		},
		editUserHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				require(['user/Edit'],function(Page){
					Page.initPage({id:id});
				})
			}
		},
		deleteUserHandler:function(e){
			var $target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id');
			if(id){
				Util.post({
					url:'user/delete',
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
