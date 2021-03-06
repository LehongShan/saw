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

package cn.shan.saw.common.validator;

import cn.shan.saw.common.exception.SAWException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @author shanlehong
 * @date 2018年3月5日10:53:05
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new SAWException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new SAWException(message);
        }
    }
}
