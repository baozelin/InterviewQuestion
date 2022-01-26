package Vmware;

//1010
public class PairsofSongsWithTotalDurationsDivisibleby60 {

    //类似 two sum
    public int numPairsDivisibleBy60(int[] time) {

        int[] arr = new int[61];

        int res = 0;
        for(int t: time){

            int rest = t%60;

            //单独考虑 x%60 == 0时
            if(rest == 0){
                res += arr[0];
            }else{


                res += arr[60 - rest];



            }
            arr[rest]++;
        }


        return res;
    }
}
