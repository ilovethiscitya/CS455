/**
 * Created by jianzhe on 2017/10/29.
 */
public class Burstballons {
    private static int BB(int[] nums) {
        int[][] T = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length;len++) {
            for (int i = 0; i <= nums.length;i++) {
                int j = i + len - 1;
                for (int k = i; i <= j; k++) {
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        rightValue = nums[j + 1];
                    }
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k - 1];
                    }
                    if (j != k) {
                        after = T[k + 1][j];
                    }
                    T[i][j] = Math.max(leftValue*nums[k]*rightValue+before+after,T[i][j] );
                }
            }
        }
        return T[0][nums.length - 1];
    }
}
