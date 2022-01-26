package Vmware;

//132
public class Palindrome_Partitioning_II {

    //O(n* 2^N)
    //
    // min[start, end] vs 1(start+i) + dfs(i+1, end)
    public int minCut(String s) {
        return cut(s, 0, s.length()-1, s.length()-1);
    }

    int cut(String s, int start, int end, int min){

        if(start == end || check(s, start, end))
            return 0;

        for(int i = start; i <= end; i++){

            if(check(s, start, i)){
                min = Math.min(min, 1 + cut(s, i+1, end, min));
            }
        }
        return min;
    }

    boolean check(String s, int start, int end){
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    /**
     *
     *   memo + recursion
     *
     *   O(N^2 * n)
     *
     *
     */
    Integer memoCuts[][];
    Boolean memoPalindrome[][];
    public int minCut_memo(String s) {
        memoCuts = new Integer[s.length()][s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
    }


    // O(n^2)
    int findMinimumCut(String s, int start, int end, int min){
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }

        //check memo
        if(memoCuts[start][end] != null){
            return memoCuts[start][end];
        }

        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                min = Math.min(min, 1 + findMinimumCut(s, i + 1, end, min));
            }
        }
        return memoCuts[start][end] = min;
    }

    //O(N/2).
    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        // check for results in memoPalindrome
        if (memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
                && isPalindrome(s, start + 1, end - 1);
    }
}
