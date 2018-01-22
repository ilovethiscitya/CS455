
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/4.
 */
public class Permutation {
    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums,res,list);
        return res;
    }
    private static void permuteHelper(int[] nums,List<List<Integer>> res, List<Integer> list) {
        // recursion is that to assume the sub-problems have already been solved
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                permuteHelper(nums,res,list);
                list.remove(list.size() - 1);
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("..");
        }
    }
}
