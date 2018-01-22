import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by jianzhe on 2017/11/1.
 */
public class isSubset {
    private static boolean isSubset(LinkedList<Integer> list, LinkedList<Integer> sub) {
        ListIterator<Integer> listIterator = list.listIterator();
        ListIterator<Integer> subIterator = sub.listIterator();
        while (subIterator.hasNext()) {
            int subcurr = subIterator.next();
            boolean equals = false;
            while (listIterator.hasNext() && !equals) {
                int curr = listIterator.next();
                if (subcurr < curr) {
                    return false;
                }
                else if (subcurr == curr) {
                    equals = true;
                }
            }
            if (!equals) {
                return false;
            }
        }
        return true;
    }
}
