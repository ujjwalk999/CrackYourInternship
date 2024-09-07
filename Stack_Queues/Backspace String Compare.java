class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getactual(s).equals(getactual(t));
    }
    private String getactual(String str){
        StringBuilder newstr = new StringBuilder();
        int hashcount =0;

        for(int i = str.length()-1; i>=0;i--){
            if(str.charAt(i) == '#'){
                hashcount++;
                continue;
            }
            else if(hashcount > 0){
                hashcount--;
            }
            else{
                 newstr.insert(0,str.charAt(i));
            }
        }
        return newstr.toString();
    }
}
