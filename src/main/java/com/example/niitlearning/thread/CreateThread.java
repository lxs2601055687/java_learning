package com.example.niitlearning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的四种方式
 */
public class CreateThread {
    public static void main(String[] args) {
        //继承Thread类重写run方法
        new InitThread().start();
        //函数式接口:匿名内部类的语法糖
        new Thread(() -> System.out.println("实现Runnable接口")).start();
        //参数是一个接口的子类并且该接口只有一个抽象方法，那么该接口就叫函数式接口
        new Thread(new RunnableTask()).start();
        //Callable接口是一个带泛型的接口，泛型表示的是call方法的返回值类型
        //Callable接口的call方法可以抛出异常
        //FutureTask是Runnable接口的实现类，可以传入Callable接口的实现类
        //FutureTask可以接收Callable接口的实现类，也可以接收Runnable接口的实现类
        //FutureTask是Future接口的实现类，Future接口是一个泛型接口，泛型表示的是call方法的返回值类型
        FutureTask<String> futureTask = new FutureTask<>(new CallableTask());
        new Thread(futureTask).start();
        try {
            //获取异步计算的结果
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //FutureTask包装Runnable接口的实现类
        FutureTask<String> futureTask1 = new FutureTask<>(new RunnableTask(), "实现Runnable接口");
        new Thread(futureTask1).start();
        //FutureTask是一个可取消的异步计算，是Future接口的实现类
        //FutureTask可以用来包装Callable或者Runnable对象
        //FutureTask可以用来获取异步计算的结果
        //FutureTask可以用来取消异步计算
        //FutureTask可以用来判断异步计算是否完成
        //FutureTask可以用来阻塞当前线程，直到异步计算完成
        //FutureTask可以用来设置异步计算完成后的回调函数
    }
}
class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}

class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "实现Callable接口";
    }
}

class InitThread extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread类");
    }
}