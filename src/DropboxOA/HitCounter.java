package DropboxOA;


import java.util.LinkedList;

// 362
public class HitCounter {

    LinkedList<Integer> que;
    public HitCounter() {
        que = new LinkedList<Integer>();

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        que.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!que.isEmpty() && timestamp - que.peek() >= 300){
            que.poll();
        }

        return que.size();
    }
}
