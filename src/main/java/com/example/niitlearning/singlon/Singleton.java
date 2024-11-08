package com.example.niitlearning.singlon;

import java.io.*;
import java.nio.file.Files;

public class Singleton implements Serializable {


    private static final long serialVersionUID = 1L;
    private Singleton() {
        if (Instance.INSTANCE != null) {
            throw new IllegalStateException();
        }
    }
    public static Singleton getInstance() {
        return Instance.INSTANCE;
    }


    //实现readResolve接口就ok了
    private Object readResolve() throws ObjectStreamException {
        return Instance.INSTANCE;
    }

    private static class Instance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("/Users/baodi/Desktop/Singleton.bin");
        Singleton singleton = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
        oos.writeObject(singleton);
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
        Singleton singleton1 = (Singleton) ois.readObject();
        System.out.println("源对象singleton == 反序列化对象 singleton1吗？" + (singleton == singleton1));
    }
}