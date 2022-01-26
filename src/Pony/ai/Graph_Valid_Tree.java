package Pony.ai;


//261
//Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//Output: true
public class Graph_Valid_Tree {


        //idea:    cycle or more than one root
        //union find
        int[] parent;
        public boolean validTree(int n, int[][] edges) {
            if(n < 2) return true;
            parent = new int[n];

            //self root
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }

            for(int[] edge: edges){
                int p1 = find(edge[0]);
                int p2 = find(edge[1]);


                //cycle
                if(p1 == p2) return false;

                if(p1 < p2){
                    parent[p2] = p1;
                }else{
                    parent[p1] = p2;
                }
            }

            int count = 0;
            for(int i = 0; i < n; i++){
                if(parent[i] == i) count++;

            }

            if(count > 1) return false;
            else return true;


        }


        int find(int i){
            while(i != parent[i]){
                i = parent[i];
            }

            return i;
        }

}
