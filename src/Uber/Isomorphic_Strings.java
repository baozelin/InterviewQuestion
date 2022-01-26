package Uber;


import java.util.Arrays;

//205. Isomorphic Strings
//Input: s = "egg", t = "add"
//Output: true
public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {

        int[] tmap = new int[256];
        int[] smap = new int[256];

        Arrays.fill(tmap, -1);
        Arrays.fill(smap, -1);

        for(int i = 0; i < s.length(); i++){

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //no map
            if(smap[c1] == -1 && tmap[c2] == -1){
                smap[c1] = c2;
                tmap[c2] = c1;
            }

            else if(! (smap[c1] == c2 && tmap[c2] == c1)) return false;
        }

        return true;
    }
}
