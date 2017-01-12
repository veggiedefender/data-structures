/**
 * Reads an undirected graph in the form of an adjacency matrix
 * from file graph.txt, prompts user for start and end nodes,
 * then prints the shortest path between the two nodes.
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Dijkstra {
    /**
     * Reads an undirected graph in the form of an adjacency matrix
     * from file graph.txt, prompts user for start and end nodes,
     * then prints the shortest path between the two nodes.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Welcome to Dijkstra Town");
            int[][] graph = readGraph("graph.txt");
            System.out.println("File Reading Complete!");

            boolean quit = false;
            while (!quit) {
                System.out.println("What node to start at? (-1 to quit)");
                int start = scan.nextInt();

                if (start >= 0) {
                    System.out.println("What node to end at?");
                    int end = scan.nextInt();
                    ArrayList<Integer> solution = solve(start, end, graph);
                    System.out.print("Your path is: ");
                    for (int i = 0; i < solution.size() - 1; i++) {
                        System.out.print(solution.get(i) + " -> ");
                    }
                    System.out.println(solution.get(solution.size() - 1));
                } else {
                    quit = true;
                    System.out.println("Goodbye");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Reads graph from a file
     * @param  filename              file to read
     * @return                       2D array representing graph
     * @throws FileNotFoundException Thrown when file is missing
     */
    public static int[][] readGraph(String filename) throws FileNotFoundException {
        Scanner scan;
        scan = new Scanner(new BufferedReader(new FileReader(filename)));
        int size = scan.nextInt();
        int[][] graph = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                graph[row][col] = scan.nextInt();
            }
        }
        return graph;
    }

    /**
     * Solve shortest path using Dijkstra's algorithm
     * @param  start starting node
     * @param  stop  ending node
     * @param  graph 2D array representing graph
     * @return       ArrayList containing steps of shortest path
     */
    public static ArrayList<Integer> solve(int start, int stop, int[][] graph) {
        int graphSize = graph.length;
        int[] dist = new int[graphSize];
        int[] prev = new int[graphSize];
        MinHeap heap = new MinHeap();

        //Set up dist, prev
        for(int v = 0; v < graphSize; v++) {
            int distance;
            if (v == start) {
                distance = 0;
            } else {
                //basically infinite
                distance = Integer.MAX_VALUE;
            }
            dist[v] = distance;
            prev[v] = -1;
            heap.insert(distance, v);
        }

        while (!heap.isEmpty()) {
            int u = heap.peekNode();
            heap.delete();

            //iterate over adjacent nodes
            for (int v = 0; v < graphSize; v++) {
                //check if there's a path
                if (graph[u][v] > 0) {
                    int length = dist[u] + graph[u][v];
                    //update distance if shorter
                    if (length < dist[v]) {
                        dist[v] = length;
                        prev[v] = u;
                        heap.insert(length, v);
                    }
                }
            }
        }

        //build solution from prev
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int curr = stop;
        while (prev[curr] != -1) {
            solution.add(0, curr);
            curr = prev[curr];
        }
        solution.add(0, curr);
        
        return solution;
    }
}