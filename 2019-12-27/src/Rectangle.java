import org.w3c.dom.css.Rect;

/**
 * 10.矩形覆盖：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Rectangle {
    //方法1：递归（545ms）
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    //方法2：循环（19ms）
    public int RectCover2(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i = 0;i < target - 2;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
