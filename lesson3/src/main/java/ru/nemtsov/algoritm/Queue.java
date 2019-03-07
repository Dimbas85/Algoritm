package ru.nemtsov.algoritm;

public class Queue {

    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newSize) {
        Object[] newQueue = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(start + i) % queue.length];
        }
        queue = newQueue;
        start = 0;
        end = size;
    }

}
