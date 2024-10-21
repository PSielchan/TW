package org.example.lab1;

public class semafor_licznikowy {
    private int robi = 0;
    private int _czeka = 0;

    public semafor_licznikowy(){
    }
    public synchronized void P(){
        _czeka++;
        try {
            while (robi>=3) {
                wait();
            }
            robi++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek został przerwany.");
        } finally {
            _czeka--;
        }
    }
    public synchronized void V(){
        robi--;
        notify();
    }
}
