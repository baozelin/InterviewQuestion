package Tiktok;

import java.util.*;


//785
public class Is_Graph_Bipartite {public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int [] colors = new int[n];
    for(int i = 0; i<n; i++){
        if(colors[i] == 0){
            LinkedList<Integer> que = new LinkedList<>();
            colors[i] = 1;
            que.add(i);
            while(!que.isEmpty()){
                int cur = que.poll();
                for(int nei : graph[cur]){
                    if(colors[nei] == 0){
                        colors[nei] = -colors[cur];
                        que.add(nei);
                    }else if(colors[nei] == colors[cur]){
                        return false;
                    }
                }
            }
        }
    }

    return true;
}
}