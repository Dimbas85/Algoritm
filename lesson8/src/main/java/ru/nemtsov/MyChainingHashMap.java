package ru.nemtsov;

import java.util.Arrays;

public class MyChainingHashMap<Key, Value> {

    private int size = 0;
    private Object[] st = new Object[1];

    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % st.length;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        if (size == st.length) {
            resize(size * 2);
        }
        add(key, value);
        size++;
    }

    private void add(Key key, Value value) {
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
    }

    private void resize(int length) {
        Object[] oldSt = Arrays.copyOf(st, st.length);
        st = new Object[length];
        for (int i = 0; i < size; i++) {
            Node x = (Node)oldSt[i];
            if (x == null) continue;
            add(x.key, x.value);
        }
    }

}
