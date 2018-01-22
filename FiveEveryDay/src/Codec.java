import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jianzhe on 2017/9/30.
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfsHelper(root,sb);
        return sb.toString();
    }
    public void dfsHelper(TreeNode root,StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        dfsHelper(root.left,sb);
        dfsHelper(root.right,sb);
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] list = data.split(" ");
        TreeNode dummy = new TreeNode(0);
        dfsHelperdeserial(list,0,dummy,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return dummy.left;
    }
    private int dfsHelperdeserial(String[] list,int pos,TreeNode par,boolean isLeft,int lower,int upper) {
        if (pos > list.length) return pos;
        int val = Integer.valueOf(list[pos]);
        if (val < lower || val > upper) return pos - 1;
        TreeNode cur = new TreeNode(val);

        if (isLeft) par.left = cur;
        else par.right = cur;

        pos = dfsHelperdeserial(list,++pos,cur,true,lower,val);
        pos = dfsHelperdeserial(list,++pos,cur,false,val,upper);
        return pos;
    }
}
