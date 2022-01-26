package LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> lines = new ArrayList();
        int index = 0;

        while(index < words.length){

            int count = words[index].length();
            int last = index + 1;

            while(last < words.length){
                if(words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }


            StringBuilder builder = new StringBuilder();
            int diff = last - index -1;   // number of words in a line

            //last line or one word in a line  --> left justify
            if(last == words.length || diff == 0){
                for(int i = index; i < last; i++){
                    builder.append(words[i] + " ");
                }

                builder.deleteCharAt(builder.length()-1);

                for(int i = builder.length(); i < maxWidth;i++){
                    builder.append(" ");
                }
            }

            //middle justify
            else{
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;

                for(int i = index; i < last;i++){
                    builder.append(words[i]);

                    if(i < last - 1){
                        for(int j = 0; j <= (spaces+ ((i-index) < r ?1 : 0)); j++){
                            builder.append(" ");
                        }
                    }
                }
            }

            lines.add(builder.toString());
            index = last;

        }
        return lines;
    }
}
