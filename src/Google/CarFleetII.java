package Google;


import java.util.Stack;

//1776. Car Fleet II
//Input: cars = [[1,2],[2,1],[4,3],[7,2]]
//Output: [1.00000,-1.00000,3.00000,-1.00000]
//Explanation: After exactly one second, the first car will collide with the second car, and form a car fleet with speed
// 1 m/s. After exactly 3 seconds, the third car will collide with the fourth car, and form a car fleet with speed 2 m/s.
public class CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {

        double[] time = new double[cars.length];
        int idx = 0;

        Stack<Integer> stack = new Stack();

        for(int i = cars.length-1; i >= 0; i--){

            time[i] = -1;

            while(!stack.isEmpty()){
                idx = stack.peek();  // next car
                double t = countTime(cars[i], cars[idx]);

                if(t > 0 && (time[idx]==-1 || t <= time[idx])){
                    time[i] = t;
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return time;
    }


    double countTime(int[] prev, int[] next){

        if(prev[1] > next[1]){
            return (double)(next[0]-prev[0])/(prev[1] - next[1]);
        }

        return -1.0;
    }
}
