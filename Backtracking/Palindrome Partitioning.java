class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
         recurr(s,0,new ArrayList<>(),n);
         return result;
        
    }
    public boolean ispalindrom(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void recurr(String s, int partindex, List<String> sublist, int n) {
    if (partindex == n) {
        result.add(new ArrayList<>(sublist));
        return;
    }
    for (int end = partindex; end < n; end++) {
        if (ispalindrom(s, partindex, end)) {
            sublist.add(s.substring(partindex, end + 1));
            recurr(s, end + 1, sublist, n);
            sublist.remove(sublist.size() - 1);
        }
    }
}
    
}
