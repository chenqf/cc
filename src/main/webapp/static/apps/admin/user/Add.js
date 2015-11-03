define([
    'jquery',
    'Util',
    'text!../../../template/admin/user/addTpl.html',
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
			var username = $('#username').val(),
				nickName = $('#nickName').val(),
				password = $('#password').val(),
				address = $('#address').val();
			if(username && nickName && password && address){
				Util.post({
					url:'user/regist',
					data:{
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
