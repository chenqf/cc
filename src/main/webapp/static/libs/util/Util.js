/**
 * Created with JetBrains WebStorm.
 * User: chenqf
 * Date: 14-09-24
 * Time: 上午9:43
 * To change this template use File | Settings | File Templates.
 */

define([
    'jquery',
   'Template'
],
    function ($,Template) {

        var Util = function () {
        	this.cache = {};
        };
        
        Util.prototype.alert = function(message){
        	alert(message)
        }
        
        Util.prototype.ajax = function(options){
        	var success = options.success;
        	options.success = function(responseData){
        		if(!responseData.success){
        			var message = responseData.message || '网络好像不给力呦！'
        			this.alert(message)
        		}else{
        			success(responseData.data);
        		}
        		
        	}
        	$.ajax(options)
        }
        
        Util.prototype.post = function(options){
        	options.type = 'POST'
        	this.ajax(options);
        }
        
        
        
        Util.prototype.pageContent = function(options){
    		if(!options.parent || !options.parent.length){
    			return false;
    		}
    		var parent = options.parent,
				callback = options.callback || function(){},
    			template = options.template || '',
    			type = options.type || 'html',
    			data = options.data || {},
    			otherData = options.otherData || {},
    			tpl = this.getTemplate(template,data,otherData);
			if(type === 'html'){
				parent.html(tpl);
			}else if(type === 'append'){
				parent.append(tpl);
			}
			callback();
    	};
    	
    	
    	Util.prototype.getTemplate = function(tpl,data,otherData){
    		var that = this;
    		data = data || {};
    		otherData = otherData || {};
    		var compiled = Template(tpl,{domain:{},Util:{},that:{}});
    		return compiled({data:data,otherData:otherData})
    	}
    	
    	Util.prototype.bindEvent = function(options){
    		for(i in options){
    			fn = options[i];
				$('body').off('click',i);
				$('body').on('click',i,(function(fn){
    				return function(e){
    					e.stopPropagation();
    					fn(e,$(this));
    				}
    			})(fn,i))
    		}
    	}
    	
        /**
         * 获取uuid
         */
        Util.prototype.getUuid = function(){
        	var id = "", i, random;

            for (i = 0; i < 32; i++) {
                random = Math.random() * 16 | 0;

                if (i == 8 || i == 12 || i == 16 || i == 20) {
                    id += "-";
                }
                id += (i == 12 ? 4 : (i == 16 ? (random & 3 | 8) : random)).toString(16);
            }
            return id;
        }
        
        Util.prototype.getPrimeNumber = function(num,isList){
        	num = num || 1;
        	var numbers = [2,3],
    			status = 0;
        	if(!this.cache.prime || (this.cache.prime && this.cache.prime.length < num)){
        		for(var i=5;i<10000;i++){
                    for (var j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            status = 0;
                            break;
                        } else {
                            status = 1;
                        }
                    }
                    if(status==1){
                        numbers.push(i);
                        if(numbers.length >= num){
                        	break;
                        }
                    }
                }
        		this.cache.prime = numbers;
        	}
        	if(isList){
        		return this.cache.prime.slice(0,num);
        	}else{
        		return this.cache.prime[num - 1]
        	}
        	
        }
        
        Util.prototype.encode = function(str){
        	return String(str).replace(/%/g,'(,)').replace(/\?/g,'(@)').replace(/\:/g,'(.)').replace(/&/g,'(!)').replace(/#/g,'(_)').replace(/=/g,'(-)');
        }
        
        Util.prototype.decode = function(str){
        	return String(str).replace(/\(,\)/g,'%').replace(/\(@\)/g,'?').replace(/\(\.\)/g,':').replace(/\(!\)/g,'&').replace(/\(_\)/g,'#').replace(/\(-\)/g,'=');
        }
        
        /**
         * 判断是否为手机平台
         */
        Util.prototype.isPhonePlatform = function () {
            if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios|SymbianOS)/i))) {
                return true;
            } else {
                return false;
            }
        };
        /**
         * 判断是否为微信平台
         */
        Util.prototype.isWeixin = function(){
        	var ua = navigator.userAgent.toLowerCase(),
        		search = location.search;
        	return (ua.match(/MicroMessenger/i)=="micromessenger") || (search && /weixin=1/.test(search))
        }
        /**
         * 获得微信版本
         */
        Util.prototype.getWeixinVersion = function(){ 
        	var u = navigator.userAgent,
        		v;
        	u = u.replace(/.*MicroMessenger\/{0,}([0-9]\.[0-9]|[0-9]).*/i,'$1');
        	v = Number(u)
        	return v ? v : 0;
        }
        /**
         * 判断是否为安卓或者Linux系统
         */
        Util.prototype.isAndroid = function(){
            var u = navigator.userAgent;
            return u.indexOf('Android') > -1 || u.indexOf('Linux') > -1;
        }
        /**
         * 判断是否为数组
         */
        Util.prototype.isArray = function(array){
        	return Object.prototype.toString.call(array) === '[object Array]';
        }
        /**
         * 判断是否为对象
         */
        Util.prototype.isObject = function(object){
        	return Object.prototype.toString.call(object) === "[object Object]";
        }
        /**
         * 从数组array中查找确定id的元素
         */
        Util.prototype.getItemById = function (array, id) {
            for (var i = 0; i < array.length; i++) {
                if (array[i]['id'] == id) {
                    return array[i];
                }
            }
            return null;
        };
        /**
         * 从array中通过key和value查找确定值的元素
         */
        Util.prototype.getItemsByAttrAndValue = function (array, key, value) {
        	array = array || [];
        	var data = [];
        	for (var i = 0; i < array.length; i++) {
        		if (array[i][key] == value) {
        			data.push(array[i]);
        		}
        	}
        	return data;
        };
        /**
         * 从array中通过key和value查找确定值的元素
         */
        Util.prototype.getItemsByNoEqualAttrAndValue = function (array, key, value) {
        	array = array || [];
        	var data = [];
        	for (var i = 0; i < array.length; i++) {
                if(!isNaN(Number(value))){
                    if (array[i][key] != value) {
                        data.push(array[i]);
                    }
                }else{
                    if (array[i][key] !== value) {
                        data.push(array[i]);
                    }
                }
        	}
        	return data;
        };
        
        Util.prototype.getItemsByHasKey = function (array, key) {
        	array = array || [];
        	var data = [];
        	for (var i = 0; i < array.length; i++) {
        		if (array[i][key] !== undefined && array[i][key] !== null && array[i][key] !== '') {
        			data.push(array[i]);
        		}
        	}
        	return data;
        };
        Util.prototype.getItemsByNoKey = function (array, key) {
        	array = array || [];
        	var data = [];
        	for (var i = 0; i < array.length; i++) {
        		if (array[i][key] === undefined || array[i][key] === null || array[i][key] === '') {
        			data.push(array[i]);
        		}
        	}
        	return data;
        };
        /**
         * 从array中通过key和value查找确定值的元素
         */
        Util.prototype.getItemByAttrAndValue = function (array, key, value) {
        	var data = {};
        	for (var i = 0; i < array.length; i++) {
        		if (array[i][key] === value) {
        			data = array[i];
        		}
        	}
        	return data;
        };
        /**
         * 获得array中所有元素的id
         */
        Util.prototype.getItemsIds = function (array) {
        	var data = [];
        	for (var i = 0; i < array.length; i++) {
        		data.push(array[i].id);
        	}
        	return data;
        };
        /**
         * 通过value获得数组array中对应的元素
         */
        Util.prototype.getItemByValue = function (array, key) {
            for (var i = 0; i < array.length; i++) {
                if (String(array[i]['value']) === String(key)) {
                    return array[i];
                }
            }
            return null;
        };
        /**
         * 通过key获得数组中的value
         */
        Util.prototype.getValuesByKey = function (array, key) {
            array = array || [];
            var data = [],
                i = 0,
                length = array.length;
            for (; i < array.length; i++) {
                if(array[i][key] !== undefined && array[i][key] !== null){
                    data.push(array[i][key]);
                }

            }
            return data;
        };
        /**
         * 通过text获得数组array中对应的元素
         */
        Util.prototype.getItemByText = function (array, key) {
            for (var i = 0; i < array.length; i++) {
                if (String(array[i]['text']) === String(key)) {
                    return array[i];
                }
            }
            return null;
        };
        /**
         * 设置属性到json中
         */
        Util.prototype.setParamsToItems = function (array, key,value){
        	for (var i = 0; i < array.length; i++) {
        		array[i][key] = value;
        	}
        	return array;
        };
        
        /**
         * json中所有的key是否都等于value
         */
        Util.prototype.isAllKeyEqual = function (array, key,value){
        	var flg = true;
        	for (var i = 0; i < array.length; i++) {
        		if(array[i][key] !== value){
        			flg = false;
        		}
        	}
        	return flg;
        };
        /**
         * json中所有的key1是否都等于value1,key2都不等于value2
         */
        Util.prototype.isAllKeyEqualAndNoEqual = function (array, key1,value1,key2,value2){
        	var flg = true;
        	var data = this.getItemsByNoEqualAttrAndValue(array,key2,value2);
        	if(!data.length){
        		flg = false;
        	}
        	for (var i = 0; i < data.length; i++) {
        		if(array[i][key1] !== value1){
        			flg = false;
        		}
        	}
        	return flg;
        };
        /**
         * 将values里面与array相同的赋值给array
         */
        Util.prototype.updateItemsByParams = function (array, values,key,text){
        	for (var i = 0; i < array.length; i++) {
        		for(var j = 0; j<values.length; j++){
        			if(array[i][key] === values[j].value){
        				array[i][text] = values[j].text
        			}
        		}
        	}
        	return null;
        };
        /**
         * 将日期改为iso格式的日期字串
         */
        Util.prototype.toISOString = function (dataStr) {
            return new Date(dataStr).toISOString();
        };
        /**
         * 剪切字符串或文字的前"len"位
         */
        Util.prototype.cutStr = function (str, len) {
            if (!str) return;
            str = str.replace(/（/g,'(').replace(/）/g,')');
            try {
                var str_length = 0;
                var str_len = 0;
                var str_cut = new String();
                if (!str) return "";
                str_len = str.length;
                for (var i = 0; i < str_len; i++) {
                    a = str.charAt(i);
                    str_length++;
                    if (escape(a).length > 4) {
                        //中文字符的长度经编码之后大于4
                        str_length++;
                    }
                    str_cut = str_cut.concat(a);
                    if (str_length >= len) {
                        str_cut = str_cut.concat("...");
                        return str_cut;
                    }
                    
                }
                //如果给定字符串小于指定长度，则返回源字符串；
                if (str_length < len) {
                    return  str;
                }
            } catch (e) {
                alert(e.message);
            }
        };
        /**
         * 将"millisecond"秒核算成a天b小时c分钟d秒
         */
        Util.prototype.calculationTimeByMillisecond = function(millisecond){
            //共多少秒
            var timeDistanceSec = Math.round(millisecond / 1000);
            //秒
            var seconds = timeDistanceSec % 60;
            if (seconds < 10) {
                seconds = "0" + seconds;
            }
            //所有的分
            var timeDistanceMin = Math.round((timeDistanceSec - seconds) / 60);
            //真正的分
            var minutes = timeDistanceMin % 60;
            if (minutes < 10) {
                minutes = "0" + minutes;
            }

            //所有的小时
            var timeDistanceHour = Math.round((timeDistanceMin - minutes) / 60);
            //真正的小时
            var hours = timeDistanceHour % 24;
            if (hours < 10) {
                hours = "0" + hours;
            }

            //所有的天
            var days = Math.round((timeDistanceHour - hours) / 24);
            if (days < 10) {
                days = "0" + days;
            }
            return {
                "days": days,
                "hours": hours,
                "minutes": minutes,
                "seconds": seconds
            };
        };
        
        /**
         * 计算时间返回字符串
         */
        Util.prototype.calculationTimeToStr = function(millisecond){
        	var obj = this.calculationTimeByMillisecond(millisecond);
            obj.days = Number(obj.days);
            if(obj.days){
                return obj.days + '天' + obj.hours + '小时';
            }else if(obj.hours){
                return obj.hours + '小时' + obj.minutes + '分'
            }else{
                return (obj.minutes||'00') +  '分' + obj.seconds + '秒';
            }
        };

        Util.everyTime = {
        };

        /**
         * options:{
         * 	key:"",
         *  runNow:true, 是否立即执行
         *  time:1000, 每一秒执行一次
         *  fn:function(){} //每一秒执行的函数
         * }
         */
        Util.prototype.everyTime = function (options) {
            if (!(options.key in Util.everyTime)) {
                if (options.runNow) {
                    options.fn();
                }
                Util.everyTime[options.key] = setTimeout(function () {
                    Util.everyTime[options.key] = setTimeout(arguments.callee, options.time);
                    options.fn();
                }, options.time);
            }
        };

        Util.prototype.stopTime = function (options) {
            window.clearTimeout(Util.everyTime[options.key]);
            delete Util.everyTime[options.key];
        };

        Util.prototype.stopAllTime = function () {
            for (var i in Util.everyTime) {
                if (Util.everyTime.hasOwnProperty(i)) {
                    window.clearTimeout(Util.everyTime[i]);
                }
            }
            Util.everyTime = {}
        };

        /**
         * 深度克隆 object/array
         * @param obj
         * @returns {Array|Object}
         */
        Util.prototype.cloneObj = function (item) {
            if (!item) {
                return item;
            } // null, undefined values check

            var types = [ Number, String, Boolean ],
                that = this;
            result;

            // normalizing primitives if someone did new String('aaa'), or new Number('444');
            //一些通过new方式建立的东东可能会类型发生变化，我们在这里要做一下正常化处理
            //比如new String('aaa'), or new Number('444')
            types.forEach(function (type) {
                if (item instanceof type) {
                    result = type(item);
                }
            });

            if (typeof result == "undefined") {
                if (Object.prototype.toString.call(item) === "[object Array]") {
                    result = [];
                    item.forEach(function (child, index, array) {
                        result[index] = that.cloneObj(child);
                    });
                } else if (typeof item == "object") {
                    // testign that this is DOM
                    //如果是dom对象，那么用自带的cloneNode处理
                    if (item.nodeType && typeof item.cloneNode == "function") {
                        var result = item.cloneNode(true);
                    } else if (!item.prototype) { // check that this is a literal
                        // it is an object literal
                        //如果是个对象迭代的话，我们可以用for in 迭代来赋值
                        result = {};
                        for (var i in item) {
                            result[i] = that.cloneObj(item[i]);
                        }
                    } else {
                        // depending what you would like here,
                        // just keep the reference, or create new object
                        //这里解决的是带构造函数的情况，这里要看你想怎么复制了，深得话，去掉那个false && ，浅的话，维持原有的引用，
                        //但是我不建议你去new一个构造函数来进行深复制，具体原因下面会解释
                        if (false && item.constructor) {
                            // would not advice to do that, reason? Read below
                            //朕不建议你去new它的构造函数
                            result = new item.constructor();
                        } else {
                            result = item;
                        }
                    }
                } else {
                    result = item;
                }
            }

            return result;
        };
        
        Util.prototype.rad = function(d){
        	return d * Math.PI / 180.0;
        }
        
        /**
         * 根据经纬度，获取距离
         */
        Util.prototype.getDistance = function(lat1, lng1, lat2, lng2){
        	//地球半径
            var EARTH_RADIUS = 6378.137;
            if (lat1 == '' || lng1 == '' || lat2 == '' || lng2 == '')
        		return 0;
            var radLat1 = this.rad(lat1);
            var radLat2 = this.rad(lat2);
            var a = radLat1 - radLat2;
            var b = this.rad(lng1) - this.rad(lng2);
            var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
            Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
            s = s * EARTH_RADIUS;
            s = Math.round(s * 10000) / 10000;
            return s;
        }
        
        
        /**
         * 获取剩余天数
         */
        Util.prototype.getRemainDays = function (endTime, baseTime, isExact) {
        	var currentTime = baseTime || new Date().getTime(),
        		 remainTime = endTime - currentTime,
        		 remainDays =remainTime / (24 * 60 * 60 * 1000);
        	
            if (remainTime < 0) {
            	return 0;
            }
                
            return isExact ? remainDays : Math.ceil(remainDays);
        } 
        /**
         * 获取折扣（至少保留一位小数）
         */
        Util.prototype.getDiscount = function (price, originalPrice, digit) {
        	if (typeof price !== "number" || typeof originalPrice !== "number") {
        		return;
        	}
        	var discount = parseFloat((price / originalPrice * 10).toFixed(digit || 1));
        	if(discount == 10){
        		return 9.9;
        	}else if(discount == 0){
        		return 0.1;
        	}else {
        		return discount;
        	}
        };
        
        /**
         * 用于cookie存储值，所在的域
         */
        Util.prototype.getCookiePath = function(){
        	return '/';
        };
        
        Util.prototype.getCookieDomain = function(){
        	return '51tiangou.com';
        };
        
        /**
         * 时间格式化 返回格式化的时间
         * @param date {object}  可选参数，要格式化的data对象，没有则为当前时间
         * @param fomat {string} 格式化字符串，例如：'YYYY年MM月DD日 hh时mm分ss秒 星期' 'YYYY/MM/DD week' (中文为星期，英文为week)
         * @return {string} 返回格式化的字符串
         * 
         * 例子:
         * formatDate(new Date("january 01,2012"));
         * formatDate(new Date());
         * formatDate('YYYY年MM月DD日 hh时mm分ss秒 星期 YYYY-MM-DD week');
         * formatDate(new Date("january 01,2012"),'YYYY年MM月DD日 hh时mm分ss秒 星期 YYYY/MM/DD week');
         * 
         * 格式：   
         *  YYYY：4位年,如1993
	    　　 *　　YY：2位年,如93
	    　　 *　　MM：月份
	    　　 *　　DD：日期
	    　　 *　　hh：小时
	    　　 *　　mm：分钟
	    　　 *　　ss：秒钟
	    　　 *　　星期：星期，返回如 星期二
	    　　 *　　周：返回如 周二
	    　　 *　　week：英文星期全称，返回如 Saturday
	    　　 *　　www：三位英文星期，返回如 Sat
         */
        Util.prototype.formatDate = function (date, format) {
            if (arguments.length < 2 && !date.getTime) {
                format = date;
                date = new Date();
            }
            typeof format != 'string' && (format = 'YYYY年MM月DD日 hh时mm分ss秒');
            var week = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', '日', '一', '二', '三', '四', '五', '六'];
            return format.replace(/YYYY|YY|MM|DD|hh|mm|ss|星期|周|www|week/g, function(a) {
                switch (a) {
                case "YYYY": return date.getFullYear();
                case "YY": return (date.getFullYear()+"").slice(2);
                case "MM": return (date.getMonth() + 1 < 10) ? "0"+ (date.getMonth() + 1) : date.getMonth() + 1;
                case "DD": return (date.getDate() < 10) ? "0"+ date.getDate() : date.getDate();
                case "hh": return (date.getHours() < 10) ? "0"+ date.getHours() : date.getHours();
                case "mm": return (date.getMinutes() < 10) ? "0"+ date.getMinutes() : date.getMinutes();
                case "ss": return (date.getSeconds() < 10) ? "0"+ date.getSeconds() : date.getSeconds();
                case "星期": return "星期" + week[date.getDay() + 7];
                case "周": return "周" +  week[date.getDay() + 7];
                case "week": return week[date.getDay()];
                case "www": return week[date.getDay()].slice(0,3);
                }
            });
        }

        /**
         * 字符串转16进制
         * @param str
         * @returns {string}
         */
        Util.prototype.stringToHex = function(str){
            var i = 0,
                length = str.length,
                val = '';
            for(; i < length; i++){
                val = val + str.charCodeAt(i).toString(16);
            }
            return val;
        }

        Util.prototype.forDight = function(Dight,How){
            return Math.round(Dight*Math.pow(10,How))/Math.pow(10,How);
        }

        return new Util();

    });
