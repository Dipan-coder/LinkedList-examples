class Problem_2{
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

    static Node removeKthNodeEnd(Node head,int k){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
    
    if(k > 0 && k <= count){
        count -= k;
        if(count == 0){
            head = head.next;
            return head;
        }
        temp = head;
        while(count != 1){
            temp = temp.next;
            count--;
        }
        temp.next = temp.next.next;
    }
        return head;
    }

    static Node removeEveryKthNode(Node head,int k){
        if(k == 1) return null;
        Node curr = head;
        Node pre = null;
        int count = 1; 
        while(curr != null){
            if(count != k){
                pre = curr;
                curr = curr.next;
                count++;
            }
            else{
                pre.next = curr.next;
                curr = pre.next;
                count = 1;
            }
        }
        return head;
    }
    public static void main(String[] args) {
    int[] arr = {10,20,30,40,50};
    Node head = linkedListRecFromArr(arr, 0);
    display(head);

//Remove kth Node from end
    Node a = removeKthNodeEnd(head, 5);
    display(a);

//Remove every Kth Node of a Linked List
    Node b = removeEveryKthNode(head, 2);
    display(b);


    }
}