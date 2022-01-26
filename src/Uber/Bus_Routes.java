package Uber;


import java.util.*;

//815
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
public class Bus_Routes {



    // bfs
    // data structure:  s, t city --> 找到对应能到 bus id
    // graph:   bus之间 graph
    //O(N^2)
    // )
    public int numBusesToDestination(int[][] routes, int source, int target) {

        // same stop
        if (source==target) return 0;

        HashSet<Integer> targetBus = new HashSet<>();
        HashSet<Integer> tookBus = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();

        //initate graph
        for(int i = 0; i < routes.length; i++){
            graph.add(new ArrayList<>());
            //Arrays.sort(routes[i]);
        }

        Queue<int[]> queue = new LinkedList<>();   // {bus id,  count}

        //fill graph: connect if they go to same stop
        for(int i = 0 ; i < routes.length; i++){  // bus id
            for(int j = i+1; j < routes.length; j++){
                if(isConnect(routes[i], routes[j] )){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // build set
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){

                if(routes[i][j] == target){
                    targetBus.add(i);
                }

                if(routes[i][j] == source){
                    tookBus.add(i);
                    queue.offer(new int[]{i,1});
                }
            }
        }


        //bfs
        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            if(targetBus.contains(cur[0])){
                return cur[1];
            }

            List<Integer> nexts = graph.get(cur[0]);
            for(int next: nexts){

                if(!tookBus.contains(next)){
                    tookBus.add(next);
                    queue.offer(new int[]{next, cur[1]+1});
                }

            }
        }
        return -1;




    }

    boolean isConnect(int[] a, int[] b){

        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]) return true;

            if(a[i] > b[j]) j++;
            else i++;
        }
        return false;
    }
}
