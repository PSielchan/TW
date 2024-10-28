package org.example.lab2;

import java.util.LinkedList;

public class Buffer {
    private final int capacity;

    public Buffer(int capacity){
        this.capacity = capacity;
    }
    private LinkedList<Integer> buf = new LinkedList<Integer>();
    public synchronized void put(int i) throws InterruptedException {
        while (buf.size() >= capacity) {
            wait();
        }
        buf.addFirst(i);
        notifyAll();
    }
    public synchronized int get() throws InterruptedException {
        while (buf.isEmpty()) {
            wait();
        }
        int item = buf.removeLast();
        notifyAll();
        return item;
    }
}
