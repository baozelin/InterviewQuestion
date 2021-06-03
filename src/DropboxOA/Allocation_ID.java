package DropboxOA;

/**
 * 379. Design Phone Directory
 * write a ID generator, supports
 * - Constructor ( given the maximum ID number )
 * - alloc() return an unused ID 0-max
 * - release( ID )
 *
 * ------------------------
 *
 * followup 1: Queue of Integer is big, how to reduce?
 * followup 2: Can we find a middle ground, sacrifice some memory and improve runtime a bit.
 * followup 3: What if size is not 2^something?
 * followup 4: Can this be done concurrently?
 */

// id 0  -> max

public class Allocation_ID {
    int max;
    boolean[] idstree;

    public Allocation_ID(int max){
        this.max = max;
        this.idstree = new boolean[max*2];
        for(int i =0; i<max*2; i++){
            idstree[i] = false;
        }
    }

    //要返回一个0 到max - 1没有用过的值（已经使用过的值不能再次被使用）
   int allocate(){
        if(idstree[1]) return -1;
        int newid = find(1);
        System.out.println(newid);
        idstree[newid] = true;
        updatetree(newid);
        return newid -max;
    }

    int find(int i){

        if(i >= max*2) return -1;
        if(idstree[i]) return -1;
        if(i < max*2 && !idstree[i] && i >= max) return i;
        return Math.max(find(i*2), find(i*2+1));
    }

    void updatetree(int id){
        if(id %2 ==1){
            while(id >=2){
                idstree[id/2] = idstree[id-1] && idstree[id];
                id = id/2;
            }
        }
        else{
            while(id >=2){
                idstree[id/2] = idstree[id] && idstree[id+1];
                id = id/2;
            }
        }
    }

    void print(){
        for(boolean s: idstree){

            System.out.println(s);
        }
    }


   //让id重新可以使用
   void release(int id){
        idstree[id+max] = false;
        updatetree(id+max);
    }




    public static void main(String[] args) throws InterruptedException {

        Allocation_ID a = new Allocation_ID(4);
        //System.out.print(a.allocate());
        a.allocate();
        a.print();

        a.allocate();
        a.print();
        a.allocate();
        a.print();

        a.allocate();
        a.allocate();
        a.allocate();
        a.allocate();



        System.out.println(a.allocate());
        a.print();
        a.release(2);
        a.print();




    }
}
