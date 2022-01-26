package Google;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MeetingRoom_Program {


    // part1 easy   leetcode 252
    //Input: intervals = [[0,30],[5,10],[15,20]]
    //Output: false
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < intervals.length -1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }



    //part2 253. Meeting Rooms II
    public int minMeetingRooms(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] < b[0]) return -1;
                else if(a[0] > b[0]) return 1;
                else{
                    return b[1] - a[1];
                }
            }
        });

        for(int[] interval: intervals){
            pq.add(new int[]{interval[0], 0});
            pq.add(new int[]{interval[1], 1});
        }

        int count = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] == 0) {
                count++;
                max = Math.max(count, max);
            }
            else count--;
        }
        return max;
    }



    // google :
    // 第一轮：面经里最近的热门topic，类似于meeting room，这次换了个马甲成了program执行时间的安排。
    // input是一个N行2列的int[][]，每行第一个元素是程序开始时间，第二个元素是程序持续时间（这是一个改动，meeting room给的是起始时间）。
    // 然后给一个新的程序[起始时间，持续时间]，问能不能加到现有的schedule里面，不能跟现有的interval 重合。可以就加，返回true，不行就不加，返回false。
    // 我先给了个解法按开始时间sort，然后一个一个interval试着往里塞，因为要sort所以TC是O(NlogN)。写了code。
    // Follow up也是个热门followup，问假如已经sort好了有没有更快的解法。用binary search在所有interval的起始时间里找the largest smaller one。


    // time[startime, duration]
    public boolean solve(int[][] arr, int[] time){

        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });

        int i = 0;
        //find largest smaller one
        while(i < arr.length && arr[i][0] < time[0]){
            i++;
        }

        if(i != arr.length) {
            if (time[0] + time[1] > arr[i][0]) return false;
            //}
            if (arr[i - 1][0] + arr[i - 1][1] > time[0]) return false;
        }
        else{
            if(time[0]  < arr[i-1][0]+arr[i-1][1]) return false;
        }

        return true;

    }



    // followup:
    //Follow up也是个热门followup，问假如已经sort好了有没有更快的解法。
    // 用binary search在所有interval的起始时间里找the largest smaller one。

    public int binarySearch(int[] arr, int target){

        int left = 0, right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return right;
    }



    public static void main(String[] args){
        MeetingRoom_Program m = new MeetingRoom_Program();
        int[][] test = {{5,2},{11,4},{30,4}};
        int[][] test1 = {{5,2},{11,4},{14,4}};
        int[] time = {16,2};
        System.out.println(m.solve(test, time));
        System.out.println(m.solve(test1, time));

        int[] test2 = {1,3,5,6,12};
        System.out.println(m.binarySearch(test2, 7));
    }
}
