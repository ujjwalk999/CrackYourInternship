class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean vis[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i])
                dfs(i,adj,vis,st);
        }
        ArrayList<ArrayList<Integer>> adjR=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjR.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                adjR.get(it).add(i);
            }
        }
        Arrays.fill(vis,false);
        int cnt=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                cnt++;
                dfsR(node,adjR,vis);
            }
        }
        return cnt;
    }
     void dfsR(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it])
                dfsR(it,adj,vis);
        }
     }
    void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],Stack<Integer> st){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it])
                dfs(it,adj,vis,st);
        }
        st.push(node);
    }
}
