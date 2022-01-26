package Codesignal;

public class Easy {


    //reverse sum, 123-->321, 1200-->2100, 再相加
    public int reverseSum(int a, int b){
        int ra = reverse(a);
        int rb = reverse(b);

        return ra + rb;
    }

    int reverse(int a){
        int tmp = 0;
        while(a != 0){
            tmp = tmp*10 + a%10;
            a /= 10;
        }
        return tmp;
    }


    //输入两个string a, b, 输出每一位相加。e.g. a="99", b="99". output="1818"
    public String stringAdd(String a, String b){
        String ret = "";
        if(a.length() < b.length()){
            int i = 0;
            while(i < a.length()){
                int num1 = a.charAt(i) - '0';
                int num2 = b.charAt(i) - '0';
                ret = ret+num1+num2;
            }

            while(i < b.length()){
                ret += b.charAt(i);
            }


        }else{
            int i = 0;
            while(i < b.length()){
                int num1 = a.charAt(i) - '0';
                int num2 = b.charAt(i) - '0';
                ret = ret+(num1+num2);
                i++;
            }

            while(i < a.length()){
                ret += a.charAt(i);
                i++;
            }
        }

        return ret;
    }



    public static void main(String[] args){
        Easy r = new Easy();
        System.out.println(r.reverse(210));
        System.out.println(r.stringAdd("99", "99"));
    }
}
