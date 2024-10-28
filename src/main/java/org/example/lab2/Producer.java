package org.example.lab2;

public class Producer extends Thread{
    private Buffer buf;
    public Producer(Buffer buff){
        buf=buff;
    }
    @Override
    public void run(){
        for (int i = 0; i<10;i++){
            try {
                buf.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
