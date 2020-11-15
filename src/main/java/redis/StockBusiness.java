package redis;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;


/**
 * author: fupeng
 * time: 2020-11-15 12:18
 */
public class StockBusiness {

    public static int INIT_STOCK_COUNT = 1000;
    public static volatile int STOCK_COUNT = INIT_STOCK_COUNT;
    private static CountDownLatch COUNT_DOWN_LATCH;
    private static JedisUtil JEDIS_UTIL;

    public StockBusiness() {
    }

    public StockBusiness(CountDownLatch countDownLatch, JedisUtil jedisUtil) {
        this.JEDIS_UTIL = jedisUtil;
        this.COUNT_DOWN_LATCH = countDownLatch;
    }

    public static synchronized void simpleBuyGoods() {
        STOCK_COUNT--;
    }


    /**
     *  @param key
     * @param timeout 单位：毫秒
     */
    public static void buyGoodsByRedisLock(String key, int timeout) {
        String value = UUID.randomUUID().toString();
        for (; ; ) {
            try {
                if (JEDIS_UTIL.lock(key, value, timeout)) {
//                    System.out.println("#lock success");
                    STOCK_COUNT--;
                    System.out.println("stockCount = " + STOCK_COUNT);
                    break;
                } else {
//                    System.out.println("#lock fail");
                    Thread.sleep(new Random().nextInt(800));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (; ; ) {
            try {
                if (JEDIS_UTIL.release(key, value)) {
//                    System.out.println("unlock success");
                    COUNT_DOWN_LATCH.countDown();
                    break;
                } else {
//                    System.out.println("unlock fail");
                    Thread.sleep(new Random().nextInt(500));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void jedisPoolDestory() {
        JEDIS_UTIL.destory();
    }


}
