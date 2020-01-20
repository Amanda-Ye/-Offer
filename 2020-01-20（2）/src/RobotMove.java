import java.util.*;

/**
 * 66.机器人的运动范围：（数组，回溯法）
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */

public class RobotMove {
    //BFS
    private final int dx[] = {-1, 1, 0 ,0};
    private final int dy[] = {0, 0, -1, 1};

    /*//DFS
    private final int dx[] = {1, -1, 0, 0};
    private final int dy[] = {0, 0, 1, -1}; */

    //BFS（广度优先搜索）
    class Path {
        private int x;
        private int y;
        public Path(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    }

    public int movingCount(int threshold, int rows, int cols){
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        int ans = 0;
        boolean[][] vis = new boolean[rows + 1][cols + 1];

        Queue<Path> queue = new LinkedList<>();

        queue.add(new Path(0, 0));
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            Path p = queue.poll();
            int x = p.getX();
            int y = p.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && !vis[xx][yy] && (sum(xx) + sum(yy) <= threshold)) {
                    ans++;
                    vis[xx][yy] = true;
                    queue.add(new Path(xx, yy));
                }
            }
        }
        return ans + 1;
    }


    //DFS（深度优先搜索）
    private int move(int threshold, int rows, int cols, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        int ans = 0;
        for (int i = 0; i < 4; i++) { // 向四个方向走
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X >= 0 && Y >= 0 && X < rows && Y < cols && !vis[X][Y] && sum(X) + sum(Y) <= threshold) {
                ans += move(threshold, rows, cols, X, Y, vis) + 1;
            }
        }
        return ans;
    }
    public int movingCount1(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] vis = new boolean[rows][cols];
        return move(threshold, rows, cols, 0, 0, vis) + 1;
    }

    private int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }


    /*
    private int cnt = 0;
    public int movingCount(int threshold, int rows, int cols){
        if(threshold < 0){
            return 0;
        }
        if(threshold == 0){
            return 1;
        }
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                int sum = getSum(i,j);
                if(sum <= threshold){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //获取坐标数位之和
    private int getSum(int i,int j){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        while(j > 0){
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
    */
}
