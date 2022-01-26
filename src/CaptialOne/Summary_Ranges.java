package CaptialOne;

import java.util.ArrayList;
import java.util.List;


//228
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
public class Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();

        int i = 0;
        while(i < nums.length){
            String cur = nums[i] + "";
            if(i+1 < nums.length && nums[i]+1 == nums[i+1]){
                while(i+1 < nums.length && nums[i]+1 == nums[i+1]){
                    i++;
                }
                cur = cur + "->" + nums[i];
                ret.add(cur);
            }else{
                ret.add(cur);
            }
            i++;
        }
        return ret;
    }
}
