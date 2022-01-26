package LinkedIn;

import java.util.HashMap;


//170
public class Two_Sum_III_Data_structure_design {
    HashMap<Integer, Integer> map = new HashMap<>();

    public Two_Sum_III_Data_structure_design() {

    }

    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number, 0);
        }
        map.put(number, map.get(number) +1);
    }

    public boolean find(int value) {

        for(int num: map.keySet()){

            int rest = value - num;
            if(rest != num){
                if(map.containsKey(rest)){
                    return true;
                }

                // [0,0] -- 0 case
            }else{
                if(map.get(num) > 1){
                    return true;
                }
            }
        }
        return false;
    }
}
