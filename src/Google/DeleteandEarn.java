package Google;


// 740
public class DeleteandEarn {

    //Input: nums = [3,4,2]
    //Output: 6
    //Explanation: You can perform the following operations:
    //- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
    //- Delete 2 to earn 2 points. nums = [].
    //You earn a total of 6 points.
    public int deleteAndEarn(int[] nums) {

        // transaction function
        // cur[i] = 1. Max(took[i-1] + i*count[i], notook[i-1]) if not negbour
        //          2. Max(took[i-1], notook[i-1] + i*count[i]) if negbour

            int[] count = new int[10001];
            for(int i: nums){
                count[i]++;
            }
            int taked = 0, notake = 0, prevIdx = -1;
            for(int i = 0; i < 10001; i++){
                //exist number
                if(count[i] > 0){

                    int prevmax = Math.max(taked, notake);
                    //continuous number
                    if(prevIdx != i-1){
                        taked = count[i] * i + prevmax;
                        notake = prevmax;
                    }
                    // not continuous
                    else{
                        taked = count[i] * i + notake;
                        notake = prevmax;
                    }
                    prevIdx = i;
                }
            }
            return Math.max(taked, notake);
        }
}
