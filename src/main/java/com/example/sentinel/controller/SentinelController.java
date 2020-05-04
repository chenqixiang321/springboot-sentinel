package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SentinelController {

    @Value("${foo22:222}")
    private String foo;

    @RequestMapping("/sentinel")
    @SentinelResource(value = "sentinel", blockHandler = "handleException")
    @ResponseBody
    public String sentinel(){
        return "sentinel ...."+foo;
    }

    @RequestMapping("/sentinel2")
    @ResponseBody
    public String sentinel2(){
        return "sentinel2 ....";
    }
    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String handleException(BlockException ex) {
        return "handleException";
    }
}
