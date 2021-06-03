package DropboxOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;



public class webcrawler {
    /**
    String hostname;

    public List<String> crawl(String startUrl, HtmlPaser htmlParser){

        List<String> ret = Collections.synchronizedList(new ArrayList());
        hostname = startUrl.split("/")[2];
        ConcurrentHashMap<String, Integer> set = new ConcurrentHashMap();
        dfs(startUrl, htmlParser, ret, set);
        return ret;
    }


    void dfs(String url, HtmlPaser htmlPaser, List<String> ret, HashSet<String> set) throws InterruptedException {
        ret.add(url);
        set.add(url);

        List<String> urls = htmlPaser.getUrls(url);
        List<Thread> threads = new ArrayList<>();

        for(String nextUrl: urls){
            if(nextUrl.split("/")[2].equals(hostname)&& !set.contains(nextUrl)){
                set.add(nextUrl);
                Thread t = new Thread(){
                    public void run(){
                        dfs(nextUrl, htmlPaser, ret,set);
                    }
                };

                threads.add(t);
            }
        }

        for(Thread t: threads){
            t.start();
        }
        for(Thread t: threads){
            t.join();
        }
    }



**/
}
