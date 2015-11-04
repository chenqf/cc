define([
    'jquery',
    'Util',
    'text!../../../template/dining/order/detailTpl.html',
],
function ($,Util,detailTpl) {
	
	return {
		initPage:function(obj){
			this._loadDetailPage(obj);
		},
		_loadDetailPage:function(obj){
			var that = this;
			Util.pageContent({
				parent:$('#content'),
				data:obj.list,
				template:detailTpl
			})
		}
	}
});
