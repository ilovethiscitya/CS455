public class PerfectSquares {
	private static int numSqaures(int n) {
		if(n <= 0) return 0;
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n = numSqaures(12);
		System.out.print(n);
	}
}