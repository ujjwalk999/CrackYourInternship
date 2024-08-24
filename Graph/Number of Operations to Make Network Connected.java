class Solution {
    
    int[] parent;
    int[] rank;
    
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }
    
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        
        if(pu != pv){
            int ru = rank[pu];
            int rv = rank[pv];
            
            if(ru > rv){
                parent[pv] = pu;
            }
            else if(rv > ru){
                parent[pu] = pv;
            }
            else{
                parent[pu] = pv;
                rank[pu]++;
            }
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        if(connections.length < n-1){
            return -1;
        }
        
        int res = 0;
        
        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];
            
            if(findParent(u) != findParent(v)){
                union(u, v);                
            }
        }   
        
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                res++;
            }
        }
        
        return res-1;
    }
}
