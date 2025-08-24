class Problem_3{
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

    static Node rotateLinkedList(Node head,int k){
    if(head == null || head.next == null) return head;
        Node temp = head;
        Node tail = null;
        int count = 0;
        while(temp != null){
            count++;
            tail = temp;
            temp = temp.next;
        }
        count -= k % count;
    if(count == 0) return head;    
        Node curr = head;
        Node pre = null;

        while(count > 0){
            pre = curr;
            curr = curr.next;
            count--;
        }
        pre.next = null;
        tail.next = head;
        head = curr;

        return head;
    }

    static boolean checkPalindrome(Node head){
    //find mid
        Node fast = head;
        Node slow = head;
        Node pre = null;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null) pre.next = null;
    //rotate slow Linked List
        Node curr = slow;
        pre = null;
        while(curr != null){
            Node post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        Node temp2 = pre;
        Node temp = head;
        while(temp2 != null && temp != null){
            if(temp.value != temp2.value) return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
    return true;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        Node head = linkedListRecFromArr(arr, 0);
        display(head);


    //Rotate a Linked List k times from right by Node
        Node a = rotateLinkedList(head, 2);
        display(a);

    //Check the Linked List is Palindrome or not
        int[] arr2 = {10,20,30,20,10};
        Node head2 = linkedListRecFromArr(arr2, 0);
        display(head2);    
        boolean isPalindrome = checkPalindrome(head2);
        if(isPalindrome) System.out.println("head2 Linked List is a Palindrome");
        else System.out.println("head2 Linked List is not a Palindrome");

    }
}