package Ebay;



//283
public class move_zero {
    public void moveZeroes(int[] nums) {

        // // 用双指针
        /*
        move 往下， zero 记录当前0，换值后再zero++；
        */
        int zero = 0, move = 0;

        while (move < nums.length) {
            if (nums[move] != 0) {
                int tmp = nums[move];
                nums[move] = nums[zero];
                nums[zero] = tmp;
                zero++;
            }
            move++;
        }
    }
}
