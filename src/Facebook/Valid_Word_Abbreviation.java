package Facebook;


//408
//Input: word = "internationalization", abbr = "i12iz4n"
//Output: true

public class Valid_Word_Abbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex = 0;
        int num = 0;
        for(int i = 0; i < abbr.length(); i++){
            char c = abbr.charAt(i);
            //digital
            if(c >= '0' && c <= '9' ){
                if(num == 0 && c == '0') return false;   //invalid number 01
                num = num * 10 + (c - '0');
                continue;
            }

            wordIndex += num;
            num = 0;
            //over length
            if(wordIndex >= word.length()){
                return false;
            }
            if(wordIndex < word.length() && c != word.charAt(wordIndex)){
                return false;
            }
            wordIndex++;
        }
        return wordIndex + num == word.length();
    }
}
