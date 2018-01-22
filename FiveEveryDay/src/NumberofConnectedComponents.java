import java.util.*;

class NumberofConnectedComponents  {
	private static int numConnected(int n, int[][] roots) {
		if(n < 0) return 0;
		// construct the adjacent matrix
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int[] root : roots) {
			adj.get(root[0]).add(root[1]);
			adj.get(root[1]).add(root[0]);
		}
		boolean[] isVisited = new boolean[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int cur = i;
			if(!isVisited[cur]) {
				bfsHelper(adj,isVisited,cur);
				sum++;
			}
		}
		return sum;
	}
//	private static void dfsHelper(List<List<Integer>> adj, boolean[] isVisited, int cur) {
//		isVisited[cur] = true;
//		for(int i : adj.get(cur)) {
//			if(!isVisited[i]) {
//				dfsHelper(adj, isVisited, i);
//			}
//		}
//	}
	private static void bfsHelper(List<List<Integer>> adj, boolean[] isVisited, int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(cur);
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int curr = q.poll();
				isVisited[curr] = true;
				for(int j: adj.get(curr)) {
					if(!isVisited[j]) {
						q.offer(j);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][] edges = {{0,1},{1,2},{3,4}};
		int n = numConnected(5, edges);
		System.out.print(n);
	}
}