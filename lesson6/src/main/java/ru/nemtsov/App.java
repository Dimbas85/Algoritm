package ru.nemtsov;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        for (int i = 0; i < 20; i++) {
            Integer val = (int) (Math.random() * 200 - 100);
            map.put(val, val);
        }
    }
}
