package Facebook;



//282
//Input: num = "123", target = 6
//Output: ["1*2*3","1+2+3"]


import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    //only + -
    //dfs   O(2^n)
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num == null) return ret;

        dfs(ret, "", num, target, 0, 0);
        return ret;
    }

    void dfs(List<String> ret, String path, String num, int target, int pos, int curRes){

        if(pos == num.length()){
            if(target == curRes){
                ret.add(path);
            }
            return;
        }

        for(int i = pos; i < num.length(); i++){
            //ignore '01
            if(i != pos && num.charAt(pos) == '0') return;

            //long curNum = Long.parseLong(num.substring(pos, i+1));
            int curNum = Integer.parseInt(num.substring(pos, i+1));

            //in the beginning, only can add number
            if(pos == 0){
                dfs(ret, path + curNum, num, target, i+1, curNum);
            }

            else{
                // +
                dfs(ret, path+"+"+curNum, num, target, i+1, curRes+curNum);

                // -
                dfs(ret, path+"-"+curNum, num, target, i+1, curRes-curNum);
            }
        }
    }

    public static void main(String[] args){
        Expression_Add_Operators e = new Expression_Add_Operators();
        System.out.print(e.addOperators("123456789", 45).get(0));
    }



    //* + -
    public List<String> addOperators_2(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num == null || num.length() == 0) return ret;

        dfs(ret, "", num, target, 0, 0, 0);
        return ret;
    }

    void dfs(List<String> ret, String path, String num, int target, int pos, long curRes, long preNum){

        if(pos == num.length()){
            if(target == curRes){
                ret.add(path);
            }
            return;
        }


        for(int i = pos; i < num.length(); i++){


            // ignore '01', '020'
            if(i != pos && num.charAt(pos) == '0')
                return;

            long curNum = Long.parseLong(num.substring(pos, i+1));

            //in the beginning, only can add number
            if(pos == 0){
                dfs(ret, path + curNum, num, target, i+1, curNum, curNum);
            }

            //add number or opreator
            else{
                // + opreator
                dfs(ret, path + "+" + curNum, num, target, i+1, curRes + curNum, curNum);

                //- opreator
                dfs(ret, path + "-" + curNum, num, target, i+1, curRes - curNum, -curNum);

                // * before add, so need to minus
                dfs(ret, path + "*" + curNum, num, target, i+1, curRes - preNum + preNum * curNum, preNum * curNum);


            }
        }
    }
}
