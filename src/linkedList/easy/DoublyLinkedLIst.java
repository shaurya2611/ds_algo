package linkedList.easy;


class NodeDLL {
    int data;
    NodeDLL next;
    NodeDLL previous;

    public NodeDLL(int data){
        this.data = data;
    }
    public NodeDLL(int data, NodeDLL next, NodeDLL previous){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

}

public class DoublyLinkedLIst {

    public NodeDLL convertArrayToDLL(int[] arr){
        NodeDLL head = new NodeDLL(arr[0]);
        NodeDLL previousNodeDLL = head;

        for (int i = 1; i < arr.length; i++) {
            NodeDLL newNodeDLL = new NodeDLL(arr[i]);
            newNodeDLL.previous = previousNodeDLL;
            previousNodeDLL.next = newNodeDLL;
            previousNodeDLL = newNodeDLL;
        }
        return head;
    }

    public void printDLL(NodeDLL head){
        while(head!=null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }

    public NodeDLL deleteKthElementDLL(NodeDLL head, int k){
        System.out.println("Deleting "+k+" element");
        if(k==0) return head;
        if(k==1 && head.next==null) return null;

        NodeDLL temp = head;
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
        NodeDLL head = dll.convertArrayToDLL(arr);
        dll.printDLL(head);
        System.out.println();
        head = dll.deleteKthElementDLL(head, 5);
        dll.printDLL(head);
    }

}
