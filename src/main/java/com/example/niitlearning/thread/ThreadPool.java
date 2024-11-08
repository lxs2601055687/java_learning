package com.example.niitlearning.thread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        //缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //固定大小线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        //单线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //定时任务线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //工作窃取线程池
        ExecutorService workStealingPool = Executors.newWorkStealingPool(10);
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                //核心线程数
                10,
                //最大线程数
                20,
                //线程空闲时间
                10,
                //时间单位
                TimeUnit.MINUTES,
                //数组有界队列
                new ArrayBlockingQueue<>(1000),
                //自定义线程池工厂
                new NamedThreadFactory("niit-learning-thread-pool", false),
                new ThreadPoolExecutor.AbortPolicy()
        );
        //提交任务submit和execute的区别
        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = threadPoolExecutor.submit(new task(i));
          try {
                System.out.println(submit.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            //没有返回值
          threadPoolExecutor.execute(new task2(i));
        }

    }
}
