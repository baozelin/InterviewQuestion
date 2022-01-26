package LinkedIn;

//526
//Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
//
//perm[i] is divisible by i.
//i is divisible by perm[i].
public class Beautiful_Arrangement {

    //backtrack
    //O(k), number of valid permutation
    //O(n)
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        dfs(n, 1, visited);
        return count;
    }

    void dfs(int n, int pos, boolean[] visited){

        if(pos > n){
            count++;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i] && (pos % i == 0 || i % pos == 0)){
                visited[i] = true;
                dfs(n, pos+1, visited);
                visited[i] = false;
            }
        }
    }
}
