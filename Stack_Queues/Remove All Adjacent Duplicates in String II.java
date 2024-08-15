class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack<>();
        for(int i =0 ; i < s.length(); i++){
            if(!stack.isEmpty()){
                if(stack.peek().ch == s.charAt(i)){
                    stack.peek().count++;
                    if(stack.peek().count == k ){
                        stack.pop();
                    }
                }
                else{
                    stack.push(new CharCount(s.charAt(i)));
                }
            }
            else{
                   stack.push(new CharCount(s.charAt(i)));
            }
        }
        StringBuilder res = new StringBuilder();
        for(CharCount charCount : stack){
            res.append(charCount);
        }
        return res.toString();

    }
}
class CharCount {
    char ch;
    int count;
    CharCount(char c){
        ch=c;
        count =1;
    }
    @Override
    public String toString(){
        return Character.toString(ch).repeat(count);
    }
}
