import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir nodo");
            System.out.println("2 - Deletar nodo");
            System.out.println("3 - Percorrer arvore");
            System.out.println("4 - Buscar nodo");
            System.out.println("5 - Criar arvore teste (1 - 10)");
            System.out.println("6 - Printar a arvore");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor a inserir: ");
                    int valInsere = sc.nextInt();
                    tree.root = tree.insert(tree.root, valInsere);
                    System.out.println("\n" + "Nodo inserido!" + "\n" + tree.searchNode(tree.root, valInsere));
                    break;

                case 2:
                    System.out.print("Informe o valor a deletar: ");
                    int valDelete = sc.nextInt();
                    tree.delete(valDelete);
                    break;

                case 3:
                    System.out.println("Percuso em pre-ordem: ");
                    tree.preOrder(tree.root);
                    System.out.println();
            
                    System.out.println("Percuso em ordem: ");
                    tree.inOrder(tree.root);
                    System.out.println();
            
                    System.out.println("Percuso em pos-ordem: ");
                    tree.postOrder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Informe o valor a buscar: ");
                    int valBusca = sc.nextInt();
                    System.out.println("\n " + tree.searchNode(tree.root, valBusca));
                    break;

                case 5:
                    System.out.print("Inseridos valores de 1 a 10");
                    int keys[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

                    for (int i = 0; i < keys.length; i++) {
                        tree.root = tree.insert(tree.root, keys[i]);
                    }
                    break;
                    //Método aque add no ultimo commit, printar a árvore AVL
                case 6: 
                    System.out.println("Árvore AVL no formato visual:");
                    printAVLTree(tree.root, "", true);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    break;
            }

        } while(opcao != 0);

        sc.close();

    }

    // Método pra imprimir árvore AVL no formato visual
    private static void printAVLTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            // Imprime o nó atual com a indentação apropriada
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.key);

            String newPrefix = prefix + (isLeft ? "│   " : "    ");

            printAVLTree(node.left, newPrefix, true);
            printAVLTree(node.right, newPrefix, false);
        }
    }


}