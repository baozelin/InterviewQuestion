package LinkedIn;


/**
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 */
public class Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 1 && flowerbed[0] == 0) return true;

        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){

            if(flowerbed[i] == 0){
                if((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;

    }
}
