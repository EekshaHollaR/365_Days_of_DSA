class Node{
    int data;
    Node left, right;
    Node(int v){
        data=v;
        left=null;
        right=null;
    }
}
class Day05_Sum_from_root_to_Leaf{
    static long treePathSum(Node root, long val){
        if(root==null){
            return 0;
        }
        val=val*10+root.data;
        if(root.left==null && root.right==null){
            return val;
        }
        return treePathSum(root.left, val)+treePathSum(root.right, val);
    }
    public static void main(String[] args) {
        Node root=new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println(treePathSum(root, 0));
    }
}