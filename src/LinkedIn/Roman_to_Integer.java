package LinkedIn;

import java.util.HashMap;



//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class Roman_to_Integer {
    //倒过来算
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int last = 0;
        int res = 0;
        for(int i = s.length()-1; i >= 0; i--){
            int cur = map.get(s.charAt(i));
            if(cur >= last){
                res += cur;
                last = cur;
            }
            else{
                res -= cur;
                last = cur;
            }
        }
        return res;
    }
}
