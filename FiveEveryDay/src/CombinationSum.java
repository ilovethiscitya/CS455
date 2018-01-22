import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/5.
 */
public class CombinationSum {
    private static List<List<Integer>> CS(int[] nums,int target) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,res,list,target,0);
        return res;
    }
    private static void helper(int[] nums,List<List<Integer>> res,List<Integer> list,int target,int index) {
        if (index > nums.length) return;
        if (target < 0) {
            return;
        } else if (target == 0){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,res,list,target - nums[i],index + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[]nums = {2,3,6,7};
        List<List<Integer>> res = CS(nums,7);
        for (int i = 0; i < res.size();i++) {
            for (int j = 0; j < res.get(i).size();i++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("---");
        }
    }
}
