package Google;


import java.util.Arrays;

//给一系列的点，问能组成多少个四边形。不用考虑复杂度。
public class BuildRectangle {

    //is square
    //1. 邻边相等且对角线相等的四边形是正方形.
    //2. 保证对角线长度大于边的长度
    public boolean isSquare (int p1[],int p2[],int p3[],int p4[]){
        int p[][]={{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int cnt=0;
        int  len[]=new int[6];
        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=3;j++){
                // p[i][0]是第i个点的x坐标;p[j][1]是第j个点的y坐标
                len[cnt++]=(p[i][0]-p[j][0])*(p[i][0]-p[j][0])+(p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
            }

        }
        //数组排序 最长的是对角线
        Arrays.sort(len);
        //相邻两边相等,对角线相等的四边形是正方形;
        if(len[0]==len[1]&&len[4]==len[5]&&len[4]>len[1]){
            return true;
        }
        return false;
    }



    //一个更加巧妙地回答，我们可以先计算中点的位置

    //xc = ( y 1 + y 2 + y 3 + y 4 ) / 4
    // y_c=(y_1+y_2+y_3+y_4)/4y

    //然后再计算中点到四个点的距离是不是一样即可
    public boolean isRectangle(){
        return true;
    }


}
