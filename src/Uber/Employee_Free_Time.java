package Uber;



//759. Employee Free Time

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//Output: [[3,4]]
public class Employee_Free_Time {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> list = new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        for(List<Interval> intervals: schedule){
            for(Interval interval: intervals){
                list.add(interval);
            }
        }

        Collections.sort(list, (a, b) ->(a.start - b.start));
        Interval last = list.get(0);

        for(int i = 1; i < list.size(); i++){

            Interval cur = list.get(i);

            // <end, start>
            if(last.end < cur.start){
                res.add(new Interval(last.end, cur.start));
                last = cur;
            }

            else{
                last.end = Math.max(last.end, cur.end);
            }
        }
        return res;
    }

    class Interval{
        int start;
        int end;


        public Interval(int end, int start) {
        }
    }
}
