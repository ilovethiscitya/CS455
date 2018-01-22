/**
 * Created by jianzhe on 2017/10/13.
 */
public class MaximumProductSubarray {
    private static int MPS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int[] global = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i<nums.length;i++) {
            max[i] = Math.max(nums[i],Math.max(max[i - 1] * nums[i],min[i - 1]*nums[i]));
            min[i] = Math.min(nums[i],Math.min(max[i - 1] * nums[i],min[i - 1] * nums[i]));
            global[i] = Math.max(global[i - 1],max[i]);
        }
        return global[nums.length - 1];
    }
}
