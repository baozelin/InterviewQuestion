package AmazonOA;

//Find the password strength.
//For each substring of the password which contains at least one vowel and one consonant, its strength goes up by 1.
//vowels={'a', 'e', 'i', 'o', 'u'}, and rest of letters are all consonant.
//(Only lower alphabet letters)

//Input:
//thisisbeautiful
//
//output:
//6
//
//explaination:
//this, is, be, aut, if, ul
public class passwordStrength {


    static public int passwordStrength(String s) {
        int i=0; int j=0;
        int v = 0; int c = 0;
        int total = 0;
        while(j < s.length() && i<=j) {
            if(v>=1 && c>=1) {
                total += 1;
                i = j;
                v=0; c=0;
            }
            if(isVowel(s.charAt(j))) {
                v++;
            }
            else {
                c++;
            }
            j++;
        }

        if(v>=1 && c>= 1){
            total += 1;
        }
        return total;
    }

    static public boolean isVowel(char ch) {
        return ch =='a' || ch =='e' || ch=='i' || ch=='o' || ch=='u';
    }


    public static void main(String[] args) {
        System.out.println(passwordStrength("hackerrank"));
    }


}
