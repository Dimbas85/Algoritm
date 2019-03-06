package ru.nemtsov.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

/**
 * 1. Повторить реализацию АТД «список» с помощью структуры данных «массив» (не подглядывать, пытаться самим сделать).
 * 2. Провести эксперимент по сравнению эффективности алгоритмов сортировки:
 * a) заполнить список случайными N целыми числами в диапазоне от a до b;
 * b) запустить алгоритмы сортировки, засекая время их выполнения;
 * c) повторить эксперимент M раз;
 * d) данные вывести в таблицe.
 */

public class App 
{
    public static void main( String[] args ) {

        int n = 10000;
        int a = 1;
        int b = 1000;
        int m = 20;
        MyIntegerComparator comparator = new MyIntegerComparator();

        System.out.println("№     sel     ins");
        for (int i = 0; i < m; i++) {
            MyArrayList<Integer> selectionList = new MyArrayList<>();
            for (int j = 0; j < n; j++) {
                selectionList.add((int) (b * Math.random()));
            }
            MyArrayList<Integer> insertionList = new MyArrayList<>();
            for (int j = 0; j < n; j++) {
                insertionList.add((int) (b * Math.random()));
            }

            System.out.print(i + "     ");

            Date startSelection = new Date();
            selectionList.selectionSort(comparator);
            System.out.print(new Date().getTime() - startSelection.getTime() + "     ");

            Date startInsertion = new Date();
            insertionList.insertionSort(comparator);
            System.out.println(new Date().getTime() - startInsertion.getTime());
        }


    }

    private static class MyIntegerComparator implements Comparator <Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}
