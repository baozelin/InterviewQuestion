package DropboxOA;


//https://1o24bbs.com/t/topic/3316
/**
 * transactional KV-Store (coding)
 *
 * 就是要实现 get, add, update and delete方法, 给了start()和commit()方法开始和结束transaction.
 * 基本思路就是用一个hashmap track transactional id as key, 考的重点应该是有多个transaction同时更新一个值的时候怎么rollback
 *
 * 这道题我的情况是不涉及多线程，开始便问了小哥两次这个问题。
 * 什么时候abort，可以先从最基本的开始，两个transaction对同一个K操作的时候，abort其中一个。
 * 至于优化，到时候可以跟interviewer具体讨论讨论，因该某些情况可以避免abort的
 *
 * k 保证的是concurrent transaction不会出现race condition。题目说了不会出现concurrent transaction，
 * 但是不同的transaction commit之前会touch同一样的id，所以说是需要另外一个map或者其他data structure而不是lock
 * ----
 * 就是要求实现一个in memory的map支持transaction，begin返回一个transactionID,
 * 实现put(transactId, k, v) get(transactId, k ,v)以及commit，需要考虑多个transaction交错的情况以及abort. F
 */


import java.util.*;

/**
 * start() // start transaction 1
 * start() // start transaction 2
 * int val1 = get(1, “a”);
 * int val2 = get(2, “a”);
 * put(1, “a”, val1+1);
 * put(2, “a”, val2+1);
 * commit(1);
 * commit(2);
 *
 * 那么transaction 1的操作就会overwritten， 这个就是update lost。
 * 解决update lost就需要实现repeatable read， 意思就是当一个transaction得到一个key的读的lock时，
 * 要一直hold这个lock到这个transaction结束为止。
 *
 * 这样一来当例子中的第二个transaction要读a的时候就会被拒绝。
 * 根据面试官的要求， 一般会直接throw一个error然后把第二个transaction取消掉（rollback之前所有已做过的操作）。
    至于在实现锁的这块， 可以使用Map来记录当前哪些key已经有读的锁， 哪些有写的锁。
 * 如果一个key已经有读的锁， 那么其他transaction只能获得读的锁， 如果一key已经有写的锁， 那么其他transaction不能再获得读或写的锁。
 * 还有一点要注意的是，一个key上的锁如果只有一个transaction并且此时要求锁的那个transaction就是holding锁的那个transaction，那么这个transaction的读或写应该被允许。
 * 如果一个transaction之前改变了一个值， 在后来的操作发现有conflict，那么要把这个transaction之前修改过的值都改回原先值。
 */

/**
 * start() // start transaction 1
 * start() // start transaction 2
 * int val1 = get(1, “a”);
 * put(2, “b”, 2);
 * put(2, “a”, 2);
 * commit(1);
 * commit(2);
 * 如果一个transaction之前改变了一个值， 在后来的操作发现有conflict， 那么要把这个transaction之前修改过的值都改回原先值。
 */

public class KVstore {
    int transcationId;
    private HashMap<String, Integer> infomap = new HashMap<>();   // K-V map
    private HashMap<String, Integer> locks = new HashMap<>();   // lock map <Key, transactionId>
    private HashMap<Integer, Map<String, Queue<Integer>>> logs = new HashMap<>();  // log < transactionId, <key, value>>  //store origin value
    private Set<Integer> transactionsInProgress = new HashSet<>();  // transactionId in progress

    public KVstore(){
        this.transcationId = 1;
    }
    //return transaction id
    int start(){
        transactionsInProgress.add(transcationId);
        return transcationId++;
    }

    void put(int transactionId, String key, int value){
        if(!transactionsInProgress.contains(transactionId)) return;

        // key 被别的 transaction占用着, 并且现在是put
        if(locks.containsKey(key) && locks.get(key) != transactionId){
            rollback(transactionId);
            System.out.println("transaction " + transactionId + "rollback");
            return;
        }

        if(!logs.containsKey(transactionId)) {
            logs.put(transactionId, new HashMap<>());
            logs.get(transactionId).put(key,new LinkedList<>());

        }

        logs.get(transactionId).get(key).offer(infomap.get(key));  // infomap maybe null????

        //update map
        infomap.put(key, value);
    };

    int get(int transactionId, String key) {
        if (!transactionsInProgress.contains(transactionId)) {
            System.out.println("id does not exist");
            return -1;
        }

        if (!infomap.containsKey(key))
            return -1;

        // ???? 不需要rollback
        if (locks.containsKey(key) && locks.get(key) != transactionId) {
            rollback(transactionId);
            System.out.println("transaction " + transactionId + "rollback");
            return -1;
        }
        locks.put(key, transactionId);
        return infomap.get(key);

    }

    void rollback(int transactionId){
        for(String key: logs.get(transactionId).keySet()){
            int val = logs.get(transactionId).get(key).poll();
            infomap.put(key,val);
        }
        commit(transactionId);


    }



    void commit(int transactionId){
        logs.remove(transactionId);
        transactionsInProgress.remove(transactionId);

        for(String key: locks.keySet()){
            if(locks.get(key) == transactionId){
                locks.remove(key);
            }
        }

    }

}
