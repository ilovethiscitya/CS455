class threeLess {
	private static int three(int[] nums, int target) {
		if(nums == null) return 0;
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				if(nums[i] + nums[start] + nums[end] > target) {
					end --;
				} else {
					count += end - start;
					end--;					
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] nums = {-2,0,1,3,7};
		System.out.println(three(nums,4));
	}
}