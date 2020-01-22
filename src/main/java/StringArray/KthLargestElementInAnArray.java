package StringArray;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int n = 2;
        int[] nums = {3,2,1,5,6,4};

        System.out.println(kthLargestElement(n, nums));
    }

    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int n, int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i:nums){
            pq.offer(i);
        }

        for (; n>1; n--){
            pq.poll();
        }

        return pq.poll();
    }
}
