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

package cn.com.tyyxtech.frame.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("message", "success");
        put("success",true);
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("message", msg);
        r.put("success",false);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("success",true);
        r.put("message", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.put("success",true);
        r.put("data",map);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.put("success",true);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        if(key.equals("code")||key.equals("success")||key.equals("message")){
            super.put(key,value);
        }else{
            if(super.containsKey("data")){
                Map<String,Object> data = (Map<String, Object>) super.get("data");
                data.put(key,value);
                super.put("data",data);
            }else{
                Map<String,Object> data = new HashMap<>();
                data.put(key,value);
                super.put("data",data);
            }
        }
        return this;
    }
}
