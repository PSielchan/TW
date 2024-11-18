package org.example.lab5;

import java.util.concurrent.locks.ReentrantLock;

public class locklist {
    private class Node {
        Object value;
        Node next;
        ReentrantLock lock;
        Node(Object value) {
            if (value == null) {
                throw new IllegalArgumentException("Null values are not allowed in the list.");
            }
            this.value = value;
            this.lock = new ReentrantLock();
        }
    }
    private Node head;

    public void addLast(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed in the list.");
        }

            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                current.lock.lock();
                while (current.next != null) {
                    current.next.lock.lock();
                    current.lock.unlock();
                    current = current.next;
                }
                current.next = newNode;
                current.lock.unlock();
            }

    }

    public boolean contains(Object value) {
        if (value == null) {
            return false;
        }

        Node current = head;
        current.lock.lock();
        while (current != null) {
            if (current.value.equals(value)) {
                current.lock.unlock();
                return true;
            }
            current.next.lock.lock();
            current.lock.unlock();
            current = current.next;
        }
        return false;

    }


    public boolean remove(Object value) {
        if (value == null) {
            return false;
        }

            if (head == null) {
                return false; // Lista jest pusta
            }

            // Sprawdzanie, czy głowa zawiera wartość
            head.lock.lock();
            if (head.value.equals(value)) {
                head = head.next;
                return true;
            }

            // Iteracja przez listę w poszukiwaniu węzła do usunięcia
            Node current = head;
            while (current.next != null) {
                current.next.lock.lock();
                if (current.next.value.equals(value)) {
                    current.next = current.next.next;
                    current.lock.unlock();
                    return true;
                }
                current.lock.unlock();
                current = current.next;
            }
            return false; // Wartość nie została znaleziona
    }


    public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
    }
}
