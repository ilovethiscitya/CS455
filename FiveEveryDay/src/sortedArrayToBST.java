class sortedArrayToBST {
	private static TreeNode covert(int[] nums) {
		if(nums == null) return null;
		return construct(nums, 0, nums.length - 1);
	}
	private static TreeNode construct(int[] nums, int start, int end) {
		if(start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(mid);
		root.left = construct(nums, start, mid - 1);
		root.right = construct(nums, mid, end);
		return root;
	}
	public static void main(String[] args) {
		
	}
}