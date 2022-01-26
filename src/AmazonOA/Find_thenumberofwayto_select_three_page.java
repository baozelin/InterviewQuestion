package AmazonOA;

//The Amazon Kindle Store is an online e-book store where readers can choose a book from a wide range of categories. It also provides the ability to bookmark pages the user wishes to return to later. A book is represented as a binary string having two types of pages:
//
//'0': an ordinary page
//'1': a bookmarked page
//
//Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.
//
//Example
//
//book = '01001'
//
//The following sequences of pages match the criterion:
//
//[1, 2 ,3], that is, 01001 → 010.
//[1, 2 ,4], that is, 01001 → 010.
//[2, 3 ,5], that is, 01001 → 101.
//[2, 4 ,5], that is, 01001 → 101.
//
//The answer is 4.
//Find the number of ways to select 3 pages in ascending index order such that no two adjacent
public class Find_thenumberofwayto_select_three_page {

    public static long numberOfWays(String book) {
        int n = book.length();
        long zeroTotal = 0, oneTotal = 0;
        for (int i = 0; i < n; i++) {
            if (book.charAt(i) == '0') zeroTotal++;
            else oneTotal++;
        }
        long zeroSoFar = 0, oneSoFar = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (book.charAt(i) == '0') {
                res += oneSoFar * (oneTotal - oneSoFar);
                zeroSoFar++;
            } else {
                res += zeroSoFar * (zeroTotal - zeroSoFar);
                oneSoFar++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("Expected: 4; Actual: "+ numberOfWays("01001"));
        System.out.println("Expected: 3; Actual: "+ numberOfWays("10111"));
        System.out.println("Expected: 0; Actual: "+ numberOfWays("0001"));
    }
}
