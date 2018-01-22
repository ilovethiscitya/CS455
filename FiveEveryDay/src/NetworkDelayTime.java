import java.util.*;

class NetworkDelayTime {
//	private static int netDT(int[][] times, int N, int K) {
//		int[][] edges = new int[101][101];
//		int[] delay = new int[N + 1];
//		Arrays.fill(delay, Integer.MAX_VALUE);
//		for (int[] e: times) {
//			edges[e[0]][e[1]] = e[2];
//		}
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.offer(K);
//		delay[K] = 0;
//		while (!q.isEmpty()) {
//			Set<Integer> set = new HashSet<Integer>();
//			int size = q.size();
//			for (int n = q.size(); n > 0; n--) {
//				int u = q.poll();
//				for (int v = 1; v <= 100; v++) {
//					if (edges[u][v] != null && delay[u] + edges[u][v] < delay[v]) {
//						if (!set.contains(v)) {
//							set.add(v);
//							q.offer(v);
//						}
//						delay[v] = delay[u] + edges[u][v];
//					}
//				}
//			}
//		}
//		int maxdelay = 0;
//		for (int i = 1; i <= N; i++) {
//			maxdelay = Math.max(maxdelay, delay[i]);
//		}
//		return maxdelay == Integer.MAX_VALUE ? -1 : maxdelay;
//	}
	private static int ND(int[][] times, int N, int K) {
		if(times == null || times.length == 0) return 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] dist = new int[N + 1];
		for (int i = 0; i < times; i++) {
			int[] nums = times[i];
			int u = nums[0];
			int v = nums[1];
			List<Integer> list = map.getOrDefault(u, new ArrayList<>());
			list.add(i); //放的是times在的相对位置
			map.put(u, list);
		}
		if (map.get(K) == null) {
			return -1;
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(K);
		dist[K] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (map.get(cur) == null) {
				continue;
			}
			List<Integer> list = map.get(cur);
			int distance = dist[cur];
			for (int n : list) {
				int v = times[i][1];
				int weight = times[i][2];
				if (dist[v] > distance + weight) {
					dist[v] = distance + weight;
					q.offer(v);
				}
			}
		}
		int res = -1;
		
		for (int i = 1; i <= N; i++) {
			int d = dist[i];
			if (d == Integer.MAX_VALUE) {
				return -1;
			}
			res = d > res d : res;
		}
		return res;
	}
	public static void main(String[] args) {
		
	}
}