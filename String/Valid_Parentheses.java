class Solution {
    public boolean isValid(String s) {
        Stack<Character> gtt = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char cr = s.charAt(i);
            if(cr=='(' || cr=='{'||cr=='['){
                gtt.push(cr);
            }
            else{
                if( gtt.isEmpty() ){

                return false;
                }

                char top = gtt.pop();
               if((cr == ')' && top != '(') ||
                   (cr == '}' && top != '{') ||
                   (cr == ']' && top != '[')) {
                    return false;
            }
        }
        }
        return gtt.isEmpty();
    }
}
