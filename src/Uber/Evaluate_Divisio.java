package Uber;


import java.util.*;

//399
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation:
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
public class Evaluate_Divisio {


    //Time Complexity: O(queries.size()*(equations.size())). dfs 用时O(V+E). E = equations.length. V node count can't be greater than equations.size().

    //build graph
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // <a, <b, 2>>
        Map<String, Map<String, Double>> graph = new HashMap<>();
        //fill map
        for(int i = 0; i < values.length; i++){

            List<String> e = equations.get(i);
            String a = e.get(0);
            String b = e.get(1);

            graph.putIfAbsent(a, new HashMap<String, Double>());
            graph.get(a).putIfAbsent(b, values[i]);

            if(values[i] == 0){
                continue;
            }

            graph.putIfAbsent(b, new HashMap<String, Double>());
            graph.get(b).putIfAbsent(a, 1.0/values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){

            List<String> q = queries.get(i);
            res[i] = dfs(q.get(0), q.get(1), 1.0, graph, new HashSet<String>());
        }

        return res;
    }



    double dfs(String s, String e, double cur, Map<String, Map<String, Double>> graph, Set<String> visited){

        if(!graph.containsKey(s) || visited.contains(s)){
            return -1.0;
        }

        if(s.equals(e)){
            return cur;
        }
        visited.add(s);

        Map<String, Double> neighbors = graph.get(s);
        for(String key: neighbors.keySet()){

            //Double> next = neighbors.get(key);
            double tmp = dfs(key, e, cur * neighbors.get(key), graph, visited);

            if(tmp != -1.0){
                return tmp;
            }
        }
        return -1;
    }
}
