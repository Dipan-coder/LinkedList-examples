class SLLDeletation{
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

    static void deleteAnyNode(Node start,int k){
        if(k == 0){
            start = start.next;
            display(start);
            return;
        }

        if(start == null){
            System.out.println("Linked list is null");
            return;
        }

        if(start.next == null){
             start = null;
             display(start);
             return;
        }
            
        Node curr = start;
        Node prev = null;
            while(k > 0){
                prev = curr;
                curr = curr.next;
                k--;
            }
        if(prev != null && curr != null)   prev.next = curr.next;
                   
        display(start);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // Node start = null;
        // Node tail = null;
        
        // for (int i = 0; i < arr.length; i++) {
        //     if(start == null){
        //         start = new Node(arr[i]);
        //         tail = start;
        //     }
        //     else{
        //         tail.next = new Node(arr[i]);
        //         tail = tail.next;
        //     }
        // }
        Node start = linkedListRecFromArr(arr, 0);
        display(start);

//Delete a node from first of a Linked list
        if(start != null){
            start = start.next;
        }
        display(start);

//Delete a node from last of a Linked list
        if(start != null){
            if(start.next == null) start = null;
            else{
            Node prev = start;
            while(prev.next.next != null){
                prev = prev.next;
            }
            prev.next = null;
            }
        }
        display(start);

//Delete a node from any position of a Linked list
        deleteAnyNode(start, 4);



    }
}