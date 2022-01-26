package AmazonOA;

import java.util.*;

public class questions {

    //Amazon Fresh Deliveries
    //Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
    //If the there is tie then choose the co-ordinate with least x value.
    //Sample Input :
    //allLocations : [ [1, 2] , [1, -1], [3, 4] ]
    //numOfDeliveries : 2
    //Sample Output :
    //[ [1, -1], [1 , 2] ]
    //Output list can be in any order.
    //This question was basically K closest points to the origin (0,0) with added tie condition.

    //K cloest
    public static int[][] closestKLocations(int[][] allLocations, int k) {
        // set capacity to k+1 to avoid resizing of pq array under-the-hood
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                int x1 = a1[0];
                int y1 = a1[1];
                int x2 = a2[0];
                int y2 = a2[1];
                int distance1 = x1 * x1 + y1 * y1;
                int distance2 = x2 * x2 + y2 * y2;

                // tie breaker
                if (distance1 == distance2) return x2 - x1;

                return distance2 - distance1;
            }
        });

        for (int[] location : allLocations) {
            pq.add(location);

            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        pq.toArray(result);

        return result;
    }


    //Demolition Robot
    //Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
    //The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
    //The demolition robot cannot enter 0 trenches and cannot leave the matrix.
    //Sample Input :
    //[1, 0, 0],
    //[1, 0, 0],
    //[1, 9, 1]]
    //Sample Output :
    //3
    //This question can be solved by using BFS or DFS.


    /**
     * *Amazon logistics has multiple delivery centers from which products are sent.
     * <p>
     * In one such delivery center, parcels are placed in a sequence where the ith parcel has a weight of weight[i]. A shipment is consituted of a contiguous segment of parcels. The shupment imbalance of a shipment is defined as the difference between the max and min weights within a shipment.
     * <p>
     * Given the arrangement of parcels, find the sum of shipment imbalance of all the shipments that can be formed from the given sequence of parcels.
     * <p>
     * Example
     * weights = [1,3,2]
     * Shipments	Max Weight	Min Weight	Imbalance
     * 1 ,3, 2	1	1	1-1=0
     * 1, 3, 2	3	3	3-3=0
     * 1, 3, 2	2	2	2-2=0
     * 1, 3, 2	3	1	3-1=2
     * 1, 3, 2	3	2	3-2=1
     * 1, 3, 2	3	1	3-1=2
     */


    //
    public int findImbalance(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            int max = weights[i];
            int min = weights[i];
            for (int j = i; j < weights.length; j++) {
                max = Math.max(max, weights[j]);
                min = Math.min(min, weights[j]);
                sum += (max - min);
            }
        }
        return sum;
    }


    //OA一道新题。 判断一个string是否Valid。条件1：在一个valid的string头尾加相同字母， 比如 AA 是valid 那么 BAAB就是valid。空是valid。
    //条件2：两个valid的string的concatenation是valid，比如AA和BB是valid，那么AABB就是valid。
    //
    //例子: EABBACDDFFCE
    //BB是Valid所以ABBA是valid，DD和FF是valid所以DDFF是valid，所以CDDFFC是valid 所以ABBACDDFFC是valid，所以EABBACDDFFCE是valid.

    public boolean isValid(String s) {
        Stack<Character> unPaired = new Stack<>();
        for (char c : s.toCharArray()) {
            if (unPaired.peek() == c) {
                unPaired.pop();
            } else {
                unPaired.add(c);
            }
        }
        return unPaired.isEmpty();
    }




