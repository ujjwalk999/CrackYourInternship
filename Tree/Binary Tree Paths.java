class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> individual = new ArrayList<>();
        count(root , individual , result);
        return result;
        
    }
    public static void count(TreeNode root, ArrayList<Integer> individual,ArrayList<String> result ){
        if(root == null) return ;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(individual);
        individual.add(root.val);
        count(root.left,individual,result);
        count(root.right,individual,result);
        if(root.left == null && root.right == null)result.add(sign(individual));
        individual.clear();
        individual.addAll(temp);

    }
    public static String sign(ArrayList<Integer> individual){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< individual.size(); i++){
            sb.append(individual.get(i));
            if(i== individual.size()-1)continue;
            sb.append("->");
        }
        return sb.toString();
    }
}
