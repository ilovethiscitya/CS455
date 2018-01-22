import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/4.
 */
public class permutaionii {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums, res, 0, nums.length - 1);
        return res;
    }

    private static void permuteHelper(int[] nums, List<List<Integer>> res, int start, int end) {
        if (start > end) {
            res.add(new ArrayList<Integer>() {{
                for (int i : nums) add(i);
            }});
        }
        for (int i = start; i <= end; i++) {
                swap(nums, i, start);
                permuteHelper(nums, res, start + 1, end);
                swap(nums, i, start);
            }
        }


    private static boolean isDuplicate(int[] nums, int start, int i) {
        for (int a = start; a < i; a++) {
            if (nums[a] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {

        int buf = nums[i];
        nums[i] = nums[j];
        nums[j] = buf;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("---");
        }
    }
}
