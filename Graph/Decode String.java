class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstack = new Stack<>();
        Stack<String> stringstack =  new Stack<>();
        int k =0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k =(k*10)+(c-'0');
                continue;
            }

            if(c == '['){
                numstack.push(k);
                k =0;
                stringstack.push(String.valueOf(c));
                continue;
            }

            if(c != ']'){
                stringstack.push(String.valueOf(c));
                continue;
            }

            StringBuilder temp = new StringBuilder();
            while(!stringstack.peek().equals("[")){
                temp.insert(0,stringstack.pop());
            }

            stringstack.pop();

            StringBuilder replacement = new StringBuilder();
            int count = numstack.pop();
            for(int i =0 ; i < count; i++){
                replacement.append(temp);
            }
            stringstack.push(replacement.toString());
        }
        StringBuilder result =  new StringBuilder();
        while(!stringstack.empty()){
            result.insert(0,stringstack.pop());
        }
        return result.toString();
    }
}
