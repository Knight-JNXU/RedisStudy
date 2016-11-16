package com.controller;

import com.model.WebModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Knigh on 2016/11/14.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController extends BaseController {

    @ResponseBody
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public void input(WebModel web){
        System.out.println(web.getUrl());
        System.out.println(web.getDes());
    }

}
