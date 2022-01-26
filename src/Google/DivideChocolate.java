package Google;


//leetcode 1231
//Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
//Output: 6
//Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
public class DivideChocolate {

    // O(nlogS)   s is totalSweetness
    // 二分查找本身并不难，但难点在于如何二分。先看题目，我们要把一个巧克力分成N份（N等于K+1），
    // 然后将其中甜度最小的一份M分给自己。也就是说，这N份巧克力的甜度肯定都是大于等于M的。因此这道题可以转化为，
    // 我们能否找到一个最大的M，使得能够将巧克力分成N份，并且每一份的甜度都大于等于M。M的取值范围在0到总甜度和之间，
    // 利用二分查找能够最高效的找到最大的M值。
    //binary
    public int maximizeSweetness(int[] sweetness, int k) {
        //count total sweetness
        int totalSweetness = 0, lessSweet = Integer.MIN_VALUE;
        for(int s: sweetness){
            lessSweet = Math.min(s, lessSweet);
            totalSweetness += s;
        }

        int res = 0;

        //binary search
        int left = lessSweet, right = totalSweetness;

        while(left <= right){

            int mid = (left+right)/2;
            int sum = 0;
            int count = 0;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < sweetness.length;i++){
                sum += sweetness[i];
                if(sum >= mid){
                    count++;
                    min = Math.min(min, sum);

                    if(count == k+1){
                        res = Math.max(res, min);
                        break;
                    }
                    sum = 0;
                }
            }
            //increasing sweet
            if(count == k+1){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        return res;


    }
}
