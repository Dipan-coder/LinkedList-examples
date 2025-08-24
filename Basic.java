//creating node class

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Basic {

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


    static void addNodeAnyPos(Node temp, int k, int val) {
        while (k > 0) {
            temp = temp.next;
            k--;
        }
        Node add = new Node(val);
        add.next = temp.next;
        temp.next = add;
    }

    public static void main(String[] args) {
        Node a = new Node(24);
        System.out.println("value: " + a.value);
        System.out.println("next: " + a.next);

        int[] arr = {10, 11, 12, 13};



        //Insertion of a node starting of the linked list from an array elements
        {
            Node head = null;

            for (int i = 0; i < arr.length; i++) {
                if (head == null) {
                    head = new Node(arr[i]);
                } else {
                    Node temp = new Node(arr[i]);
                    temp.next = head;
                    head = temp;
                }
            }
            display(head);
        }

   
   
        //Insertion of a node ending of the linked list from an array elements
        {
            // Node head = null;
            // Node tail = null;
            // for (int i = 0; i < arr.length; i++) {
            //     if (head == null) {
            //         head = new Node(arr[i]);
            //         tail = head;
            //     } else {
            //         tail.next = new Node(arr[i]);
            //         tail = tail.next;
            //     }
            // }
            Node head = new Node(arr[0]);
            Node tail = head;
            for (int i = 1; i < arr.length; i++) {
                tail.next = new Node(arr[i]);
                tail = tail.next;
            }
            display(head);
        }



        //Insertion of a node ending of the linked list from an array elements by recursion
        Node b = linkedListRecFromArr(arr, 0);
        display(b);

 
 
        //Insertion of a node any position of the linked list 
        addNodeAnyPos(b, 1, 100);
        display(b);

    }
}
