package code.base;

import redis.clients.jedis.Jedis;

/**
 * Created by Knight_JXNU on 2016/10/25.
 */
public class QuickStart {

    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6380);

        String keys = "name";

        //删数据
        jedis.del(keys);
        //存数据
        jedis.set(keys, "knight");
        //取数据
        String value = jedis.get(keys);

        System.out.println(value);
    }

}