//    insert chunks
//[1,3][8,15],[6,9],[2,5],[1,9]  -->  [[1,3], [[1,3],[8,15]], [[1,3],[6,15]], [[1,15]], [[1,15]]

    public int[][] insert(int[][] intervals, int[] newInterval) {

        // *Creat An ArrayList to save all the interval
        ArrayList<int[]> result = new ArrayList<>();
        int start = 0;

        // *Insert All The interval which starting index is smaller than newInterval
        while (start < intervals.length) {

            if (intervals[start][0] < newInterval[0]) {

                result.add(intervals[start++]);

            } else

                break;

        }


        // *Now Insert our new Interval
        if (result.isEmpty() || result.get(result.size() - 1)[1] < newInterval[0]) {
            result.add(newInterval);
        } else {
            // *Mergeing with the last interval of the array
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], newInterval[1]);
        }

        while (start < intervals.length) {
            if (result.get(result.size() - 1)[1] >= intervals[start][0])
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[start++][1]);
            else
                result.add(intervals[start++]);
        }
        return result.toArray(new int[0][]);
    }



    //Count no. of substrings with exactly k distinct letters.

    static int substrCount (String a, int k) {
        //code here.
        int i = 0, j = 0, res = 0, count = 0, n = a.length();
        for (i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap();
            count = 0;

            for (j = i; j < n; j++) {
                char c = a.charAt(j);
                if(!map.containsKey(c)) map.put(c, 0);
                map.put(c, map.get(c)+1);

                if (map.get(c) == 1) count++;

                if (count == k) res++;
                if (count > k) break;
            }
        }
        return res;
    }




    //Find total number of unique characters in all substrings of a given string.
    //Ex:
    //"og": 1 for "g", 1 for "o" and 2 for "og". 4 is total number
    //
    //I tried merging intervals for question 1 and dp for question 2 but i couldnt fix bugs in my code because i was so nervous :(
    //828. Count Unique Characters of All Substrings of a Given String
    public int uniqueLetterString(String s) {

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int[] secLastSeen = new int[26];
        Arrays.fill(secLastSeen, -1);

        int count = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            int p = lastSeen[idx];
            int q = secLastSeen[idx];

            count += i - p - p + q;
            res += count;

            secLastSeen[idx] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        return res;
    }



    //The Amazon Kindle Store is an online e-book store where readers can choose a book from a wide range of categories. It also provides the ability to bookmark pages the user wishes to return to later. A book is represented as a binary string having two types of pages:
    //
    //'0': an ordinary page
    //'1': a bookmarked page
    //
    //Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.
    //
    //Example
    //
    //book = '01001'
    //
    //The following sequences of pages match the criterion:
    //
    //[1, 2 ,3], that is, 01001 → 010.
    //[1, 2 ,4], that is, 01001 → 010.
    //[2, 3 ,5], that is, 01001 → 101.
    //[2, 4 ,5], that is, 01001 → 101.
    //
    //The answer is 4.
    public static long numberOfWays(String book) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < book.length(); i++){


        }



        int n = book.length();
        long zeroTotal = 0, oneTotal = 0;
        for (int i = 0; i < n; i++) {
            if (book.charAt(i) == '0') zeroTotal++;
            else oneTotal++;
        }
        long zeroSoFar = 0, oneSoFar = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (book.charAt(i) == '0') {
                res += oneSoFar * (oneTotal - oneSoFar);
                zeroSoFar++;
            } else {
                res += zeroSoFar * (zeroTotal - zeroSoFar);
                oneSoFar++;
            }
        }
        return res-1;
    }

    public static long numberOfWays2(String book) {
        HashSet<String> set = new HashSet<>();
        for(int i = 1; i < book.length(); i++){
            String tmp = book.substring(0, i);
            if(check(tmp)) set.add(tmp);

        }
        return set.size();

    }


    static boolean check(String str){

        int l = 0, r = str.length()-1;
        int lc = 0, lr = 0;

        while( l < str.length()) {
            char c = str.charAt(l);
            if(lc == 0)
                l++;
        }

        if(lc == lr) return true;
        else return false;

    }






    public static void main(String[] args){
        System.out.print(substrCount("abcd",2));


        System.out.println("Expected: 4; Actual: "+ numberOfWays2("10010011100011"));
        System.out.println("Expected: 3; Actual: "+ numberOfWays2("10001"));
        System.out.println("Expected: 0; Actual: "+ numberOfWays2("0001"));
    }



}