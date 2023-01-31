/**
 * Question:
 * Implement (from scratch, without using Java library components) a doubly linked list (of
 * integers) class which allows new integers to be added to either end of the list, any referenced
 * node to be removed, and the first and last integers to be read quickly.
 *
 * The class has an internal class node. This represents the nodes in the list.
 * The class is quite simple, it allows to add new nodes at each end.
 * The use of a head and tail parameter allows for fast access of the data.
 * There is no need to traverse the list to get the data at each end.
 * You can delete all the nodes that are referenced by using the removeNode method.**/

public class DoublyLinkedList {

    static class Node{
        //the data that the class contains
        int data = 0;
        Node prev = null;
        Node next = null;

        public Node(int data){
            this.data = data;
        }

    }

    Node start, end = null;

    public void addStart(int add){
        // adds node at the head of the list
        // accounts if the list is empty or not
        Node newNode = new Node(add);
        if (start != null){
            newNode.next = start;
            newNode.prev = null;
            start.prev = newNode;
            start = newNode;
        } else {
            start = end = newNode;
            start.prev = null;
            end.next = null;
        }
    }

    public void addEnd(int add){
        // adds node at the tail of the list
        // accounts if the list is empty or not
        Node newNode = new Node(add);
        if (end != null){
            newNode.next = null;
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        } else {
            start = end = newNode;
            start.prev = null;
            end.next = null;
        }
    }

    public int firstNode(){
        //returns data from the head node
        return start.data;
    }

    public int endNode(){
        //returns data from the tail
        return end.data;
    }

    public void removeNode(Node node){
        //accounts for all the unique cases
        if (start == null || node == null) {
            //no need to check for tail as it will be null
            return;
        }

        // If node to be deleted is head node
        if (start == node) {
            start = node.next;
            return;
        }

        if (end == node) {
            //if node to be deleted is tail
            end.prev.next = null;
            end = end.prev;
            return;
        }

        //accounts for all the nodes in between
        Node current = start;

        while (current != node){
            current = current.next;
        }

        current.next.prev = current.prev;
        current.prev.next = current.next;

    }

    public void displayNode() {

        //displays all the nodes
        Node currentNode = start;
        if(start == null) {
            System.out.println("Linked List is empty");
            return;
        }
        System.out.println("Nodes: ");

        System.out.print(currentNode.data + " ");
        currentNode = currentNode.next;
        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addStart((9));
        doublyLinkedList.addEnd((7));
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addStart(1);
        doublyLinkedList.addEnd((12));
        doublyLinkedList.addStart((31));
        doublyLinkedList.displayNode();
        System.out.println("\n");
        doublyLinkedList.removeNode(doublyLinkedList.end.prev.prev);
        doublyLinkedList.displayNode();
        System.out.println();
        System.out.println(doublyLinkedList.endNode());
        System.out.println(doublyLinkedList.firstNode());
    }

}
