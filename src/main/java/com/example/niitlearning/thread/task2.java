package com.example.niitlearning.thread;

public class task2 implements Runnable{
    private int i;
    public task2(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println("子线程正在进行计算");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i*i);
    }
}
