package LinkedList.SinglyLinkedList;




public class LinkedList {
    private ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }    
    }
    public void display(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.data+" ---> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public int length(ListNode head){
        ListNode curr = head;
        int l = 0 ;
        while(curr != null){
            l++;
            curr = curr.next;
        }
        return l;
    }
    public void insertbeg(int f){
        ListNode newNode = new ListNode(f);
        newNode.next = head;
        head = newNode;
    }
    public void insertend(int e){
        ListNode eNode = new ListNode(e);
        ListNode curr = head;
        if(head == null){
            head = eNode;
            return;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = eNode;
    }
    public void insert(int v, int p){
        ListNode Node = new ListNode(v);
        int count = 1;
        // if(p > length()){
        //     System.out.println("Invalid length");
        //     return;
        // }
        if(p == 1){
            Node.next = head;
            head = Node;
        }
        else{
            ListNode prev = head;
            while(count < p - 1){
                prev = prev.next;
                count++;
            }
            ListNode curr = prev.next;
            Node.next = curr;
            prev.next = Node;
        }
    }
    public ListNode delf(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public ListNode dell(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next!= null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
        
    }
    public ListNode del(int pos){
        if(pos == 1){
            if(head == null){
                return null;
            }
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
        else{
            int count = 1;
            ListNode curr = head;
            ListNode prev = null;
            while (count < pos) {
                count++;
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return curr;

        }
    }
    public boolean searListNode(ListNode head, int x){
        if(head == null){
            return false;
        }
        ListNode curr = head;
        while(curr != null){
            if(curr.data == x){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode mid(){
        if(head == null){
            return null;
        }
        ListNode spoint = head;
        ListNode fpoint = head;
        while(fpoint != null && fpoint.next != null){
            spoint = spoint.next;
            fpoint = fpoint.next.next;
        }
        return spoint;
    }
    public ListNode nthListNode( int n){
        // ListNode mptr = head;
        // ListNode rptr = head;
        // int count = 0;
        // while(count < n){
        //     rptr = rptr.next;
        //     count++;
        // }   
        // while (rptr != null) {
        //     rptr = rptr.next;
        //     mptr = mptr.next;
        // }
        // return mptr;
        int count = 1;
        n = length(head) - n + 1;
        ListNode curr = head;
        while(count < n){
            curr = curr.next;
            count++;
        }
        return curr;
     }
     public void dub(){
        if(head == null){
            return;
        }
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
    }
    public void insertsort(int data){
        if(head == null ){
            return;
        }
        ListNode newListNode = new ListNode(data);
        ListNode curr = head;
        ListNode temp = null;
        while(curr != null && curr.data < newListNode.data){
                temp = curr;
                curr = curr.next;
        }
        if(temp == null){
            newListNode.next = curr;
            head = newListNode;
            return;
        }
        newListNode.next = curr;
        temp.next = newListNode;
    }
    public void removekey(int key){
        if(head == null){
            return;
        }
        ListNode curr = head;
        ListNode temp = null;
        while(curr.data != key && curr != null){
            temp = curr;
            curr = curr.next;
        }
        if(curr == null) return;
        if(curr == head){
            head = curr.next;
            curr.next = null;
            return;
        }
        temp.next = curr.next;
    }
    public boolean loop(){
        if(head == null || head.next == null) return false;
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr != null && fptr.next != null){
            fptr = fptr.next.next;
            sptr = sptr.next;
            if(fptr == sptr){
                return true;
            }
        }
        return false;
    }
    public ListNode floop(){
        if(head == null || head.next == null) return null;
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr != null && fptr.next != null){
            fptr = fptr.next.next;
            sptr = sptr.next;
            if(fptr == sptr){
                return fnode(sptr);
            }
        }
        return null;
    }
    public void removeLoop(ListNode sptr){
        ListNode temp = head;
        while(sptr.next != temp.next){
            temp = temp.next;
            sptr = sptr.next;
        }
        sptr.next = null;
    }
    public ListNode fnode(ListNode sptr){
        ListNode temp = head;
        while(sptr != temp){
            temp = temp.next;
            sptr = sptr.next;
        }
        return temp;
    }
    public void merge(ListNode l1, ListNode l2){
        ListNode curr = l1;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = l2;
    }
    public ListNode smerge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null ){
            if(l1.data <= l2.data){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 == null){
            tail.next = l2;
        }
        else{
            tail.next = l1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ListNode l1 = new ListNode(1);
        ListNode sec1 = new ListNode(3);
        ListNode th1 = new ListNode(5);
        ListNode fo1 = new ListNode(8);
        l1.next = sec1;
        sec1.next = th1;
        th1.next = fo1;
        ListNode l2 = new ListNode(2);
        ListNode sec2 = new ListNode(4);
        ListNode th2 = new ListNode(6);
        ListNode fo2 = new ListNode(7);
        ListNode fi2 = new ListNode(10);
        l2.next = sec2;
        sec2.next = th2;
        th2.next = fo2;
        fo2.next = fi2;
        ll.display(l1);
        ll.display(l2);
        ListNode smereh = ll.smerge(l1, l2);
        ll.display(smereh);
    }
 }
