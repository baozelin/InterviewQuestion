package Tiktok;


import java.util.*;

//1048
//Input: words = ["a","b","ba","bca","bda","bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
public class Longest_String_Chain {

    public int longestStrChain(String[] words) {

        int res = 0;
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });

        HashMap<String, Integer> map = new HashMap();

        for(String word: words){

            int max = 1;
            for(int i = 0; i < word.length(); i++){

                String prev = word.substring(0, i) + word.substring(i+1);


                if(!map.containsKey(prev)){
                    map.put(prev, 0);
                }

                int currLength = map.get(prev) +1;
                max = Math.max(max, currLength);
            }

            map.put(word, max);
            res = Math.max(max, res);

        }
        return res;
    }
}
