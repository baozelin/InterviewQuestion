package AmazonOA;


//Took the test two days ago, was asked the following
//
//You are given an array of ratings for n days. Find the number of groups that can be formed consisting of 1 or more consecutive days such that the ratings continously decreases over the days.
//The rating is consecutively decreasing if it has the form r, r - 1, r - 2 ... and so on, where r is the rating on the first day of the group. Two groups are considered different if they contain the ratings of different consecutive days.
//Example
//ratings = [4,3,5,4,3] answer = 9
//there are 9 periods in which the rating is consecutively decreasing
//5 one day periods: [4],[3],[5],[4],[3]
//3 two day periods: [4,3], [5,4], [4, 3]
//1 three day period: [5, 4, 3]
//
//ratings = [2, 1, 3] answer = 4
//groups are [2],[1], [3], [2, 1]
//
//ratings = [4,2,3,1] answer = 4
//groups are [4], [2], [3], [1] are the only groups
public class ratingDecreasing {

    static int Run(int[] nums) {
        int sum = 1;
        int prev = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] + 1) {
                sum += prev + 1;
                prev++;
            } else {
                prev = 1;
                sum++;
            }
        }
        return sum;

    }


    int consecutiveDecreasing(int[] arr) {
        if (arr.length == 0)
            return 0;

        int left, right, total = 0;

        for (int i = 0; i < arr.length; i++) {
            left = i;
            right = i;
            while (i < arr.length - 1 && arr[i] - arr[i + 1] == 1) {
                i++;
                right = i;
            }
            int sequenceSize = right - left + 1;
            total += (sequenceSize * (sequenceSize + 1)) / 2;
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(Run(new int[]{4,3,5,4,3}));
        System.out.println(Run(new int[]{2, 1, 3}));
    }
}
