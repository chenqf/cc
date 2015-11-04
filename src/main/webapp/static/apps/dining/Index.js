define([
    'jquery',
    'Util',
    'text!../../template/dining/index/mainTpl.html',
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
				"#dishEvent":$.proxy(this.dishHandler,this),
				"#orderEvent":$.proxy(this.orderHandler,this)
			})
		},
		logout:function(){
			location.reload()
		},
		dishHandler:function(){
			$('#dishEvent').parent().find('li').removeClass('active');
			$('#dishEvent').addClass('active');
			require(['dish/List'],function(Page){
				Page.initPage();
			})
			
		},
		orderHandler:function(){
			$('#orderEvent').parent().find('li').removeClass('active');
			$('#orderEvent').addClass('active');
			require(['order/List'],function(Page){
				Page.initPage();
			})
		}
	}
});
