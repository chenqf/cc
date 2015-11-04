require.config({
    baseUrl: 'apps/' + (/admin/.test(location.href) ? 'admin':'dining'),
    waitSeconds: 60,
    paths : {
        'jquery' 				: '../../libs/jquery/jquery',
        'async' 				: '../../libs/require-async/async',
        'text' 					: '../../libs/requirejs-text/text',
        'css' 					: '../../libs/require-css/css',
        'json' 					: '../../libs/require-json/json',
        'css-builder'			: '../../libs/require-css/css-builder',

        /**插件**/
        //cookie
        'cookie'				: '../../libs/cookie/jquery.cookie',
        'Template' 				: '../../libs/template/Template',
        'Util' 					: '../../libs/util/Util',
        'bootstrap'				: '../../libs/bootstrap/bootstrap',
        'message'				: '../../libs/message/js/messenger.min'

        
    },
    shim: {
    	jquery: {
            exports: '$'
        },
        bootstrap:{
        	deps:[
        	     'jquery',
        	     'css!../../libs/bootstrap/bootstrap.min.css',
        	     'css!../../libs/bootstrap/bootstrap-theme.min.css'
        	]
        },
        message:{
        	deps: [
   				'jquery',
   				'bootstrap',
   				'css!../../libs/message/css/messenger.css',
   			]
        },
        cookie : {
        	deps: [
				'jquery'
			]
		}
	},
	
	map: {
	  	  '*': {
	  	    'css' : 'libs/require-css/css.js'		
	  	  }
	}
});

require(['Login'],function(Page){
	Page.initPage();
})




