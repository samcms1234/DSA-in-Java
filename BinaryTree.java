import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;   
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> iterativelyPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.data);

            if(temp.left != null) {
                stack.push(temp.left);
            }

            if(temp.right != null) {
                stack.push(temp.right);
            }
        }
        return list;
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String args[]) {
        BinaryTree b = new BinaryTree();

        b.createBinaryTree();
        // b.preOrder(b.root);
        b.inOrder(b.root);
    }
}
