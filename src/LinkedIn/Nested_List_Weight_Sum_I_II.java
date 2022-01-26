package LinkedIn;

public class Nested_List_Weight_Sum_I_II {
/**
  I:
    //bfs
 Input: nestedList = [[1,1],2,[1,1]]
 Output: 10
 Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.

    public int depthSum_bfs(List<NestedInteger> nestedList) {

        Queue<NestedInteger> queue = new LinkedList();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){

                NestedInteger tmp = queue.poll();

                if(tmp.isInteger()){
                    total += tmp.getInteger() * depth;
                }else{
                    queue.addAll(tmp.getList());
                }
            }
            depth++;
        }

        return total;

    }

    //dfs
    int total = 0;
    public int depthSum(List<NestedInteger> nestedList) {

        dfs(nestedList, 1);
        return total;

    }

    void dfs(List<NestedInteger> nestedList, int d){

        for(NestedInteger tmp : nestedList){
            if(tmp.isInteger()){
                total += tmp.getInteger() * d;

            }else{
                dfs(tmp.getList(), d+1);
            }
        }
    }

 // II
 Input: nestedList = [[1,1],2,[1,1]]
 Output: 8
 Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8




 // count maxdepth, then dfs
    int maxdepth = 0;
    int total = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {

        getMax(nestedList,1);
        dfs(nestedList, 1);
        return total;
    }
    void getMax(List<NestedInteger> nestedList, int d){

        for(NestedInteger tmp: nestedList){
            if(tmp.isInteger()){
                maxdepth = Math.max(maxdepth, d);
            }
            else{
                getMax(tmp.getList(), d+1);
            }
        }
    }

    void dfs(List<NestedInteger> nestedList, int d){
        for(NestedInteger tmp: nestedList){
            if(tmp.isInteger()){
                total += tmp.getInteger() * (maxdepth - d + 1);
            }
            else{
                dfs(tmp.getList(), d+1);
            }
        }
    }



    //way3: linkedin:
    only one traversal
    数学公式： （max+1) * (x+y+z) - (1x + 2y+3z)

 int max = 0;
 int base = 0;
 int curr = 0;
 public int depthSumInverse(List<NestedInteger> nestedList) {
 dfs(nestedList, 1);
 return (max+1) * (base) - curr;
 }

 void dfs(List<NestedInteger> nestedList, int d){
 for(NestedInteger tmp: nestedList){
 if(tmp.isInteger()){
 max = Math.max(max, d);
 base += tmp.getInteger();
 curr += tmp.getInteger() * d;
 }
 else{
 dfs(tmp.getList(), d+1);
 }
 }
 }
 **/
}
