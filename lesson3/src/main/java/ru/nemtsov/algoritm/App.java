package ru.nemtsov.algoritm;

/**
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 */

public class App 
{
    public static void main( String[] args ) {
        Stack<Character> stack = new Stack<>();
        System.out.println(stack);
        stack.push('d');
        stack.push('i');
        System.out.println(stack);
        stack.push('m');
        stack.push('a');
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
