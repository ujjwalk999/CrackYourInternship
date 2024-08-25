class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String,Boolean> vmap = new HashMap<String, Boolean>();
        for(int i = 0 ; i < wordList.size(); i++){
            vmap.put(wordList.get(i), false);
        }
        Queue<String> q = new LinkedList<String>();
        int length = 1;
        q.add(beginWord);
        vmap.put(beginWord,true);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size; i++){
                String w = q.poll();
                if(w.equals(endWord)){
                    return length;
                }
                wordmatch(w,q,vmap);
            }
            length++;
        }
        return 0;
    }
    private void wordmatch(String word,  Queue<String> q , HashMap<String,Boolean> vmap){
        for(int i = 0 ; i < word.length() ; i++){
            char [] search = word.toCharArray();
            for(int j = 0 ; j < 26 ; j++ ){
                char c = (char)('a' + j);
                search[i] = c;
                String s = String.valueOf(search);
                if(vmap.containsKey(s) && vmap.get(s)== false){
                    q.add(s);
                    vmap.put(s,true);
                }
            }
        }
    }
}
