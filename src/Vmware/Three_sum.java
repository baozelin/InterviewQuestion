package Vmware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_sum {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 2; i < nums.length; i++) {

                // duplicate number
                if (i < nums.length - 1 && nums[i] == nums[i + 1])
                    continue;

                int target = -nums[i];
                int left = 0, right = i - 1;
                while (left < right) {

                    //find
                    if (nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        res.add(new ArrayList(list));

                        //dupilcated
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                    } else if (nums[left] + nums[right] > target)
                        right--;

                    else
                        left++;
                }

            }
            return res;
        }
}
