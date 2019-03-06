package ru.nemtsov.algo;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item>{

    private Object[] list = new Object[1];
    private int size = 0;

    public void add(Item item) {
        if (size == list.length) {
            resize(size * 2);
        }
        list[size] = item;
        size++;
    }

    private void resize(int length) {
        Object[] newList = new Object[length];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public int size() {
        return size;
    }

    public boolean remove(Item item) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i].equals(item)) break;
        }
        if (i == size) {
            return false;
        }
        for (int j = i + 1; j <= size; j++) {
            list[j - 1] = list[j];
        }
        list[size - 1] = null;
        size--;
        if (size < list.length / 4) {
            resize(size * 2);
        }
        return true;
    }

    public Item get(int Index) {
        if (Index < 0 || Index > size - 1) throw new IndexOutOfBoundsException();
        else return (Item) list[Index];
    }

    public void set(int Index, Item item) {
        if (Index < 0 || Index > size - 1) throw new IndexOutOfBoundsException();
        else list[Index] = item;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(list[i] + (i == size - 1 ? "" : ", "));
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            Item result = (Item) list[cursor];
            cursor++;
            return result;
        }
    }

    public void exchange(int i, int j) {
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private boolean less(Item i1, Item i2, Comparator<Item> comparator) {
        return comparator.compare(i1, i2) < 0;
    }

    public void selectionSort(Comparator<Item> comparator) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size(); j++) {
                if (less(get(j), get(min), comparator)) {
                    min = j;
                }
            }
            if (i != min) exchange(i, min);
        }
    }

    public void insertionSort(Comparator<Item> comparator) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less(get(j), get(j - 1), comparator)) {
                    exchange(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

}
