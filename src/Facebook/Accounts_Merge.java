package Facebook;


//721
//Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//union find
public class Accounts_Merge {


    // union find
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> res = new ArrayList<>();
        if(accounts.size() == 0) return res;

        // email, row index
        HashMap<String, Integer> emailToIndex = new HashMap<>();

        int[] parents = new int[accounts.size()];

        //fill parents
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }

        for(int i = 0; i < accounts.size(); i++){

            List<String> account = accounts.get(i);

            for(int j = 1; j < account.size(); j++){

                String email  = account.get(j);
                emailToIndex.putIfAbsent(email, i);
                union(parents, i, emailToIndex.get(email));
            }
        }

        // based row
        HashMap<Integer,List<String>> indexToEmails = new HashMap<>();
        for(String email: emailToIndex.keySet()){

            int index = emailToIndex.get(email);
            int root = find(parents,index);
            indexToEmails.putIfAbsent(root, new ArrayList<>());
            indexToEmails.get(root).add(email);
        }


        //put name
        for(int key: indexToEmails.keySet()){
            List<String> list = new ArrayList<>();
            list.addAll(indexToEmails.get(key));
            Collections.sort(list);
            list.add(0, accounts.get(key).get(0));
            res.add(list);
        }

        return res;
    }


    void union(int[] parents, int a, int b){
        int pa = find(parents, a);
        int pb = find(parents, b);

        if(pa != pb){
            parents[pa] = pb;
        }
    }

    int find(int[] parents, int a){

        int p = parents[a];
        while(parents[p] != p){
            p = parents[p];
        }
        return p;
    }
}
