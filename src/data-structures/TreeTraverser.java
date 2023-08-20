import java.util.Stack;

public class TreeTraverser {

    private enum TraversalMode {
        ITERATIVE,
        RECURSIVE
    }

    /**
     *  Kth Smallest Element in a BST
     *  Validate Binary Search Tree
     */
    void traverseInOrder(TreeNode root, TraversalMode mode) {
        switch (mode) {
            case ITERATIVE:
                traverseInOrderIteratively(root);
                break;

            case RECURSIVE:
                traverseInOrderRecursively(root);
                break;
        }
    }

    void traverseInOrderIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);

                root = root.left;
            }
            root = stack.pop();

            visit(root);

            root = root.right;
        }
    }

    void traverseInOrderRecursively(TreeNode root) {
        if (root != null) {
            traverseInOrderRecursively(root.left);

            visit(root);

            traverseInOrderRecursively(root.right);
        }
    }

    void traversePreOrder(TreeNode root, TraversalMode mode) {
        switch (mode) {
            case ITERATIVE:
                traversePreOrderIteratively(root);
                break;

            case RECURSIVE:
                traversePreOrderRecursively(root);
                break;
        }
    }

    void traversePreOrderIteratively(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();

       stack.push(root);

       while (!stack.isEmpty()) {
           TreeNode node = stack.pop();

           visit(node);

           if (node.right != null) {
               stack.push(node.right);
           }
           if (node.left != null) {
               stack.push(node.left);
           }
       }
    }

    void traversePreOrderRecursively(TreeNode root) {
        if (root != null) {
            visit(root);

            traversePreOrderRecursively(root.left);
            traversePreOrderRecursively(root.right);
        }
    }

    void traversePostOrder(TreeNode root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);

            visit(root);
        }
    }

    private void visit(TreeNode root) {
        System.out.println(root.val);
    }
}
