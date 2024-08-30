class WordDictionary {
   
   class TrieNode{
    TrieNode children[];
    boolean islast;
    TrieNode(){
        children = new TrieNode[26];
        islast = false;
    }
   }
   TrieNode  root;
    
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            TrieNode curr = node.children[c-'a'];
            if(curr == null){
                node.children[c-'a'] = new TrieNode();
                curr = node.children[c-'a'];
            }
            node = curr;
        }
        node.islast = true;
    }
    
    public boolean search(String word) {
        return find(0,word,root);
        
    }
private boolean find(int index, String word, TrieNode node) {
    if (index == word.length()) {
        return node.islast;
    }
    if (word.charAt(index) == '.') {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && find(index + 1, word, node.children[i])) {
                return true;
            }
        }
        return false;
    } else {
        if (node.children[word.charAt(index) - 'a'] != null) {
            return find(index + 1, word, node.children[word.charAt(index) - 'a']);
        } else {
            return false;
        }
    }
}
}
