package LinkedIn;


import java.util.HashMap;
import java.util.Stack;

//150
public class Evaluate_Reverse_Polish_Notation {



    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++){

            String cur = tokens[i];
            if(!cur.equals("+") && !cur.equals("-") && !cur.equals("*") && !cur.equals("/")){
                stack.push(Integer.parseInt(cur));
            }else {
                if (cur.equals("+")) {
                    int c1 = stack.pop();
                    int c2 = stack.pop();
                    stack.push(c2 + c1);
                }

                if (cur.equals("*")) {
                    int c1 = stack.pop();
                    int c2 = stack.pop();
                    stack.push(c2 * c1);
                }

                if (cur.equals("-")) {
                    int c1 = stack.pop();
                    int c2 = stack.pop();
                    stack.push(c2 - c1);
                }

                if (cur.equals("/")) {
                    int c1 = stack.pop();
                    int c2 = stack.pop();

                    //int c = c2/c1;

                    try {
                        stack.push(c2 / c1);
                    } catch (Exception ex) {
                        c2 = 1;
                        throw ex;
                    }


                }
                if (cur.equals("squrt")) {
                    int c1 = stack.pop();
                }
            }
        }

        return stack.pop();
    }



    //OOD
    HashMap<String, Operator>  operator = new HashMap();
    public Evaluate_Reverse_Polish_Notation(){
        operator.put("+", new Add("add"));

        int s = (operator.get("+")).operate(1,2);
    }


    interface Operator{
        String name = "";

        //public Operator(String name){
          //  this.name = name;
        //}

        int operate(int a, int b);
        //    return 0;
       // }
        //public  abstract int opeateB(int a);


    }

    class Add implements Operator{
        String name;
        public Add(String name) {
            this.name = name;
        }


        public int operate(int a, int b) {
            return a + b;
        }


    }


    public static void main(String[] args){
        Evaluate_Reverse_Polish_Notation e = new Evaluate_Reverse_Polish_Notation();
        String[] test1 = new String[]{"2","0","/","3","*"};

        System.out.println(e.evalRPN(test1));
    }


}
