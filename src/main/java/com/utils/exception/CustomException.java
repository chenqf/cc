/**  
 * Copyright © 2014电子商务. All rights reserved.
 *
 * @Title: SelfDefinedException.java
 * @Prject: tgou
 * @Package: com.tgou.utils.exception
 * @Description: 自定义异常类
 * @author: Jingh 
 * @date: 2014年8月6日 下午2:15:11
 * @version: V1.0  
 */
package com.utils.exception;

/**
 * @ClassName: SelfDefinedException
 * @Description: 自定义异常类
 * @author: Jingh
 * @date: 2014年8月6日 下午2:15:11
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
