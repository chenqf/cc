define([
    'jquery',
    'Util',
    'text!../../../template/admin/user/editTpl.html',
],
function ($,Util,editTpl) {
	
	return {
		initPage:function(options){
			this._loadEditPage(options.id);
			this._bindEvent();
		},
		_loadEditPage:function(id){
			Util.ajax({
				url:'user/getById',
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
			var id = $('#userId').val(),
				username = $('#username').val(),
				nickName = $('#nickName').val(),
				password = $('#password').val(),
				address = $('#address').val();
			if(id && username && nickName && password && address){
				Util.post({
					url:'user/edit',
					data:{
						id:id,
						nickName:nickName,
						username:username,
						password:password,
						address:address
					},
					success:function(data){
						require(['user/List'],function(Page){
							Page.initPage();
						})
					}
				})
			}
		}
	}
});
