import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/15.
 */
public class Tester {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
                allrows.add(row);
        }
        return allrows;
    }
    public static void main(String [] args) {
        List<List<Integer>> res = new ArrayList<>();
        int x = Integer.parseInt("90");
        System.out.println(x);
    }
}
