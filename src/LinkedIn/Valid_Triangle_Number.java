package LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Valid_Triangle_Number {



    //O(n2)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int ans = 0;
        for (int i = 0; i < size - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for(int j = i+1; j < size -1; j++){

                while(k < size && nums[k] < nums[i]+ nums[j]) k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }


    // O(n^3)
    public int triangleNumber_n3(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
                        count++;
                }
            }
        }
        return count;
    }


    //O(n^3)
    int ret = 0;
    public int triangleNumber_dfs(int[] nums) {


        Arrays.sort(nums);
        dfs(0, new ArrayList(), nums);

        return ret;

    }


    void dfs(int k, List<Integer> list, int[] nums){

        if(list.size() == 3){
            if(check(list)){
                System.out.println(list.get(0) + ","+list.get(1)+","+list.get(2));
                ret++;
            }
        }

        for(int i = k; i < nums.length;i++){
            if(nums[i] == 0) continue;

            list.add(nums[i]);
            dfs(i+1, list, nums);
            list.remove(list.size()-1);
        }


    }

    boolean check(List<Integer> list){

        if(list.get(0)+list.get(1) > list.get(2)) return true;
        return false;
    }
}
