package org.example.lab3;
import org.example.lab1.semafor;

public class Stol {
    public static void main(String[] args){
        semafor[] s = new semafor[5];
        for(int i=0;i<5;i++){
            s[i] = new semafor();
        }
        Filozof[] fil = new Filozof[5];
        for(int i=0;i<4;i++){
            fil[i] = new Filozof(s[i],s[i+1],i);
        }
        fil[4] = new Filozof(s[4],s[0],4);
        for(int i=0;i<5;i++){
            fil[i].start();
        }
        try {
            for(int i=0;i<5;i++){
                fil[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
