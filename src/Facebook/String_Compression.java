package Facebook;


//443
// Input: chars = ["a","a","b","b","c","c","c"]
// Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
// Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
public class String_Compression {

    public int compress(char[] chars) {
        int pos = 0,  count = 0, index = 0;

        while(index < chars.length){

            char cur = chars[index];

            while(index < chars.length && chars[index] == cur){
                count++;
                index++;
            }

            chars[pos] = chars[index-1];
            pos++;

            if(count > 1){
                for(char c : ("" + count).toCharArray()){
                    chars[pos] = c;
                    pos++;
                }
            }
            count = 0;
        }

        return pos;
    }
}
