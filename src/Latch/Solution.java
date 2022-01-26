package Latch;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */












// 6 rows, 7 columns
// rule1 4 item in horziontal, vertical, diagnal

// end case: 1. one wins,  2. no space left


// char[6][7] map ---> '.'
// player1  -- > 'y'
// player2 ---> 'r'
// max size 7*6 = 42;
public class Solution {

    int size = 0;
    char[][] tables = new char[6][7];


    public Solution(){
        //initiate table
        for(int i =0;i < 6; i++){
            for(int j = 0; j < 7; j++){
                tables[i][j] = '.';
            }
        }
    }

    // check size >= 42: this over;


    //
    // true: game over
    // false: game be continue

    boolean play(int playerid, int col){
        char color;
        if(playerid == 1){
            color = 'y';
        }else{
            color = 'r';
        }

        if(tables[5][col] != '.'){
            System.out.println("Error move");
            return false;
        }

        int row = 0;
        // fill row
        for(int r = 0; r < 6; r++){
            if(tables[r][col] == '.'){
                row = r;
                tables[r][col] = color;
                break;
            }
        }

        size++;
        return checkWin(row, col, color);
    }

    boolean checkWin(int row, int col, char color){

        int count = 0;
        // horizontal
        //forward
        int c = col;
        int r = row;
        while(c >= 0 && tables[r][c] == color){
            count++;
            c--;
        }

        //backard
        while(c < 7 && tables[r][c] == color){
            count++;
            c++;
        }

        if(count >= 4){
            return true;
        }

        // vertical
        count = 0;
        r = row;
        c = col;
        //upward


        while(r < 6 && tables[r][c] == color){
            r++;
            count++;

        }

        //downward
        while(r >= 0 && tables[r][c] == color){
            r--;
            count++;
        }
        System.out.println(count);

        if(count >= 4){
            return true;
        }




        return false;
    }


    boolean isOver(){

        if(size >= 42){
        }

        //check size
        return false;

    }

    void displayTable(){
        for(int i =5;i >= 0; i--){
            for(int j = 0; j < 7; j++){
                System.out.print(tables[i][j] + " ");
            }
            System.out.println();
        }

    }




    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.play(1, 1));
        System.out.println(s.play(1, 2));
        System.out.println(s.play(1, 3));
        //System.out.println(s.play(1, 4));

        System.out.println(s.play(1, 1));
        System.out.println(s.play(1, 1));
        System.out.println(s.play(1, 1));

        s.displayTable();


    }
}
