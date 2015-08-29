/**  
 * Copyright 漏 2014鐢靛瓙鍟嗗姟. All rights reserved.
 *
 * @Title: SelfDefinedException.java
 * @Prject: tgou
 * @Package: com.tgou.utils.exception
 * @Description: 鑷畾涔夊紓甯哥被
 * @author: Jingh 
 * @date: 2014骞�鏈�鏃�涓嬪崍2:15:11
 * @version: V1.0  
 */
package com.utils.exception;

/**
 * @ClassName: SelfDefinedException
 * @Description: 鑷畾涔夊紓甯哥被
 * @author: Jingh
 * @date: 2014骞�鏈�鏃�涓嬪崍2:15:11
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 6655164451288057079L;

private Integer code = 0;
    
    public CustomException() {
        super();
    }

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public CustomException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
