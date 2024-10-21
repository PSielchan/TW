package org.example;

import org.example.lab0.Counter;
import org.example.lab0.ThreadCreator;
import org.example.lab1.semafor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        semafor sem = new semafor();
        sem.P();
        sem.V();
    }
}