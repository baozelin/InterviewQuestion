package AmazonOA;

public class ngoa {

    public static void main(String[] args) {
        String testCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss = "UGBQTF0THJ";
        int k=2;
        System.out.println(decrypting2(testCase,k));
        System.out.println(decrypting(ss,76));
    }

    private static String decrypting(String ecrypted,int k) {

        int n = ecrypted.length();
        k=k%26;

        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i < n;i++){
            char c = ecrypted.charAt(i);

            int intchar = (c-k);

            if(intchar < 65) {
                intchar+=26;
            }

            char newchar = (char)intchar;

            sb.append(newchar);
        }
        return sb.toString();
    }


    private static String decrypting2(String input,int k) {


        int min = 65, max = 90;
        char[] inputChars = input.toCharArray();

        for (int p = 0; p < inputChars.length; p++) {
            int ascii = (int) inputChars[p];
            int targetAscii = ascii - k;
            if (targetAscii < min) {
                targetAscii = max - (ascii - targetAscii) - 1;
//eg. k=3, ascii = 66 ie B, initial targetAscii = 66-3 ie 63, so final targetAscii =  90-(66-63)+1 ie 88 ie X where, '+1' ~= managing array. length-1 for integration target kind of logic
            }

            inputChars[p] = (char) targetAscii;     //in memory replacement
        }

        return new String(inputChars);
    }
}
