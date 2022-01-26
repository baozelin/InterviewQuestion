package Flexport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//17 原题
public class Combination_Letter {
    String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        dfs(digits.toCharArray(),"", 0);
        return res;
    }


    void dfs(char[] letter, String cur, int index){
        if(index == letter.length){
            res.add(cur);
            return;
        }

        String str = key[letter[index] - '0'];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            cur += c;
            dfs(letter, cur, index+1);
            cur = cur.substring(0, cur.length()-1);
        }
    }


    //变种/
    //给一个数字string到字母list的map，给一个string，找出所有可能的字母combination。
    //例如'1' -> ['a', 'b'] 跟刷题网的手机按键有多少字母组合题一样。
    //Follow‍‌‍‌‌‍up，如果多个数字可以map到一个字母list时，怎么做。

    //Follow up: multiple digit to character eg "1 -> abc, 2 -> def, 23 -> qwert"

    /**
     *  "1"  ['a','b']
     *  '2' [c, ]
     *  '23' [q,w,e,t]
     *
     */

    public List<String> letter(String digits, HashMap<String, List<String>> map) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs_2(res, map,"", 0, digits);

        return res;
    }

    void dfs_2(List<String> res, HashMap<String, List<String>> map, String cur, int start, String digits){

        if(start == digits.length()){
            res.add(cur);
        }

        for(int i = start+1; i < digits.length(); i++){

            String tmp = digits.substring(start, i);
            if(!map.containsKey(tmp)) continue;

            List<String> ws = map.get(tmp);

            for(int j = 0; j < ws.size(); j++){
                String c = ws.get(i);
                cur += c;

                dfs_2(res, map, cur, i+1, digits);
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
}
