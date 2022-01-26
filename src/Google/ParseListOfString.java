package Google;


import java.util.HashMap;

// 国人大哥，parse list of string，要求是
//parse之后要保持原有的顺序
//duplicate的string在后边加一个后缀，保证parse之后不包含duplicate，例如[x, x] -> [x, x_1]
//unique的string要保持不变
//如果string中包含invalid字符（valid字符包括digit，letter，_）,吧invalid字符替换下划线
//空白的字符串也要parse，例如["", ""] -> ["", "_1"]
//这题居多edge case，做之前一定问清楚，比如 ["@x", "_x"] -> ["_x_1", "_x"]，有一些case美国，感谢大哥抬我一手
public class ParseListOfString {


    public void parse(String[] arr){
        HashMap<String, Integer> map  = new HashMap<>();
        // first travel list and only count valid string
        for(int i = 0 ; i < arr.length; i++){
            String tmp = arr[i];
            if(check(tmp)){
                if(!map.containsKey(tmp)){
                    map.put(tmp, 1);

                }else{
                    arr[i] = tmp + "_" + map.get(tmp);
                    map.put(tmp, map.get(tmp)+1);
                }

            }
        }

        //second travel and handle invalid string
        for(int i = 0; i < arr.length; i++) {
            String tmp = arr[i];

            if (!check(tmp)) {

                //fix invalid string
                for(int j = 0; j < tmp.length();j++){
                    char c = tmp.charAt(j);

                    if(Character.isDigit(c)|| (c>='a'&&c<='z'))
                        continue;
                    else{
                        //tmp = tmp.replace(c, '_');
                        tmp = tmp.substring(0, j) + "_" + tmp.substring(j + 1);
                    }
                }

                if(map.containsKey(tmp)){
                    arr[i] = tmp +"_" + map.get(tmp);
                    map.put(tmp, map.get(tmp)+1);
                }
                else{
                    if(!map.containsKey(tmp)){
                        map.put(tmp, 0);
                    }
                    map.put(tmp, map.get(tmp)+1);
                }

            }
        }

        for(String i : arr){
            System.out.println(i);
        }

    }


    boolean check(String s){
        for(int j = 0; j < s.length();j++){
            char c = s.charAt(j);

            if(Character.isDigit(c)|| (c>='a'&&c<='z') || c == '_')
                continue;
            else{
                //tmp = tmp.replace(c, '_');
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ParseListOfString p = new ParseListOfString();
        String[] test1 = new String[]{"x", "x","x"};  //["", "_1"]
        String[] test2 = new String[]{"", "",""};
        String[] test3 = new String[]{"@x", "_x"};  //["_x_1", "_x"]

        p.parse(test1);
        p.parse(test2);
        p.parse(test3);
    }
}




// "X"  ---> "123"
// "Y"  --> "456"
//%X%_%Y%  --> 123_456
