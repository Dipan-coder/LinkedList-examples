class SpNode{
    int  value;
    SpNode next;
    SpNode bottom;

    SpNode(int val){
        this.value = val;
        this.next = null;
        this.bottom = null;
    }
}
public class Problem_6{
    static void display(SpNode head) {
    SpNode goRight = head;
    while (goRight != null) {
        System.out.print("[");
        SpNode goBottom = goRight;
        while (goBottom != null) {
            System.out.print(goBottom.value + "->");
            goBottom = goBottom.bottom;
        }
        System.out.print("END] ");
        goRight = goRight.next;
    }
    System.out.println("");
}
//To create the main Node
    static SpNode createNodeByRec(int[] arr,int n){
        if(n == arr.length) return null;

        SpNode head = new SpNode(arr[n]);
        head.next = createNodeByRec(arr , n+1);
        return head;
    }

    static SpNode createNodeForBottom(int[] arr,int n){
        if(n == arr.length) return null;

        SpNode temp = new SpNode(arr[n]);
        temp.bottom = createNodeForBottom(arr , n+1);
        return temp;
    }

    static SpNode addBottomNodes(SpNode head,int k,int[] arr){
        SpNode add = createNodeForBottom(arr, 0);
        SpNode temp = head;
        while(temp.next != null && k > 0){
            temp = temp.next;
            k--;
        }
        temp.bottom = add;
        return head;
    }

    public static void main(String[] args) {
        int[] nextArr = {5,10,19,28,30};
        SpNode head = createNodeByRec(nextArr, 0);
        int[][] bottomArr = {{7,8,30},{20,40},{22,50},{35,40,45},{34,40}};

        for (int i = 0; i < nextArr.length; i++) {
            addBottomNodes(head, i, bottomArr[i]);
        }

        display(head);


    }
}