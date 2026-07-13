class MyQueue {

    Stack<Integer> s;
    Stack<Integer> temp;

    public MyQueue() {
        s = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
    }

    private void moveToTemp() {
        while (s.size() > 1) {
            temp.push(s.pop());
        }
    }

    private void restore() {
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public int pop() {
        moveToTemp();

        int x = s.pop();

        restore();

        return x;
    }

    public int peek() {
        moveToTemp();

        int x = s.peek();

        restore();

        return x;
    }

    public boolean empty() {
        return s.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */