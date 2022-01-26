package Tinder;


import java.util.ArrayList;
import java.util.List;

//17
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class Letter_Combinations_of_a_phonenumber {

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
}
