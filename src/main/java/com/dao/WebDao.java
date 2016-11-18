package com.dao;

import com.model.WebModel;
import org.springframework.stereotype.Repository;

/**
 * Created by Knigh on 2016/11/16.
 */
@Repository
public class WebDao extends BaseDao{
    public boolean saveWeb(final WebModel web) throws Exception{
        try {
            set(web.getDes(), web.getUrl());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public WebModel getWeb(String des) throws Exception{
        return new WebModel(des, (String)get(des));
    }

    public void hset(WebModel webModel) throws Exception{
        super.hset(webModel);
    }

    public WebModel hget(String key) throws Exception{
        String url = super.hget(key, new WebModel().getField());
        return new WebModel(key, url);
    }
}
