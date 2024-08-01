public class finddupli {
    public String find(String s){
        int n = s.length();
        HashMap<Character,Integer> hpp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int num : s.toCharArray()){
            if(hpp.containsKey(num)){
                sb.append(num);
            }
            else{
                hpp.put(num,1);
            }
    }
    return sb.toString();
}
}
