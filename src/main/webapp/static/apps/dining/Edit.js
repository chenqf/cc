define([
    'jquery',
    'Util',
    'text!../../template/dining/edit/editTpl.html'
],
function ($,Util,editTpl) {
	
	return {
		initPage:function(){
			this._loadEditPage();
			this._bindEvent();
		},
		_loadEditPage:function(id){
			Util.ajax({
				url:'dining/getById',
				data:{
					id:$.cookie('diningId')
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
			var id = $('#diningId').val(),
			username = $('#username').val(),
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
					url:'dining/edit',
					data:{
						id:id,
						name:name,
						username:username,
						password:password,
						address:address,
						image:image,
						lat:lat,
						lon:lon
					},
					success:function(data){
						require(['Index'],function(Page){
							Page.initPage();
						})
					}
				})
			}else{
				Util.alert('信息输入有误，请重新输入！')
			}
		}
	}
});
