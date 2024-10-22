package org.example.lab2;

import java.util.LinkedList;

public class Buffer {
    public Buffer(){
    }
    private LinkedList<Integer> buf = new LinkedList<Integer>();
    public synchronized void put(int i){
        buf.addFirst(i);
    }
    public synchronized int get(){
        return(buf.getLast());
    }
    public synchronized int size(){
        return buf.size();
    }
}
