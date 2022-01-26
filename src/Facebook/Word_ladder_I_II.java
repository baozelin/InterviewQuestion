package Facebook;

import java.util.*;

public class Word_ladder_I_II {

    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //Output: 5
    //Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

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
    /**
     *  *  126. Word Ladder II
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
     *
     *
     *  Time complexity: O(NK^2)).
     *
     * Here N is the number of words in wordList, K is the maximum length of a word
     *
     * Space complexity: {O}(NK).
     */

    List<List<String>> res;
    //List<String> list;
    Map<String, List<String>> map;  //cur ---> list<prev>

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //initate
        res = new ArrayList<>();
        //list = new ArrayList<>();
        map = new HashMap<>();

        //empty
        if (wordList.isEmpty()) return res;

        //int count = 0, next = 0;
        boolean found = false;
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        unvisited.remove(beginWord);

        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();

            //level
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();

                for (int i = 0; i < cur.length(); i++) {

                    //next word
                    StringBuilder sb = new StringBuilder(cur);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        sb.setCharAt(i, ch);
                        String newWord = sb.toString();

                        //new newword
                        if (unvisited.contains(newWord)) {
                            if (visited.add(newWord)) {
                                queue.add(newWord);
                            }

                            //add to map
                            if (!map.containsKey(cur)) {
                                map.put(cur, new ArrayList<>());
                            }
                            map.get(cur).add(newWord);
                            //if (newWord.equals(endWord) && !found) found = true;   时间上的优化
                        }
                    }
                }
            }
            //after finish this level, reset hashset
            //if (found) break;     时间上的优化
            unvisited.removeAll(visited);
            visited.clear();
        }
        backTrack(beginWord, endWord, new ArrayList<>());
        return res;
    }



    public void backTrack(String word, String endWord, List<String> list) {
        if (word.equals(endWord)) {
            list.add(endWord);
            res.add(new ArrayList<>(list));
            //list.remove(0);
            return;
        }
        list.add(word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTrack(s, endWord, list);
                list.remove(list.size()-1);
            }
        }
    }





}
