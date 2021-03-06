define([
    'jquery',
    'Util',
    'text!../../template/dining/login/loginTpl.html',
    'bootstrap',
    'cookie'
    
],
function ($,Util,loginTpl) {
	
	return {
		initPage:function(){
			this._initLogin();
			this._bindEvent();
		},
		_initLogin:function(){
			Util.pageContent({
				parent:$('body'),
				template:loginTpl
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				'#submit':$.proxy(this.submit,this)
			})
		},
		submit:function(){
			var that = this,
				name = $('#username').val(),
				psd = $('#password').val();
			if(name && psd){
				Util.post({
					url:'dining/login',
					data:{
						username:name,
						password:psd
					},
					success:function(data){
						$.cookie('diningId',data.id);
						require(['Index'],function(Page){
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
