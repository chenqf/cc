package com.cc.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.order.dto.Order;
import com.cc.order.service.OrderService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;

@Controller
@RequestMapping("order")
public class OrderController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/queryByUserId", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryByUserId(@RequestParam(value = "userId") Long userId) throws Exception {
		List<Order> list = this.orderService.queryByUserId(userId);
		List<Map> newList = new ArrayList<Map>();
		List<Long> ids = new ArrayList<Long>();
		for(int i = 0; i<list.size(); i++){
			Order order = list.get(i);
			Long id = order.getId();
			double price = order.getPrice();
			Map m=new HashMap();
			m.put("dishId", order.getDishId());
			m.put("dishName", order.getDishName());
			m.put("dishImage", order.getDishImage());
			m.put("diningId", order.getDiningId());
			m.put("diningName", order.getDiningName());
			m.put("diningImage", order.getDiningImage());
			if(ids.indexOf(id) >= 0){
				int len = newList.size();
				Map map = newList.get(len -1);
				map.put("price", (double)map.get("price") + price);
				List<Map> ll = (List<Map>) map.get("list");
				ll.add(m);
			}else{
				ids.add(id);
				Map map=new HashMap();
				map.put("id", id);
				map.put("state", order.getState());
				map.put("price", price);
				List<Map> l = new ArrayList<Map>();
				l.add(m);
				map.put("list", l);
				newList.add(map);
			}
		}
		
		return new JsonData(newList);
	}
	
	
	
}






