package Codesignal;


//Given an array of 0s and 1s, every 8 bits is considered 1 block and a contigous subarray of 0's starting with the
// starting index of each block is considered "free memory". For ex: [0011111111111100].
// Block 1: [00111111] Free memory size 2 Block 2: [11111100] Free memory: 0
//Input is a list of queries of format (i,j) , output list with size = size of queries list ie: 1 output per query,
//if i = 0, allocate memory, ex: (0,5) -> Find the earliest memory block where we have size 5 memory available
// ie: 5 consecutive 0's starting at the starting index of any given block; Return the starting index where free memory was found.
// This will be one of the starting indexes of each block. If no free memory found, return -1.
// Also when memory is successfully assigned, uniquely name this assignment,
// for ex: Assignment1. Once assigned those bits should be marked 1 or in other words that block be unavilable to use until memory is released.
//if i = 1, release memory,
// ex (1,3) -> Release the 3rd successfull memory assignement.
// This will always be valid, ie, There will always be 3 successful queries of type 0 before a release memory query with value 3.
// Return the size of memory being released. Once release those bits should be marked 0 or in other words that block i‍‌‍‌‌‌‍‍‍‍‍‍‍‍‌‌‌‌‍s again avilable to use.
public class Memory_allocate {
}
