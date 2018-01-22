import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/4.
 */
public class Subset {
    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        subsetHelper(nums,res,list,0,used);
        return res;
    }
    private static void subsetHelper(int[] nums, List<List<Integer>> res, List<Integer> list, int index,boolean[] used) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length;i++) {
            if (used[i]) continue;
            if (i > index && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            subsetHelper(nums,res,list,i + 1,used); // 找这个元素之后的
            list.remove(list.size() - 1);
            used[i] =false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("---");
        }
    }
}
