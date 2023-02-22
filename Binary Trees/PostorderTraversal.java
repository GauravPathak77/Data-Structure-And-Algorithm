import java.util.*;
public class PostorderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public Node buildTree(ArrayList<Integer> nodes){
            idx++;
            if(nodes.get(idx) == -1){
                return null;
            }
            Node newNode = new Node(nodes.get(idx));
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Postorder
        public void postorder(Node root){
            if(root == null){
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer> nodes = new ArrayList<>();
            System.out.println("Enter values of nodes: ");
            char choice;
            do {
                int data = sc.nextInt();
                nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            } while (choice == 'y' || choice == 'Y');

            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.print("Do you Want to print Postorder Traversal(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                tree.postorder(root);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
