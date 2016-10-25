package code.base;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Knight_JXNU on 2016/10/25.
 */
public class JedisSharding {

    public static void main(String[] args){
        ResourceBundle bundle = ResourceBundle.getBundle("jedis-sharding-conf");
        if(bundle == null){
            throw new IllegalArgumentException("[redis.properties] is not found!");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWaitMillis")));
        config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));

        JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis1.ip"), Integer.valueOf(bundle.getString("redis.port")));
        JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis2.ip"), Integer.valueOf(bundle.getString("redis.port")));
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1);
        list.add(jedisShardInfo2);

        ShardedJedisPool pool = new ShardedJedisPool(config, list);
        ShardedJedis jedis = pool.getResource();
        String keys = "name";

        //删数据
        jedis.del(keys);
        //存数据
        jedis.set(keys, "liuwen");
        //取数据
        String value  = jedis.get(keys);

        System.out.println(value);

        //释放对象池
        pool.returnResource(jedis);
    }

}
