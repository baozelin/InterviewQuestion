package Expedia;

//1507. Reformat Date

//Input: date = "20th Oct 2052"
//Output: "2052-10-20"
public class Reformat_Date {

    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String arr[]=date.split(" ");
        String res=arr[2]+"-";
        for(int i=1;i<=12;i++)
        {
            if(months[i-1].equals(arr[1]))
            {
                if(i<=9) res+="0"+i;
                else res+=i;
            }
        }
        res+="-";
        String day=arr[0].substring(0,arr[0].length()-2);
        return res+(day.length()<2?"0"+day:day);
    }

}
