package Google;

public class QuickUnionfind {

    int[] parent;

    public QuickUnionfind(int n){
        parent = new int[n];

        //individual tree
        for(int i=0; i < n; i++){
            parent[i] = i;
        }
    }


    int find(int p){
        if(p < 0 || p > parent.length) return -1;

        //find root
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    boolean isConnect(int p, int q){
        return find(p) == find(q);
    }

    void union(int p, int q){
        int proot = find(p);
        int qroot = find(q);

        //already connnect
        if(proot == qroot){
            return;
        }
        else{
            parent[proot] = qroot;
        }
    }
}
