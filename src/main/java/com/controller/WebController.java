package com.controller;

import com.model.WebModel;
import com.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public void getWeb() throws Exception{
        System.out.println("output:");
        System.out.println(webService.getWeb());
    }

}
