// AVLTree.java
public class AVLTree {

    Node root;

    int height(Node nodeToGetHeight) {
        if (nodeToGetHeight == null)
            return 0;
        return nodeToGetHeight.height;
    }

    void updateHeight(Node nodeToUpdateHeight) {
        if (nodeToUpdateHeight != null) {
            nodeToUpdateHeight.height = 1 + (((height(nodeToUpdateHeight.left) > height(nodeToUpdateHeight.right))
                    ? height(nodeToUpdateHeight.left)
                    : height(nodeToUpdateHeight.right)));
        }
    }
    public Node getRoot() {
        return root;
    }
    Node rightRotate(Node k2) {
        Node k1 = k2.left;
        Node y = k1.right;

        k1.right = k2;
        k2.left = y;

        updateHeight(k2);
        updateHeight(k1);

        return k1;
    }

    Node leftRotate(Node k1) {
        Node k2 = k1.right;
        Node y = k2.left;

        k2.left = k1;
        k1.right = y;

        updateHeight(k1);
        updateHeight(k2);

        return k2;
    }

    int getBalance(Node nodeToGetBalance) {
        if (nodeToGetBalance == null)
            return 0;
        return height(nodeToGetBalance.left) - height(nodeToGetBalance.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        updateHeight(node);

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    Node searchNode(Node node, int key) {
        if (node != null) {
            if (node.key == key) {
                return node;
            } else {
                Node foundNode;
                if (key < node.key) {
                    foundNode = searchNode(node.left, key);
                    if (foundNode != null) {
                        return foundNode;
                    }
                } else {
                    foundNode = searchNode(node.right, key);
                    if (foundNode != null) {
                        return foundNode;
                    }
                }
            }
        }
        return null;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // Exclusão por fusão
                Node smallestOnRight = node.right;
                Node parentOfSmallest = node;
                while (smallestOnRight.left != null) {
                    parentOfSmallest = smallestOnRight;
                    smallestOnRight = smallestOnRight.left;
                }
                if (parentOfSmallest != node) {
                    parentOfSmallest.left = smallestOnRight.right;
                    smallestOnRight.right = node.right;
                }
                smallestOnRight.left = node.left;
                node = smallestOnRight;
            }
        }

        updateHeight(node);

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balance = getBalance(node);
        if (balance < -1 || balance > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
}