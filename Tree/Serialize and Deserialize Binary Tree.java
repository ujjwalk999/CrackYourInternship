public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==  null) return "null ";
        Queue <TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("null ");
                continue;
            }
            else{
                res.append(node.val + " ");
            }
            q.add(node.left);
            q.add(node.right);

        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null ")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String [] value = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        q.add(root);
        int i =1;
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if(!value[i].equals("null")){
                parent.left = new TreeNode(Integer.parseInt(value[i]));
                q.add(parent.left);
            }
            i++;
            if(!value[i].equals("null")){
                parent.right = new TreeNode(Integer.parseInt(value[i]));
                q.add(parent.right);
            }
            i++;
        }
        return root;
        }
    }
