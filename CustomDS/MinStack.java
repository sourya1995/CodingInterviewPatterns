public class MinStack {
    int maxSize;
    static Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        this.maxSize = 100;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }

    public int pop(){
        minStack.pop();
        return minStack.pop();
    }

    public void push(Integer value) {
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value){
            minStack.push(minStack.top());
        } else {
            minStack.push(value);
        }
    }

    public int minNumber(){
        return minStack.top();
    }
}
