import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 2017/11/2.
 */
public class TwoSum {
    private static int[] TS(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(remain)) {
                    res[0] = i;
                    res[1] = map.get(remain);
                }
                if (res[0] == res[1]) continue;
                return res;
            }
        }
        return null;
    }
}
