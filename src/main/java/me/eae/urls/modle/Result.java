package me.eae.urls.modle;

import java.util.HashMap;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3016:31
 */
public class Result  extends HashMap<String, Object> {


    public static Result OK(String data){
        Result result = new Result();
        result.put("code","0");
        result.put("data",data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.put("code","500");
        result.put("msg",msg);
        return result;
    }
}
