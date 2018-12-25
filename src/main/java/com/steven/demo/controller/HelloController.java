package com.steven.demo.controller;

import com.steven.demo.common.CommonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author steven.sheng
 * @Date 2018/12/25/025.
 */
@Controller
public class HelloController {

    private static  Integer count = 0;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public CommonResponse hello() throws Exception{
        count++;
        if(count%2==0){
            throw new Exception("count="+count);
        }
        return new CommonResponse(1,"成功");
    }

    @RequestMapping(value = "/input/{name}")
    @ResponseBody
    public CommonResponse input(@PathVariable(value = "name")String name) throws Exception{
        if(StringUtils.isEmpty(name) || name.length()%2==0){
            throw new Exception();
        }
        return new CommonResponse(1,"成功");
    }
}
