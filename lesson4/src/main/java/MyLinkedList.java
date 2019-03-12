import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <Item> implements Iterable{

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Node previous, Item item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = first;
        while (current != null) {
            stringBuilder.append(current.item.toString() + (current.next == null ? "" : ", "));
            current = current.next;
        }
        return stringBuilder.toString();
    }

    public int indexOf(Item item) {
        Node current = first;
        int index = 0;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
            index++;
        }
        return current != null ? index : -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (size == 0) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Item getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return first.item;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node second = first.next;
        Item item = first.item;
        first.item = null;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            second.previous = null;
        }
        return item;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return last.item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Item item = last.item;
        Node previous = last.previous;
        last.previous = null;
        last = previous;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public void add(int index, Item item) { //addBefore
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        else if (index == size) {
            addLast(item);
            return;
        }

        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(current.previous, item, current);
        Node previous = current.previous;
        previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current.item;
    }

    public void set(int index, Item item) { //a[index] = item;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        current.item = item;
    }

    public Item remove(Item item) {
        Node current = first;

        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            return removeFirst();
        }
        if (current == last) {
            return removeLast();
        }
        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.previous = null;
        current.next = null;
        return current.item;
    }

    private class MyLinkedIterator implements Iterator <Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public Iterator iterator() {
        return new MyLinkedIterator();
    }

}


