package graph;

import sun.misc.Queue;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MatrixUndirectedGraph {
    private boolean[][] matrix;
    private int size;

    public MatrixUndirectedGraph(int i) {
        this.size = i;
        this.matrix = new boolean[size][size];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            matrix[i][j] = true;
            matrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            matrix[i][j] = false;
            matrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return matrix[i][j];
        } else {
            return false;
        }
    }

    public int getAdjUnvisitedVertex(int x, boolean[] visitedlist) {
        for (int i = 0; i < size; i++) {
            if (x != i && isEdge(x, i) && !visitedlist[i]) {
                return i;
            }
        }
        return -1;
    }
    public void DFS() {
        boolean[] visitedList = new boolean[size];
        for (int i = 0; i < visitedList.length; i++) {
            visitedList[i] = false;
        }

        Stack<Integer> stack = new Stack<>();

        System.out.println(0);
        visitedList[0] = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek(), visitedList);

            if (v == -1) stack.pop();
            else {
                System.out.println(v);
                visitedList[v] = true;
                stack.push(v);
            }
        }
    }

    public void BFS() throws InterruptedException {
        boolean[] visitedList = new boolean[size];
        for (int i = 0; i < visitedList.length; i++) {
            visitedList[i] = false;
        }


        Queue<Integer> queue = new Queue<>();

        queue.enqueue(0);
        visitedList[0] = true;
        while (!queue.isEmpty()) {

            int visitVertex = queue.dequeue();
            System.out.println(visitVertex);

            for (int i = 0; i < size; i++) {
                if (visitVertex != i && matrix[visitVertex][i] && !visitedList[i]) {
                    queue.enqueue(i);
                    visitedList[i] = true;
                }
            }
        }
    }
}
