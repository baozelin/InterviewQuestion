package Google;


//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
public class FloodFill {


    //dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];
        if(color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor){

        if(image[r][c] == color) {

            image[r][c] = newColor;
            if(r -1 >= 0) dfs(image, r -1, c, color, newColor);
            if(c -1 >= 0) dfs(image, r, c-1, color, newColor);
            if(r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if(c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}
