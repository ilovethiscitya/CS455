import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 2017/9/30.
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 */
public class MostFrequentSubtreeSum {
        public static int maxFreq = 0;
        public static int count = 0;
        private int[] findMostFrequent(TreeNode root) {
            if (root == null) return null;
            HashMap<Integer,Integer> map = new HashMap<>();
            dfsHelper(root,map);
            int[] res = new int[count];
            int i = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxFreq) {
                    res[i++] = entry.getKey();
                }
            }
            return res;
        }
        private static int dfsHelper(TreeNode root, HashMap<Integer,Integer> map) {
            if (root == null) return 0;
            int left = dfsHelper(root.left,map);
            int right = dfsHelper(root.right,map);
            int sum = left + right + root.val;
            map.put(sum,map.getOrDefault(sum,0) + 1);
            if (map.get(sum) > maxFreq) {
                maxFreq = map.get(sum);
                count = 1;
            } else if (map.get(sum) == maxFreq) {
                count++;
            }
            return sum;
        }
    }

