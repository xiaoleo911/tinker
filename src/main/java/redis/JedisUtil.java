package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

/**
 * author: fupeng
 * time: 2020-11-15 14:28
 */
public class JedisUtil {

    private static JedisPoolConfig jedisPoolConfig;
    public static JedisPool jedisPool;
    private static String ip = "localhost";
    private static int port = 6379;
    private static int timeout = 2000;

    private static String LOCK_SUCCESS = "OK";
    private static Long UNLOCK_SUCCESS = 1L;


    public static void jedisInit() {
        // UUID 初始化比较耗时
        UUID.randomUUID().toString();
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(10000);
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setTestOnCreate(false);
        jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout);
    }

    public static void destory() {
        jedisPool.destroy();
    }

    /**
     *
     * @param key
     * @param timeout 过期时间，单位：ms
     * @return
     */
    public static boolean lock(String key, String value, int timeout) {
        return LOCK_SUCCESS.equals(jedisPool.getResource().set(key, value, new SetParams().nx().px(timeout)));
    }

    public static boolean release(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        return UNLOCK_SUCCESS.equals(jedisPool.getResource().eval(script, Collections.singletonList(key), Collections.singletonList(value)));
    }

    public static void main(String[] args) {

        JedisUtil jedisUtil = new JedisUtil();
        jedisUtil.jedisInit();

//        System.out.println(jedisPool.getResource().set("fupeng", "test"));
//        System.out.println(jedisPool.getResource().get("fupeng"));

        String value1 = UUID.randomUUID().toString();
        System.out.println(JedisUtil.lock("stockLock", value1, 5000));


        System.out.println(JedisUtil.release("stockLock", value1));


//        String value2 = UUID.randomUUID().toString();
//        System.out.println(JedisUtil.lock("stockLock", value2, 5000));



        JedisUtil.destory();
    }


}
