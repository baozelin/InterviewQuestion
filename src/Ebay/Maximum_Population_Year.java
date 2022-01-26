package Ebay;


//1854
public class Maximum_Population_Year {

    // int[]
    public int maximumPopulation(int[][] logs) {

        int[] diff = new int[105];

        for(int[] log: logs){

            diff[log[0] - 1950] ++;
            diff[log[1] - 1950] --;

        }

        int count = 0, max = 0, res = 1950;
        for(int i = 0; i <= 100; i++){
            count += diff[i];

            if(count > max){
                max = count;
                res = i+1950;
            }
        }

        return res;
    }
}
