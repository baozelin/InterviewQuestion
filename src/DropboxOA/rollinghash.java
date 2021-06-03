package DropboxOA;

public class rollinghash {

    /**
     * 判断一个 byte[] array是否存在在一个file里面
     */

    byte[] arr = new byte[2];



     int rollinghash(byte[] ar){

        int hash = 0;
        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
             int c = ar[i];
             sum *= 10;
             sum += c;

        }

        hash  = sum;

        return hash;
    }


    public static void main(String[] args) {
        rollinghash r = new rollinghash();

        byte[] arr = new byte[4];
        arr[0] = 5;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 10;
        System.out.println(r.rollinghash(arr));
        byte a = 127;
        //a+=1;
        System.out.println(a);

    }


}
