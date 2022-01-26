package Ebay;

import java.util.LinkedList;
import java.util.Queue;


//785. Is Graph Bipartite?
public class Is_Graph_Bipartite {


    //bfs
    // 记录1， 临近点记入-num， 如果有一样，所以false
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] colors = new int[n];

        for(int i = 0; i < n; i++){

            if(colors[i] == 0){

                Queue<Integer> queue = new LinkedList<>();
                colors[i] = 1;
                queue.add(i);

                while(!queue.isEmpty()){

                    int cur = queue.poll();

                    for(int next: graph[cur]){
                        if(colors[next] == 0){
                            colors[next] = -colors[cur];
                            queue.add(next);
                        }
                        else if(colors[next] == colors[cur]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
