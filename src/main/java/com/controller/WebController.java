package com.controller;

import com.model.WebModel;
import com.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Knigh on 2016/11/14.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController extends BaseController {

    @Autowired
    private WebService webService;

    @ResponseBody
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public void input(WebModel web) throws Exception{
        System.out.println("input:");
        System.out.println(web);
        webService.saveWeb(web);
    }

    @ResponseBody
    @RequestMapping(value = "/getweb", method = RequestMethod.GET)
    public void getWeb(@RequestParam String des) throws Exception{
        System.out.println("output:");
        System.out.println(webService.getWeb(des));
    }

    @ResponseBody
    @RequestMapping(value = "/webhset", method = RequestMethod.POST)
    public void webhset(WebModel web) throws Exception{
        System.out.println("webhset:");
        System.out.println(web);
        webService.hset(web);
    }

    @ResponseBody
    @RequestMapping(value = "/webhget", method = RequestMethod.POST)
    public void webhget(@RequestParam String des) throws Exception{
        System.out.println("webhget:");
        System.out.println(webService.hget(des));
    }

    @ResponseBody
    @RequestMapping(value = "/weblike", method = RequestMethod.GET)
    public void weblike(@RequestParam String key) throws Exception{
        webService.weblike(key);
    }
}
