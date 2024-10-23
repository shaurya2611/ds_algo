package linkedList;


class Node{
    int data;
    Node next;
    Node previous;

    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next, Node previous){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

}

public class DoublyLinkedLIst {

    public Node convertArrayToDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node previousNode = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.previous = previousNode;
            previousNode.next = newNode;
            previousNode = newNode;
        }
        return head;
    }

    public void printDLL(Node head){
        while(head!=null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }

    public Node deleteKthElementDLL(Node head, int k){
        System.out.println("Deleting "+k+" element");
        if(k==0) return head;
        if(k==1 && head.next==null) return null;

        Node temp = head;
        for (int i = 1; i < k-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if(temp.next!=null) {
            temp.next.previous = temp;
        }
        return head;
    }

    public static void main(String[] args){
        DoublyLinkedLIst dll = new DoublyLinkedLIst();
        int[] arr = {12,5,8,7,13};
        Node head = dll.convertArrayToDLL(arr);
        dll.printDLL(head);
        System.out.println();
        head = dll.deleteKthElementDLL(head, 5);
        dll.printDLL(head);
    }

}
