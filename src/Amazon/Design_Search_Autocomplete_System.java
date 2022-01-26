package Amazon;

import java.util.*;

//642
//Design a search autocomplete system for a search engine. Users may input a sentence
// (at least one word and end with a special character '#').
public class Design_Search_Autocomplete_System {

    class AutocompleteSystem {
        StringBuilder sb;
        TrieNode root;
        TrieNode point;

        public AutocompleteSystem(String[] sentences, int[] times) {
            sb = new StringBuilder();
            root = new TrieNode();
            point = root;

            for(int i = 0; i < sentences.length; i++){
                String s = sentences[i];
                int t = times[i];
                TrieNode cur = root;

                for(char c : s.toCharArray()){
                    if(cur.nexts[c] == null){
                        cur.nexts[c] = new TrieNode();
                    }

                    cur = cur.nexts[c];
                    cur.map.put(s, cur.map.getOrDefault(s, 0) + t);
                    cur.updateTop3();
                }
            }
        }

        public List<String> input(char c) {
            if(c == '#'){
                TrieNode cur = root;
                String s = sb.toString();
                for(char sChar : s.toCharArray()){
                    cur = cur.nexts[sChar];
                    cur.map.put(s, cur.map.getOrDefault(s, 0) + 1);
                    cur.updateTop3();
                }

                sb = new StringBuilder();
                point = root;
                return new ArrayList<String>();
            }

            sb.append(c);
            if(point.nexts[c] == null){
                point.nexts[c] = new TrieNode();
            }

            point = point.nexts[c];
            return point.top3;
        }
    }

    class TrieNode{
        TrieNode [] nexts;
        HashMap<String, Integer> map;
        List<String> top3;

        public TrieNode(){
            nexts = new TrieNode[256];
            map = new HashMap<>();
            top3 = new ArrayList<>();
        }

        public void updateTop3(){
            top3 = new ArrayList<>();
            PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                maxHeap.add(entry);
            }

            int k = 3;
            while(!maxHeap.isEmpty() && k-- > 0){
                top3.add(maxHeap.poll().getKey());
            }
        }
    }

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
}
