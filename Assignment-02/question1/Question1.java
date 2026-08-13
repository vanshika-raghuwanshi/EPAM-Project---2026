import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}


class Tree {
    Node root;
    int K;
    int count = 0;

    Tree(int K) {
        this.K = K;
    }

    public void check(Node node, int xor) {
        if (node == null)
            return;

        xor = xor ^ node.data;

        if (xor >= K)
            count++;

        check(node.left, xor);
        check(node.right, xor);
    }

     public int trustedNodes() {
        check(root, 0);
        return count;
    }
}

public class Question1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No of Nodes:- ");
        int N = sc.nextInt();
        System.out.println("Enter the Value of Threshold:- ");
        int K = sc.nextInt();

        
        Node[] nodes = new Node[N + 1];

        // Create all nodes
        System.out.println("Enter the Key for the Nodes:- ");
        for (int i = 1; i <= N; i++) {
            int key = sc.nextInt();
            nodes[i] = new Node(key);
        }

        // Create tree from edges
        for (int i = 0; i < N - 1; i++) {

            System.out.println("Enter the Parent Node:- ");
            int parent = sc.nextInt();
            System.out.println("Enter the Child Node:- ");
            int child = sc.nextInt();

            if (nodes[parent].left == null) {
                nodes[parent].left = nodes[child];
            } 
            else {
                nodes[parent].right = nodes[child];
            }
        }

        System.out.println("The Tree is Generated ");

        // Root is always node 1
        Tree tree = new Tree(K);
        tree.root = nodes[1];

        System.out.print("The No of Trusted Server :-  ");
        System.out.println(tree.trustedNodes());

        sc.close();
    }
}