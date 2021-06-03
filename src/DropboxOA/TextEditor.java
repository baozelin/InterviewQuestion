package DropboxOA;

import java.lang.reflect.Array;
import java.util.*;

public class TextEditor {

    //StringBuilder context = new StringBuilder();

    //List<String[]> logs = new ArrayList();

    Stack<StringBuilder> redoStack = new Stack<>();
    Stack<StringBuilder> undoStack = new Stack<>();
    private boolean isSelecet = false;
    //private boolean isUndo = false;
    int[] selecet = new int[2];

    public TextEditor(String[][] args){
        operate(args);
        System.out.println("result: "  + this.toString());
    }


    private void operate(String[][] input){

        Arrays.sort(input, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return (int) ((Long.parseLong(o1[0])-  Long.parseLong(o1[0])));
            }
        });

        for(int i = 0; i < input.length; i++){

            System.out.println("1111");

            String timestamp = input[i][0];
            String operate = input[i][1];

            if(operate.equals("APPEND")){
                append(input[i]);
                isSelecet = false;
                //isUndo =false;
                redoStack = new Stack<StringBuilder>();
            }

            else if(operate.equals("BACKSPACE")){
                backspace();
                isSelecet = false;
                redoStack.clear();
            }
            else if(operate.equals("UNDO")) {
                undo();
                //isUndo = true;

            }
            else if(operate.equals("REDO")){
                redo();
                redoStack.clear();
            }
            else if(operate.equals("SELECT")){
                int start = Integer.parseInt(input[i][2]);
                int end = Integer.parseInt(input[i][3]);
                select(start,end);
                redoStack.clear();
            }

            printStack();
        }

    }

    void select(int start, int end){
        if(start >= end) return;

        isSelecet = true;
        selecet = new int[]{start, end};
    }

    void printStack(){
        Stack<StringBuilder> q = (Stack<StringBuilder>) undoStack.clone();
        String res = "";

        while(!q.empty()){
            res = res + q.pop() + ",\t";
        }

        System.out.println("unstack: " + res);


    }

    private void redo(){
        //if(!isUndo) return;

        if(redoStack.empty()) return;
        StringBuilder redoBuilder = redoStack.pop();
        undoStack.push(redoBuilder);
    }

    private void undo(){
        //printStack();

        if(undoStack.empty()) return;
        StringBuilder undoBuilder = undoStack.pop();
        //printStack();
        redoStack.push(undoBuilder);
    }


    private void backspace(){
        if(undoStack.empty()) return;

        StringBuilder curBuilder = undoStack.peek();

        if(curBuilder.length() < 1){
            undoStack.push(curBuilder);
            return;
        }

        // if select before
        if(isSelecet) {

            int end = Math.min(curBuilder.length()-1, selecet[1]);
            curBuilder.delete(selecet[0],end);

        }

        else{
            curBuilder.deleteCharAt(curBuilder.length()-1);

        }




        undoStack.push(curBuilder);

    }

    private void append(String[] command){
        if(undoStack.empty()){
            undoStack.push(new StringBuilder().append(command[2]));
            return;
        }


        StringBuilder curBuilder = new StringBuilder(undoStack.peek());
        // if select before
        if(isSelecet){
            curBuilder.replace(selecet[0],selecet[1],command[2]);
        }

        else{
            curBuilder.append(command[2]);
        }
        undoStack.push(curBuilder);



    }

    public String toString(){
        if(undoStack.empty()) return "";
        return undoStack.peek().toString();
    }


    public static void main(String[] arg){
        String[][] input = {
                {"0","APPEND","Hey"},
                {"1","APPEND"," World"},
                {"2","APPEND","!"},
        };
        TextEditor te = new TextEditor(input);




        String[][] input2 = {

                {"2","APPEND","words"},
                {"1","BACKSPACE"},
                {"1","BACKSPACE"}
        };
        TextEditor te2= new TextEditor(input2);


        String[][] input3 = {

                {"0","APPEND","Hey"},
                {"1","APPEND"," World"},
                {"2","APPEND","!"},
                {"3", "UNDO"},

        };
        TextEditor te3= new TextEditor(input3);



        String[][] input4 = {
                {"0","APPEND","Hey"},
                {"1","APPEND"," World"},
                {"2","APPEND","!"},
                {"3", "UNDO"},
                {"3", "REDO"},
                {"4", "REDO"},

        };
        TextEditor te4= new TextEditor(input4);





        String[][] input5 = {
                {"0","APPEND","Hey"},
                {"1", "UNDO"},
                {"2", "UNDO"}

        };
        TextEditor te5= new TextEditor(input5);


        String[][] input6 = {
                {"0","APPEND","Hey"},
                {"1", "UNDO"},
                {"2", "APPEND", "there"},
                {"3", "REDO"}

        };
        TextEditor te6= new TextEditor(input6);

        String[][] input7 = {
                {"0","APPEND","Hey"},
                {"1100000011122", "UNDO"},
                {"2222", "APPEND", "there"},
                {"3", "REDO"}

        };
        TextEditor te7= new TextEditor(input7);


        String[][] input8 = {
                {"0","APPEND","Hello"},
                {"1", "SELECT","2","5"},
                {"2222", "APPEND", "y ther"}


        };
        TextEditor te8= new TextEditor(input8);


        String[][] input9 = {
                {"0","APPEND","Hello"},
                {"1", "SELECT","1","5"},
                {"2222", "BACKSPACE"}


        };
        TextEditor te9= new TextEditor(input9);
    }

}
