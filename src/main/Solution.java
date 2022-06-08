package main;

public class Solution {
    public static int getResult(String field, String species){
        Graph graph = new Graph(field, species);
        return graph.dijkstra();
    }
}
