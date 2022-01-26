package Vmware;

public class Sort {


    //a、冒泡排序，是通过每一次遍历获取最大/最小值
    //
    //　　b、将最大值/最小值放在尾部/头部
    //
    //　　c、然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
    void bubbeSort(int[] arr){
        //冒泡
        for (int i = 0; i < arr.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //a、将第一个值看成最小值
    //
    //　　b、然后和后续的比较找出最小值和下标
    //
    //　　c、交换本次遍历的起始值和最小值
    //
    //　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
    void selectSort(int[] arr){
        //选择
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
    }


    //a、默认从第二个数据开始比较。
    //
    //　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
    //
    //　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
    void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
    }



    //
    void quicksort(int[] A, int start, int end){

        if(start >= end) return;

        int left = start, right = end;

        int pivot = A[(left + right)/2];

        while(left <= right){

            while(left <= right && A[left] < pivot)
                left++;

            while(left <= right && A[right] > pivot)
                right--;

            if(left <= right){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;

                left++;
                right--;
            }
        }

        quicksort(A, start, right);
        quicksort(A, left, end);
    }



    public static void MergeSort(int[] A,int[] temp,int start,int end){
        if (start<end){
            int mid = (start+end)/2;
            //把数组分解为两个子列
            MergeSort(A,temp,start,mid);
            MergeSort(A,temp,mid+1,end);
            //逐级合并两个子列
            Merge(A,temp,start,mid,end);
        }
    }

    public static void Merge(int[] A,int[] temp,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=end){
            if (A[i]<=A[j]) {
                temp[k] = A[i];
                i++;
                k++;
            }else {
                temp[k] = A[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = A[i];
            k++;
            i++;
        }
        while(j <= end){
            temp[k] = A[j];
            k++;
            j++;
        }
        for (int m = 0; m<k; m++) {
            A[start+m] = temp[m];
        }
    }
}
