package cn.shan.saw.common.controller;

import cn.shan.saw.common.utils.S;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 41973_000 on 2018-3-11.
 */
public class BaseController {

    public  S RS(){
        return S.ok();
    }

    public S RS(Object o){
        if (o==null){
            return RS();
        }

        Map map = new LinkedHashMap();
        map.put("data",o);
        return S.ok(map);
    }
}
