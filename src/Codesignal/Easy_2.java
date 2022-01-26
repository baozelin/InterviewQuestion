package Codesignal;

import java.util.HashMap;

public class Easy_2 {

    public class solution{


        int numberSigningSum(int n){


            //5 -2 + 1 -3 +4
            // 104956
            // 1 - 0 + 4 -9 + 5 - 6


            if(n < 0) return n;

            int i = 0;
            int sum = 0;

            int tmp = 0;
            while(n!= 0){
                tmp = tmp *10 + n % 10;
                n /=10;

            }


            //System.
            //43125


            n = tmp;
            while(n != 0){

                int re = n%10;
                System.out.println(re);

                if(i % 2 == 0){
                    sum += re;
                }else{
                    sum -= re;
                }

                n /= 10;

                i++;
            }

            return sum;

        }



    }



    // 1, 4, 2, 3
    boolean s(int[] elements){

        if(elements.length == 0) return false;


        String target1 = "";
        String target2 = "";
        for(int i = 1; i <= elements.length; i++){
            target1 += i;
            target2 = i + target2;
        }

        String cur = "";
        for(int i = 0; i < elements.length; i++){
            cur += elements[i];
        }


        for(int i = 0 ; i < elements.length; i++){
            if(cur.equals(target1) || cur.equals(target2)){
                return true;
            }
            System.out.println(cur);
            cur = cur.substring(cur.length()-1) + cur.substring(0, cur.length()-1);

        }
        return false;





    }



/**
// event : eventid, starttime , recurringinterval
    commands : subscribe, unsubscribe
 					: timestamp
            eventId


    endTimestamp:

**/
    String[] event(int[][] events, String[][] commands, int endTimestamp){

        // id, [start, interval, end]
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < events.length; i++){
            int[] event = events[i];
            map.put(event[0], new int[]{event[1], event[2], endTimestamp});

        }

        HashMap<Integer, Integer> ret = new HashMap<>();

        for(int i = 0 ; i < commands.length; i++){

            String[] command = commands[i];


            if(command[0].equals("subscribe")){
                int start = Integer.parseInt(command[1]);
                int id = Integer.parseInt(command[2]);

                int[] tmp = map.get(id);
                tmp[0] = Math.max(start, tmp[0]);

                map.put(id, tmp);
            }
            else if(command[0].equals("unsubscribe")){
                int end = Integer.parseInt(command[1]);
                int id = Integer.parseInt(command[2]);
                if(!map.containsKey(id)){
                    continue;
                }

                int[] tmp = map.get(id);

                int count = 0;
                int num = tmp[0];
                while( num <= end){
                    count++;
                    num += tmp[2];
                }

                if(!ret.containsKey(id)){
                    ret.put(id, 0);

                }
                ret.put(id, ret.get(id) + count);
                map.remove(id);
            }

        }

        for(int id: map.keySet()) {

            int[] tmp = map.get(id);   //start, interval, end
            int count = 0;
            int num = tmp[0];
            while( num <= tmp[2]){
                count++;
                num += tmp[2];
            }

            if(!ret.containsKey(id)){
                ret.put(id, 0);

            }
            ret.put(id, ret.get(id) + count);

        }

        String[] res = new String[ret.size()];

        int i = 0;
        for(int id: ret.keySet()) {
            res[i] = id + ": " + ret.get(id);
        }

        return res;
    }



    public  static void main(String[] args){

        Easy_2 s = new Easy_2();
        int[][] events = new int[][]{{1, 0, 5}, {2,7,3}};
        String[][] command = new String[][]{{"subscribe","0", "1"}, {"unsubscribe", "15", "1"}, {"subscribe", "4", "2"}};
        int end = 20;


        System.out.println(s.s(new int[]{1, 5, 3, 2}));
    }
}
