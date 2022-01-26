package Ebay;


//28
//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//Clarification:
//
//What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
// and Java's indexOf().
public class Implement_strStr {
    public int strStr(String haystack, String needle) {

        int lenh = haystack.length();
        int lenn = needle.length();

        int index= -1;
        if(haystack.equals(needle)) return 0;

        if(lenn > lenh) return index;

        for(int i = 0; i <= lenh-lenn; i++){

            String tmp = haystack.substring(i, i+lenn);

            if(tmp.equals(needle)){
                return i;
            }
        }
        return index;
    }
}
