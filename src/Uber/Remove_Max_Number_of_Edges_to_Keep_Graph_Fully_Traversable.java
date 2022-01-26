package Uber;

//1579
//Alice and Bob have an undirected graph of n nodes and 3 types of edges:
//
//Type 1: Can be traversed by Alice only.
//Type 2: Can be traversed by Bob only.
//Type 3: Can by traversed by both Alice and Bob.
public class Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    //1. 并查集
    //1）思路
    //可将边的删除过程转变为图的生成过程，用并查集记录节点间的连通性，若待生成的边所连接的节点先前已被连通，说明该边可删除。
    //第 3 种边至少可替代 1 条第 1、2 种边，因此可先对通用的第 3 种边进行生成，再处理仅可供一人使用的第 1、2 种边。
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //parents array of alice and bob
        int[] alice = new int[n+1];
        int[] bob = new int[n+1];

        for(int i = 0; i <= n; i++){
            alice[i] = i;
            bob[i] = i;
        }

        int res = 0;

        // visit type3
        for(int i = 0; i < edges.length; i++){
            int type = edges[i][0];
            int n1 = edges[i][1];
            int n2 = edges[i][2];

            if(type  == 3){
                boolean b1 = union(alice, n1, n2);
                boolean b2 = union(bob, n1, n2);
                //已经联通了
                if(!b1 && !b2)
                    res++;
            }

        }

        ////处理只可由Alice或Bob遍历的边 type1,or 2
        for(int i = 0; i < edges.length; i++){
            int type = edges[i][0];
            int n1 = edges[i][1];
            int n2 = edges[i][2];
            // alice
            if(type == 1){
                if(!union(alice, n1, n2))
                    res++;
            }

            //bob
            if(type == 2){
                if(!union(bob, n1, n2))
                    res++;
            }
        }

        //check full traversal
        int p1 = find(alice, 1);
        System.out.println(p1);
        int p2 = find(bob, 1);
        System.out.println(p2);

        for(int i = 2; i <= n; i++){
            if(find(alice, i) != p1 || find(bob, i) != p2){
                System.out.println(find(alice, i));

                System.out.println(find(bob, i));
                return -1;
            }
        }
        return res;
    }


    //time limited exceeded
    int find2(int[] parent, int n){
        int p = parent[n];
        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }


    public int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }




    boolean union(int[] parent, int n1, int n2){
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);

        if(p1 == p2){
            return false;
        }

        parent[p2] = p1;
        return true;
    }
}
