package com.service;

import com.common.Constant;
import com.dao.WebDao;
import com.model.WebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getWeb() throws Exception{
        return webDao.getWeb().toString();
    }
}
