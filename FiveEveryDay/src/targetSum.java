/**
 * Created by jianzhe on 2017/10/31.
 */
public class targetSum {
    private static int TS(int[] nums, int S){
        if (nums.length == 0 || nums == null) return 0;
        int[] res = new int[1];
        targetHelper(nums,S,res,0,0);
        return res[0];
    }
    private static void targetHelper(int[] nums, int S, int[] res, int sum, int start) {
        if (start == nums.length) {
            if (S == sum) {
                res[0] ++;
            }
            return;
        }
        targetHelper(nums,S,res,sum + nums[start],start + 1);
        targetHelper(nums,S, res, sum - nums[start],start + 1);
    }
    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        System.out.println(TS(a,3));
    }
}
