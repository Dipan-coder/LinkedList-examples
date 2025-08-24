
import java.util.ArrayList;

class Problem_1{
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
    
    static int findMidNode(Node temp){
        Node slow = temp;
        Node fast = temp;

        if(temp == null) return 0;
        if(temp.next == null) System.out.println("Mid value is: "+temp.value);

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }
    public static void main(String[] args){
    int[] arr = {10,20,30,40,50};
    Node head = linkedListRecFromArr(arr, 0);
    display(head);

    
    //Reverse an singly Linked List by it's value
    {   
        Node temp = head;
        ArrayList<Integer> values = new ArrayList<>();
        while(temp != null){
            values.add(temp.value);
            temp = temp.next;
        }
        temp = head;
        for (int i = values.size()-1; i >= 0; i--) {
            temp.value = values.get(i);
            temp = temp.next;
        }
        System.out.print("After reverse by value: ");
        display(head);
    }

    //Reverse an singly Linked List by Node
    {
        Node curr = head;
        Node pre = null;

        while(curr != null){
            Node post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        head = pre;
        System.out.print("After reverse by Node: ");
        display(head);
    }

    //Find the middle of Linked List
        System.out.println(findMidNode(head));


    }
}