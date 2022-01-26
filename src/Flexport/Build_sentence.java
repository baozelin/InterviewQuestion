package Flexport;



//Given a string, implement a method that given a word in the sentence, randomly return one of its following words.
// Plus, if the given wrod is in the end of the string, the first word is counted as its following word.


//代码：随机生成句子 那道题 输入一个句子（“I am a good student I am not a bad student") 和 长度L, 输出长度为L的句子
//要求第一个word是随机的，后面的词是前一个词的direct following word。比如 “a“ 是第一个词，第二个词就要从”good“和”bad“随机选择一个，如果”good“选择之后，‍‌‍‌‌‍下个词就是”student“。以此类推

//follow-up：多加一个input N 表示连续的词。N=2， good_student 之后就是 “I”， 接下来student_I后面是am

import java.util.*;

public class Build_sentence {

    public String build(String s, int L){
        StringBuilder sb = new StringBuilder();

        HashMap<String, List<String>> map = new HashMap<>();
        String[] words = s.split(" ");

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }

            if(i == words.length-1){
                if(!map.get(word).contains(words[0]))
                     map.get(word).add(words[0]);
            }
            else{
                if(!map.get(word).contains(words[i+1]))
                    map.get(word).add(words[i+1]);
            }
        }

        System.out.println(map.toString());

        //build
        //random
        Object[] keys = map.keySet().toArray();
        Random random = new Random();
        int rand = random.nextInt(keys.length);
        String randKey = (String)keys[rand];

        System.out.println(randKey);
        sb.append(randKey);

        for(int i = 1; i < L; i++){

            List<String> list = map.get(randKey);
            sb.append(" ");
            sb.append(list.get(0));

            randKey = list.get(0);
        }


        return sb.toString();
    }




    public static void main(String[] args){
        Build_sentence b = new Build_sentence();
        System.out.println(b.build("I am a good student I am not a bad student", 5));
    }
}
