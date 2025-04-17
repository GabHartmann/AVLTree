// Node.java
public class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }

    @Override
    public String toString() {
        return "Key: " + key +
                "\nChild on Left: " + ((left != null) ? left.key : "null") +
                "\nChild on Right: " + ((right != null) ? right.key : "null") +
                "\nHeight: " + height;
    }
}