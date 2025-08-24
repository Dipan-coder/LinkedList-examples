class Node {
    int value;
    Node next;
    Node random;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.random = null;
    }
}
public class Problem_7 {
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

    static Node findRandom(Node curr1,Node curr2,Node x){
        if(x == null) return null;
        
        while(curr1 != x){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr2;
    }
    static Node cloneLinkedList(Node head) {
        // code here
        Node copyHead = new Node(0);
        Node copyTail = copyHead;
        Node temp = head;
        while(temp != null){
            copyTail.next = new Node(temp.value);
            temp = temp.next;
            copyTail = copyTail.next;
        }
        copyHead = copyHead.next;
        
        temp = head;
        copyTail = copyHead;
        while(temp != null){
            copyTail.random = findRandom(head,copyHead,temp.random);
            copyTail = copyTail.next;
            temp = temp.next;
        }
        return copyHead;
    }

    static Node cloneLinkedListOptimal(Node head) {
        // code here
        Node copyHead = new Node(0);
        Node copyTail = copyHead;
        Node temp = head;
        while(temp != null){
            copyTail.next = new Node(temp.value);
            temp = temp.next;
            copyTail = copyTail.next;
        }
        copyHead = copyHead.next;
        
        Node curr1 = head;
        Node curr2 = copyHead;
        while(curr1 != null){
            Node front = curr1.next;
            curr1.next = curr2;
            curr2 = curr2.next;
            curr1.next.next = front;

            curr1 = front;
        }
        curr1 = head;
        while(curr1 != null){
            curr2 = curr1.next;
            if(curr1.random != null){
                curr2.random = curr1.random.next;
            }
            curr1 = curr2.next;
        }
        curr1 = head;
        while(curr1.next != null){
            Node front = curr1.next;
            curr1.next = front.next;
            curr1 = front;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = linkedListRecFromArr(arr, 0);
        display(head);

    //Clone a Linked List
        Node copyHead = cloneLinkedList(head);
        display(copyHead);  //T.C = O(n*n);

    //Optimal approach
        Node copyHead2 = cloneLinkedListOptimal(head);
        display(copyHead2);


    }
}
