package Facebook;



//269//

//Input: words = ["wrt","wrf","er","ett","rftt"]
//Output: "wertf"

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// graph --> topo sort
public class Alien_Dictionary {


    //topo sort
    //["wrt","wrf","er","ett","rftt"]  t->f , w->e, r->t, e->r
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();

        ////build graph, and cound graph
        for(int i = 0; i < words.length; i++){

            char[] curArr = words[i].toCharArray();

            //create element in  degree
            for(char c: curArr) degree.putIfAbsent(c, 0);

            if(i > 0){

                if (words[i-1].length() > words[i].length() && words[i-i].startsWith(words[i])) {
                    return "";
                }

                char[] preArr = words[i-1].toCharArray();
                int len = Math.min(words[i].length(), words[i-1].length());

                //fill graph and degree
                for(int j = 0; j < len; j++){
                    if(preArr[j] != curArr[j]){

                        if(!graph.containsKey(preArr[j])){
                            graph.put(preArr[j], new HashSet<>());
                        }

                        if(!graph.get(preArr[j]).contains(curArr[j])){
                            graph.get(preArr[j]).add(curArr[j]);
                            degree.put(curArr[j], degree.get(curArr[j]) + 1);  //degree update +1
                        }
                        break;
                    }
                }
            }
        }



        return bfs(graph, degree);

    }

    //build graph, and cound graph


    String bfs(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> degree){
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // put degree == 0 to queue
        for(char c: degree.keySet()){
            if(degree.get(c) == 0) queue.offer(c);
        }


        //bfs
        while(!queue.isEmpty()){

            char c = queue.poll();
            sb.append(c);
            degree.remove(c);

            HashSet<Character> nextset = graph.get(c);

            if(nextset != null){

                for(char next : nextset){

                    int nextDegree = degree.get(next) -1;
                    if(nextDegree == 0)
                        queue.offer(next);

                    //degree -1
                    degree.put(next, nextDegree);
                }
            }
        }
        System.out.println(degree.isEmpty());
        return degree.isEmpty() ? sb.toString() : "";
    }
}
