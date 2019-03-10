package ru.nemtsov.algoritm;

import java.util.NoSuchElementException;

public class Queue <Item> {

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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(queue[(start + i) % queue.length].toString() + (i == size - 1 ? "" : ", "));
        }
        return stringBuilder.toString();
    }

    public void enqueue(Item item) {
        if (size == queue.length) {
            resize(size * 2);
        }
        queue[end++] = item;
        end = end % queue.length;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[start++];
        size--;
        start = start % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return  (Item) queue[start];
    }
}
