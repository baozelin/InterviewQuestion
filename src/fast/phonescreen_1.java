package fast;
import java.io.*;
import java.util.*;
import java.lang.*;

public class phonescreen_1 {

    /*
     * Click `Run` to execute the snippet below!
     */



    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

// Rate limiter component parameterized by a time window T and a burst count N
//
// Return an indication of success or failure based on whether there were N successes in the past
// window of length T

    //   millsecond
//
//      int totalcount
//      queue<par<timestamp, count>>

//

// time 0.
// time 1
//   time window T : 100 second    N 20
// burst count N
//
//
// rateLimiter.invoke()
// rateLimiter.invoke()
// rateLimiter.invoke()

// time = currentTime();

// check()


// while(true):
//     curtime = currentTime();

//           top：first in queue
//     check: queue<par<timestamp, count>>, currentTime()
//      curtime with top  :
    //    updata count;
    //   > 100;   pop() top,  --> updata totalcount - top.count



// millsecond invoke()


// rateLimiter.invoke();
//   curtimestap && totalcount < 20
//     return true;
    //    updata my queue,   new pair<timestamp, 1>;
//


/**

    class RateLimiter{

        int totalcount = 0;
        Queue<pair<long, count>> timeWindows = new LinkedList<>();



        // check each milsecond
        public void check(){
            while(true){
                long curTime  = System.currentTimeMillis();

                //  if current time  - first > 100
                while(!timeWindows.isEmpty() && (curTime - timeWindows.peek().times) > 100){
                    Pair tmp = timeWindows.poll();
                    totalcount -= tmp.count;


                }
            }



        }


        boolean invoke(){

            //synchronzied(this){
            long curTime  = System.currentTimeMillis();

            // success, and add this to queue
            if(totalcount < 20){

                //  last one is same with new one, update
                if(timeWindows.get(timeWindows.size() -1).times == curTime){
                    Pair tmp = timeWindows.pollLast();
                    timeWindows.offer(new Pair(curTime, tmp.count+1));
                }

                //new timestamp
                else{
                    timeWindows.offer(new Pair(curTime, 1));
                }

                return true;
            }
            else{
                return false;
            }
            //  }

        }



        public static void main(String[] args){

            RateLimiter rt = new RateLimiter();
            Thread thread = new Thread(){
                public void run(){
                    rt.check();
                }
            };

            thread.start();


            for(int i = 0; i < 200; i++){
                System.out.println(rt.invoke());

            }
        }

    }





    class Pair{
        long times;
        int count;

        public Pair(long t, int count){

            this.times =  t;
            this.count = count;
        }

    }







    class Solution {
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("Hello, World!");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java " + Runtime.version().feature());

            for (String string : strings) {
                System.out.println(string);
            }
        }

    }

 **/

}
