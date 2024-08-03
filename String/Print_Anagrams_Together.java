class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
      HashMap<String,List<String>> map = new HashMap<>();
     
      for(String str : string_list ){
          char[] word = str.toCharArray();
          Arrays.sort(word);
        String sorted = new String(word);
        
        if(!map.containsKey(sorted)){
            map.put(sorted, new ArrayList<String>());
        }
         map.get(sorted).add(new String(str));
      }
      return new ArrayList<>(map.values());
    }
}
