package com.example.niitlearning.thread;

import java.util.concurrent.Callable;

public class task implements Callable<Integer> {
    private int i;
    public task(int i){
        this.i = i;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在进行计算");
        Thread.sleep(3000);
        return i*i;
    }
}
