package wepay;


//433
//constance space, return chars and length
public class String_Compression {

    public int compress(char[] chars) {
        if(chars.length == 0) return 0;

        int pos = 0;
        int count = 0;
        int index = 0;

        while(index < chars.length){
            char cur = chars[index];
            while(index < chars.length && chars[index] == cur){
                count++;
                index++;
            }
            chars[pos] = chars[index-1];
            pos++;
            if(count > 1){
                for(char c: (""+count).toCharArray()){
                    chars[pos] = c;
                    pos++;
                }
            }
            count = 0;
        }
        return pos;
    }

}
