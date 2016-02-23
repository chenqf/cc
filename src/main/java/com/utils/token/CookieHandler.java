package com.utils.token;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Component;

@Component
public class CookieHandler{
	
	public String getCookieValue(Cookie[] cookies, String key) {
		if (cookies == null) {
			return null;
		}
		String result = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}
	
	public String getCookieValue(HttpServletRequest request,String key) {
		Cookie[] cookies = request.getCookies();
		return this.getCookieValue(cookies, key);
	}
	
	public void addCookies(HttpServletResponse response, String key, String value,Integer time) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(time);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	public void addCookies(HttpServletResponse response, String key, String value,Integer time,boolean httpOnly) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(time);
		cookie.setPath("/");
		cookie.setHttpOnly(httpOnly);
		response.addCookie(cookie);
	}
	
	public void removeCookies(HttpServletResponse response, String key) {
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	
	public String createToken() {
		return new Md5Hash(UUID.randomUUID().toString()).toHex();
	}
	
}
