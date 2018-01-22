import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 2017/11/1.
 */
public class targetSum2 {
    private static int shoppingOffer(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingHelper(price,special,needs,0);
    }
    private static int shoppingHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index == special.size()) {
            return purchaseSingle(price,needs);
        }
        List<Integer> clone = new ArrayList<>(needs);
        // use the special offer at the current index
        int i;
        for (i = 0; i < special.get(index).size() - 1; i++) {
            int remain = needs.get(i) - special.get(index).get(i);
            if (remain < 0) break;
            else {
                clone.set(i,remain);
            }
        }
        if (i == special.get(index).size() - 1) {
            return Math.max(special.get(index).get(i) + shoppingHelper(price,special,clone,index), shoppingHelper(price,special,needs,index + 1));
        } else {
            return shoppingHelper(price,special,needs,index + 1);
        }
    }
    private static int purchaseSingle(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size();i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
