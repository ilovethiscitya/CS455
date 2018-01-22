import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/4.
 *
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class permulation2 {
    private static List<List<Integer>> permute(int[] nums) {
       if (nums == null || nums.length == 0) return null;
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> list = new ArrayList<>();
       boolean[] used = new boolean[nums.length];
       permuteHelper(nums,res,list,used);
       return res;
    }
    private static void permuteHelper(int[] nums,List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            permuteHelper(nums,res,list,used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> res= permute(nums);
        for (int i = 0; i < res.size();i++) {
            for (int j = 0; j < res.get(i).size();j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("---");
        }
    }
}
