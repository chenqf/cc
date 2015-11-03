define([
    'jquery',
    'Util',
    'text!../../template/admin/index/mainTpl.html',
],
function ($,Util,mainTpl) {
	
	return {
		initPage:function(){
			this._initPage();
			this._bindEvent();
		},
		_initPage:function(){
			Util.pageContent({
				parent:$('body'),
				template:mainTpl
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#logout":$.proxy(this.logout,this),
				"#userEvent":$.proxy(this.userHandler,this),
				"#diningEvent":$.proxy(this.diningHandler,this)
			})
		},
		logout:function(){
			location.reload()
		},
		userHandler:function(){
			$('#userEvent').parent().find('li').removeClass('active');
			$('#userEvent').addClass('active');
			require(['user/List'],function(Page){
				Page.initPage();
			})
			
		},
		diningHandler:function(){
			$('#diningEvent').parent().find('li').removeClass('active');
			$('#diningEvent').addClass('active');
			require(['dining/List'],function(Page){
				Page.initPage();
			})
		}
	}
});
