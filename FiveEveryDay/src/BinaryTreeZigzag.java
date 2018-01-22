

class BinaryTreeZigzag {
	private static List<List<Integer>> zigzagLevel(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();
//		List<Integer> list = new ArrayList<Integer>();
//		if(root == null) return res;
//		Deque<TreeNode> deque = new LinkedList<TreeNode>();
//		boolean flag = true;
//		deque.offer(root);
//		while (!deque.isEmpty()) {
//			if(flag) {
//				int size = deque.size();
//				for(int i = 0; i < size; i++) {
//					TreeNode cur = deque.pollFirst();
//					list.add(cur.val);
//					if(cur.left != null) {
//						deque.offerLast(cur.left);
//					}
//					if(cur.right != null) {
//						deque.offerLast(cur.right);
//					}
//				}
//				res.add(new ArrayList<>(list));
//				flag = false;
//			} else {
//				int size = deque.size();
//				for(int i = 0; i < size; i++) {
//					TreeNode cur = deque.pollLast();
//					list.add(cur.val);
//					if(cur.right != null) {
//						deque.offerLast(cur.right);
//					}
//					if(cur.left != null) {
//						deque.offerLast(cur.left);
//					}
//				}
//				res.add(new ArrayList<>(list));
//				flag = true;
//			}
//		}
//		return res;
//	}
	List<List<Integer>> res = new ArrayList<>();
	if (root == null) {
		return res;
	}
	Deque<TreeNode> deque = new LinkedList<>();
	deque.offerLast(root);
	boolean flag = true;
	while (!deque.isEmpty()) {
		int size = deque.size();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			if (flag) {
				TreeNode cur = deque.pollLast();
				list.add(cur.val);
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}

			} else {
				TreeNode cur = deque.pollLast();
				list.add(cur.val);
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}

			}
		}
		flag = flag ? false : true;
		res.add(list);
	}
	return res;
}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n4;
		n2.right = n5;
		List<List<Integer>> res = zigzagLevel(n1);
		for(List<Integer> list : res) {
			for(int i : list) {
				System.out.println(i);
			}
		}
	}
}