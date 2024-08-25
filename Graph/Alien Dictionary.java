class Solution
{
     public void solve(ArrayList<ArrayList<Integer>> adj,String [] dict,int N){
       for(int i=0;i<N-1;i++){
           String str1=dict[i];
           String str2=dict[i+1];
           for(int j=0;j<Math.min(str1.length(),str2.length());j++){
               if(str1.charAt(j)!=str2.charAt(j)){
                   adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                   break;
               }
           }
       }
       return;
   }
   
   public void toposort(ArrayList<ArrayList<Integer>> adj,int s,boolean vis[],Stack<Integer> st){
       vis[s]=true;
       for(int i=0;i<adj.get(s).size();i++){
           int val=adj.get(s).get(i);
           if(vis[val]==false)
           toposort(adj,val,vis,st);
       }
       st.push(s);
   }
   
   public String findOrder(String [] dict, int N, int K)
   {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
       for(int i=0;i<K;i++){
           adj.add(new ArrayList<Integer>());
       }
       String str="";
       solve(adj,dict,N);
      
       boolean vis[]=new boolean[K];
       Stack<Integer> st=new Stack<>();
       Arrays.fill(vis,false);
       for(int i=0;i<K;i++){
           if(vis[i]==false)
           
       
       toposort(adj,i,vis,st);
       }
       while(st.size()>0){
          char ch=(char)('a'+st.pop());
          str=str+ch;
       }
       return str;
    }
}
