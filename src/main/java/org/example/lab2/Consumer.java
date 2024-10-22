package org.example.lab2;

public class Consumer extends Thread{
    private  Buffer buf;
    public Consumer(Buffer buff){
        buf=buff;
    }
    @Override
    public void run(){
        for (int i = 0; i<100;i++){
            System.out.println("con");
            while(buf.size()==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(buf.get());
            notifyAll();
        }
    }
}
