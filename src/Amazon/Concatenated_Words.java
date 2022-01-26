package Amazon;


//472
//["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]


import java.util.*;
import java.util.stream.Collectors;

//
public class Concatenated_Words {
    private class TrieNode {
        public TrieNode[] children;
        public boolean isword;
        public String word;
        public TrieNode () {
            this.children = new TrieNode[26];
            this.isword = false;
            this.word = null;
        }
    }

    private class Trie {
        public TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isword = true;
            cur.word = word;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<String>();
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }

        for(String word: words) {
            if(dfs(word, trie.root, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(String word, TrieNode root, int index, int count) {
        if(index == word.length()) {
            return count >= 2;
        }

        TrieNode cur = root;
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
            // 如果当前是一个单词了，那么继续下一层的递归，如果是true，就返回true；
            if(cur.isword) {
                if(dfs(word, root, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    // 变种 amazon
    //Input: [rockstar, rock, stars, rocks, tar, star, rockstars, super, highway, high, way, superhighway]
    //
    //Output: [[rock, star], [rocks, tar], [super, highway], [super, high, way],...]

    //input: { wordbreak, word, break, wor ,dbreak, rainfall, rain, fall, ra, infall } - find words which are combination of other words
    //
    //Output: {{word, break}, {wor, dbreak}, {rain, fall}. {ra, infall}}

    public List<List<String>> findCombine(List<String> list) {
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>(list);

        for (String word : list) {
            set.remove(word);
            List<List<String>> tempList = wordBreak(word, set);

            if (tempList != null && tempList.size() != 0) {
                for (List<String> temp : tempList) {
                    result.add(new ArrayList<>(temp));
                }
            }
            set.add(word);
        }
        return result;
    }

    public List<List<String>> wordBreak(String s, Set<String> wordDict) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new HashSet<>(wordDict), ans, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int start, Set<String> wordSet, List<List<String>> ans, List<String> tmp) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (wordSet.contains(sub)) {
                tmp.add(sub);
                dfs(s, i + 1, wordSet, ans, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        // Example 1
        Concatenated_Words c = new Concatenated_Words();


       // //Input: [rockstar, rock, stars, rocks, tar, star, rockstars, super, highway, high, way, superhighway]
        List<String> test = new ArrayList<>();
        test.add("rockstar");
        test.add("rock");
        test.add("stars");
        test.add("rocks");
        test.add("tar");
        test.add("star");
        test.add("rockstars");
        test.add("super");
        test.add("highway");
        test.add("way");
        test.add("high");
        test.add("superhighway");

        System.out.println(c.findCombine(test));  //[[rock, star], [rocks, tar], [rock, stars]]

    }
}
