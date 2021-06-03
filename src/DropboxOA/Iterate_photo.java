package DropboxOA;


import java.util.*;

/**
 * 有photo {photoId, timestamp}，还有iterator读取photo。实现getTopM返回review次数最多的M个photoId
 * 实现一个支持修改的heap
 *
 * 我的做法是用一个heap保持当前top m，还有一个hashmap<photoId, ptr_node_in_heap>，读到新的photo，通过hashmap找到对应的node，更新node，然后swim up／down。
 *
 *
 * follow up: top K经常被call怎么优化 hashmap+double linkedlist
 */
public class Iterate_photo {
    int m = 10;
    PriorityQueue<Photo> pq = new PriorityQueue<>( new Comparator<Photo>() {
        @Override
        public int compare(Photo o1, Photo o2) {
            return o2.review - o1.review;
        }
    });
    HashMap<Integer, Photo> map = new HashMap<>();

    List<Photo> getTopM(){
        List<Photo> ret = new ArrayList<>();
        for(int i = 0; i < m;i++){
            Photo cur = pq.poll();
            ret.add(cur);
        }
        for(Photo p: ret){
            pq.offer(p);
        }
        return ret;
    }

    void review(int id){
        if(!map.containsKey(id)){
            return;
        }
        Photo p = map.get(id);
        pq.remove(p);
        p.review++;
        pq.offer(p);


    }


    class Photo{
        int id;
        int review;

        public Photo(int id, int review){
            this.id = id;
            this.review = review;
        }

    }




}


