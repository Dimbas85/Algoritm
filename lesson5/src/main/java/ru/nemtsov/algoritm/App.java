package ru.nemtsov.algoritm;

/**
 *
 *
 */

public class App 
{
    public static void main( String[] args ) {
        System.out.println("towerRec");
        String start_peg = "A", destination_peg = "B", buffer_peg = "C";
        int plate_quantity = 4;
        towerRec(plate_quantity, start_peg, destination_peg, buffer_peg);
        System.out.println("tower");
        tower(4);
    }

    //1. Написать программу по возведению числа в степень с помощью рекурсии и с помощью циклического оператора.
    // методы возводят число а в степень b

    private static int exp(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    private static int expRec(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        return a * expRec(a, b - 1);
    }

    //2. Познакомиться с головоломкой Ханойские башни. Реализовать рекурсивный и циклический алгоритмы решения этой головоломки.
    private static void towerRec(int qty, String from, String to, String buffer) {
        if (qty != 0) {
            towerRec(qty - 1, from, buffer, to);
            System.out.println("Move from " + from + " to " + to );
            towerRec(qty - 1, buffer, to, from);
        }
    }

    private static void tower(int qty)	{
        Stack<Integer> stackA = new Stack<>();
        for (int i = qty; i > 0; i--) {
            stackA.push(i);
        }
        Stack<Integer> stackC = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        while (true) {
            if (stackA.size() == 0 && stackB.size() == qty) break;
            if (qty % 2 == 0) {
                if (!stackA.isEmpty() && (stackC.isEmpty() || stackA.peek() < stackC.peek())) {
                    stackC.push(stackA.pop());
                    System.out.println("Move from A to C");
                } else {
                    stackA.push(stackC.pop());
                    System.out.println("Move from C to A");
                }
                if (!stackA.isEmpty() && (stackB.isEmpty() || stackA.peek() < stackB.peek())) {
                    stackB.push(stackA.pop());
                    System.out.println("Move from A to B");
                } else {
                    stackA.push(stackB.pop());
                    System.out.println("Move from B to A");
                }
                if (!stackC.isEmpty() && (stackB.isEmpty() || stackC.peek() < stackB.peek())) {
                    stackB.push(stackC.pop());
                    System.out.println("Move from C to B");
                } else {
                    stackC.push(stackB.pop());
                    System.out.println("Move from B to C");
                }
            } else {
                if (!stackA.isEmpty() && (stackB.isEmpty() || stackA.peek() < stackB.peek())) {
                    stackB.push(stackA.pop());
                    System.out.println("Move from A to B");
                } else {
                    stackA.push(stackB.pop());
                    System.out.println("Move from B to A");
                }
                if (!stackA.isEmpty() && (stackC.isEmpty() || stackA.peek() < stackC.peek())) {
                    stackC.push(stackA.pop());
                    System.out.println("Move from A to C");
                } else {
                    stackA.push(stackC.pop());
                    System.out.println("Move from C to A");
                }
                if (!stackC.isEmpty() && (stackB.isEmpty() || stackC.peek() < stackB.peek())) {
                    stackB.push(stackC.pop());
                    System.out.println("Move from C to B");
                } else {
                    stackC.push(stackB.pop());
                    System.out.println("Move from B to C");
                }
            }
        }
    }

//    Обозначим через «1-2» такое действие: переложить диск или с 1-го штыря на 2-й, или со 2-го на 1-й, в зависимости от
//    того, где он меньше. Тогда, чтобы решить головоломку с чётным количеством дисков, надо многократно повторять
//    действия: 1-2, 1-3, 2-3. Если число дисков нечётно — 1-3, 1-2, 2-3.

}
