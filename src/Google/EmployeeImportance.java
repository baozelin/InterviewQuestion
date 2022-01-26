package Google;


import java.util.HashMap;
import java.util.List;

//leetcode 690

public class EmployeeImportance {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }

    int dfs(int id){
        int sum = map.get(id).importance;
        List<Integer> employees = map.get(id).subordinates;
        for(Integer i: employees){
            sum += dfs(i);
        }
        return sum;
    }


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    ////面试：
    ////这题之前只是看了一眼没想，所以没get到大叔想问啥。input是[A: B, C, D], [B: E, F], [C: G, H]这种形式，ABC就是员工ID，
    //// [manager：后面一堆小弟]这样。但形式不重要，int string都无所谓。
    //// 问如何求某人下面一共多少小弟。就是tree node有多少subnode的问题。
    //// 我说DFS找。然后训训善诱你看你是不是需要存成这种结构[A, 3],[B: 2], [C: 2]，我心想那也得遍历所有人还是O(N)昂？
    //// 这会儿还有20分钟时间，为了不交白卷我直接问我能用dfs方法获得下属数量么？对方没继续坚持，说那你写吧。DFS不难，狂写完了以后QA环节随便聊了聊结束了。这轮应该是跪。

    //input是[A: B, C, D], [B: E, F], [C: G, H]
    public int solve(List<Employee> employees, int id){
        map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs_2(id);
    }

    int dfs_2(int id){
        int num = map.get(id).subordinates.size();
        for(int i: map.get(id).subordinates){
            num += dfs(i);
        }
        return num;
    }


}
