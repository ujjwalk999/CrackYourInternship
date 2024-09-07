class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        recurr(S,result,new ArrayList<>());
           return result;
        
    }
    public static void recurr(String s,ArrayList<ArrayList<String>> result, ArrayList<String> tempList ){
       if(s.length() == 0){
           result.add(new ArrayList<>(tempList));
           return;
       }
        for(int i =0; i< s.length() ; i++){
            String substrings = s.substring(0,i+1);
            String remaning = s.substring(i+1);
            if( ispalindrom(substrings) ){
                tempList.add(substrings);
                recurr(remaning,result,tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static boolean ispalindrom(String check){
        int l = 0;
        int r = check.length()-1;
        while(l<r){
            if( check.charAt(l) != check.charAt(r) ){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
};
