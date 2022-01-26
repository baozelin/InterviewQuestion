package Facebook;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Sechedule_I_II {

    //207
    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: true
    //return true of false
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int count = 0;
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];

        //initiate
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }

        //fill indegree and graph
        for(int[] p: prerequisites){
            indegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        //bfs
        while(!q.isEmpty()){

            int cur = q.poll();
            count++;

            for(int i = 0; i < graph[cur].size(); i++){

                indegree[graph[cur].get(i)]--;
                if(indegree[graph[cur].get(i)] == 0){
                    q.offer(graph[cur].get(i));
                }
            }
        }

        if(count == numCourses) return true;
        else
            return false;
    }



    //210
    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: [0,1]
    //find a solution
    // topological + bfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] indegree = new int[numCourses];
        int[] ret = new int[numCourses];

        // prerequisites[1]: prerequisites[0]
        //after take p[1], can take p[0]
        List<Integer>[] graph = new List[numCourses];

        //initiate
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }

        //fill indegree and graph
        for(int[] p: prerequisites){
            indegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }

        Queue<Integer> q = new LinkedList();

        //add all 0 indegree class id
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        //bfs
        while(!q.isEmpty()){
            int cur = q.poll();
            ret[count] = cur;

            for(int i = 0; i < graph[cur].size(); i++){
                indegree[graph[cur].get(i)]--;

                if(indegree[graph[cur].get(i)] == 0){
                    q.offer(graph[cur].get(i));
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
