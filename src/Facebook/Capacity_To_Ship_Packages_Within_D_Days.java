package Facebook;
//类似 divide Chocolate
// 二分法， left 0 or 单个最大， right total sum

//1011
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
public class Capacity_To_Ship_Packages_Within_D_Days {

    // binary search: left: max weight,  right-sum of weight
    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;
        for(int w: weights){
            left = Math.max(left, w);
            right += w;
        }

        while(left <= right){
            int mid = (left + right)/2;
            int need =1;
            int cur = 0;

            for(int w : weights){
                if(cur + w > mid){
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }

            if(need > days){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return left;
    }
}
