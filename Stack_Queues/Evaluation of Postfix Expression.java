class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> store = new Stack<>();
        for(int i = 0 ; i < S.length();  i++){
            if(Character.isDigit(S.charAt(i))){
                store.push(S.charAt(i) - '0');
            } else {
                int a1 = store.pop();
                int a2 = store.pop();
                
                switch(S.charAt(i))
                {
                    case '+':
                        store.push(a2 + a1);
                        break;
                        
                    case '-':
                        store.push(a2 - a1);
                        break;
                        
                    case '*':
                        store.push(a2 * a1);
                        break;
                        
                    case '/':
                        store.push(a2 / a1);
                        break;    
                }
            }
        }
        return store.pop();
    }
}
