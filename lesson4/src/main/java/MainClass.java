import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addFirst('d');
        list.addFirst('m');
        list.addFirst('g');
        list.addLast('w');
        list.addLast('a');
        list.add(1, 'i');
        System.out.println(list);
        System.out.println(list.remove('m'));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.get(0));
        list.set(1, 'r');
        System.out.println(list.size());
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
