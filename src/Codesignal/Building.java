package Codesignal;


import java.util.HashMap;

//[1, 3, 2, 7] --> [1, 1, 3, 1]
public class Building {

    public int solve(int[] arr){

        //int[] parents = new int[100];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int cur: arr){

            //int parent = find(cur);
            int parent1 = find(cur-1, map);
            int parent2 = find(cur+1, map);

            if(parent2 == parent1) {

            }


        }


        return -1;
    }

    int find(int num, HashMap<Integer, Integer> map){
        while(map.containsKey(num)){

            num = map.get(num);
        }
        return num;
    }


}
