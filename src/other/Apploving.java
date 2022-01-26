package other;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Apploving {
}
    // package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3

/*
Question:

design a file concatenation task

Note: files are in directories, nested 2 layers deep. any files in /root should not be touched



Example:

starting:
  /root
  /root/sub1
  /root/sub1/file1, /root/sub1/file2,
  /root/sub2
  /root/sub2/file1, /root/sub2/file2,
  /root/file9.txt,
  /root/file10.txt


result:
  /root
  /root/sub1-concat.txt
  /root/sub2-concat.txt
  /root/file9.txt,
  /root/file10.txt



**/


/**


class File {

  //(recursively) lists all directories & files
  public static List<File> getFiles(String path, boolean recursive);
  given (/root, false) ==>  /root/sub1, /root/sub2, /root/file9, /root/file10
  given (/root, true) ==>  /root/sub1, /root/sub1/file1, /root/sub1/file2, /root/sub2, .... /root/file9, /root/file10

  public File(String path);
  public String getPath(); ->  ex. /root/sub1
  public String getName(); -> ex. file1
  public boolean isDirectory();
  public boolean isFile();
  public void append(File file);
  public void delete();

}

    Queue<String: path> queue
    check isDir or file

    queue.offer("/root");
    int level == 0

    getFiles('/root", false) --->   /root/sub1, /root/sub2, /root/file9, /root/file10  --->  /root/sub1, /root/sub2, queue

    /root/sub1, getFiles

    /root/sub2












    class MyCode {



        public void solve(String root) {

            if(root.length() == 0){
                System.out.println("wrong input");
                throw Exception;
            }

            int level = 0;
            // string: path
            Queue<String> queue = new LinkedList<>();
            queue.offer(root);


            //  queue: root
            while(!queue.isEmpty()){


                String curPath = queue.poll();

                // now in root direction
                if(curPath.equals(root)){
                    List<File> children = getFiles(root, false);

                    for(File next: children){
                        // is dir
                        if(next.isDirectory()){
                            queue.offer(next);
                        }
                    }
                }
                // not in root dir
                else{
                    //initiate a new file
                    // path => /root/subtask.txt
                    File  newFile = null;
                    List<File> children = getFiles(root, false);
                    for(File next: children){
                        if(next.isFile()) {
                            if(newFile == null){
                                newFile = new File(curPath + "-concat.txt");
                            }
                            newFile.append(next);
                        }
                    }
                    //case is no files in subdir
                }
            }
        }




    }

}
 */