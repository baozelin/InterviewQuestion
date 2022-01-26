package Uber;


//470
//
//Implement Rand10() Using Rand7()

//    7 * 7

/**
 *
 *            1,2,3,4,5,6,7
 *          1 1 2 3 4 5 6 7
 *          2 8 9 10 1 2 3 4
 *          3 5 6 7 8 9 10 1
 *          4 2 3 4 5 6 7 8
 *          5 9 10 1 2 3 4 5
 *          6 6 7 8 9 10 * *
 *          7 * * * * * * *
 *
 *
 */
public class Implement_Rand10_Using_Rand7 {

    public int rand10() {
        int row, col, idx;

        do{
            row = rand7();
            col = rand7();

            idx = col + (row - 1)*7;
        }
        while(idx > 40);

        return 1 + (idx-1) % 10;
    }

    int rand7(){return -1;}
}
