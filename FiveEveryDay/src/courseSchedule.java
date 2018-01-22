import java.awt.image.*;

class courseSchedule {
	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
			return false;
		}
		int[][] matrix = new int[numCourses][numCourses];
		int[] degree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0) {
				degree[pre]++;
			}
			matrix[pre][ready] = 1;
		}
		
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
			while (!q.isEmpty()) {
				int cur = q.poll();
				count++;
				for (int j = 0; j < numCourses; i++) {
					if (matrix[cur][j] != 0) {
						degree[j]--;
						if (degree == 0) {
							q.offer(j);
						}
					}
				}
			}
		}
		return count == numCourses;
	}
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}, {0,1}};
		
	}
}