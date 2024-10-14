package org.example.lab0;

public class ThreadCreator {
    public void run(){
        for(int i=0;i<5000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //int j=0;
                    while(true){
                    //    j+=1;
                    }
                }
            }).start();
            System.out.println(i);
        }
    }
}
