import java.util.List;
import java.util.*;

class FindDisappearedNumbers {
	private static int FDN(int[] nums) {
		int[] index = new int[nums.length - 1];
		for(int i = 0; i < nums.length; i++) {
			if(i != nums.length - 1 && nums[i + 1] - nums[i] != 1) {
				return nums[i] + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {0,1,3,4};
		System.out.print(FDN(nums));
	}
}