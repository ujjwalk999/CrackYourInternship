class Trie {
      PrefixTreeNode root;
    public Trie() {
         root = new PrefixTreeNode('\0');
    }

 class PrefixTreeNode{
        private char value;
        private boolean isWord;
        private PrefixTreeNode[] children;

        PrefixTreeNode(char val){
            this.value=val;
            this.isWord = false;
            this.children = new PrefixTreeNode[26];
        }
    }
    
    public void insert(String word) {
         PrefixTreeNode curr = root;
              for(char x : word.toLowerCase().toCharArray()){
                if(curr.children[x -'a'] == null){
                    curr.children[x -'a'] = new PrefixTreeNode(x);
                }
                curr = curr.children[x-'a'];
              }
              curr.isWord = true;
    }
    
    public boolean search(String word) {
             PrefixTreeNode res = getLast(word.toLowerCase());
            return (res != null && res.isWord);
    }
       private PrefixTreeNode getLast(String word){
        PrefixTreeNode curr = root;
        for(char x : word.toLowerCase().toCharArray()){
            if(curr.children[x-'a'] == null){
                return null;
            }
            curr = curr.children[x-'a'];
        }
        return curr;
    }
    
    public boolean startsWith(String prefix) {
         PrefixTreeNode res = getLast(prefix);
            if(res == null) return false;
            return true;
    }
}
