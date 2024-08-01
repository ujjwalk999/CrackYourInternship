class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String word :strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedword = new String(chars);

            if(!map.containsKey(sortedword)){
                map.put(sortedword, new ArrayList<>());
            }
            map.get(sortedword).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
