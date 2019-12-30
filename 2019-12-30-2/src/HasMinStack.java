import java.util.Stack;
/**
 * 20.包含min函数的栈：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class HasMinStack {
    private int minElement = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    //用一个整型变量 minElement
    public void push(int node) {
        if(stack.isEmpty()){
            stack.push(node);
            minElement = node;
        }else{
            if(node <= minElement) {
                stack.push(minElement);  //在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        //增加最后一个元素以及栈为空时候的检测
        if(stack.isEmpty()){
            return;
        }
        if(minElement == stack.peek()){
            if(stack.size() > 1){
                stack.pop();
                minElement = stack.peek();
            }else{
                minElement = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }

    //用另一个栈 min
    public void push1(int node) {
        stack.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else{
            if(node <= min.peek()){
                min.push(node);
            }else{
                min.push(min.peek());
            }
        }
    }

    public void pop1() {
        stack.pop();
        min.pop();
    }

    public int top1() {
        return stack.peek();
    }

    public int min1() {
        return min.peek();
    }
}
