class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}
public class Problem_4{
    static void display(Node Head) {
        while (Head != null) {
            System.out.print(Head.value + " -> ");
            Head = Head.next;
        }
        System.out.print("END");
        System.out.println("");
    }

    static Node linkedListRecFromArr(int[] arr, int idx) {
        if (idx == arr.length) {
            return null;
        }
        Node temp = new Node(arr[idx]);
        temp.next = linkedListRecFromArr(arr, idx + 1);
        return temp;
    }

    static void removeDuplicates(Node head){
        if(head == null) return;

        Node pre = head;
        Node curr = head.next;

        while(curr != null){
            if(curr.value == pre.value){
                pre.next = curr.next;
                curr = pre.next;
            }
            else{
                pre = pre.next;
                curr = curr.next;
            }
        }
    }

    static Node mergeTwoSortedLL(Node head1, Node head2){
        Node head = new Node(0);
        Node tail = head;

        while(head1 != null && head2 != null){
        if(head1.value <= head2.value){
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
            tail.next = null;
        }
        else{
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
            tail.next = null;
        }
        }
        if(head1 != null){
            tail.next = head1;
        }
        else{
            tail.next = head2;
        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,3,3,4,4};
        Node head = linkedListRecFromArr(arr, 0);
        display(head);

    //Remove duplicate element from a sorted LinkedList
        removeDuplicates(head);
        System.out.println("After removing duplicate element");
        display(head);

    //Merge two sorted LinkedList thus resultant should be sorted (Inplace)
        int[] arr2 = {2,4,5,7};
        Node head1 = linkedListRecFromArr(arr2, 0);
        display(head1);
        int[] arr3 = {3,4,6,8,10};
        Node head2 = linkedListRecFromArr(arr3, 0);
        display(head2);

        System.out.println("After merge two sorted LL");
        Node result = mergeTwoSortedLL(head1, head2);
        display(result);

    }
}