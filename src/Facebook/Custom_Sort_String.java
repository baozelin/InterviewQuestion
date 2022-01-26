package Facebook;


//791
//Input: order = "cba", s = "abcd"
//Output: "cbad"
public class Custom_Sort_String {


    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray())
            count[c - 'a']++;

        StringBuilder ans = new StringBuilder();


        for (char c: order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}
