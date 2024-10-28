package org.example.lab1;

public class semafor {
    private boolean _stan = true;
    private int _czeka = 0;

    public semafor(){
    }
    public synchronized void P(){
        _czeka++;
        try {
            while (!_stan) {
                wait();
            }
            _stan = false;
            //System.out.println("koniec");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek został przerwany.");
        } finally {
            _czeka--;
        }
    }
    public synchronized void V(){
        _stan=true;
        notifyAll();
    }
}
