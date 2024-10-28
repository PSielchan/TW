package org.example.lab2;

public class Consumer extends Thread{
    private  Buffer buf;
    public Consumer(Buffer buff){
        buf=buff;
    }
    @Override
    public void run(){
        for (int i = 0; i<10;i++){
            try {
                System.out.println(buf.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
