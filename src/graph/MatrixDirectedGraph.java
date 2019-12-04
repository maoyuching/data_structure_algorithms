package graph;

import sun.misc.Queue;

/*
有向图 带权重
 */
public class MatrixDirectedGraph {

    boolean[][] matrix;
    int[][] weight;
    int size;

    /*
    构造函数
     */
    public MatrixDirectedGraph(int i) {
        size = i;
        matrix = new boolean[size][size];
        weight = new int[size][size];
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                matrix[j][k] = false;
            }
        }

        for (int j = 0; j < weight.length; j++) {
            for (int k = 0; k < weight.length; k++) {
                weight[j][k] = -1;
            }
        }
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            matrix[i][j] = true;
        }
    }

    public void addEdgeWithWeight(int i, int j, int weight) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            this.matrix[i][j] = true;
            this.weight[i][j] = weight;
        }

    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            matrix[i][j] = false;
            this.weight[i][j] = -1;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return matrix[i][j];
        } else {
            return false;
        }
    }

    public int indegree(int i) {
        int ans = 0;
        for (int j = 0; j < size; j++) {
            if (j != i && isEdge(j, i)) {
                ans ++;
            }
        }
        return ans;
    }

    public void topologicalSort() {
        int[] indegreeList = new int[size];
        for (int i = 0; i < indegreeList.length; i++) {
            indegreeList[i] = indegree(i);
        }

        int visitedCount = 0;
        while (visitedCount != size) {
            for (int i = 0; i < indegreeList.length; i++) {
                if (indegreeList[i] == 0) {
                    indegreeList[i]= -1;
                    System.out.println(i);
                    for (int j = 0; j < size; j++) {
                        if (isEdge(i, j)) indegreeList[j]--;
                    }
                    visitedCount++;
                }
            }
        }
    }

    public int getWeight(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            if (i == j) return 0;
            else return this.weight[i][j];
        } else {
            return -1;
        }
    }


    public void bellmanFord(int i) throws InterruptedException {

        int[] cost = new int[size];
        for (int j = 0; j < cost.length; j++) {
            cost[j] = -1;
        }
        cost[i] = 0;

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(i);

        while (!queue.isEmpty()) {
            int temp = queue.dequeue();

            for (int j = 0; j < cost.length; j++) {
                if (isEdge(temp, j)&& temp != j) {
                    if (cost[j] == -1) cost[j] = getWeight(temp,j) + cost[temp];
                    else cost[j] = Math.min(cost[j], cost[temp] + getWeight(temp, j));
                }
            }

            for (int j = 0; j < size; j++) {
                if (isEdge(temp, j) && temp != j) {
                    queue.enqueue(j);
                }
            }
        }

        /*
        打印结果
         */
        for (int j = 0; j<cost.length; j++) {
            System.out.println(" " + j + " " + cost[j]);
        }
    }

    public int findMinNotVisitedPosition(int[] distance, boolean[] visitedlist) {
        int min = distance[0];
        int ans = 0;
        boolean find = false;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] != -1 && distance[i] < min && !visitedlist[i]) {
                find = true;
                min = distance[i];
                visitedlist[i] = true;
                ans = i;
            }
        }
        if (find) return ans;
        else  return -1;
    }

    public void dijkstra(int i) {
        int[] distance = new int[size];
        boolean[] visitedlist = new boolean[size];
        for (int j = 0; j < distance.length; j++) {
            distance[i] = -1;
        }
        for (int j = 0; j < visitedlist.length; j++) {
            visitedlist[j] = false;
        }
        distance[i] = 0;

        while (findMinNotVisitedPosition(distance, visitedlist) != -1) {
            int temp = findMinNotVisitedPosition(distance, visitedlist);
            for (int j = 0; j < size; j++) {
                if (isEdge(temp, j)) {
                    int newdistance = getWeight(temp, j) + distance[temp];
                    distance[j] = Math.min(newdistance, distance[j]);
                }
            }
        }

        /*
        打印结果
         */

        for (int j = 0; j < distance.length; j++) {
            System.out.println(j + " " + distance[j]);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MatrixDirectedGraph graph = new MatrixDirectedGraph(5);
        graph.addEdgeWithWeight(0,1, 4);
        graph.addEdgeWithWeight(0,2, 1);
        graph.addEdgeWithWeight(2,1,2 );
        graph.addEdgeWithWeight(2,3,4);
        graph.addEdgeWithWeight(1,4,4);
        graph.addEdgeWithWeight(3,4,4);

        graph.dijkstra(0);

    }
}
