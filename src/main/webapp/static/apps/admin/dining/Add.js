define([
    'jquery',
    'Util',
    'text!../../../template/admin/dining/addTpl.html'
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
				name = $('#name').val(),
				password = $('#password').val(),
				image = $('#image').val(),
				lat = $('#lat').val(),
				lon = $('#lon').val(),
				address = $('#address').val();
			if(isNaN(lat) || isNaN(lon)){
				Util.alert('经纬度输入有误，请重新输入！')
			}else if(username && name && password && image && lat && lon && address){
				Util.post({
					url:'dining/add',
					data:{
						name:name,
						username:username,
						password:password,
						address:address,
						image:image,
						lat:lat,
						lon:lon
					},
					success:function(data){
						require(['dining/List'],function(Page){
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
