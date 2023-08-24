package Seminar4;

import java.util.LinkedList;
import java.util.Queue;

//1. Необходимо превратить собранное на семинаре дерево поиска в
//        полноценное левостороннее красно-черное дерево. И реализовать
//        в нем метод добавления новых элементов с балансировкой.
//2. Красно-черное дерево имеет следующие критерии:
//        ● Каждая нода имеет цвет (красный или черный)
//        ● Корень дерева всегда черный
//        ● Новая нода всегда красная
//        ● Красные ноды могут быть только левым ребенком
//        ● У красной ноды все дети черного цвета
//3. Соответственно, чтобы данные условия выполнялись, после
//        добавления элемента в дерево необходимо произвести
//        балансировку, благодаря которой все критерии выше станут
//        валидными.
//4. Для балансировки существует 3 операции – левый малый поворот,
//        правый малый поворот и смена цвета.

public class RedBlackTree {
    private Node root;

    class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            this.color = Color.RED; // Новые узлы всегда красные
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        RED, BLACK
    }

    /**
     * @apiNote -  Красно-черное дерево, метод добавляющий значение
     * @param value - добавляемое значение
     * @return  - либо true либо false
     */
    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node(value);
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node(value);
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    (result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED)) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(Node root) {
        if (root != null) {
            inorderTraversalRec(root.leftChild);
            System.out.print(root.value + " ");
            inorderTraversalRec(root.rightChild);
        }
    }

    public void breadthFirstTraversal() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
        System.out.println();
    }

    /**
     * @apiNote -поиск значения в красно-черном дереве
     * @param value - искомое значение
     * @return - true либо false
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    // обход в глубину;
    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (node.value == value) {
            return node;
        }

        if (node.value > value) {
            return find(node.leftChild, value);
        } else {
            return find(node.rightChild, value);
        }
    }


    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(8);
        tree.add(1);
        tree.add(6);
        tree.add(22);

        System.out.println("Обход в ширину:");
        tree.breadthFirstTraversal();

        System.out.println("Симметричный обход(выводит вершины в отсортированном порядке):");
        tree.inorderTraversal();


        System.out.println("\n");
        System.out.println("tree.exist(22) = " + tree.exist(22));
        System.out.println("tree.exist(2) = " + tree.exist(2));
        System.out.println("tree.exist(220) = " + tree.exist(220));
        System.out.println("tree.exist(5) = " + tree.exist(5));
        System.out.println("tree.exist(15) = " + tree.exist(15));


    }
}