package Expedia;

//array of commit，
// 从某一个commit开始后面的commit全部test fail，求第一个commit的index。Binary search
public class Array_of_commit {


    //binary search
    public static int find(int[] arr){

        int left = 0, right = arr.length-1;

        while(left < right){
            int mid = (left + right)/2;
            if(arr[mid] == 1){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }



    public static void main(String[] args){
        int[] test = new int[]{1,1,1,1,1,0,0,0,0};
        System.out.println(find(test));
    }

}
