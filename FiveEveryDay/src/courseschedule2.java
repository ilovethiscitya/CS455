class courseschedule2 {
	private static int[] course(int[][] prerequisites, int numCourses) {
		if(numCourses == 0) return new int[0];
		int[] res = new int[numCourses];
		if(prerequisites == null) {
			for(int i = 0; i < numCourses; i++) {
				res[i] = i;
			}
		}
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		int index = 0;
		for (int i = 0; i < numCourses; i++) {
			int pre = prerequisites[i][1];
			int ready = prerequisites[i][0];
			indegree[ready]++;
			matrix[pre][ready] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				res[index++] = i;
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int j = 0; j < numCourses; i++) {
					if(matrix[cur][j] == 1) {
						if(--indegree[j] == 0) {
							q.offer(j);
							res[indegree++] = j;
						}
						
					}
				}
			}
		}
		
		
		
		
	}
	public static void main(String[] args) {
		
	}
}