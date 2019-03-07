package ru.nemtsov.algoritm;

import java.util.NoSuchElementException;

public class Stack<Item> {

    private Object[] stack = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(stack[i].toString() + (i == 0 ? "" : ", "));
        }
        return stringBuilder.toString();
    }

    private void resize(int newSize) {
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(size * 2);
        }
        stack[size++] = item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (Item) stack[size - 1];
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item result = (Item) stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size < stack.length / 4) {
            resize(stack.length / 2);
        }
        return result;
    }

}
