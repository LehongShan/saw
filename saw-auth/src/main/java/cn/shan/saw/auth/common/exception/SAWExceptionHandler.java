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

package cn.shan.saw.auth.common.exception;

import cn.shan.saw.common.exception.SAWException;
import cn.shan.saw.common.utils.S;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author shanlehong
 */
@RestControllerAdvice
public class SAWExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(SAWException.class)
	public S handleRRException(SAWException e){
        S s = new S();
		s.put("code", e.getCode());
		s.put("msg", e.getMessage());

		return s;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public S handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return S.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public S handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return S.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public S handleException(Exception e){
		logger.error(e.getMessage(), e);
		return S.error();
	}
}
