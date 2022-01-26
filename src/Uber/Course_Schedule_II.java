package Uber;

import java.util.*;

// return one solution
// bfs

public class Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //[child, parent]
        //topology
        int count =0;

        int[] indegree = new int[numCourses];
        int[] ret = new int[numCourses];

        List<Integer>[] reqlist = new List[numCourses];

        //initate
        for(int i = 0; i < numCourses; i++){
            reqlist[i] = new ArrayList<Integer>();
        }

        //fill indegree
        for(int[] p: prerequisites){
            indegree[p[0]]++;
            reqlist[p[1]].add(p[0]);
        }


        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }


        while(!q.isEmpty()){

            int curr = q.poll();

            ret[count] = curr;
            for(int i = 0; i < reqlist[curr].size(); i++){
                indegree[reqlist[curr].get(i)]--;

                if(indegree[reqlist[curr].get(i)] == 0){
                    q.offer(reqlist[curr].get(i));
                }
            }

            count++;


        }

        if(count == numCourses){
            return ret;
        }else{
            return new int[0];
        }
    }
}
