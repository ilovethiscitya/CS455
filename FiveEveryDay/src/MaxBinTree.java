import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * Created by jianzhe on 2017/10/28.
 */
public class MaxBinTree {
    private TreeNode constructTree(int[] nums) {
        if (nums == null) return null;
        return construct(nums,0,nums.length - 1);
    }
    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums,start,max - 1);
        root.right = construct(nums,max + 1, end);
        return root;


    }
}
