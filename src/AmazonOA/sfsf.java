package AmazonOA;
// Java program for the above approach
import java.util.*;

class GFG{

    // Function to get the maximum of all
// the subarrays of size Y
    static Vector<Integer> get_submaxarr(int[] arr, int n,
                                         int y)
    {
        int j = 0;
        Stack<Integer> stk = new Stack<Integer>();

        // ith index of maxarr array
        // will be the index upto which
        // Arr[i] is maximum
        int[] maxarr = new int[n];
        Arrays.fill(maxarr,0);
        stk.push(0);

        for(int i = 1; i < n; i++)
        {

            // Stack is used to find the
            // next larger element and
            // keeps track of index of
            // current iteration
            while (stk.size() != 0 &&
                    arr[i] > arr[stk.peek()])
            {
                maxarr[stk.peek()] = i - 1;
                stk.pop();
            }
            stk.push(i);
        }

        // Loop for remaining indexes
        while (stk.size() != 0)
        {
            maxarr[stk.size()] = n - 1;
            stk.pop();
        }
        Vector<Integer> submax = new Vector<Integer>();

        for(int i = 0; i <= n - y; i++)
        {

            // j < i used to keep track
            // whether jth element is
            // inside or outside the window
            while (maxarr[j] < i + y - 1 || j < i)
            {
                j++;
            }
            submax.add(arr[j]);
        }

        // Return submax
        return submax;
    }

    // Function to get the minimum for
// all subarrays of size Y
    static Vector<Integer> get_subminarr(int[] arr, int n,
                                         int y)
    {
        int j = 0;

        Stack<Integer> stk = new Stack<Integer>();

        // ith index of minarr array
        // will be the index upto which
        // Arr[i] is minimum
        int[] minarr = new int[n];
        Arrays.fill(minarr,0);
        stk.push(0);

        for(int i = 1; i < n; i++)
        {

            // Stack is used to find the
            // next smaller element and
            // keeping track of index of
            // current iteration
            while (stk.size() != 0 &&
                    arr[i] < arr[stk.peek()])
            {
                minarr[stk.peek()] = i;
                stk.pop();
            }
            stk.push(i);
        }

        // Loop for remaining indexes
        while (stk.size() != 0)
        {
            minarr[stk.peek()] = n;
            stk.pop();
        }

        Vector<Integer> submin = new Vector<Integer>();

        for(int i = 0; i <= n - y; i++)
        {

            // j < i used to keep track
            // whether jth element is inside
            // or outside the window

            while (minarr[j] <= i + y - 1 || j < i)
            {
                j++;
            }
            submin.add(arr[j]);
        }

        // Return submin
        return submin;
    }

    // Function to get minimum difference
    static void getMinDifference(int[] Arr, int N, int Y)
    {

        // Create submin and submax arrays
        Vector<Integer> submin = get_subminarr(Arr, N, Y);

        Vector<Integer> submax = get_submaxarr(Arr, N, Y);

        // Store initial difference
        int sum = 0;
        int b = submax.size();

        for(int i = 1; i < b; i++)
        {

            // Calculate temporary difference
            int dif = submax.get(i) - submin.get(i) + 1;
            sum = dif;
        }

        // Final minimum difference
        System.out.print(sum);
    }

    // Driver code
    public static void main(String[] args)
    {

        // Given array arr[]
        int[] arr = { 2,4,3,5};
        int N = arr.length;

        // Given subarray size
        int Y = 4;

        // Function Call
        getMinDifference(arr, N, 4);
    }
}

// This code is contributed by decode2207
