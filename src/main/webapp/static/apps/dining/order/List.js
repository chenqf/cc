define([
    'jquery',
    'Util',
    'text!../../../template/dining/order/listTpl.html',
],
function ($,Util,listTpl) {
	
	return {
		initPage:function(){
			this._loadListPage();
			this._bindEvent();
		},
		_loadListPage:function(){
			var that = this;
			Util.ajax({
				url:'order/queryByDiningId',
				data:{
					diningId:$.cookie('diningId')
				},
				success:function(data){
					var state = ''
					for(var i = 0; i<data.length; i++){
						state = data[i].state;
						if(state = 'sending'){
							data[i].stateText = '已送餐'
						}else if(state = 'sended'){
							data[i].stateText = '已送达'
						}else if(state = 'ready'){
							data[i].stateText = '已接单'
						}else if(state = 'not'){
							data[i].stateText = '未接单'
						}
					}
					Util.pageContent({
						parent:$('#content'),
						data:data,
						template:listTpl,
						callback:function(){
							that.orderData = data;
						}
					})
				}
			})
		},
		_bindEvent:function(){
			Util.bindEvent({
				"#detailOrder":$.proxy(this.detailOrderHandler,this)
			})
		},
		detailOrderHandler:function(e){
			var that = this,
				$target = $(e.target),
				$item = $target.closest('tr'),
				id = $item.data('id'),
				obj = Util.getItemById(that.orderData,id);
			require(['order/Detail'],function(Page){
				Page.initPage(obj);
			})
		}
	}
});
