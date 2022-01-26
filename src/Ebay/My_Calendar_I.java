package Ebay;


import java.util.TreeMap;

//729. My Calendar I
public class My_Calendar_I {


    //O(nlogn)
    TreeMap<Integer, Integer> calendar;

    public My_Calendar_I() {

        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        if((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)){
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
