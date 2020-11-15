package redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static redis.StockBusiness.INIT_STOCK_COUNT;
import static redis.StockBusiness.STOCK_COUNT;

/**
 * author: fupeng
 * time: 2020-11-15 12:09
 */
public class RedisLock {


    public static CountDownLatch countDownLatch = new CountDownLatch(INIT_STOCK_COUNT);

    public static void main(String[] args) {
        System.out.println("Stock should be 1000, stockCount = " + STOCK_COUNT);
        ExecutorService executor = Executors.newCachedThreadPool();

        /**
         * 并发执行会导致超卖问题
         */
        System.out.println("抢购商品(错误姿势)开始执行");
        long beginTimeMillis1 = System.currentTimeMillis();
        for (int i = 0; i < INIT_STOCK_COUNT; i++) {
            executor.execute(() -> {
                StockBusiness stockBusiness = new StockBusiness();
                stockBusiness.simpleBuyGoods();
                System.out.println("stockCount = " + STOCK_COUNT);
            });
        }

        int count = 0;
        int lastStockCount = STOCK_COUNT;
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (lastStockCount == STOCK_COUNT) {
                count++;
            } else {
                count = 0;
            }
            lastStockCount = STOCK_COUNT;
            if (count > 5) {
                long stopTimeMillis1 = System.currentTimeMillis();
                System.out.println("抢购商品(错误姿势)执行结束, stockCount should be " + INIT_STOCK_COUNT + " but is " +
                        STOCK_COUNT + ", runTime = " + (stopTimeMillis1 - beginTimeMillis1 - count) + "ms");
                break;
            }

        }






        /**
         * 采用redis分布式锁，不会产生超卖问题
         */
//        STOCK_COUNT = INIT_STOCK_COUNT;
//        JedisUtil jedisUtil = new JedisUtil();
//        jedisUtil.jedisInit();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("抢购商品(正确姿势)开始执行");
//        long beginTimeMillis2 = System.currentTimeMillis();
//        for (int i = 0; i < INIT_STOCK_COUNT; i++) {
//            executor.execute(() -> {
//                StockBusiness stockBusiness = new StockBusiness(countDownLatch, jedisUtil);
//                stockBusiness.buyGoodsByRedisLock("lock", 5000);
//            });
//        }
//        try {
//            countDownLatch.await();
//            long stopTimeMillis2 = System.currentTimeMillis();
//            System.out.println("抢购商品(正确姿势)执行结束, stockCount should be " + INIT_STOCK_COUNT + " and actualy it is "
//                    + STOCK_COUNT + ", runTime = " + (stopTimeMillis2 - beginTimeMillis2) + "ms");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            jedisUtil.destory();
//        }


        executor.shutdown();
    }


}
