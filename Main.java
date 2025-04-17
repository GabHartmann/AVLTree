// Main.java
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int keys[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // lista de chaves

        for (int i = 0; i < keys.length; i++) {
            tree.root = tree.insert(tree.root, keys[i]); // inserir
        }

        System.out.println("\n" + tree.searchNode(tree.root, 8)); // checar pela chave

        tree.delete(8); // deletar pela chave

        // percorrer ordens:

        System.out.println("Preorder traversal of constructed AVL tree is : ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Inorder traversal of constructed AVL tree is : ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal of constructed AVL tree is : ");
        tree.postOrder(tree.root);
        System.out.println();

    }
}