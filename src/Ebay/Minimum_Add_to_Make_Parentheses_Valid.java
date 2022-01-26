package Ebay;

public class Minimum_Add_to_Make_Parentheses_Valid {

    /**
     * keep a balance ( +, ) -
     */
    public int minAddToMakeValid(String s) {
        int ans = 0, balance = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                balance += 1;

                // )
            }else{
                balance -= 1;
            }
            if(balance == -1){
                ans++;
                balance ++; // clear this )
            }
        }
        return ans + balance;
    }
}
