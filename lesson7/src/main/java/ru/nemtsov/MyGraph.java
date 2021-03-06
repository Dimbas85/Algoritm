package ru.nemtsov;

import java.util.LinkedList;

public class MyGraph {

    private int vertexCount, edgeCount;
    private LinkedList<Integer>[] adjLists;

    public MyGraph(int vertexCount) {

        if (vertexCount < 0) {
            throw new IllegalArgumentException("Количество вершин не может быть отрицательным");
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }

    }

    public int vertexCount() {

        return vertexCount;

    }

    public int edgeCount() {

        return edgeCount;

    }

    public void addEdge(int v1, int v2) {

        if (v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Номер вершины не может быть отрицательным");
        }
        if (v1 >= vertexCount || v2 >= vertexCount) {
            throw new IndexOutOfBoundsException("Нет вершины с таким номером");
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);

    }

    public LinkedList<Integer> adjList(int vertex) {

        return adjLists[vertex];

    }

}