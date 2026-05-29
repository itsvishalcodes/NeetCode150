
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

 // APPROACH A (PRIORITY QUEUE + HASHMAP) - O(n log n)
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int leftPtr = 0, rightPtr = k-1;
//         int[] ans = new int[nums.length - k + 1];
//         Map<Integer, Integer> freqCount = new HashMap<>();
//         Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
//         // in a loop, 3 conditions, 2 main conditions
//         // if currElem (rightPtr) == mxElem, increase freq count,
//         // if elem leaving (leftPtr) == mxElem, decrease freq count,
//         // if after decrease, freqcount becomes 0, get next max elem
//         // from the window (priority queue?)
//         // if currElem (rightPtr) > mxElem, assignmxElem, put freq count 1
        
//         // Initial Calculation
//         for(int i=leftPtr; i<=rightPtr; i++) {
//             pq.add(nums[i]);
//             if (!freqCount.containsKey(nums[i])) {
//                 freqCount.put(nums[i], 0);
//             }
//             freqCount.put(nums[i], freqCount.get(nums[i]) + 1);
//         }

//         while(rightPtr < nums.length) {
//             while(pq.peek() != null && freqCount.get(pq.peek()) == 0) {
//                 pq.remove();
//             }
//             Integer maxElemInWindow = pq.peek();
//             ans[leftPtr] = maxElemInWindow == null ? 0 : maxElemInWindow;
//             freqCount.put(nums[leftPtr], freqCount.get(nums[leftPtr]) - 1);
//             leftPtr++; rightPtr++;
//             if (rightPtr == nums.length) break;
//             if (!freqCount.containsKey(nums[rightPtr])) {
//                 freqCount.put(nums[rightPtr], 0);
//             }
//             pq.add(nums[rightPtr]);
//             freqCount.put(nums[rightPtr], freqCount.get(nums[rightPtr]) + 1);
//         }

//         return ans;
//     }
// }

 // APPROACH B (DEQUEUE / MONOTONIC QUEUE) - O(n)
 class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, leftPtr = 0, rightPtr = k-1;
        int[] ans = new int[n - k + 1];

        // MONOTONIC DEQUE
        /*
            The largest element in the window would
            always be at the front that is present in
            the window. The deque will store indices,
            and as the indices go out of window, we will 
            pop the indices from the front until we arrive 
            at an index that exists in the window.
            Since it's a queue, if we arrive at an index
            that exists in the window at the front of queue,
            the elements following that will also be there in
            the window because when elements are populated in
            queue, they are in FIFO order.
        */
        for(int i=leftPtr; i<=rightPtr; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.removeLast();

        }

        for(int i=0; i<n; i++) {

        }

        return ans;
    }
}
// @lc code=end

