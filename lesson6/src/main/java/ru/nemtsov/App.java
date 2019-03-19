package ru.nemtsov;

/**
 * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев
 * с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */

public class App 
{
    public static void main( String[] args ) {
        int balanced = 0;
        int notBalanced = 0;
        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            while (true){
                if (map.height() >= 7) {
                    break;
                }
                Integer val = (int) (Math.random() * 200 - 100);
                map.put(val, val);
            }
            if (map.isBalanced()) balanced++;
            else notBalanced++;
        }
        System.out.println("Balanced: " + balanced);
        System.out.println("Not balanced: " + notBalanced);
        System.out.println("Percent: " + String.format("%.2f",(float) balanced / (balanced + notBalanced) * 100));
    }
}
