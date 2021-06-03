package DropboxOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class find_duplicate_files {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList();
        // HashMap<String,String> map = new HashMap();
        HashMap<String,List<String>> retMap = new HashMap();

        for(String path: paths){
            //System.out.println(path);
            String[] words = path.split(" ");
            //System.out.println(words.length);
            int index = 0;
            String root="";
            for(String word: words){

                if(index == 0){
                    root = word;
                    //System.out.println("111");
                    index++;
                    continue;
                }

                index++;
                //System.out.println(word);

                int left = word.indexOf("(");
                int right = word.indexOf(")");

                String context = word.substring(left+1,right);

                System.out.println(context);
                if(!retMap.containsKey(context)){
                    retMap.put(context, new ArrayList());
                }

                String fpath = root+ "/"+word.substring(0, left);
                retMap.get(context).add(fpath);

            }


        }
        for(String key: retMap.keySet()){
            if(retMap.get(key).size() > 1)
                ret.add(new ArrayList(retMap.get(key)));
        }

        return ret;
    }


}

/**
 * Imagine you are given a real file system, how will you search files? DFS or BFS?
 *  不同点在于用DFS搜索时，如果文件深度太深，那么可能会需要占用较大的内存栈空间；用BFS时，如果每个文件夹下面的文件夹数量太多，
 *  则队列可能会比较长，因此也会占用较大的内存空间
 *
 * If the file content is very large (GB level), how will you modify your solution?
 *  convert content to hash, need some hash algrithom rolling hash, a part of content + file size
 *
 * If you can only read the file by 1kb each time, how will you modify your solution?
 *  every time read 1kb --> hash, continue read hash+hash --->get final hash
 *
 * What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it?
 * How to optimize?  mutiple threads
 * How to make sure the duplicated files you find are not false positive?
 * ————————————————
 */


/**

 /foo
 |---/bar
 |---/test.png
 |---/img.png
 |--/test
 |---/test2
 |---/test.txt
 |--blabla.txt


 假设  /bar/test.png and /img.png 有相同内容
 /test/test2/test.txt and blabla.txt 有相同内容
 输出
 [[/bar/test.png, /img.png], [/test/test2/test.txt, /blabla.txt]]

 **/

/**
    solution how to get folder and file-----api?。

        hash是怎么算的 -> whole file hash ,,  sample chunk hash+file size



 hmm 其实你不用搞这么复杂，你只需要两个hashmap， 一个是size和对应的文件list，一个是md5 hash和对应的文件list。首先读所有文件的metadata，把相同size的文件丢到对应的list中，然后只处理list size > 1的entry，一行行地读文件内容，生成md5 hash，然后hash不一样的就又自成一个entry，直到读完所有的文件。其实每一轮只需要继续读size > 2的list中的文件，所以比较快。简而言之就是size不一样的一定不在同一个集合中，sample hash值不一样的一定不在同一个集合中，这些都可以过滤掉，不用花时间再去读文件。最坏情况就是所有的大文件都duplicate，那么只能所有文件都得读一遍
 --------------
 1) 如何确定文件类型？遍历目录文件时候，如何确定这是个regular文件，是一个符号链接，是一个特殊的设备文件，还是目录？这是在遍历时候的一个必要步骤。不同的语言和操作系统下可能有不同的方法。如果能够谈到linux下文件系统下有多种文件类型，Linux提供了多种API，比如is_regular_file(), is_block_file等保证确定文件w类型，应该是加分项。
 (2) 如何确定两个文件相同？所有文件对每个文件跟其它文件逐个byte比较是一个很直接了当的办法。但这样非常不高效。改进的办法应该是对文件产生指纹，比如用MD5，或者SHA256等hash算法来产生指纹。这样在指纹库里面进行匹配查找就容易多了。
 (3) 但MD5等hash算法依然存在着冲突的可能性，也就是说，两个文件可能有同样的MD5值。怎么解决这个问题？MD5值相同的情况下，再对两个文件进行逐个byte比较。
 (4) 都是大文件怎么优化这个重复文件检测？重复文件意味着两个大文件的每一个块都是相同的。可以将文件进行切块，对每个块生成MD5，这样大文件的比较就是比较每个文件的MD5列表。只有两个MD5列表完全一致，才说明两个文件完全相同。但在比较过程中，只要遇到不同的MD5，就可以跳出检测，节省时间。
 (5) 如果文件数量非常多怎么办？这个考虑两点优化：第一点要对MD5指纹库查询并行化，首先是单机内多线程的查询，文件规模巨大的情况下，就是多机分布式查询。这个涉及到system design方面了。第二点是考虑文件自身的特性。文件大小相同才有可能是重复文件。所以在查询时，首先找到系统中其他相同大小的文件，然后只跟这些个文件的MD5列表对比，这样就缩小了查询范围。另外，对于一些小文件，是否可以有特殊的处理。比如空文件。比如文件特别小，那是否可以不产生MD5，直接进行byte比较。这个是开放性的提问，只要保证回答合理就行。
 (6) 如果目录里面有soft symbol link怎么办？这个是要考虑是否出现死循环的情况。所以如果提到了第一个问题的解答，在这里就可以表明如果是symbol link就直接跳过。
 (7) 如果目录很深怎么办？这个需要考虑，用来存储文件路径名的字符数组是否有溢出的可能性。
 (8) 如果重复文件查询过程中死机了怎么办？第一点可以考虑checkpointing，定期保存进度。这样重新启动查询的时候，不需要从零开始。
 **/