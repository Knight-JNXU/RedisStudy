package com.service;

import com.common.Constant;
import com.dao.WebDao;
import com.model.WebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Knigh on 2016/11/16.
 */
@Service
public class WebService extends BaseService {

    @Autowired
    private WebDao webDao;

    public String saveWeb(WebModel web) throws Exception{
//        return Constant.TEST_MES;
        try {
            webDao.saveWeb(web);
            return Constant.SUCCESS_MES;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.FAILED_MES;
        }
    }

    public String getWeb(String des) throws Exception{
        return webDao.getWeb(des).toString();
    }

    public String hset(WebModel web) throws Exception{
        try {
            webDao.hset(web);
            return Constant.SUCCESS_MES;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.FAILED_MES;
        }
    }

    public WebModel hget(String key) throws Exception{
        return webDao.hget(key);
    }

    public void weblike(String key) throws Exception{
        System.out.println(webDao.like(key));
    }
}
