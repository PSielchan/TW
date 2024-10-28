package org.example.lab3;

import org.example.lab1.semafor;

public class Filozof extends Thread{
    boolean par;
    semafor a,b;
    public Filozof(semafor a, semafor b,int i){
        this.a=a;
        this.b=b;
        par = (i%2==0);
    }
    @Override
    public void run(){
        for (int i=0;i<30;i++) {
            think();
            je();
        }
    }
    private void think(){
        try {
            System.out.println("Mysli");
            sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void je(){
        if (par) {
            a.P();
            //System.out.println("Bierze A");
            try {
                System.out.println("Bierze A");
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.P();
            System.out.println("Je");
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.V();
            b.V();
        }else{
            b.P();
            //System.out.println("Bierze A");
            try {
                System.out.println("Bierze B");
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.P();
            System.out.println("Je");
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.V();
            b.V();
        }
    }
}
