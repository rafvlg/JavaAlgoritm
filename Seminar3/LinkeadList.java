package Seminar3;



public class LinkeadList {

    private Node head;


    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {//список пуст
            head = node;
        } else { //список наполнен
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void removeLast() {
        if (head != null) {
            Node current = head;
            while (current.next != null) {//todo проверка на последний =null
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }
            head = null;
        }
    }

    private class Node {

        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean isContains(int target) {
        return find(target) != null ? true : false;
    }

    public Node find(int target) {
        while (head != null) {
            if (head.value == target) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = head;
        str.append(current.value).append(" ,");
        while (current.next != null) {
            str.append(current.value).append(" ,");
            current=current.next;
        }
        return "LinkedList{" + str + '}';
    }

    public void print(){
        Node current = head;
        while (current != null) {
            System.out.println("currentNode = " + current.value);
            current = current.next;
        }
    }

}
