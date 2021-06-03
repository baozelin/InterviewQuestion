package LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
public class permulation {
    List<List<Integer>> ret = new ArrayList();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, new ArrayList());

        return ret;
    }


    void dfs(int[] nums, boolean[] visited, List<Integer> list){

        if(list.size() == nums.length){

            //if(!ret.contains)
            ret.add(new ArrayList(list));
            return;
        }




        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;

            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
