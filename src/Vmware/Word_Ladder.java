package Vmware;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//127
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
public class Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int level = 1;

        queue.offer(beginWord);
        set.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();

                for(String word: wordList){
                    if(change(word, cur)){
                        //end
                        if(word.equals(endWord)){
                            return level+1;
                        }
                        if(!set.contains(word)){
                            queue.add(word);
                            set.add(word);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

    boolean change(String target, String word){
        int count = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != word.charAt(i)){
                count++;
            }
        }
        return count == 1? true:false;
    }
}
