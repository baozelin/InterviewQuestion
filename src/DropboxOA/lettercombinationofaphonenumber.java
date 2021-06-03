package DropboxOA;

import java.util.ArrayList;
import java.util.List;

public class lettercombinationofaphonenumber {
    String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ret = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return ret;
        char[] chars = digits.toCharArray();

        dfs(chars, "", 0);
        return ret;
    }

    public void dfs(char[] chars, String list, int index) {

        if (list.length() == chars.length) {
            ret.add(list);
            return;
        }

        String str = key[chars[index] - '0'];

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            list = list + c;
            dfs(chars, list, index + 1);
            list = list.substring(0, list.length() - 1);
        }

    }
}
