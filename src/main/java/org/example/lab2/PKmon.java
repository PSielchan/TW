package org.example.lab2;

public class PKmon {
    public static void main(String[] args){
        final int n = 10;
        Buffer b1 = new Buffer(10);
        Producer[] p = new Producer[n];
        Consumer[] c = new Consumer[n];
        for (int i=0;i<n;i++){
            p[i]=new Producer(b1);
            p[i].start();
        }
        for (int i=0;i<n;i++){
            c[i]=new Consumer(b1);
            c[i].start();
        }
        try {
            for(int i=0;i<n;i++){
                p[i].join();
                c[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
