import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1091_Shortest_Path_in_Binary_Matrix {
    
    int[] dirX = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    int[] dirY = new int[]{0, 1, -1, 0, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[row - 1].length;
        int[][] sol = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int[] m : sol) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        if (grid[0][0] == 0) {
            q.offer(new int[]{0, 0});
        }

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                for (int j = 0; j < 8; j++) {
                    int x = tmp[0] + dirX[j];
                    int y = tmp[1] + dirY[j];
                    // if (isValid(grid, x, y) && !visited[x][y]) {
                    if (isValid(grid, x, y)) {
                        if (!visited[x][y] && grid[x][y] == 0) {
                            visited[x][y] = true;
                            // sol[x][y] = Math.min(count, sol[x][y]);
                            sol[x][y] = count;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return sol[row - 1][col - 1] == Integer.MAX_VALUE ? -1 : sol[row - 1][col - 1] + 1;
    }

    public boolean isValid(int[][] grid, int row, int col) {
        int i = grid.length - 1;
        int j = grid[i].length - 1;

        return row >= 0 && row <= i && col >= 0 && col <= j;
    }
}
