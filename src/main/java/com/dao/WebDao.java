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

    public WebModel getWeb() throws Exception{
        Object o = get("baidu");
        return (WebModel)o;
    }
}
