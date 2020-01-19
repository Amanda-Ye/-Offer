/**
 * 51.构建乘积数组：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */

public class BuildMulArray {
    //将乘积沿着对角线分为左右两部分  （对角矩阵）
    public int[] multiply(int[] A) {
        int len = A.length;
        if(A == null || len == 0){
            return new int[]{};
        }
        int[] res = new int[len];
        res[0] = 1;
        //计算左边各部分乘积  下标上界为 i - 1
        for(int i = 1;i < len;i++){
            res[i] = res[i - 1] * A[i - 1];
        }
        //计算右边各部分乘积  下标下界为 i + 1
        for(int i = len - 2,temp = 1;i >= 0;i--){
            temp *= A[i + 1];
            res[i] *= temp;
        }
        return res;
    }

    //将特殊位置“ 置”1
    public int[] multiply1(int[] A) {
        int len = A.length;
        int[] b = new int[len];
        for(int i = 0;i < len;i++){
            b[i] = 1;
            for(int j = 0;j < len;j++){
                if(j == i){
                    b[i] *= 1;
                }else{
                    b[i] *= A[j];
                }
            }
        }
        return b;
    }
}
