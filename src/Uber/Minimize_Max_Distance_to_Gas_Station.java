package Uber;



//774
//Input: stations = [1,2,3,4,5,6,7,8,9,10], k = 9
//Output: 0.50000
public class
Minimize_Max_Distance_to_Gas_Station {

    //binary
    //Time Complexity: O(NlogW), where N is the length of stations, and W = 10^{14}W=10
    //14
    //  is the range of possible answers (10^8
    // )
    public double minmaxGasDist(int[] stations, int k) {
        double lo = 0, hi = 1e8;   //min , max
        while(hi - lo > 1e-6){
            double mid = (lo + hi)/2;
            if(possible(mid, stations, k)){
                // too large
                hi = mid;
            }else{
                lo = mid;
            }
        }

        return lo;

    }

    boolean possible(double d, int[] stations, int k){

        int used = 0;
        for(int i = 0; i < stations.length-1; i++){

            used += (stations[i+1] - stations[i])/d;

        }

        return used <= k;
    }
}
