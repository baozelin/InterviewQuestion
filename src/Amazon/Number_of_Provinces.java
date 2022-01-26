package Amazon;


//547
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
public class
Number_of_Provinces {


    public int findCircleNum(int[][] isConnected) {
        boolean[] visit = new boolean[isConnected.length];

        int count = 0;

        for(int i = 0; i < isConnected.length; i++){
            if(!visit[i]){
                visit[i] = true;
                count++;
                dfs(isConnected, visit, i);
            }
        }

        return count;
    }


    void dfs(int[][] isConnected, boolean[] visit, int i){

        for(int j = 0; j < isConnected[i].length; j++){
            if(!visit[j] && isConnected[i][j] == 1){
                visit[i] = true;
                dfs(isConnected, visit, j);
            }
        }
    }
}
