package Uber;
//332
//You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
//
//All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
//
//For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
//Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//Output: ["JFK","MUC","LHR","SFO","SJC"]

import java.util.*;

public class Reconstruct_Itinerary {


    // hashmap<JFK, heap<>> + dfs

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(int i = 0; i < tickets.size(); i++){

            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            if(!map.containsKey(from)){
                map.put(from, new PriorityQueue<>());
            }

            map.get(from).add(to);
        }

        List<String> res = new ArrayList<>();

        dfs(map, "JFK", res);
        return res;
    }


    void dfs(HashMap<String, PriorityQueue<String>> map, String from, List<String> res){

        while(map.containsKey(from) && !map.get(from).isEmpty()){
            String to = map.get(from).poll();
            dfs(map, to, res);
        }
        res.add(0, from);
    }
}
