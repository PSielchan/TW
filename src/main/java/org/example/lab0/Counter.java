package org.example.lab0;

public class Counter{
    public int Count=0;
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<5;i++){
                    Count+=1;
            }
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<4;i++){
                Count-=1;
            }
        }
    });
}