package Codesignal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1229
//时间是"HH : MM"
public class Meeting_Scheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);


        int pointer1 = 0, pointer2 = 0;
        while(pointer1 < slots1.length && pointer2 < slots2.length){

            int left = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int right = Math.min(slots1[pointer1][1], slots2[pointer2][1]);

            if(right - left >= duration){
                return new ArrayList<Integer>(Arrays.asList(left, left + duration));
            }

            if(slots1[pointer1][1] < slots2[pointer2][1]){
                pointer1++;
            }else{
                pointer2++;
            }
        }

        return new ArrayList();
    }
}
