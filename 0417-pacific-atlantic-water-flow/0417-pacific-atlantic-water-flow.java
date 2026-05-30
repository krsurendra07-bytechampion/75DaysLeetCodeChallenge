import java.util.*;

class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j);
            dfs(heights, atl, m - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if (visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, visited, nr, nc);
        }
    }
}