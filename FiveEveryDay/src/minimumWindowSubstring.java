import java.util.*;

class minimumWindowSubstring {
	private static int MWS(String s, String t) {
		int[] index = new int[128];
		for (int i = 0; i < t.length(); i++) {
			index[t.charAt(i)]++;
		}
		char [] sChar = s.toCharArray();
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int count = t.length();
		while (end < sChar.length) {
			if(index[sChar[end]] == 1) {
				count--;
				index[sChar[end]]--;
				end++;
			} else {
				index[sChar[end]]--;
				end++;
			}
			while (count == 0) {
				if(end - start < min) {
					min = end - start;
				}
				if(index[sChar[start]] == 0) {
					index[sChar[start]]++;
					count ++;
					start++;
				} else {
					index[sChar[start]] ++;
					start++;
				}
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String s = "BXCDEBBD";
		String t = "BDC";
		System.out.println(MWS(s,t));
	}
}