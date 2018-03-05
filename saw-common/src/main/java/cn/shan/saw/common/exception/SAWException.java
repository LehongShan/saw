/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.shan.saw.common.exception;

/**
 * 自定义异常
 * Created by shanlehong on 2018/3/5.
 */
public class SAWException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private String  code = "-1";
    
    public SAWException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public SAWException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public SAWException(String msg, String code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public SAWException(String msg, String code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
