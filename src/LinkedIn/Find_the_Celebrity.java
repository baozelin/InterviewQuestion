package LinkedIn;

public class Find_the_Celebrity {

    public int findCelebrity(int n) {

        if(n <= 1) return -1;

        int celebrity = 0;

        //find probably celebrity, can not know the others
        for(int i = 0; i < n; i++){
            if(knows(celebrity,i)){
                celebrity = i;
            }
        }

        for(int i =0; i < n;i++){
            if(i != celebrity){
                if(knows(celebrity, i) || !knows(i,celebrity)){
                    return -1;
                }
            }
        }

        return  celebrity;
    }


    boolean knows(int i, int j){
        return true;
    }
}
