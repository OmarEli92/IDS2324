package it.unicam.cs.proxy;

public class DoubleLinkedList {

    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = this.tail = null;
    }

    public Node addNode(Node node){
        if(node == null){
            throw new NullPointerException("Non passare un nodo nullo ");
        }
        if(head == null){
            head = tail = node;
        }
        Node tempHead = head;
        head.setPrevious(node);
        node.setNext(head);
        head = node;
        return head;
    }

    public boolean removeNodeFromTail(){
        if(head != null) {
            Node beforeTailNode = tail.getPrevious();
            beforeTailNode.setNext(null);
            tail = beforeTailNode;
            return true;
        }
        return false;
    }

    public Node removeNode(Node node){
        if(node == null)
            throw new NullPointerException("Il nodo non può essere nullo");
        if(node == head){
            head = head.getNext();
            head.setPrevious(null);
        }
        if(node == tail){
            removeNodeFromTail();
        }
        Node pointer = head;
        while(node != pointer){
            pointer = pointer.getNext();
        }
        Node previousNode = pointer.getPrevious();
        Node successiveNode = pointer.getNext();
        previousNode.setNext(successiveNode);
        successiveNode.setPrevious(previousNode);
        return pointer;
    }

    public Node moveNodeTohead(Node node){
        removeNode(node);
        node.setPrevious(null);
        node.setNext(head);
        head.setPrevious(node);
        head = node;
        return head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
