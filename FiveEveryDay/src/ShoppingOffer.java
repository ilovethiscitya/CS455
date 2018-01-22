import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/29.
 *
 */
public class ShoppingOffer {
    private static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingHelper(price,special,needs,0);
    }
    private static int shoppingHelper(List<Integer> price, List<List<Integer>> special,List<Integer> needs,int index) {
        if (index == special.size()) {
            return purchaseWithSingle(price,needs);
        }
        List<Integer> clone = new ArrayList<>(needs);
        int i;
        for (i = 0; i < special.get(index).size() - 1; i++) {
            int remain = needs.get(i) - special.get(index).get(i);
            if (remain < 0) {
                break;
            } else {
                clone.set(i,remain);
            }
        }
        // determine whether use the current special offer or not
        if (i == special.get(index).size()) {
            return Math.max(special.get(index).get(i) + shoppingHelper(price,special,clone,index), shoppingHelper(price,special,needs,index + 1));
        } else {
            return shoppingHelper(price,special,needs,index + 1);
        }
    }
    private static int purchaseWithSingle(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size();i++) {
            total += price.get(i)*needs.get(i);
        }
        return total;
    }
}
