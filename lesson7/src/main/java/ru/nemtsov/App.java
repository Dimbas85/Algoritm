package ru.nemtsov;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */

public class App 
{
    public static void main( String[] args ) {

        MyGraph g = new MyGraph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 7);
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(5, 0);
        g.addEdge(5, 3);
        g.addEdge(6, 2);
        g.addEdge(7, 5);
        g.addEdge(8, 3);
        g.addEdge(9, 2);
        g.addEdge(9, 8);

        BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);
        System.out.println(bfp.pathTo(7));
    }
    
}
