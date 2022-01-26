package AmazonOA;



//packet = [1,2,3,4,5]
//channels = 2

import java.util.Arrays;

//[5],[1,2,3,4]
public class max_middle {


    static int max(int[] packets, int channels){

        int res = 0;
        Arrays.sort(packets);

        for(int i = packets.length-1; i >= 0; i--){
            if(channels > 1){
                res += packets[i];
                channels--;
            }
            else{
                int tmp = 0;
                if(i%2 == 1){
                    tmp += packets[i/2]+packets[i/2+1];
                    //System.out.print(tmp+1);
                    res += Math.ceil((tmp+1)/2);
                }else{
                    res += tmp;
                }
                break;
            }
        }

        return res;
    }

    public static void main(String[] args){

        System.out.println(max(new int[]{1,2,3,4,5}, 2));
    }
}
