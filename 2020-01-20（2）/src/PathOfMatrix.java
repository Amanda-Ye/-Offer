/**
 * 65.矩阵中的路径：（回溯法）
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e
 *      s f c s
 *      a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class PathOfMatrix {
    /**
     * 来源题解2
     */
    private final int dx[] = {1, -1, 0, 0};
    private final int dy[] = {0, 0, 1, -1};
    private boolean jude(char[] matrix, int rows, int cols, char[] str, int k, int index, boolean[] vis) {
        vis[index] = true;
        if (k == str.length) { // 匹配成功
            return true;
        }
        int x = index / cols;
        int y = index % cols;
        for (int i = 0; i < 4; i++) { // 向四个方向走
            int X = x + dx[i];
            int Y = y + dy[i];
            int next = X * cols + Y;
            if (X >= 0 && Y >= 0 && X < rows && Y < cols && !vis[next] && matrix[next] == str[k] && jude(matrix, rows, cols, str, k + 1, next, vis)) {
                return true;
            }
        }
        vis[index] = false;
        return false;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || rows < 1 || cols < 1) {
            return false;
        }
        boolean[] vis = new boolean[matrix.length]; // 标记数组
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0] && jude(matrix, rows, cols, str, 1, i, vis)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 来源题解1：
     * 使用DFS（深度优先搜索）递归的回溯剪枝思想，即添加一些判断条件使得程序不再递归下去。
     * 首先对于matrix中的每一个都可能是起点，需要遍历。
     * 由题可知，只要找到一条路径，即可返回true，最后的0表示从str的第0个字符开始。
     */
    private boolean[] visited = null;
    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(subHasPath(matrix,rows,cols,str,i,j,0))
                    return true;
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int len){
        if(matrix[row * cols + col] != str[len] || visited[row * cols + col] == true) return false;
        if(len == str.length-1) return true;
        visited[row * cols + col] = true;
        if(row > 0 && subHasPath(matrix,rows,cols,str,row - 1,col,len + 1)) return true;
        if(row < rows-1 && subHasPath(matrix,rows,cols,str,row + 1,col,len + 1)) return true;
        if(col > 0 && subHasPath(matrix,rows,cols,str,row,col - 1,len + 1)) return true;
        if(col < cols-1 && subHasPath(matrix,rows,cols,str,row,col + 1,len + 1)) return true;
        visited[row * cols + col] = false;
        return false;
    }
}
