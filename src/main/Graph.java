package main;

import java.util.Arrays;


public class    Graph {
    private final int n = 16; // the length of the string
    private final int[][] matrix = new int[n][n]; // incidence matrix
    private final String field;
    private final String species;

    Graph(String field, String species) {
        this.field = field;
        this.species = species;
    }

    void fillStartMatrix() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
    }

    void createGraph() {
        for (int i = 0; i < field.length(); i++) {
            if (i % 4 != 0) {
                int cost = Data.getData(species, field.charAt(i - 1));
                matrix[i][i - 1]  =cost;
            }
            if (i % 4 != 3 && i + 1 < n) {
                int cost = Data.getData(species, field.charAt(i + 1));
                matrix[i][i + 1] = cost;
            }
            if (i - 4 >= 0) {
                int cost = Data.getData(species, field.charAt(i - 4));
                matrix[i][i - 4]  = cost;
            }
            if (i + 4 < n) {
                int cost = Data.getData(species, field.charAt(i + 4));
                matrix[i][i + 4] = cost;
            }
        }
    }


    int dijkstra() {
        int[] d = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        fillStartMatrix();
        createGraph();
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (v == -1 || d[j] < d[v])) {
                    v = j;
                }
            }
            if (d[v] == Integer.MAX_VALUE) {
                break;
            }
            used[v] = true;
            for (int j = 0; j < n; j++) {
                if (matrix[v][j] != -1 && matrix[v][j] != 0 && (d[v] + matrix[v][j] < d[j])) {
                    d[j] = d[v] + matrix[v][j];
                }
            }
        }
        return d[n - 1];
    }
}
