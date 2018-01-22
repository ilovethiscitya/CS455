/**
 * Created by jianzhe on 2017/10/18.
 */
public class MaximumBinaryTree {
    private static TreeNode CM(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums,0,nums.length - 1);
    }
    private static TreeNode helper(int[] nums,int start, int end) {
        if (start > end) return null;
        int imax = start;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[imax]) {
                imax = i;
            }
        }
        TreeNode root = new TreeNode(nums[imax]);
        root.left = helper(nums,start,imax - 1 );
        root.right = helper(nums,imax,end);
        return root;
    }
}
