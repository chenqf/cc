package com.cc.base;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.exception.CustomException;
import com.utils.json.JsonError;
import com.utils.json.JsonObject;

public abstract class BaseController {


	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonObject exceptionHandler(HttpServletRequest request, Exception exception) {
		BindingResult bindingResult = null;
		StringBuilder errorMessage = null;
		if(exception instanceof CustomException){
			CustomException ce = (CustomException)exception;
			return new JsonError(exception.getMessage(),ce.getCode());
		}else if (!StringUtils.contains(exception.getClass().toString(), "ClientAbortException")) {
//	        	logger.error(this.getClass().getName() + "    操作失败,ip:" + getIp(request) + "url:" + request.getRequestURI() + ",参数:"
//						+ JsonMapper.buildNormalMapper().toJson(request.getParameterMap())
//						+ "\r\ncookie:" + JsonMapper.buildNormalMapper().toJson(request.getCookies()), exception);
		}
		if (exception instanceof BindException) {
			bindingResult = ((BindException) exception).getBindingResult();
			errorMessage = new StringBuilder();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage.append(fieldError.getDefaultMessage()).append(", ");
			}
			return new JsonError(errorMessage.toString());
		}

		if (exception instanceof MissingServletRequestParameterException ||
				exception instanceof TypeMismatchException) {
			return new JsonError("参数有误");
		}

		if (exception instanceof NullPointerException) {
			return new JsonError("系统内部错误");
		}

		if (exception instanceof BadSqlGrammarException) {
			return new JsonError("数据有误");
		}
		return new JsonError(exception.getMessage());
	}


	private String getIp(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if (request.getHeader("X-Forwarded-For") != null) {
			ip = request.getHeader("X-Forwarded-For");
		} else if (request.getHeader("X-Real-IP") != null) {
			ip = request.getHeader("X-Real-IP");
		}
		return ip;
	}


	private String getCookieValue(Cookie[] cookies, String str) {
		String result = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(str)) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}
}
