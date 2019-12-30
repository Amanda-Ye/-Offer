import java.util.ArrayList;

/**
 * 19.顺时针打印矩阵：（画图让抽象形象化）
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Print {
    /**讨论区思路1：
     *
     * 定义四个变量代表范围，up、down、left、right
     * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
     * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
     * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
     * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(true){
            //最上面一行
            for(int col = left;col <= right;col++){
                list.add(matrix[up][col]);
            }
            //向下逼近
            up++;
            //判断是否越界
            if(up > down){
                break;
            }
            //最右边一列
            for(int row = up;row <= down;row++){
                list.add(matrix[row][right]);
            }
            //向左逼近
            right--;
            if(left > right){
                break;
            }
            //最下面一行
            for(int col = right;col >= left;col--){
                list.add(matrix[down][col]);
            }
            //向上逼近
            down--;
            if(up > down){
                break;
            }
            //最左边一列
            for(int row = down;row >= up;row--){
                list.add(matrix[row][left]);
            }
            //向右逼近
            left++;
            //判断是否越界
            if(left > right){
                break;
            }
        }
        return list;
    }

    /**讨论区思路2：
     *
     * 随便画图可知，走的方向dir有规律：向右->向下->向左->向上->向右->向下->向左->... 是一个圆圈
     * 判断哪一步是否可以走，首先，它没越界；其次，它没被走过（vis标记数组，为false代表没走过）
     */

    // 走的方向：向右、向下、向左、向上
    private final int[] dx = {0,1,0,-1};
    private final int[] dy = {1,0,-1,0};

    public ArrayList<Integer> printMatrix2(int [][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] go = new boolean[row][col];
        ArrayList<Integer> list = new ArrayList<>();

        int x = 0,y = 0,dir = 0;
        while(x >= 0 && x < row && y >= 0 && y < col && !go[x][y]){
            list.add(matrix[x][y]);
            go[x][y] = true;   //标记为走过

            // 试着继续向dir的方向走
            while(x + dx[dir] >= 0 && x + dx[dir] < row && y + dy[dir] >= 0 && y + dy[dir] < col && !go[x + dx[dir]][y + dy[dir]]){
                x += dx[dir];
                y += dy[dir];
                list.add(matrix[x][y]);
                go[x][y] = true;
            }

            // 走不通了换方向
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        return list;
    }
}
