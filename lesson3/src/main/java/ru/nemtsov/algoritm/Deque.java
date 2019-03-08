package ru.nemtsov.algoritm;

import java.util.NoSuchElementException;

public class Deque <Item> {

    Object[] deque = new Object[1];
    int size = 0;
    int left = 0;
    int right = -1;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(deque[(left + i) % deque.length].toString() + (i == size - 1 ? "" : ", "));
        }
        return stringBuilder.toString();
    }

    private void resize(int newSize) {
        Object[] newQueue = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = deque[(left + i) % deque.length];
        }
        deque = newQueue;
        left = 0;
        right = size - 1;
    }

    public void enqueueLeft(Item item) {
        if (deque.length == size) {
            resize(size * 2);
        }
        if (left > 0) {
            left--;
        } else {
            left = deque.length - 1;
        }
        deque[left] = item;
        size++;
        if (size == 1) {
            right = left;
        }
    }

    public void enqueueRight(Item item) {
        if (deque.length == size) {
            resize(size * 2);
        }
        if (right == deque.length - 1) {
            right = 0;
        } else {
            right++;
        }
        deque[right] = item;
        size++;
        if (size == 1) {
            left = right;
        }
    }

    public Item dequeueLeft() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = (Item) deque[left];
        if (left == deque.length - 1) {
            left = 0;
        } else {
            left++;
        }
        size--;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item dequeueRight() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = (Item) deque[right];
        if (right == 0) {
            right = deque.length - 1;
        } else {
            right--;
        }
        size--;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item peekLeft() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        return (Item) deque[left];
    }

    public Item peekRight() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        return (Item) deque[right];
    }
}
