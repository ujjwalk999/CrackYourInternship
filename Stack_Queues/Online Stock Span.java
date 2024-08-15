class Pair{
    int price;
    int span;

    public Pair(int e, int c){
        price = e;
        span = c;
    }
}

class StockSpanner {

    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        
        //For every new price, if the top element in the stack is smaller or
        //equal to the given price then add the top element count + it's own count
        //Keep on doing it untill st.peek() > price
        while(!st.isEmpty() && st.peek().price <= price){
            span += st.peek().span;
            st.pop();
        }
        
        st.push(new Pair(price, span));

        return span;
    }
}
