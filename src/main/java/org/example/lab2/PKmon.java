package org.example.lab2;

public class PKmon {
    public static void main(String[] args){
        Buffer b1 = new Buffer();
        Producer p1 = new Producer(b1);
        Consumer c1 = new Consumer(b1);
        p1.start();
        c1.start();
        try {
            p1.join();
            c1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
