package Codesignal;


//给一篇文章(vector<vector<string>> paragraphs)，以及对应的对齐方式（left 或 right），一个行宽。要求用空格分隔每行单词 如果打不下就换行，
// 每一行首尾以*分隔开。要求打印出重新排版的文章。
//需要注意在首尾增加一行“*”进行隔断。
//样例数据：[["hello", "world"], ["how", "are",  "you", "doing"], ["this", "is a", "paragraph", "to align"]],
// ["left", "right", "left"], 16
//样例输出：[["******************],
//                  ["*hello world     *],
//                  ["*     how are you*"],
//                  ["*           doing*"],
//                  ["*this is a       *],
//                  ["*paragraph to    *"],
//                  ["*align           *"],
//                  ["******************]]
//需要注意首尾其实是width+2个* 楼主自己写cutomize test case的时候没注意到所以自测的时候的expect output一直是错的…‍‌‍‌‌‌‍‍‍‍‍‍‍‍‌‌‌‌‍…最后找了半天耽误了好久

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String_array {

    public String[] solve(String[][] words, String[] sides, int width){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            String[] ws = words[i];
            int length = 0;

            for(String w: ws){
                length += w.length() +1;
            }

        }

        return null;
    }

}
