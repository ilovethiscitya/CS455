import java.util.*;

/**
 * Created by jianzhe on 2017/10/14.
 */
public class NumberofBoomer {
    private static int NB(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int ret = 0;
        for(int i = 0; i < points.length;i++) {
            Map<Integer, Set<int[]>> map = new HashMap<>();

            int[] p = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] q = points[j];
                int dis = getDistance(p, q);
                if (!map.containsKey(dis)) map.put(dis, new HashSet<>());
                map.get(dis).add(q);
            }
            for (Integer key : map.keySet()) {
                int size = map.get(key).size();
                if (size >= 2) ret += (size * (size - 1));
            }
        }
        return ret;
    }
    private static int getDistance(int[]p,int[]q) {
        int a = p[0]-q[0];
        int b = p[1] - q[1];
        return a*a + b*b;
    }
    public static void main(String[] args) {
        int[][] input = {{0,0},{1,1},{2,0}};
        System.out.println(NB(input));

    }
}
