package Microsoft;


//1304
//Input: n = 5
//Output: [-7,-1,1,3,4]
public class Find_N_Unique_Integers_Sum_up_to_Zero {


    public int[] sumZero(int n) {
        int res[]=new int[n];
        int i=0;
        if(n==1){
            res[i]=0;
            return res;
        }
        int sum=0;
        for(int j=1;j<n;j++){
            sum+=j;
            res[i++]=j;
        }
        res[i]=-sum;
        return res;
    }
}
