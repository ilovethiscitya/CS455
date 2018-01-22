/**
 * Created by jianzhe on 2017/10/13.
 */
public class MaximumSubarray {
    private static int MS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] global = new int[2];
        int[] local = new int[2];
        global[0] = nums[0];
        local[0] = nums[0];
        for (int i = 1; i < nums.length;i++) {
            local[i % 2] = Math.max(nums[i],local[(i - 1)%2] + nums[i]);
            global[i%2] = Math.max(global[(i - 1)%2],local[i%2]);
        }
        return global[(nums.length - 1)%2];
    }
}
