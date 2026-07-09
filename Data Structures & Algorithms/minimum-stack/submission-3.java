class MinStack {

    Stack<Integer> st;
    ArrayList<Integer> min = new ArrayList<>();

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        min.add(val);
    }
    
    public void pop() {
        int x = st.pop();
        min.remove(Integer.valueOf(x));
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return Collections.min(min);
    }
}
