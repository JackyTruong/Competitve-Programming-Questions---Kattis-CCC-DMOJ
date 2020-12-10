public class Main {

    static class Node{
        int key;
        Node left, right;

        public Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    public static class PyramidTree{
        Node root;

        PyramidTree(int key){
            root = new Node(key);
        }

        PyramidTree(){
            root = null;
        }

    }

    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        PyramidTree tree = new PyramidTree(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        traverseInOrder(tree.root);
    }
}
