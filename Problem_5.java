class Problem_5{
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

    static boolean detectLoop(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    static Node reverseIngroup(Node head, int k){
        Node first = new Node(0);
        first.next = head;
        head = first;
        int x;
        Node second ,curr ,pre;

        while(first.next != null){
            x = k;
            second = first.next;
            pre = first;
            curr = first.next;

            while(x > 0 && curr != null){
                Node post = curr.next;
                curr.next = pre;
                pre = curr;
                curr = post;
                x--;
            }
            first.next = pre;
            second.next = curr;

            first = second;
        }
        return head.next;
    }
    public static void main(String[] args) {
    //Detect loop in LinkedList
        int[] arr = {1,2,3,4,5};
        Node head = linkedListRecFromArr(arr, 0);
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        boolean isLoop = detectLoop(head);
        if(isLoop){
        System.out.println("There is a loop in the linked list");
        }
        else{
        System.out.println("There is no loop in the linked list");
        }

    //Reverse a LinkedList ingroup of sizes k
        int[] arr2 = {2,3,4,6,8,7,5,9,11,17};
        Node head2 = linkedListRecFromArr(arr2, 0);
        display(head2);
        int k = 4;
        Node reversed = reverseIngroup(head2, k);
        display(reversed);

    }
}