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

package cn.shan.saw.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * Created by shanlehong on 2018/3/5.
 */
public class S extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public S() {
		put("code", "0000");
		put("msg", "success");
	}
	
	public static S error() {
		return error("-1", "未知异常，请联系管理员");
	}
	
	public static S error(String msg) {
		return error("-1", msg);
	}
	
	public static S error(String code, String msg) {
		S s = new S();
		s.put("code", code);
		s.put("msg", msg);
		return s;
	}

	public static S ok(String msg) {
		S s = new S();
		s.put("msg", msg);
		return s;
	}
	
	public static S ok(Map<String, Object> map) {
		S s = new S();
		s.putAll(map);
		return s;
	}
	
	public static S ok() {
		return new S();
	}

	@Override
	public S put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
