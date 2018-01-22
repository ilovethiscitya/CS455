import java.util.*;

class FindAllNumbersDisappears {
	private static List<Integer> FA(int[] list) {
		List<Integer> res = new ArrayList<Integer>();
		if(list == null || list.length == 0) return res;
		for(int i = 0; i < list.length; i++) {
			if (Math.abs(list[i]) > 0) {
				if (list[Math.abs(list[i]) - 1] > 0) {
					list[Math.abs(list[i]) - 1] = - list[Math.abs(list[i]) - 1];
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};
		List<Integer> res = FA(a);
		ListIterator<Integer> iter = res.listIterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
	}
}