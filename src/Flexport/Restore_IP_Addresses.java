package Flexport;



import java.util.ArrayList;
import java.util.List;

//rule1: 0 -255
// rule2: 011

public class Restore_IP_Addresses {



    // 93 原题，返回list
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if(s.length() == 0) return res;
        dfs(res, s, 0, 0, "");
        return res;
    }


    //  reslist, position, part count, current string, current part
    void dfs(List<String> res, String s, int index, int count, String cur){

        // 多于 4， return
        if(count > 4) return;
        // 4 parts and reach the ending
        if(index == s.length() && count == 4){
            res.add(cur.substring(0, cur.length()-1));
        }

        //add part to current string


        for(int i = index+1; i <= s.length(); i++){

            String part = s.substring(index, i);
            //System.out.println(part);

            if(part.length() > 1 && part.startsWith("0") || Integer.parseInt(part) > 255) break;

            //cur = cur + part + ",";
            dfs(res, s, i, count+1, cur + part + ".");

        }
    }

    boolean can = false;


    /**
     Write a function that given a string of number, return True if it can be a valid IP.
     Eg, “256256256256” -> False
     “256256” -> True (25.6.25.6)
     “0000000000” -> False
     “111” ->True
     “1111” ->True
     "11111” -> True


     **/
    public boolean restoreIpAddresses_true(String s) {

        List<String> res = new ArrayList<>();
        if(s.length() == 0) return false;
        return dfs_true(res, s, 0, 0, "");
        //return can;
    }


    //  reslist, position, part count, current string, current part
    boolean dfs_true(List<String> res, String s, int index, int count, String cur){

        if(count > 4) return false;
        // 4 parts and reach the ending
        if(index == s.length() && count == 4){
            can = true;
            return true;
            //res.add(cur.substring(0, cur.length()-1));
        }

        //add part to current string

        for(int i = index+1; i <= s.length(); i++){
            String part = s.substring(index, i);
            //System.out.println(part);
            if(part.length() > 1 && part.startsWith("0") || Integer.parseInt(part) > 255) break;

            //cur = cur + part + ",";
             if(dfs_true(res, s, i, count+1, cur + part + ".")) return true;

        }
        return false;
    }


    public static void main(String[] args){
        Restore_IP_Addresses r = new Restore_IP_Addresses();
        System.out.println(r.restoreIpAddresses_true("256256256256"));
        System.out.println(r.restoreIpAddresses_true("256256"));
        System.out.println(r.restoreIpAddresses_true("111" ));
        System.out.println(r.restoreIpAddresses_true("1111"));
        System.out.println(r.restoreIpAddresses_true("11111"));
        System.out.println(r.restoreIpAddresses_true("0000000000"));

    }
}
