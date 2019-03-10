package ru.nemtsov.algoritm;

import java.util.Scanner;

/**
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 */

public class App 
{
    public static void main( String[] args ) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;
            for (int i = 0; i < line.length(); i++) {
                stack.push(line.charAt(i));
            }
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
        scanner.close();
    }
}
