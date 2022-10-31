package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/10/31 17:44
 */
public class jainzhi1201 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("0");
        System.out.println(stringBuilder.toString());
        char a[][] = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(a, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] vis = new boolean[m][n];
                    vis[i][j] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(word.charAt(0));
                    try {
                        dfs(i, j, vis, sb, word, board);
                    } catch (Exception e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int flag[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int x, int y, boolean[][] vis, StringBuilder sb, String word, char board[][]) throws
            Exception {
        if (sb.toString().equals(word)) {
            throw new Exception();
        }
        if (sb.length() == word.length()) return;

        for (int i = 0; i < 4; i++) {
            int newx = x + flag[i][0];
            int newy = y + flag[i][1];
            if (newx >= 0 && newx < vis.length && newy >= 0 && newy < vis[0].length && !vis[newx][newy] && word.charAt(sb.length()) == board[newx][newy]) {
                sb.append(board[newx][newy]);
                vis[newx][newy] = true;
                dfs(newx, newy, vis, sb, word, board);
                sb.deleteCharAt(sb.length() - 1);
                vis[newx][newy] = false;
            }
        }
    }
}
