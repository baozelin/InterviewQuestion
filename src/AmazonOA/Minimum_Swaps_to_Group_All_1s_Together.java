package AmazonOA;


//The amazon question is given an array of only 1s and 0s where you can only make adjacent swaps, return the min number of swaps required to have all 1s or 0s on one side.
//
//Eg. [0, 1, 0, 1] would return 1 since it takes 1 swap to have it as [0, 0, 1, 1] which is the minimum.
//[1, 1, 0, 0] would be a valid array except it is not in the minimum as it would take 3 swaps.


//1. 给一个0， 1数组，要求吧所有的0和所有的1group起来，可以吧0移到数组的最前面1移到数组的最后面，或者相反。每次只能交换相邻的元素，要求算最小步数。
//arr = [0, 1, 1, 0, 0]  -> [1, 1, 0, 0, 0] 最小步数为2.
//arr = [1, 1, 0, 0] 已经group了最小步数为0
//解法：
//统计0和1个数
//分两种情况 计算到左边全0右边1 或者左边1右边0因为相邻的可以自由移动，所以最优解是等于左边所有的1[0...sum_zero]到右边所有的0的距离之和[sum_zero...len]， 或者左边所有的0[0...sum_one]到右边所有的1[sum_one...len]之和
//two pointers 分别求左边1到右边0的dist， 左边0到右边1的dist，每次的dist加上去 然后比较两种情况的最小值

public class Minimum_Swaps_to_Group_All_1s_Together {
}
