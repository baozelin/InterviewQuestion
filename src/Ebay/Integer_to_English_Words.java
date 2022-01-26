package Ebay;

public class Integer_to_English_Words {
    //Input: num = 123
//Output: "One Hundred Twenty Three"
    public class IntegertoEnglishWords {

        //divide + conquer
        //O(n)
        public String numberToWords(int num) {
            if (num < 0) return "";
            if (num == 0) return "Zero";

            int segment1 = num / 1000000000;   // above billion
            int segment2 = num % 1000000000 / 1000000;   // above million
            int segment3 = num % 1000000 / 1000;    // thousand - hundred thousand
            int segment4 = num % 1000;      // below hundred
            String res = "";

            if (segment1 > 0)
                res += below1000(segment1) + " Billion";
            if (segment2 > 0)
                res += below1000(segment2) + " Million";
            if (segment3 > 0)
                res += below1000(segment3) + " Thousand";
            if (segment4 > 0)
                res += below1000(segment4);


            return res.trim();
        }

        String below1000(int num) {
            if (num == 0) return "";
            String res = "";
            if (num >= 100) res += below1000(num / 100) + " Hundred";

            num = num % 100;
            if (num > 20) {
                res += find(num / 10 * 10);  // let 67 -> 60
                if (num % 10 != 0) {
                    res += find(num % 10);
                }
            } else if (num > 0)
                res += find(num);
            return res;
        }


        String find(int num) {
            String result = " ";
            switch (num) {
                case 1:
                    result += "One";
                    break;
                case 2:
                    result += "Two";
                    break;
                case 3:
                    result += "Three";
                    break;
                case 4:
                    result += "Four";
                    break;
                case 5:
                    result += "Five";
                    break;
                case 6:
                    result += "Six";
                    break;
                case 7:
                    result += "Seven";
                    break;
                case 8:
                    result += "Eight";
                    break;
                case 9:
                    result += "Nine";
                    break;
                case 10:
                    result += "Ten";
                    break;
                case 11:
                    result += "Eleven";
                    break;
                case 12:
                    result += "Twelve";
                    break;
                case 13:
                    result += "Thirteen";
                    break;
                case 14:
                    result += "Fourteen";
                    break;
                case 15:
                    result += "Fifteen";
                    break;
                case 16:
                    result += "Sixteen";
                    break;
                case 17:
                    result += "Seventeen";
                    break;
                case 18:
                    result += "Eighteen";
                    break;
                case 19:
                    result += "Nineteen";
                    break;
                case 20:
                    result += "Twenty";
                    break;
                case 30:
                    result += "Thirty";
                    break;
                case 40:
                    result += "Forty";
                    break;
                case 50:
                    result += "Fifty";
                    break;
                case 60:
                    result += "Sixty";
                    break;
                case 70:
                    result += "Seventy";
                    break;
                case 80:
                    result += "Eighty";
                    break;
                case 90:
                    result += "Ninety";
                    break;
            }
            return result;
        }
    }
}