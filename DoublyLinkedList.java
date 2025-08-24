class LinkedNode{
    int value;
    LinkedNode prev;
    LinkedNode next;

    LinkedNode(int val){
        this.value = val;
        this.prev = null;
        this.next = null;
    }  
}

public class DoublyLinkedList{
    static void display(LinkedNode head){   //by recursion
        LinkedNode temp = head;
        if(temp == null){
            System.out.println("");
            return;}
        System.out.print(temp.value +" ");
        display(temp.next);
    }

    static LinkedNode createDLLbyloop(int[] arr){
        if(arr.length == 0) return null;
        LinkedNode head = new LinkedNode(arr[0]);
        LinkedNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            LinkedNode temp = new LinkedNode(arr[i]);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        return head;
    }

    static LinkedNode createDLLbyRec(int[] arr,int idx){
        if(arr.length == 0 || idx >= arr.length) return null;
        LinkedNode temp = new LinkedNode(arr[idx]);
        LinkedNode smallAns = createDLLbyRec(arr, idx+1);
        temp.next = smallAns;
        if(smallAns != null){
        smallAns.prev = temp;
        }
        return temp;
    }

    static LinkedNode addLinkedNodeAnyPos(LinkedNode head,LinkedNode add,int k){
        if(head == null) return add;
    //Add at first position
        if(k == 0){
            add.next = head;
            head.prev = add;
            return add;
        }
    //Add at last position
        LinkedNode tail = head;
        int count = 0;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        if(k >= count){
           tail.next = add;
           add.prev = tail;
           return head; 
        }
    //Add at any other position
        LinkedNode curr = head;
        while(k > 1){
            curr = curr.next;
            k--;
        }
        add.next = curr.next;
        curr.next = add;
        add.prev = curr;
        add.next.prev = add;
        return head;
    }
    public static void main(String[] args) {
    //     LinkedNode a = new LinkedNode(10);
    //     System.out.println(a.value);
    //     System.out.println(a.prev);
    //     System.out.println(a.next);

    // //Create a Doubly LinkedList from an array
    //     int[] arr = {1,2,3,4,5};
    //     LinkedNode A = createDLLbyloop(arr);
    //     display(A);

    // //Add a LinkedNode at first of a Linked List
    //     LinkedNode add = new LinkedNode(100);
    //     if(A == null) A = add;
    //     else{
    //     add.next = A;
    //     A.prev = add;
    //     display(add);}

    // //Add a LinkedNode end of a Linked List
    //     LinkedNode addEnd = new LinkedNode(200);
    //     //if(A == null) A = addEnd;
    //     //else{
    //         LinkedNode temp = A;
    //         while(temp.next != null){
    //             temp = temp.next;
    //         }
    //             temp.next = addEnd;
    //             addEnd.prev = temp;
    //     //}
    //     display(A);

    // //Create a Doubly LinkedList from an array by recursion
    //     int[] arr2 = {11,22,33,44,55};
    //     LinkedNode head = createDLLbyRec(arr2, 0);
    //     display(head);

    //Add a LinkedNode any position of a Linked List
        int[] arr3 = {12,13,14,15};
        LinkedNode head2 = createDLLbyRec(arr3, 0);
        display(head2);
        LinkedNode addAny = new LinkedNode(100);
        LinkedNode result = addLinkedNodeAnyPos(head2, addAny, 2);
        System.out.println("After adding kth position");
        display(result);

    }
}