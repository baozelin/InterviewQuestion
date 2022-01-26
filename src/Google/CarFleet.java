package Google;


import java.util.TreeMap;

//Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//Output: 3
//Explanation:
//The cars starting at 10 and 8 become a fleet, meeting each other at 12.
//The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        TreeMap<Integer, Double> map = new TreeMap();
        for(int i = 0; i < position.length; i++){
            map.put(target-position[i], (double)(target - position[i])/speed[i]);
        }

        int res = 0;
        double cur = 0.0;

        for(Double time: map.values()){
            System.out.println(time);
            if(time > cur){
                res++;
                cur = time;
            }
        }
        return res;
    }



    // 2.
    //infinite destination,
    // output the car index which can catch up other car by meeting timestamp sequence
    //speed [2,1,4, 5,3,2],
    //position [0,3,4,5,8,10],
    //output [ 3, 4, 0, 2]
}
