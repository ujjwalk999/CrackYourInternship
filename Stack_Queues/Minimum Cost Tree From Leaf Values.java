class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for(int num : arr){
            while(!stack.isEmpty() && stack.peek() <= num){
                int mid = stack.pop();
               
                if(stack.isEmpty()){
                    sum += mid * num;
                } else {
                    sum += mid * Math.min(num , stack.peek());
                }
            }
            
            stack.push(num);
        }

        while(stack.size() > 1){
            int mid = stack.pop();
            sum += stack.peek() * mid;
        }

        return sum;
    }
}
