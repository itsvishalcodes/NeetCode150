
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    int[] res = new int[k];
    Map<Integer, Integer> mp = new HashMap<>();
    Queue<Map.Entry<Integer, Integer>> freqPQ = new PriorityQueue<>(
      (a, b) -> b.getValue() - a.getValue()
    );
    
    for (int i:nums) {
      if (!mp.containsKey(i)) {
        mp.put(i, 0);
      }
      mp.put(i, mp.get(i)+1);
    }

    for (int i:mp.keySet()) {
      freqPQ.add(new AbstractMap.SimpleEntry<>(i, mp.get(i)));
    }

    for (int i=0; i<k; i++) {
      res[i] = freqPQ.poll().getKey();
    }

    return res;
  }
}
// @lc code=end

