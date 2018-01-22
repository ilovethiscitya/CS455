class wallsgates {
	private static void wg(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}
		for(int i = 0; i < rooms.length; i++) {
			for(int j = 0; j < rooms[0].length; j++) {
				if(rooms[i][j] == 0) {
					dfsHelper(rooms, i + 1 , j, 1);
					dfsHelper(rooms, i - 1, j, 1);
					dfsHelper(rooms, i, j + 1, 1);
					dfsHelper(rooms, i, j - 1, 1);
				}
			}
		}
	}
	private static void dfsHelper(int[][] rooms, int i, int j, int val) {
		if (i < 0 || i > rooms.length || j < 0 || j > rooms[0].length) {
			return;
		}
		if(rooms[i][j] > val) {
			rooms[i][j] = val;
			dfsHelper(rooms, i + 1, j, val + 1);
			dfsHelper(rooms, i - 1, j, val + 1);
			dfsHelper(rooms, i, j + 1, val + 1);
			dfsHelper(rooms, i, j - 1, val + 1);
		}
	}
	public static void main(String[] args) {
		
		
	}
}