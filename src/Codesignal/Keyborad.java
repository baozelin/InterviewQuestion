package Codesignal;


import java.util.HashSet;

//一个电话键盘只有某几个数字键可以用， 给定一个全字母的字符串，问能否用这个键盘打出来。
//样例数据：[1,3,5,7], ["abc", "def", "djp", "dmr"]
//样例输出：[false, true, true, false]
public class Keyborad {

    String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public boolean[] solve(int[] nums, String[] arr) {

        boolean[] res = new boolean[arr.length];
        HashSet<Character> map = new HashSet<>();

        for(int i: nums){
            for(int j =0; j < key[i].length(); j++){
                map.add(key[i].charAt(j));
            }
        }


        for(int i = 0; i < arr.length; i++){

            String cur = arr[i];
            for(int j = 0; j < cur.length(); j++){
                if(!map.contains(cur.charAt(j))){
                    res[i] = false;
                    break;
                }
            }

            res[i] = true;
        }

        return res;
    }
}
