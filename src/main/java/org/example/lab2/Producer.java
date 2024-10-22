package org.example.lab2;

public class Producer extends Thread{
    private Buffer buf;
    public Producer(Buffer buff){
        buf=buff;
    }
    @Override
    public void run(){
        for (int i = 0; i<100;i++){
            System.out.println("prod");
            while (buf.size()>=100){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            buf.put(i);
            notifyAll();
        }
    }
}
