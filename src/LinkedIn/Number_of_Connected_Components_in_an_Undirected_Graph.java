package LinkedIn;

import java.util.*;

//323
// union find
//
public class Number_of_Connected_Components_in_an_Undirected_Graph {

    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        int res = n;

        //initiate
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for(int[] edge: edges){
            int num1 = edge[0];
            int num2 = edge[1];
            int parent1 = find(parents, num1);
            int parent2 = find(parents, num2);

            if(parent1 != parent2){
                parents[parent1] = parent2;   // note：更新parent 不是children
                res--;
            }
        }


        return res;
    }

    int find(int[] parents, int n){
        int p = parents[n];

        while(p != parents[p]){
            p = parents[p];
        }

        return p;
    }



    // solution2 : dfs
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;

        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }

    public int countComponents_dfs(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
}
