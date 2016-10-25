package code.base;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by Knight_JXNU on 2016/10/25.
 * 单个 Jedis 不是线程安全的，JedisPool 是线程安全的
 */
public class JedisPoolTest {
    public static void main(String[] args){
        JedisPool pool;
        ResourceBundle bundle = ResourceBundle.getBundle("jedis-pool-conf");
        if(bundle == null){
            throw new IllegalArgumentException("[redis.properties] is not found!");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWaitMillis")));
        config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
        pool = new JedisPool(config, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));

        //从池中获取一个Jedis对象
        Jedis jedis = pool.getResource();
        String keys = "name";

        //删数据
        jedis.del(keys);
        //存数据
        jedis.set(keys, "knight");
        //取数据
        String value = jedis.get(keys);

        System.out.println(value);

        //释放对象池
        pool.close();
    }
}
